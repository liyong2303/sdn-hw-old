package com.ky.util;
/*
 *作者：barret
 *日期：2018年1月31日
 *
*/

import java.io.InputStream;
import java.util.Map;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.InputStreamEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import com.ky.exception.ServiceException;

public class CreateHttpRequestUtil {

	private static Logger log = LoggerFactory.getLogger(CreateHttpRequestUtil.class);
	
	
	/**
	 * 创建请求
	 * @param requestUrl
	 * @param headers
	 * @param in
	 * @param contentLength
	 * @param httpMethod
	 * @return
	 * @throws ServiceException 
	 */
	public static HttpRequestBase createHttpRequest(String requestUrl, Map<String, String> headers, InputStream in,
			int contentLength, HttpMethod httpMethod) throws ServiceException {
		HttpRequestBase httpRequest;
		if(httpMethod == HttpMethod.PUT){
			HttpPut put = new HttpPut(requestUrl);
			if(null !=  in){
				InputStreamEntity entiey = new InputStreamEntity(in);
				put.setEntity(entiey);
			}
			httpRequest = put;
		}else if(httpMethod == HttpMethod.POST){
			HttpPost post = new HttpPost(requestUrl);
			if(null != in){
				InputStreamEntity entiey = new InputStreamEntity(in);
				post.setEntity(entiey);
			}
			httpRequest = post;
		}else if(httpMethod == HttpMethod.GET){
			httpRequest = new HttpGet(requestUrl);
		}else if(httpMethod == HttpMethod.DELETE){
			httpRequest = new HttpDelete(requestUrl);
		}else{
			log.info("暂无该请求方式");
			throw new ServiceException(400, "Unknown HTTP method name: " + httpMethod);
		}
		//将签名信息设置到httpclient的头信息中
		for(String key : headers.keySet()){
			httpRequest.addHeader(key,headers.get(key));
		}
		return httpRequest;
	}
}
