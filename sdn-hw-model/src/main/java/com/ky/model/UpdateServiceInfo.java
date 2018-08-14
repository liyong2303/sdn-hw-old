package com.ky.model;
/*
 *作者：barret
 *日期：2018年1月27日
 *
*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class UpdateServiceInfo implements Serializable{

	/** 互联网专线业务 UUID*/
	private String vpnUUID;
	/** 专线业务编码*/
	@NotBlank(message="businessID不能为空")
	private String businessID;
	/** 服务类型*/
	private String serviceType = "l2vpws";
	/** 业务名称*/
	private String name = "LianTong";
	/** 业务描述*/
	private String description;
	/** 接入点*/
	private List<UpdateAccessPoint> accessPoint;
	
	
	public UpdateServiceInfo() {
		super();
	}
	
	public UpdateServiceInfo(List<UpdateAccessPoint> accessPoint){
		super();
		this.accessPoint = accessPoint;
	}
	
	public UpdateServiceInfo(String vpnUUID, String businessID, String serviceType, String name, String description,
			List<UpdateAccessPoint> accessPoint) {
		super();
		this.vpnUUID = vpnUUID;
		this.businessID = businessID;
		this.serviceType = serviceType;
		this.name = name;
		this.description = description;
		this.accessPoint = accessPoint;
	}

	public String getVpnUUID() {
		return vpnUUID;
	}
	public void setVpnUUID(String vpnUUID) {
		this.vpnUUID = vpnUUID;
	}
	public String getBusinessID() {
		return businessID;
	}
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<UpdateAccessPoint> getAccessPoint() {
		return accessPoint;
	}
	public void setAccessPoint(List<UpdateAccessPoint> accessPoint) {
		this.accessPoint = accessPoint;
	}

	@Override
	public String toString() {
		return "{vpnUUID:" + vpnUUID + ", businessID:" + businessID + ", serviceType:" + serviceType
				+ ", name:" + name + ", description:" + description + ", accessPoints:" + accessPoint + "}";
	}
	
	
}
