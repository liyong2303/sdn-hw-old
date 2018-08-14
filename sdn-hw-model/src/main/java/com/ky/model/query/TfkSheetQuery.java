package com.ky.model.query;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ky.sdn.common.base.BaseQuery;

import java.io.Serializable;


public class TfkSheetQuery extends BaseQuery  {
 
    

	/** 主键 */
	private java.lang.Long id;
	/** 业务类型 */
	private java.lang.String busiType;
	/** 客户名称 */
	private java.lang.String customerName;
	/** 0=正常工单；1=撤销工单 */
	private Integer orderSign;
	/** 客户编码 */
	private java.lang.String customerId;
	/** 用户ID */
	private java.lang.String userId;
	/** 产品号码 */
	private java.lang.String productCode;
	/** 工单编码 */
	private java.lang.String sheetNo;
	/** 城市 */
	private java.lang.String city;
	/** 营销中心 */
	private java.lang.String marketingCenter;
	/** 区县 */
	private java.lang.String area;
	/** 装机地址 */
	private java.lang.String installedAddr;
	/** 客户联系人姓名 */
	private java.lang.String linkName;
	/** 客户联系人手机号码 */
	private java.lang.String linkPhone;
	/** 套餐 */
	private java.lang.String packages;
	/** 受理时间 */
	private java.util.Date acceptTimeBegin;
	private java.util.Date acceptTimeEnd;
	/** 客户经理姓名 */
	private java.lang.String managerName;
	/** 客户经理电话 */
	private java.lang.String managerPhone;
	/** 上行带宽，单位M */
	private java.lang.String upBandwidth;
	/** 下行带宽，单位M */
	private java.lang.String downBandwidth;
	/** 最大支持带宽，单位M */
	private java.lang.String maxBandwidth;
	/** IP地址数量 */
	private java.lang.Integer ipNum;
	/** 光口、电口 */
	private java.lang.String cpeType;
	/** 客户证件号码 */
	private java.lang.String userIdNo;
	/** 预判CPE设备编码 */
	private java.lang.String cpeDeviceCode;
	/** 业务标识，0=SDN未处理,1=SDN已处理 */
	private Integer sheetType;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.String getBusiType() {
		return this.busiType;
	}
	
	public void setBusiType(java.lang.String value) {
		this.busiType = value;
	}
	
	public java.lang.String getCustomerName() {
		return this.customerName;
	}
	
	public void setCustomerName(java.lang.String value) {
		this.customerName = value;
	}
	
	public Integer getOrderSign() {
		return this.orderSign;
	}
	
	public void setOrderSign(Integer value) {
		this.orderSign = value;
	}
	
	public java.lang.String getCustomerId() {
		return this.customerId;
	}
	
	public void setCustomerId(java.lang.String value) {
		this.customerId = value;
	}
	
