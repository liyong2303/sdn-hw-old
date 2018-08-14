package com.ky.model;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

import com.ky.sdn.common.base.BaseEntity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class Tnotice extends BaseEntity {
	
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 主键       db_column: ID 
     */	
	
	private Long id;
    /**
     * 客户公司ID       db_column: COMPANY_ID 
     */	
	
	private Long companyId;
    /**
     * 业务ID       db_column: BUSI_ID 
     */	
	
	private Long busiId;
    /**
     * 业务代码       db_column: BUSI_CODE 
     */	
	@Length(max=255)
	private String busiCode;
    /**
     * 业务类型ID       db_column: BUSI_TYPE_ID 
     */	
	
	private Long busiTypeId;
    /**
     * noticeTypeId       db_column: NOTICE_TYPE_ID 
     */	
	
	private Integer noticeTypeId;
    /**
     * 0=不跳转，1=跳转       db_column: TYPE 
     */	
	@Max(127)
	private Integer type;
    /**
     * 跳转ID       db_column: REDIRECT_ID 
     */	
	
	private Long redirectId;
    /**
     * 标题       db_column: TITLE 
     */	
	@Length(max=255)
	private String title;
    /**
     * 通知详情       db_column: CONTENT 
     */	
	@Length(max=65535)
	private String content;
    /**
     * 创建时间       db_column: CREATE_TIME 
     */	
	
	private java.util.Date createTime;
	//columns END

	public Tnotice(){
	}

	public Tnotice(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setCompanyId(Long value) {
		this.companyId = value;
	}
	
	public Long getCompanyId() {
		return this.companyId;
	}
	public void setBusiId(Long value) {
		this.busiId = value;
	}
	
	public Long getBusiId() {
		return this.busiId;
	}
	public void setBusiCode(String value) {
		this.busiCode = value;
	}
	
	public String getBusiCode() {
		return this.busiCode;
	}
	public void setBusiTypeId(Long value) {
		this.busiTypeId = value;
	}
	
	public Long getBusiTypeId() {
		return this.busiTypeId;
	}
	public void setNoticeTypeId(Integer value) {
		this.noticeTypeId = value;
	}
	
	public Integer getNoticeTypeId() {
		return this.noticeTypeId;
	}
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
	}
	public void setRedirectId(Long value) {
		this.redirectId = value;
	}
	
	public Long getRedirectId() {
		return this.redirectId;
	}
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public String toString() {
		return new StringBuilder()
			.append("Id=").append(getId())
			.append("CompanyId=").append(getCompanyId())
			.append("BusiId=").append(getBusiId())
			.append("BusiCode=").append(getBusiCode())
			.append("BusiTypeId=").append(getBusiTypeId())
			.append("NoticeTypeId=").append(getNoticeTypeId())
			.append("Type=").append(getType())
			.append("RedirectId=").append(getRedirectId())
			.append("Title=").append(getTitle())
			.append("Content=").append(getContent())
			.append("CreateTime=").append(getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tnotice == false) return false;
		if(this == obj) return true;
		Tnotice other = (Tnotice)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

