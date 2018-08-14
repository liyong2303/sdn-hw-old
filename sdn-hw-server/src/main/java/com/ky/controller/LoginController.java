package com.ky.controller;
/*
 *作者：barret
 *日期：2018年1月30日
 *
*/

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ky.model.HwConstant;
import com.ky.model.query.LoginRequestBodyParams;
import com.ky.model.reponse.LoginReponseBodyParams;
import com.ky.sdn.common.base.Response;
import com.ky.service.LogonService;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController{
	private Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LogonService logonService;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * 鉴权登录获取token
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/logon")
	@ResponseBody
	public Response logon(){
		LoginReponseBodyParams body = logonService.logon();
		if(null != body){
			//token 存入数据库或者redis
			Object lastToken = redisTemplate.opsForHash().get(HwConstant.HW, HwConstant.COOKIE);
			if(lastToken != null){
				redisTemplate.delete(lastToken);
			}
			// redis要存放用户什么数据，待定
			HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(HwConstant.COOKIE, body.getAccessSession());
			map.put(HwConstant.ROARAND, body.getRoaRand());
		    hash.putAll(HwConstant.HW, map);
		    redisTemplate.expire(HwConstant.HW, 5L, TimeUnit.MINUTES);
			return Response.success(SUCCESS, "获取成功！登录信息是："+body.toString());
		}
		return Response.fail(FAIL, "登录失败,帐号或密码错误");
	}
	
}