	public java.lang.String getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.String value) {
		this.userId = value;
	}
	
	public java.lang.String getProductCode() {
		return this.productCode;
	}
	
	public void setProductCode(java.lang.String value) {
		this.productCode = value;
	}
	
	public java.lang.String getSheetNo() {
		return this.sheetNo;
	}
	
	public void setSheetNo(java.lang.String value) {
		this.sheetNo = value;
	}
	
	public java.lang.String getCity() {
		return this.city;
	}
	
	public void setCity(java.lang.String value) {
		this.city = value;
	}
	
	public java.lang.String getMarketingCenter() {
		return this.marketingCenter;
	}
	
	public void setMarketingCenter(java.lang.String value) {
		this.marketingCenter = value;
	}
	
	public java.lang.String getArea() {
		return this.area;
	}
	
	public void setArea(java.lang.String value) {
		this.area = value;
	}
	
	public java.lang.String getInstalledAddr() {
		return this.installedAddr;
	}
	
	public void setInstalledAddr(java.lang.String value) {
		this.installedAddr = value;
	}
	
	public java.lang.String getLinkName() {
		return this.linkName;
	}
	
	public void setLinkName(java.lang.String value) {
		this.linkName = value;
	}
	
	public java.lang.String getLinkPhone() {
		return this.linkPhone;
	}
	
	public void setLinkPhone(java.lang.String value) {
		this.linkPhone = value;
	}
	
	public java.lang.String getPackages() {
		return this.packages;
	}
	
	public void setPackages(java.lang.String value) {
		this.packages = value;
	}
	
	public java.util.Date getAcceptTimeBegin() {
		return this.acceptTimeBegin;
	}
	
	public void setAcceptTimeBegin(java.util.Date value) {
		this.acceptTimeBegin = value;
	}	
	
	public java.util.Date getAcceptTimeEnd() {
		return this.acceptTimeEnd;
	}
	
	public void setAcceptTimeEnd(java.util.Date value) {
		this.acceptTimeEnd = value;
	}
	
	public java.lang.String getManagerName() {
		return this.managerName;
	}
	
	public void setManagerName(java.lang.String value) {
		this.managerName = value;
	}
	
	public java.lang.String getManagerPhone() {
		return this.managerPhone;
	}
	
	public void setManagerPhone(java.lang.String value) {
		this.managerPhone = value;
	}
	
	public java.lang.String getUpBandwidth() {
		return this.upBandwidth;
	}
	
	public void setUpBandwidth(java.lang.String value) {
		this.upBandwidth = value;
	}
	
	public java.lang.String getDownBandwidth() {
		return this.downBandwidth;
	}
	
	public void setDownBandwidth(java.lang.String value) {
		this.downBandwidth = value;
	}
	
	public java.lang.String getMaxBandwidth() {
		return this.maxBandwidth;
	}
	
	public void setMaxBandwidth(java.lang.String value) {
		this.maxBandwidth = value;
	}
	
	public java.lang.Integer getIpNum() {
		return this.ipNum;
	}
	
	public void setIpNum(java.lang.Integer value) {
		this.ipNum = value;
	}
	
	public java.lang.String getCpeType() {
		return this.cpeType;
	}
	
	public void setCpeType(java.lang.String value) {
		this.cpeType = value;
	}
	
	public java.lang.String getUserIdNo() {
		return this.userIdNo;
	}
	
	public void setUserIdNo(java.lang.String value) {
		this.userIdNo = value;
	}
	
	public java.lang.String getCpeDeviceCode() {
		return this.cpeDeviceCode;
	}
	
	public void setCpeDeviceCode(java.lang.String value) {
		this.cpeDeviceCode = value;
	}
	
	public Integer getSheetType() {
		return this.sheetType;
	}
	
	public void setSheetType(Integer value) {
		this.sheetType = value;
	}
	

	public String toString() {
 		return new StringBuilder()
					.append("Id=").append(getId())
					.append("BusiType=").append(getBusiType())
					.append("CustomerName=").append(getCustomerName())
					.append("OrderSign=").append(getOrderSign())
					.append("CustomerId=").append(getCustomerId())
					.append("UserId=").append(getUserId())
					.append("ProductCode=").append(getProductCode())
					.append("SheetNo=").append(getSheetNo())
					.append("City=").append(getCity())
					.append("MarketingCenter=").append(getMarketingCenter())
					.append("Area=").append(getArea())
					.append("InstalledAddr=").append(getInstalledAddr())
					.append("LinkName=").append(getLinkName())
					.append("LinkPhone=").append(getLinkPhone())
					.append("Packages=").append(getPackages())
					.append("AcceptTime").append("Begin=").append(getAcceptTimeBegin())
					.append("ManagerName=").append(getManagerName())
					.append("ManagerPhone=").append(getManagerPhone())
					.append("UpBandwidth=").append(getUpBandwidth())
					.append("DownBandwidth=").append(getDownBandwidth())
					.append("MaxBandwidth=").append(getMaxBandwidth())
					.append("IpNum=").append(getIpNum())
					.append("CpeType=").append(getCpeType())
					.append("UserIdNo=").append(getUserIdNo())
					.append("CpeDeviceCode=").append(getCpeDeviceCode())
					.append("SheetType=").append(getSheetType())
					.toString();
	}
}

