package com.ky.service.impl;
/*
 *作者：barret
 *日期：2018年1月31日
 *
*/

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ky.model.TspeedLog;
import com.ky.model.UpdateAccessPoint;
import com.ky.model.query.SpeedAdjustParams;
import com.ky.model.vo.TzxBusiVo;
import com.ky.sdn.common.util.DateUtil;
import com.ky.service.TnoticeService;
import com.ky.service.TspeedLogService;
import com.ky.service.TzxBusiService;
import com.ky.service.VpnOperateService;
import com.ky.util.AccessService;
import com.ky.util.BuildRequestBodyUtil;
import com.ky.util.PropertyUtil;

@Service
public class VpnOperateServiceImpl implements VpnOperateService {
	private Logger log = LoggerFactory.getLogger(VpnOperateServiceImpl.class);

	@Autowired
	private TzxBusiService tzxBusiService;

	@Autowired
	private TnoticeService tnoticeService;

	@Autowired
	private TspeedLogService tspeedLogService;

	private String requestUrl = PropertyUtil.getValue("URL_PREFIX")
			+ "/rest/restadapter/v1/services/internetprivateline?roaRand=";

	@Override
	public String vpnUpdate(String roaRand, String accessSession, List<UpdateAccessPoint> accessPoint) {
		try {
			// 设置http请求头
			Map<String, String> bodheaders = new HashMap<String, String>();
			bodheaders.put("Content-Type", "application/json");
			bodheaders.put("Accept", "application/json");
			bodheaders.put("Cookie", "accessSession=" + accessSession);
			log.info("调整带宽头部信息：" + bodheaders.toString());
			log.info("调整带宽body信息：" + BuildRequestBodyUtil.buildBodRequestBody(accessPoint));
			String bodresponse = AccessService.accessService(requestUrl + roaRand, bodheaders,
					BuildRequestBodyUtil.buildBodRequestBody(accessPoint), HttpMethod.POST);
			return bodresponse;
		} catch (Exception e) {
			log.error("", e);
			return null;
		}

	}

	@Override
	public String vpnUpdate(String roaRand, String accessSession, String body) {
		try {
			// 设置http请求头
			Map<String, String> bodheaders = new HashMap<String, String>();
			bodheaders.put("Content-Type", "application/json");
			bodheaders.put("Accept", "application/json");
			bodheaders.put("Cookie", "accessSession=" + accessSession);
			log.info("调整带宽头部信息：" + bodheaders.toString());
			log.info("调整带宽body信息：" + body);
			String bodresponse = AccessService.accessService(requestUrl + roaRand, bodheaders, body, HttpMethod.POST);
			return bodresponse;
		} catch (Exception e) {
			log.error("", e);
			return null;
		}

	}

	/**
	 * 
	 * 异步调速，提速
	 * 
	 */
	@Override
	@Transactional
	public boolean synDbStatus(SpeedAdjustParams params, TzxBusiVo tzxBusiVo) {
		// 更改数据库专线状态
		boolean updateflag = tzxBusiService.updateZxStatus(params, tzxBusiVo);
		// 插入日志
		Date beginTimePre = new Date();
		// Date beginTime = new
		// Date(beginTimePre.getYear(),beginTimePre.getMonth(),beginTimePre.getDate(),beginTimePre.getHours(),beginTimePre.getMinutes(),beginTimePre.getSeconds());
		Date beginTime = DateUtil.getDate(beginTimePre);
		TspeedLog tspeedLog = tspeedLogService.insertSpeedLog(params, tzxBusiVo, beginTime);
		if (tspeedLog == null) {
			return false;
		}
		// 插入通知
		boolean flag = false;
		if (!(params.getUpSpeed().equals(tzxBusiVo.getUpBandwidth())
				&& params.getDownSpeed().equals(tzxBusiVo.getDownBandwidth()))) {
			flag = tnoticeService.insertTnotice(params, tzxBusiVo, tspeedLog.getSpeedLogId());
		}
		if (tspeedLog != null && updateflag && flag) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	/**
	 * 
	 * 异步调速的降速，回填调速日志，更新数据库状态
	 * 
	 */
	public boolean synRecoverDbStatus(SpeedAdjustParams initparams, TzxBusiVo tzxBusiVo) {
		boolean speedLog = false;
		boolean updateflag = false;
		// 更改数据库专线状态
		updateflag = tzxBusiService.updateZxStatus(initparams, tzxBusiVo);
		// 回填调速日志
		TspeedLog tspeedLog = new TspeedLog();
		tspeedLog.setBusiId(tzxBusiVo.getId());
		tspeedLog.setFinished(0);
		TspeedLog tSpeedLog = tspeedLogService.queryOne(tspeedLog);
		if (tSpeedLog == null) {
			return false;
		}
		Date endTimePre = new Date();
		// Date endTime = new
		// Date(endTimePre.getYear(),endTimePre.getMonth(),endTimePre.getDate(),endTimePre.getHours(),endTimePre.getMinutes(),endTimePre.getSeconds());
		Date endTime = DateUtil.getDate(endTimePre);
		int countMins = DateUtil.countMin(tSpeedLog.getBeginTime(), endTime);
		log.info("开始时间:" + tSpeedLog.getBeginTime() + "\t结束时间:" + endTime + "\t调速时长:" + countMins);

		speedLog = tspeedLogService.updateSpeedLogByZxId(tzxBusiVo.getId(), initparams.getUserId(), countMins, endTime);
		if (speedLog && updateflag) {
			return true;
		}
		return false;
	}

	@Override
	public boolean synRecoverDbStatusDown(SpeedAdjustParams initparams, TzxBusiVo tzxBusiVo) {
		try {
			// 更改数据库专线状态
			tzxBusiService.updateZxStatus(initparams, tzxBusiVo);
			// 回填调速日志
			TspeedLog tspeedLog = new TspeedLog();
			tspeedLog.setBusiId(tzxBusiVo.getId());
			tspeedLog.setFinished(0);
			TspeedLog tSpeedLog = tspeedLogService.queryOne(tspeedLog);
			if (tSpeedLog != null) {
				Date endTimePre = new Date();
				Date endTime = DateUtil.getDate(endTimePre);
				int countMins = DateUtil.countMin(tSpeedLog.getBeginTime(), endTime);
				log.info("开始时间:" + tSpeedLog.getBeginTime() + "\t结束时间:" + endTime + "\t调速时长:" + countMins);

			tspeedLogService.updateSpeedLogByZxId(tzxBusiVo.getId(), initparams.getUserId(), countMins, endTime);
			}
		} catch (Exception e) {
			log.error("用户免费时长使用完降速成功，更新数据出现异常", e);
			return false;
		}
		return true;
	}

}
