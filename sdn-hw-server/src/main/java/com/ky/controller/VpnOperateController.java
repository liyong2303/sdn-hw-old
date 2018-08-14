package com.ky.controller;
/*
 *作者：barret
 *日期：2018年1月31日
 *
*/

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ky.model.CommonInfo;
import com.ky.model.HwConstant;
import com.ky.model.TzxBusi;
import com.ky.model.UpdateAccessPoint;
import com.ky.model.UpdateServiceInfo;
import com.ky.model.query.SpeedAdjustParams;
import com.ky.model.query.TaopQuery;
import com.ky.model.reponse.LoginReponseBodyParams;
import com.ky.model.reponse.OperateReponseBodyParams;
import com.ky.model.vo.TaopResult;
import com.ky.model.vo.TzxBusiVo;
import com.ky.sdn.common.base.Response;
import com.ky.sdn.hw.common.zx.ZxPackageUtil;
import com.ky.service.LogonService;
import com.ky.service.ThourService;
import com.ky.service.TzxBusiService;
import com.ky.service.VpnOperateService;
import com.ky.util.BuildRequestBodyUtil;
import com.ky.util.PropertyUtil;
import com.ky.util.aop.AopUtil;

@RestController
@RequestMapping("/operate")
public class VpnOperateController extends BaseController {

	private static final String isTest = PropertyUtil.getValue("isTest");

	private static final String SERVOPER_TYPE = PropertyUtil.getValue("servOperType");
	private static final String BUSINESS_TYPE = PropertyUtil.getValue("businessType");
	private static final String SERVICE_TYPE = PropertyUtil.getValue("serviceType");
	private static final String NAME = PropertyUtil.getValue("name");
	private static final String SPEED_LOCK_PREFIX = "snd_speed_asyUpdateVpn";
	private static final String SPEED_DOWN_LOCK_PREFIX = "snd_speed_down_asyUpdateVpn";

	private Logger log = LoggerFactory.getLogger(VpnOperateController.class);

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Autowired
	private VpnOperateService vpnOperateService;

	@Autowired
	private LogonService LogonService;

	@Autowired
	private TzxBusiService tzxBusiService;

	@Autowired
	private ThourService thourService;


