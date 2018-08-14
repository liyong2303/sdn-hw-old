package com.ky.service.impl;
/*
 *作者：barret
 *日期：2018年1月30日
 *
*/

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ky.model.reponse.LoginReponseBodyParams;
import com.ky.service.LogonService;
import com.ky.util.AccessService;
import com.ky.util.BuildRequestBodyUtil;
import com.ky.util.Config;
import com.ky.util.PropertyUtil;

@Service
public class LogonServiceImpl implements LogonService{
	private Logger log = LoggerFactory.getLogger(LogonServiceImpl.class);
	
	private static final String URL_PREFIX = PropertyUtil.getValue("URL_PREFIX");
	
	@Override
	public LoginReponseBodyParams logon() {
		try {
			String requestUrl = URL_PREFIX + "/rest/plat/smapp/v1/oauth/token";
			//设置http请求信息
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type", "application/json;charset=utf-8");
			headers.put("Accept", "application/json;q=1;version=Netmatrix V1R3C00");
			headers.put("Accept-Charset", "utf-8;q=1");
			headers.put("Cache-Control", "no-cache");
			String response = AccessService.accessService(requestUrl, headers, BuildRequestBodyUtil.buildLogonBody(), HttpMethod.PUT);
			LoginReponseBodyParams body = JSONObject.parseObject(response, LoginReponseBodyParams.class);
			log.info("登录返回登录信息："+body);
			return body;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
