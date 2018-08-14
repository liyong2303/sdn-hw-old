package com.ky.model.query;
import com.ky.sdn.common.base.BaseQuery;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TspeedLogQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    

	/** id */
	private Long speedLogId;
	/** 专线ID */
	@NotNull(message="busiId不能为空")
	private Long busiId;
	/** 客户公司ID */
	private Long companyId;
	/** 用户ID */
	private Long userId;
	/** 结束用户ID */
	private Long updateUserId;
	/** 基础上行带宽 */
	private String upBandwidth;
	/** 基础下行带宽 */
	private String downBandwidth;
	/** 调速后上行带宽 */
	private String upBandwidthSpeeded;
	/** 调速后下行带宽 */
	private String downBandwidthSpeeded;
	/** 当前月份 */
	@NotNull(message="currentMonth不能为空")
	private Integer currentMonth;
	/** 操作类型；0=上下行调速，1=上行调速；2=下行调速 */
	private Integer optType;
	/** 实际开始执行时间 */
	private java.util.Date beginTime;
	private java.util.Date beginTimeBegin;
	private java.util.Date beginTimeEnd;
	/** 实际结束时间 */
	private java.util.Date endTime;
	private java.util.Date endTimeBegin;
	private java.util.Date endTimeEnd;
	/** 累计时间，单位分钟 */
	private Integer minutes;
    private String proudctCode;

	
	public Long getSpeedLogId() {
		return speedLogId;
	}

	public void setSpeedLogId(Long speedLogId) {
		this.speedLogId = speedLogId;
	}

	public Long getBusiId() {
		return this.busiId;
	}
	
	public void setBusiId(Long value) {
		this.busiId = value;
	}
	
	public Long getCompanyId() {
		return this.companyId;
	}
	
	public void setCompanyId(Long value) {
		this.companyId = value;
	}
	
	public Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(Long value) {
		this.userId = value;
	}
	
	public String getUpBandwidth() {
		return this.upBandwidth;
	}
	
	public void setUpBandwidth(String value) {
		this.upBandwidth = value;
	}
	
	public String getDownBandwidth() {
		return this.downBandwidth;
	}
	
	public void setDownBandwidth(String value) {
		this.downBandwidth = value;
	}
	
	public String getUpBandwidthSpeeded() {
		return this.upBandwidthSpeeded;
	}
	
	public void setUpBandwidthSpeeded(String value) {
		this.upBandwidthSpeeded = value;
	}
	
	public String getDownBandwidthSpeeded() {
		return this.downBandwidthSpeeded;
	}
	
	public void setDownBandwidthSpeeded(String value) {
		this.downBandwidthSpeeded = value;
	}
	
	public Integer getCurrentMonth() {
		return this.currentMonth;
	}
	
	public void setCurrentMonth(Integer value) {
		this.currentMonth = value;
	}
	
	public Integer getOptType() {
		return this.optType;
	}
	
	public void setOptType(Integer value) {
		this.optType = value;
	}
	
	public java.util.Date getBeginTime(){
		return this.beginTime;
	}
	
	public void setBeginTime(java.util.Date value) {
		this.beginTime = value;
	}
	
	public java.util.Date getBeginTimeBegin() {
		return this.beginTimeBegin;
	}
	
	public void setBeginTimeBegin(java.util.Date value) {
		this.beginTimeBegin = value;
	}	
	
	public java.util.Date getBeginTimeEnd() {
		return this.beginTimeEnd;
	}
	
	public void setBeginTimeEnd(java.util.Date value) {
		this.beginTimeEnd = value;
	}
	
	public java.util.Date getEndTime(){
		return this.endTime;
	}
	
	public void setEndTime(java.util.Date value) {
		this.endTime = value;
	}
	
	public java.util.Date getEndTimeBegin() {
		return this.endTimeBegin;
	}
	
	public void setEndTimeBegin(java.util.Date value) {
		this.endTimeBegin = value;
	}	
	
	public java.util.Date getEndTimeEnd() {
		return this.endTimeEnd;
	}
	
	public void setEndTimeEnd(java.util.Date value) {
		this.endTimeEnd = value;
	}
	
	public Integer getMinutes() {
		return this.minutes;
	}
	
	public void setMinutes(Integer value) {
		this.minutes = value;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getProudctCode() {
		return proudctCode;
	}

	public void setProudctCode(String proudctCode) {
		this.proudctCode = proudctCode;
	}

	@Override
	public String toString() {
		return "TspeedLogQuery [speedLogId=" + speedLogId + ", busiId=" + busiId + ", companyId=" + companyId
				+ ", userId=" + userId + ", updateUserId=" + updateUserId + ", upBandwidth=" + upBandwidth
				+ ", downBandwidth=" + downBandwidth + ", upBandwidthSpeeded=" + upBandwidthSpeeded
				+ ", downBandwidthSpeeded=" + downBandwidthSpeeded + ", currentMonth=" + currentMonth + ", optType="
				+ optType + ", beginTime=" + beginTime + ", beginTimeBegin=" + beginTimeBegin + ", beginTimeEnd="
				+ beginTimeEnd + ", endTime=" + endTime + ", endTimeBegin=" + endTimeBegin + ", endTimeEnd="
				+ endTimeEnd + ", minutes=" + minutes + ", proudctCode=" + proudctCode + "]";
	}

	 
	

 
}