	/**
	 * 通过id获取调速策略，进行同步调速
	 * 
	 * @return Adjust speed
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/speedAdjust")
	public Response updateVpnById(@RequestBody SpeedAdjustParams params) {

		try {
			TzxBusiVo tzxBusiVo = tzxBusiService.findTzxBusiVoById(params.getZxid(), "ZXC801");
			if (null == tzxBusiVo) {
				log.error("该id查询失败:" + params.getZxid());
				return Response.fail(PARAM_ERROR, "该id查询失败"  + params.getZxid());
			}
			// 发送调速请求
			String response = requestSDN(params, tzxBusiVo, isTest);
			if (response == null) {
				return Response.fail(FAIL, "调速失败:适配器内部异常 ");
			}

			log.info("同步调速结果:" + response + "\t" + "productCode:" + tzxBusiVo.getProductCode() + "\t" + "busiId:"
					+ params.getZxid());
			// 更改数据库状态
			boolean updateflag = tzxBusiService.updateZxStatus(params, tzxBusiVo);
			if (updateflag) {
				return Response.success(SUCCESS, "调速成功",
						"busiId:" + params.getZxid() + " productCode:" + tzxBusiVo.getProductCode());
			}
			return Response.fail(FAIL, "调速失败:更新数据库出现异常");
		} catch (Exception e) {
			log.error("调速失败：", e);
			return Response.fail(FAIL, "调速失败：" + "\t" + "busiId:" + params.getZxid());
		}

	}

	/**
	 * 通过id获取调速策略，进行异步调速
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/speedAsynAdjust")
	public Response asyUpdateVpnById(@RequestBody SpeedAdjustParams params) { // TODO
		// 没有校验？！！！
		try {
			if (hasKey(params.getZxid())) {
				log.info("该专线正在调速！！！！" + "\t" + "busiId:" + params.getZxid());
				return Response.fail(FAIL, "该专线正在进行调速" + params.getZxid());
			}
			log.info("进入异步调速接口" + "\t" + "busiId:" + params.getZxid());
			if (null == params.getUserId()) {
				return Response.fail(PARAM_ERROR, "userId不能为空!");
			}
			TzxBusiVo tzxBusiVo = tzxBusiService.findTzxBusiVoById(params.getZxid(), "ZXC801");
			if (null == tzxBusiVo) {
				log.info("该id查询失败" + "\t" + "busiId:" + params.getZxid());
				return Response.fail(PARAM_ERROR, "该id查询失败" + "busiId:" + params.getZxid());
			}
			// 查询专线的详细信息，用于回显redis时间
			TzxBusi tzxBusi = tzxBusiService.getById(params.getZxid());
			// TODO 获取免费时长剩余时间
			queryAop(tzxBusi);
			// 查询到该专线正在提速
			if (tzxBusi.getZxStatus().intValue() == 1) {
				// 入参等于初始化参数，说明此操作为降速
				if (params.getUpSpeed().equals(tzxBusiVo.getUpBandwidth())
						&& params.getDownSpeed().equals(tzxBusiVo.getDownBandwidth())) {
					SpeedAdjustParams initparams = new SpeedAdjustParams();
					initparams.setZxid(params.getZxid());
					initparams.setUserId(params.getUserId());
					initparams.setUpSpeed(tzxBusiVo.getUpBandwidth());
					initparams.setDownSpeed(tzxBusiVo.getDownBandwidth());
					String response = requestSDN(initparams, tzxBusiVo, isTest);
					if (response == null) {
						return Response.fail(FAIL, "调速失败:适配器内部异常");
					}
					boolean flag = vpnOperateService.synRecoverDbStatus(initparams, tzxBusiVo);
					if (flag) {
						log.info("加速的专线降速成功" + "\t" + "productCode:" + tzxBusiVo.getProductCode() + "\t" + "busiId:"
								+ params.getZxid());
						thourService.update(tzxBusi, 2); // 回显时间，此处的tzxbusi属性 没变
						OperateReponseBodyParams body = JSONObject.parseObject(response,
								OperateReponseBodyParams.class);
						//封装一下 busiId和productCode
						body.setBusiId(params.getZxid());
						body.setProductCode(tzxBusi.getProductCode());
						return Response.success(SUCCESS, "调速成功", JSONObject.toJSONString(body));
					}
				} else {// 提速 (先进行降速操作,再进行提速)
					SpeedAdjustParams initparams = new SpeedAdjustParams();
					initparams.setZxid(params.getZxid());
					initparams.setUserId(params.getUserId());
					initparams.setUpSpeed(tzxBusiVo.getUpBandwidth());
					initparams.setDownSpeed(tzxBusiVo.getDownBandwidth());
					String response = requestSDN(initparams, tzxBusiVo, isTest);
					if (response == null) {
						return Response.fail(FAIL, "调速失败:适配器内部异常");
					}
					boolean flag = vpnOperateService.synRecoverDbStatus(initparams, tzxBusiVo);
					if (flag) {
						log.info("加速前先将此专线降速成功" + "\t" + "productCode:" + tzxBusiVo.getProductCode() + "\t" + "busiId:"
								+ params.getZxid());
						thourService.update(tzxBusi, 2); // 回显时间，此处的tzxbusi属性zx——status等可能改变，但是不影响回显操作
					}
					// （开始加速操作，先取出最高的套参值）
					String responseUp;
					if (tzxBusi.getFreeBandwidthUsed().intValue() < tzxBusi.getFreeBandwidthLimit().intValue()) { // 免费时长未用完
						Map<String, String> zxParam = ZxPackageUtil.getMaxBandwith(tzxBusiVo.getUpBandwidth(),
								tzxBusiVo.getDownBandwidth());
						initparams.setUpSpeed(zxParam.get("upBandwidth"));
						initparams.setDownSpeed(zxParam.get("downBandwidth"));
						responseUp = requestSDN(initparams, tzxBusiVo, isTest);
						params.setUpSpeed(zxParam.get("upBandwidth"));
						params.setDownSpeed(zxParam.get("downBandwidth"));
						if (responseUp == null) {
							return Response.fail(FAIL, "调速失败:适配器内部异常");
						}
					} else {
						initparams.setUpSpeed(params.getUpSpeed());
						initparams.setDownSpeed(params.getDownSpeed());
						responseUp = requestSDN(initparams, tzxBusiVo, isTest);
						if (responseUp == null) {
							return Response.fail(FAIL, "调速失败:适配器内部异常");
						}
					}
					boolean flagUp = vpnOperateService.synDbStatus(params, tzxBusiVo);
					if (flagUp) {
						log.info("降速后将此专线加速成功" + "productCode:" + tzxBusiVo.getProductCode() + "\t" + "busiId:"
								+ params.getZxid());
						thourService.update(tzxBusi, 1); // 回显时间，此处的tzxbusi属性zx——status等可能改变，但是不影响回显操作
						OperateReponseBodyParams body = JSONObject.parseObject(responseUp,
								OperateReponseBodyParams.class);
						// 封装一下 busiId和productCode
						body.setBusiId(params.getZxid());
						body.setProductCode(tzxBusi.getProductCode());
						return Response.success(SUCCESS, "调速成功", JSONObject.toJSONString(body));
					}
				}
			} else if (tzxBusi.getZxStatus().intValue() == 0) {// 该专线未加速
				// 入参等于初始化参数，说明此操作为降速,不做处理
				if (params.getUpSpeed().equals(tzxBusiVo.getUpBandwidth())
						&& params.getDownSpeed().equals(tzxBusiVo.getDownBandwidth())) {
					OperateReponseBodyParams body = JSONObject.parseObject(
							"{'workOrderNo':'20180211095200001','vpnUUID':'88b51037-81c5-4805-8734-3ddca800c34b'}",
							OperateReponseBodyParams.class);
					log.info("调速成功,降速的专线未进行降速处理" + "\t" + "productCode:" + tzxBusiVo.getProductCode() + "\t" + "busiId:"
							+ params.getZxid());
					// 封装一下 busiId和productCode
					body.setBusiId(params.getZxid());
					body.setProductCode(tzxBusi.getProductCode());
					return Response.success(SUCCESS, "调速成功", JSONObject.toJSONString(body));
				} else {// 提速,跟协同器交互
					SpeedAdjustParams initparams = new SpeedAdjustParams();
					initparams.setZxid(params.getZxid());
					initparams.setUserId(params.getUserId());
					String responseUp;
					if (tzxBusi.getFreeBandwidthUsed().intValue() < tzxBusi.getFreeBandwidthLimit().intValue()) { // 免费时长未用完
						Map<String, String> zxParam = ZxPackageUtil.getMaxBandwith(tzxBusiVo.getUpBandwidth(),
								tzxBusiVo.getDownBandwidth());
						initparams.setUpSpeed(zxParam.get("upBandwidth"));
						initparams.setDownSpeed(zxParam.get("downBandwidth"));
						params.setUpSpeed(zxParam.get("upBandwidth"));
						params.setDownSpeed(zxParam.get("downBandwidth"));
						responseUp = requestSDN(initparams, tzxBusiVo, isTest);
						if (responseUp == null) {
							return Response.fail(FAIL, "调速失败:适配器内部异常");
						}
					} else {
						initparams.setUpSpeed(params.getUpSpeed());
						initparams.setDownSpeed(params.getDownSpeed());
						responseUp = requestSDN(initparams, tzxBusiVo, isTest);
						if (responseUp == null) {
							return Response.fail(FAIL, "调速失败:适配器内部异常");
						}
					}
					boolean flagUp = vpnOperateService.synDbStatus(params, tzxBusiVo);
					if (flagUp) {
						log.info("此专线加速成功" + "\t" + "productCode:" + tzxBusiVo.getProductCode() + "\t" + "busiId:"
								+ params.getZxid());
						thourService.update(tzxBusi, 1); // 回显时间，此处的tzxbusi属性zx——status等可能改变，但是不影响回显操作
						OperateReponseBodyParams body = JSONObject.parseObject(responseUp,
								OperateReponseBodyParams.class);
						//封装一下 busiId和productCode
						body.setBusiId(params.getZxid());
						body.setProductCode(tzxBusi.getProductCode());
						return Response.success(SUCCESS, "调速成功", JSONObject.toJSONString(body));
					}
				}
			}
		} catch (Exception e) {
			log.error("调速失败：", e);
			return Response.fail(FAIL, "调速失败" + "busiId:" + params.getZxid());
		}
		return Response.fail(FAIL, "调速失败，更新数据库出现异常" + "busiId:" + params.getZxid());
	}

	/**
	 * 向sdn发送调试请求
	 * 
	 * @param params
	 * @param tzxBusiVo
	 * @param status
	 *            0测试，1真实环境
	 * @return
	 */
	private String requestSDN(SpeedAdjustParams params, TzxBusiVo tzxBusiVo, String status) {
		List<UpdateAccessPoint> accessPoint = new ArrayList<>();
		switchByQosAdjustPolicyName(params, accessPoint);
		// 构建commonInfo,serviceInfo对象
		String requestbody = createRequestBody(tzxBusiVo, accessPoint);
		String response = null;
		if ("0".equals(status)) {
			log.info("调速内容：" + requestbody);
			response = "{'workOrderNo':'20180211095200001','vpnUUID':'88b51037-81c5-4805-8734-3ddca800c34b'}";
		} else if ("1".equals(status)) {
			// cookie失效处理
			if (!redisTemplate.hasKey(HwConstant.HW)) {
				restToken();
			}
			response = vpnOperateService.vpnUpdate(
					String.valueOf(redisTemplate.opsForHash().get(HwConstant.HW, HwConstant.ROARAND)),
					String.valueOf(redisTemplate.opsForHash().get(HwConstant.HW, HwConstant.COOKIE)), requestbody);
			if (null == response) {
				log.info("调速失败body:" + response + ",进行第二次调速");
				// 华为系统器有可能一次调不通，需要进行第二次调速
				String repeatResponse = vpnOperateService.vpnUpdate(
						String.valueOf(redisTemplate.opsForHash().get(HwConstant.HW, HwConstant.ROARAND)),
						String.valueOf(redisTemplate.opsForHash().get(HwConstant.HW, HwConstant.COOKIE)), requestbody);
				
				return repeatResponse;
			}
		} else {
			return null;
		}
		// }
		return response;
	}

	

