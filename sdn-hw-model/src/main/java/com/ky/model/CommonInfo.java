package com.ky.model;
/*
 *作者：barret
 *日期：2018年1月27日
 *
*/

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class CommonInfo implements Serializable{
	
	/** 工单编码*/
	@NotBlank(message="workOrderNo不能为空")
	private String workOrderNo;
	/** 工单类型*/
	private String workOrderType;
	/** 操作类型*/
	private String servOperType = "BOD";
	/** 客户ID*/
	@NotBlank(message="customerID不能为空")
	private String customerID;
	/** 客户名称*/
	@NotBlank(message="customerName不能为空")
	private String customerName;
	/** 客户地址*/
	@NotBlank(message="customerAddress不能为空")
	private String customerAddress;
	/** 订单号码*/
	@NotBlank(message="orderNumber不能为空")
	private String orderNumber;
	/** 订单类型*/
	@NotBlank(message="orderType不能为空")
	private String orderType;
	/** 订单类型*/
	private String businessType = "InternetPrivateLine";
	
	
	
	
	public CommonInfo() {
		super();
	}
	public CommonInfo(String workOrderNo, String workOrderType, String servOperType, String customerID,
			String customerName, String customerAddress, String orderNumber, String orderType, String businessType) {
		super();
		this.workOrderNo = workOrderNo;
		this.workOrderType = workOrderType;
		this.servOperType = servOperType;
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.orderNumber = orderNumber;
		this.orderType = orderType;
		this.businessType = businessType;
	}
	public String getWorkOrderNo() {
		return workOrderNo;
	}
	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}
	public String getWorkOrderType() {
		return workOrderType;
	}
	public void setWorkOrderType(String workOrderType) {
		this.workOrderType = workOrderType;
	}
	public String getServOperType() {
		return servOperType;
	}
	public void setServOperType(String servOperType) {
		this.servOperType = servOperType;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	@Override
	public String toString() {
		return "{workOrderNo:" + workOrderNo + ", workOrderType:" + workOrderType + ", servOperType:"
				+ servOperType + ", customerID:" + customerID + ", customerName:" + customerName + ", customerAddress:"
				+ customerAddress + ", orderNumber:" + orderNumber + ", orderType:" + orderType + ", businessType:"
				+ businessType + "}";
	}
	
	

}
