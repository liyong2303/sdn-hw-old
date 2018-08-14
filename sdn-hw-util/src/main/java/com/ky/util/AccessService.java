package com.ky.util;
/*
 *作者：barret
 *日期：2018年1月30日
 *
*/

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.DefaultHttpRequestFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import com.ky.exception.ServiceException;

/**
 * 访问服务，提供基本的http访问能力
 * @author Administrator
 *
 */
public class AccessService {
	private static Logger log = LoggerFactory.getLogger(AccessService.class);
	/**
	 * 访问请求
	 * @param requestUrl
	 * @param headers
	 * @param requestBody
	 * @param httpMethod
	 * @return
	 * @throws ServiceException 
	 */
	public static String accessService(String requestUrl,Map<String,String> headers,String requestBody,HttpMethod httpMethod) throws ServiceException{
		if(log.isDebugEnabled()){
			log.debug("requestUrl:"+requestUrl+";headers:"+headers+";bodys:"+requestBody+";httpMethod:"+httpMethod);
		}
		InputStream in = null;
		int contentLength = 0;
		if(requestBody != null){
			in = new ByteArrayInputStream(requestBody.getBytes());
			contentLength = requestBody.getBytes().length;
		}
		HttpRequestBase httpRequest = CreateHttpRequestUtil.createHttpRequest(requestUrl,headers,in,contentLength,httpMethod);
		String strRsp = SSLHttpUtil.sendSSLHttp(httpRequest);
		return strRsp;
	}
	
}
