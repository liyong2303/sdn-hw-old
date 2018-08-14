package com.ky.model.query;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ky.sdn.common.base.BaseQuery;

import java.io.Serializable;


public class TnoticeQuery extends BaseQuery  {
 
    

	/** 主键 */
	private java.lang.Long id;
	/** 客户公司ID */
	private java.lang.Long companyId;
	/** 业务ID */
	private java.lang.Long busiId;
	/** 业务代码 */
	private java.lang.String busiCode;
	/** 业务类型ID */
	private java.lang.Long busiTypeId;
	/** noticeTypeId */
	private java.lang.Integer noticeTypeId;
	/** 0=不跳转，1=跳转 */
	private Integer type;
	/** 跳转ID */
	private java.lang.Long redirectId;
	/** 标题 */
	private java.lang.String title;
	/** 通知详情 */
	private java.lang.String content;
	/** 创建时间 */
	private java.util.Date createTimeBegin;
	private java.util.Date createTimeEnd;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getCompanyId() {
		return this.companyId;
	}
	
	public void setCompanyId(java.lang.Long value) {
		this.companyId = value;
	}
	
	public java.lang.Long getBusiId() {
		return this.busiId;
	}
	
	public void setBusiId(java.lang.Long value) {
		this.busiId = value;
	}
	
	public java.lang.String getBusiCode() {
		return this.busiCode;
	}
	
	public void setBusiCode(java.lang.String value) {
		this.busiCode = value;
	}
	
	public java.lang.Long getBusiTypeId() {
		return this.busiTypeId;
	}
	
	public void setBusiTypeId(java.lang.Long value) {
		this.busiTypeId = value;
	}
	
	public java.lang.Integer getNoticeTypeId() {
		return this.noticeTypeId;
	}
	
	public void setNoticeTypeId(java.lang.Integer value) {
		this.noticeTypeId = value;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	public java.lang.Long getRedirectId() {
		return this.redirectId;
	}
	
	public void setRedirectId(java.lang.Long value) {
		this.redirectId = value;
	}
	
	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.util.Date getCreateTimeBegin() {
		return this.createTimeBegin;
	}
	
	public void setCreateTimeBegin(java.util.Date value) {
		this.createTimeBegin = value;
	}	
	
	public java.util.Date getCreateTimeEnd() {
		return this.createTimeEnd;
	}
	
	public void setCreateTimeEnd(java.util.Date value) {
		this.createTimeEnd = value;
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
					.append("CreateTime").append("Begin=").append(getCreateTimeBegin())
					.toString();
	}
}