	/**
	 * 免费时长用完降速
	 */
	@RequestMapping("/speedDown")
	public Response speedDown(@RequestBody SpeedAdjustParams params) {
		try {
			if (hasDownSpeedKey(params.getZxid())) {
				log.error("该专线正在降速！！！！" + "\t" + "busiId:" + params.getZxid());
				return Response.fail(FAIL, "该专线正在进行调速");
			}
			log.info("进入免费时长使用完毕降速接口" + "\t" + "busiId:" + params.getZxid());
			if (null == params.getUserId()) {
				return Response.fail(PARAM_ERROR, "userId不能为空");
			}
			TzxBusiVo tzxBusiVo = tzxBusiService.findTzxBusiVoById(params.getZxid(), "ZXC801");
			// 查询专线的详细信息，用于回显redis时间
			TzxBusi tzxBusi = tzxBusiService.getById(params.getZxid());
			if (null == tzxBusiVo) {
				log.info("该id查询失败" + "\t" + "busiId:" + params.getZxid());
				return Response.fail(PARAM_ERROR, "该id查询失败");
			}
			// 此专线请求是为了降速操作
			if (params.getUpSpeed().equals(tzxBusiVo.getUpBandwidth())
					&& params.getDownSpeed().equals(tzxBusiVo.getDownBandwidth())) {
				SpeedAdjustParams initparams = new SpeedAdjustParams();
				initparams.setZxid(params.getZxid());
				initparams.setUserId(params.getUserId());
				initparams.setUpSpeed(tzxBusiVo.getUpBandwidth());
				initparams.setDownSpeed(tzxBusiVo.getDownBandwidth());
				String response = requestSDN(initparams, tzxBusiVo, isTest);
				if (response == null) {
					return Response.fail(FAIL, "调速失败:适配器内部异常");
				}
				boolean flag = vpnOperateService.synRecoverDbStatusDown(initparams, tzxBusiVo);
				if (flag) {
					log.info("专线降速成功" + "\t" + "productCode:" + tzxBusiVo.getProductCode() + "\t" + "busiId:"
							+ params.getZxid());
					// thourService.update(tzxBusi, 2); // 回显时间，此处的tzxbusi属性 没变
					OperateReponseBodyParams body = JSONObject.parseObject(response, OperateReponseBodyParams.class);
					//封装一下 busiId和productCode
					body.setBusiId(params.getZxid());
					body.setProductCode(tzxBusi.getProductCode());
					return Response.success(SUCCESS, "调速成功", JSONObject.toJSONString(body));
				}
			} else {
				return Response.fail(PARAM_ERROR, "提交的参数不是套餐的最低速度");
			}
		} catch (Exception e) {
			log.error("免费时长用完对接异常", e);
			return Response.fail(FAIL, "调速失败：" + "busiId:" + params.getZxid());
		}
		return Response.success(SUCCESS, "降速成功" + "busiId:" + params.getZxid());
	}


