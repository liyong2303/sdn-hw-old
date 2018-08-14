package com.ky.model.query;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/*
 *作者：barret
 *日期：2018年2月8日
 *
*/

public class SpeedAdjustParams {

	
	@NotNull(message="zxid不能为空")
	private Long zxid;
	@NotBlank(message="upSpeed不能为空")
	private String upSpeed;
	@NotBlank(message="downSpeed不能为空")
	private String downSpeed;
	private Long userId;
	
	
	public Long getZxid() {
		return zxid;
	}
	public void setZxid(Long zxid) {
		this.zxid = zxid;
	}
	public String getUpSpeed() {
		return upSpeed;
	}
	public void setUpSpeed(String upSpeed) {
		this.upSpeed = upSpeed;
	}
	public String getDownSpeed() {
		return downSpeed;
	}
	public void setDownSpeed(String downSpeed) {
		this.downSpeed = downSpeed;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
