package com.ky.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ky.sdn.common.base.BaseEntity;

public class TspeedLog extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	 /**
     * 调速记录ID       db_column: SPEED_LOG_ID 
     */	
	private Long speedLogId;
    /**
     * 专线ID       db_column: BUSI_ID 
     */	
	private Long busiId;
    /**
     * 客户公司ID       db_column: COMPANY_ID 
     */	
	private Long companyId;
    /**
     * 用户ID       db_column: USER_ID 
     */	
	private Long userId;
    /**
     * 结束用户ID       db_column: UPDATE_USER_ID 
     */	
	private Long updateUserId;
    /**
     * 基础上行带宽       db_column: UP_BANDWIDTH 
     */	
	private String upBandwidth;
    /**
     * 基础下行带宽       db_column: DOWN_BANDWIDTH 
     */	
	private String downBandwidth;
    /**
     * 调速后上行带宽       db_column: UP_BANDWIDTH_SPEEDED 
     */	
	private String upBandwidthSpeeded;
    /**
     * 调速后下行带宽       db_column: DOWN_BANDWIDTH_SPEEDED 
     */	
	private String downBandwidthSpeeded;
    /**
     * 当前月份       db_column: CURRENT_MONTH 
     */	
	private Integer currentMonth;
    /**
     * 操作类型；0=上下行调速，1=上行调速；2=下行调速       db_column: OPT_TYPE 
     */	
	private Integer optType;
    /**
     * 实际开始执行时间       db_column: BEGIN_TIME 
     */	
	private java.util.Date beginTime;
    /**
     * 实际结束时间       db_column: END_TIME 
     */	
	private java.util.Date endTime;
    /**
     * 累计时间，单位分钟       db_column: MINUTES 
     */	
	private Integer minutes;
	
    /**
     * 0=正在进行，1=已经完成       db_column: FINISHED 
     */	
	private Integer finished;
	
	/**
	 * 专线编号
	 */
	private String productCode;
	//columns END

	// -----------非数据库字段

	private String userName;
    private String updateUserName; 
	public TspeedLog() {
	}


	public TspeedLog(Long speedLogId) {
		this.speedLogId = speedLogId;
	}


	 


	public TspeedLog(Long speedLogId, Long companyId) {
 		this.speedLogId = speedLogId;
		this.companyId = companyId;
	}


 

	public TspeedLog(Long busiId, Integer finished) {
		this.busiId = busiId;
		this.finished = finished;
	}


	public Long getSpeedLogId() {
		return speedLogId;
	}


	public void setSpeedLogId(Long speedLogId) {
		this.speedLogId = speedLogId;
	}


	public void setBusiId(Long value) {
		this.busiId = value;
	}

	public Long getBusiId() {
		return this.busiId;
	}

	public void setCompanyId(Long value) {
		this.companyId = value;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setUserId(Long value) {
		this.userId = value;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUpBandwidth(String value) {
		this.upBandwidth = value;
	}

	public String getUpBandwidth() {
		return this.upBandwidth;
	}

	public void setDownBandwidth(String value) {
		this.downBandwidth = value;
	}

	public String getDownBandwidth() {
		return this.downBandwidth;
	}

	public void setUpBandwidthSpeeded(String value) {
		this.upBandwidthSpeeded = value;
	}

	public String getUpBandwidthSpeeded() {
		return this.upBandwidthSpeeded;
	}

	public void setDownBandwidthSpeeded(String value) {
		this.downBandwidthSpeeded = value;
	}

	public String getDownBandwidthSpeeded() {
		return this.downBandwidthSpeeded;
	}

	public void setCurrentMonth(Integer value) {
		this.currentMonth = value;
	}

	public Integer getCurrentMonth() {
		return this.currentMonth;
	}

	public void setOptType(Integer value) {
		this.optType = value;
	}

	public Integer getOptType() {
		return this.optType;
	}

	public void setBeginTime(java.util.Date value) {
		this.beginTime = value;
	}

	public java.util.Date getBeginTime() {
		return this.beginTime;
	}

	public void setEndTime(java.util.Date value) {
		this.endTime = value;
	}

	public java.util.Date getEndTime() {
		return this.endTime;
	}

	public void setMinutes(Integer value) {
		this.minutes = value;
	}

	public Integer getMinutes() {
		return this.minutes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Integer getFinished() {
		return finished;
	}


	public void setFinished(Integer finished) {
		this.finished = finished;
	}


	public Long getUpdateUserId() {
		return updateUserId;
	}


	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}


	public String getUpdateUserName() {
		return updateUserName;
	}


	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	@Override
	public String toString() {
		return "TspeedLog [speedLogId=" + speedLogId + ", busiId=" + busiId + ", companyId=" + companyId + ", userId="
				+ userId + ", updateUserId=" + updateUserId + ", upBandwidth=" + upBandwidth + ", downBandwidth="
				+ downBandwidth + ", upBandwidthSpeeded=" + upBandwidthSpeeded + ", downBandwidthSpeeded="
				+ downBandwidthSpeeded + ", currentMonth=" + currentMonth + ", optType=" + optType + ", beginTime="
				+ beginTime + ", endTime=" + endTime + ", minutes=" + minutes + ", finished=" + finished
				+ ", productCode=" + productCode + ", userName=" + userName + ", updateUserName=" + updateUserName
				+ "]";
	}


 
 

}
