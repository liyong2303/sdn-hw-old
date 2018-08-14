package com.ky.model.query;
/*
 *作者：barret
 *日期：2018年1月30日
 *
*/

import java.io.Serializable;

public class LoginRequestBodyParams implements Serializable{
	
	private String grantType;
	private String userName;
	private String value;
	
	
	public LoginRequestBodyParams() {
		super();
	}
	public LoginRequestBodyParams(String grantType, String userName, String value) {
		super();
		this.grantType = grantType;
		this.userName = userName;
		this.value = value;
	}
	public String getGrantType() {
		return grantType;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "LoginRequestBodyParams [grantType=" + grantType + ", userName=" + userName + ", value=" + value + "]";
	}
	
	

}
