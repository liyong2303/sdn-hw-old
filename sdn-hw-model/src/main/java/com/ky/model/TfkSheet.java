package com.ky.model;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.ky.sdn.common.base.BaseEntity;

public class TfkSheet extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键 db_column: ID
	 */

	private Long id;
	/**
	 * 业务类型 db_column: BUSI_TYPE
	 */
	@Length(max = 255)
	private String busiType;
	/**
	 * 客户名称 db_column: CUSTOMER_NAME
	 */
	@Length(max = 255)
	private String customerName;
	/**
	 * 0=正常工单；1=撤销工单 db_column: ORDER_SIGN
	 */
	@Max(127)
	private Integer orderSign;
	/**
	 * 客户编码 db_column: CUSTOMER_ID
	 */
	@Length(max = 255)
	private String customerId;
	/**
	 * 用户ID db_column: USER_ID
	 */
	@Length(max = 255)
	private String userId;
	/**
	 * 产品号码 db_column: PRODUCT_CODE
	 */
	@Length(max = 255)
	private String productCode;
	/**
	 * 工单编码 db_column: SHEET_NO
	 */
	@Length(max = 255)
	private String sheetNo;
	/**
	 * 城市 db_column: CITY
	 */
	@Length(max = 255)
	private String city;
	/**
	 * 营销中心 db_column: MARKETING_CENTER
	 */
	@Length(max = 255)
	private String marketingCenter;
	/**
	 * 区县 db_column: AREA
	 */
	@Length(max = 255)
	private String area;
	/**
	 * 装机地址 db_column: INSTALLED_ADDR
	 */
	@Length(max = 255)
	private String installedAddr;
	/**
	 * 客户联系人姓名 db_column: LINK_NAME
	 */
	@Length(max = 255)
	private String linkName;
	/**
	 * 客户联系人手机号码 db_column: LINK_PHONE
	 */
	@Length(max = 255)
	private String linkPhone;
	/**
	 * 套餐 db_column: PACKAGES
	 */
	@Length(max = 255)
	private String packages;
	/**
	 * 受理时间 db_column: ACCEPT_TIME
	 */

	private java.util.Date acceptTime;
	/**
	 * 客户经理姓名 db_column: MANAGER_NAME
	 */
	@Length(max = 255)
	private String managerName;
	/**
	 * 客户经理电话 db_column: MANAGER_PHONE
	 */
	@Length(max = 255)
	private String managerPhone;
	/**
	 * 上行带宽，单位M db_column: UP_BANDWIDTH
	 */
	@Length(max = 255)
	private String upBandwidth;
	/**
	 * 下行带宽，单位M db_column: DOWN_BANDWIDTH
	 */
	@Length(max = 255)
	private String downBandwidth;
	/**
	 * 最大支持带宽，单位M db_column: MAX_BANDWIDTH
	 */
	@Length(max = 255)
	private String maxBandwidth;
	/**
	 * IP地址数量 db_column: IP_NUM
	 */

	private Integer ipNum;
	/**
	 * 光口、电口 db_column: CPE_TYPE
	 */
	@Length(max = 255)
	private String cpeType;
	/**
	 * 客户证件号码 db_column: USER_ID_NO
	 */
	@Length(max = 255)
	private String userIdNo;
	/**
	 * 预判CPE设备编码 db_column: CPE_DEVICE_CODE
	 */
	@Length(max = 255)
	private String cpeDeviceCode;
	// columns END

	public TfkSheet() {
	}

	public TfkSheet(java.lang.Long id) {
		this.id = id;
	}

	public void setId(Long value) {
		this.id = value;
	}

	public Long getId() {
		return this.id;
	}

	public void setBusiType(String value) {
		this.busiType = value;
	}

	public String getBusiType() {
		return this.busiType;
	}

	public void setCustomerName(String value) {
		this.customerName = value;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setOrderSign(Integer value) {
		this.orderSign = value;
	}

	public Integer getOrderSign() {
		return this.orderSign;
	}

	public void setCustomerId(String value) {
		this.customerId = value;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setUserId(String value) {
		this.userId = value;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setProductCode(String value) {
		this.productCode = value;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setSheetNo(String value) {
		this.sheetNo = value;
	}

	public String getSheetNo() {
		return this.sheetNo;
	}

	public void setCity(String value) {
		this.city = value;
	}

	public String getCity() {
		return this.city;
	}

	public void setMarketingCenter(String value) {
		this.marketingCenter = value;
	}

	public String getMarketingCenter() {
		return this.marketingCenter;
	}

	public void setArea(String value) {
		this.area = value;
	}

	public String getArea() {
		return this.area;
	}

	public void setInstalledAddr(String value) {
		this.installedAddr = value;
	}

	public String getInstalledAddr() {
		return this.installedAddr;
	}

	public void setLinkName(String value) {
		this.linkName = value;
	}

	public String getLinkName() {
		return this.linkName;
	}

	public void setLinkPhone(String value) {
		this.linkPhone = value;
	}

	public String getLinkPhone() {
		return this.linkPhone;
	}

	public void setPackages(String value) {
		this.packages = value;
	}

	public String getPackages() {
		return this.packages;
	}

	public void setAcceptTime(java.util.Date value) {
		this.acceptTime = value;
	}

	public java.util.Date getAcceptTime() {
		return this.acceptTime;
	}

	public void setManagerName(String value) {
		this.managerName = value;
	}

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerPhone(String value) {
		this.managerPhone = value;
	}

	public String getManagerPhone() {
		return this.managerPhone;
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

	public void setMaxBandwidth(String value) {
		this.maxBandwidth = value;
	}

	public String getMaxBandwidth() {
		return this.maxBandwidth;
	}

	public void setIpNum(Integer value) {
		this.ipNum = value;
	}

	public Integer getIpNum() {
		return this.ipNum;
	}

	public void setCpeType(String value) {
		this.cpeType = value;
	}

	public String getCpeType() {
		return this.cpeType;
	}

	public void setUserIdNo(String value) {
		this.userIdNo = value;
	}

	public String getUserIdNo() {
		return this.userIdNo;
	}

	public void setCpeDeviceCode(String value) {
		this.cpeDeviceCode = value;
	}

	public String getCpeDeviceCode() {
		return this.cpeDeviceCode;
	}

	public String toString() {
		return new StringBuilder().append("Id=").append(getId()).append("BusiType=").append(getBusiType())
				.append("CustomerName=").append(getCustomerName()).append("OrderSign=").append(getOrderSign())
				.append("CustomerId=").append(getCustomerId()).append("UserId=").append(getUserId())
				.append("ProductCode=").append(getProductCode()).append("SheetNo=").append(getSheetNo()).append("City=")
				.append(getCity()).append("MarketingCenter=").append(getMarketingCenter()).append("Area=")
				.append(getArea()).append("InstalledAddr=").append(getInstalledAddr()).append("LinkName=")
				.append(getLinkName()).append("LinkPhone=").append(getLinkPhone()).append("Packages=")
				.append(getPackages()).append("AcceptTime=").append(getAcceptTime()).append("ManagerName=")
				.append(getManagerName()).append("ManagerPhone=").append(getManagerPhone()).append("UpBandwidth=")
				.append(getUpBandwidth()).append("DownBandwidth=").append(getDownBandwidth()).append("MaxBandwidth=")
				.append(getMaxBandwidth()).append("IpNum=").append(getIpNum()).append("CpeType=").append(getCpeType())
				.append("UserIdNo=").append(getUserIdNo()).append("CpeDeviceCode=").append(getCpeDeviceCode())
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof TfkSheet == false)
			return false;
		if (this == obj)
			return true;
		TfkSheet other = (TfkSheet) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}
}
