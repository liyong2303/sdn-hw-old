package com.ky.model;

import org.hibernate.validator.constraints.*;

import com.ky.sdn.common.base.BaseEntity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class ThwOperate extends BaseEntity {
	
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: ID 
     */	
	
	private Integer id;
    /**
     * workOrderNo       db_column: workOrderNo 
     */	
	@Length(max=255)
	private String workOrderNo;
    /**
     * vpnUuid       db_column: vpnUUID 
     */	
	@Length(max=255)
	private String vpnUUID;
	//columns END

	public ThwOperate(){
	}

	public ThwOperate(
		java.lang.Integer id
	){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setWorkOrderNo(String value) {
		this.workOrderNo = value;
	}
	
	public String getWorkOrderNo() {
		return this.workOrderNo;
	}
	public String getVpnUUID() {
		return vpnUUID;
	}

	public void setVpnUUID(String vpnUUID) {
		this.vpnUUID = vpnUUID;
	}

	
	@Override
	public String toString() {
		return "ThwOperate [id=" + id + ", workOrderNo=" + workOrderNo + ", vpnUUID=" + vpnUUID + "]";
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ThwOperate == false) return false;
		if(this == obj) return true;
		ThwOperate other = (ThwOperate)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