	/**
	 * 根据调速策略生成相应的接入点
	 * 
	 * @param qosAdjustState
	 *            调速策略
	 * @param accessPoint
	 *            接入点
	 */
	private void switchByQosAdjustPolicyName(SpeedAdjustParams param, List<UpdateAccessPoint> accessPoint) {
		String qosAdjustPolicyName = "SDUTN_" + param.getUpSpeed() + "/" + param.getDownSpeed() + "";
		int upSpeed = Integer.valueOf(param.getUpSpeed().substring(0, param.getUpSpeed().length() - 1)) * 1000;
		int downSpeed = Integer.valueOf(param.getDownSpeed().substring(0, param.getDownSpeed().length() - 1)) * 1000;
		UpdateAccessPoint uppoint3 = new UpdateAccessPoint(qosAdjustPolicyName, upSpeed, "NNI");
		UpdateAccessPoint downpoint3 = new UpdateAccessPoint(qosAdjustPolicyName, downSpeed, "UNI");
		log.info("qosAdjustPolicyName:" + qosAdjustPolicyName + "upSpeed:" + upSpeed + "downSpeed:" + downSpeed);
		accessPoint.add(uppoint3);
		accessPoint.add(downpoint3);
	}

	/**
	 * 重置redis过期token
	 */
	private void restToken() {
		log.info("调速进入cookie过期");
		LoginReponseBodyParams body = LogonService.logon();
		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(HwConstant.COOKIE, body.getAccessSession());
		map.put(HwConstant.ROARAND, body.getRoaRand());
		hash.putAll(HwConstant.HW, map);
		redisTemplate.expire(HwConstant.HW, 29L, TimeUnit.MINUTES);
	}

