package com.ky.model.reponse;
/*
 *作者：barret
 *日期：2018年1月30日
 *
*/

import java.io.Serializable;
import java.util.Map;

public class LoginReponseBodyParams implements Serializable{
	
	private String accessSession;
	private Integer  expires;
	private String roaRand;
	private Map<String,String> additionalInfo;
	
	
	public LoginReponseBodyParams() {
		super();
	}
	
	public LoginReponseBodyParams(String accessSession, Integer expires, String roaRand,
			Map<String, String> additionalInfo) {
		super();
		this.accessSession = accessSession;
		this.expires = expires;
		this.roaRand = roaRand;
		this.additionalInfo = additionalInfo;
	}

	public String getAccessSession() {
		return accessSession;
	}
	public void setAccessSession(String accessSession) {
		this.accessSession = accessSession;
	}
	public Integer getExpires() {
		return expires;
	}
	public void setExpires(Integer expires) {
		this.expires = expires;
	}
	public Map<String, String> getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public String getRoaRand() {
		return roaRand;
	}
	public void setRoaRand(String roaRand) {
		this.roaRand = roaRand;
	}

	@Override
	public String toString() {
		return "LoginReponseBodyParams [accessSession=" + accessSession + ", expires=" + expires + ", roaRand="
				+ roaRand + ", additionalInfo=" + additionalInfo + "]";
	}

	
	

}
