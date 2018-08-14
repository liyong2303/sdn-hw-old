package com.ky.model.vo;

public class TaopResult {
	private String freeTimeLeft;
	private String realTotalCost;
	private Integer code;
	private String msg;
	public String getFreeTimeLeft() {
		return freeTimeLeft;
	}
	public void setFreeTimeLeft(String freeTimeLeft) {
		this.freeTimeLeft = freeTimeLeft;
	}
	public String getRealTotalCost() {
		return realTotalCost;
	}
	public void setRealTotalCost(String realTotalCost) {
		this.realTotalCost = realTotalCost;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "TaopResult [freeTimeLeft=" + freeTimeLeft + ", realTotalCost=" + realTotalCost + ", code=" + code
				+ ", msg=" + msg + "]";
	}
 
}