	/**
	 * 构建请求body
	 * 
	 * @param tzxBusiVo
	 * @param accessPoint
	 * @return
	 */
	private String createRequestBody(TzxBusiVo tzxBusiVo, List<UpdateAccessPoint> accessPoint) {
		CommonInfo commonInfo = new CommonInfo(tzxBusiVo.getSheetNo(), "", SERVOPER_TYPE, tzxBusiVo.getCustomerId(),
				tzxBusiVo.getCustomerName(), tzxBusiVo.getInstalledAddr(), "", "", BUSINESS_TYPE);
		// 倒数2，3个字段不知道怎么来的，最好改成配置文件
		UpdateServiceInfo serviceInfo = new UpdateServiceInfo("", tzxBusiVo.getProductCode(), SERVICE_TYPE, NAME, "",
				accessPoint);
		log.info("构造的请求体:" + BuildRequestBodyUtil.buildBodRequestBody(commonInfo, serviceInfo));
		return BuildRequestBodyUtil.buildBodRequestBody(commonInfo, serviceInfo);
	}

	private synchronized boolean hasKey(Long busiId) {
		boolean flag = redisTemplate.opsForValue().setIfAbsent(SPEED_LOCK_PREFIX + busiId, "snd_speed_" + busiId);
		redisTemplate.expire(SPEED_LOCK_PREFIX + busiId, 5, TimeUnit.SECONDS);
		return !flag;
	}

	private synchronized boolean hasDownSpeedKey(Long busiId) {
		boolean flag = redisTemplate.opsForValue().setIfAbsent(SPEED_DOWN_LOCK_PREFIX + busiId, "snd_speed_" + busiId);
		redisTemplate.expire(SPEED_DOWN_LOCK_PREFIX + busiId, 5, TimeUnit.SECONDS);
		return !flag;
	}

	private Integer queryAop(TzxBusi t) {
		try {
			// 查询AOP时长

			// TODO
			TaopResult rs = AopUtil.queryAop(new TaopQuery(t.getProductCode(),
					new SimpleDateFormat("yyyyMM").format(new Date()), t.getEparchyCode()));
//			 TaopResult rs = new TaopResult();
//			 rs.setFreeTimeLeft("1200");

			if (StringUtils.isNotBlank(rs.getFreeTimeLeft())) {
				Integer freeTimeLeft = Integer.valueOf(rs.getFreeTimeLeft());
				t.setFreeBandwidthUsed(Integer.valueOf(t.getFreeBandwidthLimit().intValue() - freeTimeLeft.intValue()));
				TzxBusi tUpdate = new TzxBusi();
				tUpdate.setId(t.getId());
				tUpdate.setFreeBandwidthUsed(
						Integer.valueOf(t.getFreeBandwidthLimit().intValue() - freeTimeLeft.intValue()));
				tzxBusiService.update(tUpdate);

				return freeTimeLeft;
			}
		} catch (Exception e) {
			log.error("aop查询异常", e);
		}
		// 查询出错或未加速，返回上一次的一个时长
		return t.getFreeBandwidthUsed();
	}

}
