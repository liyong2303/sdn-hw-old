package com.ky.model.query;
/*
 *作者：barret
 *日期：2018年1月30日
 *
*/

import java.io.Serializable;

public class LoginRequestHeaderParams implements Serializable{

	private String Content_Type;
	private String Accept;
	private String Accept_Charset;
	private String Cache_Control;
	
	
	public LoginRequestHeaderParams() {
		super();
	}
	public LoginRequestHeaderParams(String content_Type, String accept, String accept_Charset, String cache_Control) {
		super();
		Content_Type = content_Type;
		Accept = accept;
		Accept_Charset = accept_Charset;
		Cache_Control = cache_Control;
	}
	public String getContent_Type() {
		return Content_Type;
	}
	public void setContent_Type(String content_Type) {
		Content_Type = content_Type;
	}
	public String getAccept() {
		return Accept;
	}
	public void setAccept(String accept) {
		Accept = accept;
	}
	public String getAccept_Charset() {
		return Accept_Charset;
	}
	public void setAccept_Charset(String accept_Charset) {
		Accept_Charset = accept_Charset;
	}
	public String getCache_Control() {
		return Cache_Control;
	}
	public void setCache_Control(String cache_Control) {
		Cache_Control = cache_Control;
	}
	@Override
	public String toString() {
		return "LoginRequestHeaderParams [Content_Type=" + Content_Type + ", Accept=" + Accept + ", Accept_Charset="
				+ Accept_Charset + ", Cache_Control=" + Cache_Control + "]";
	}
	
	
	
}
