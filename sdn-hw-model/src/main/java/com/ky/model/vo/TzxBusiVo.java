package com.ky.model.vo;


import com.ky.sdn.common.base.BaseEntity;

public class TzxBusiVo extends BaseEntity {
	
	private Long id;
	private String sheetNo;
	private String productCode;
	private String customerId;
	private String installedAddr;
	private String customerName;
	private Integer zxStatus;
	private Long companyId;
	private String currentUpBandwidth;
	private String currentDownBandwidth;
	private String upBandwidth;
	private String downBandwidth;
	
	public TzxBusiVo() {
		super();
	}
	public TzxBusiVo(Long id, String sheetNo, String productCode, String customerId, String installedAddr,
			String customerName ,Integer zxStatus,Long companyId,String currentUpBandwidth,String currentDownBandwidth,
			String upBandwidth,String downBandwidth) {
		super();
		this.id = id;
		this.sheetNo = sheetNo;
		this.productCode = productCode;
		this.customerId = customerId;
		this.installedAddr = installedAddr;
		this.customerName = customerName;
		this.zxStatus = zxStatus;
		this.companyId = companyId;
		this.currentUpBandwidth = currentUpBandwidth;
		this.currentDownBandwidth = currentDownBandwidth;
		this.upBandwidth = upBandwidth;
		this.downBandwidth = downBandwidth;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSheetNo() {
		return sheetNo;
	}
	public void setSheetNo(String sheetNo) {
		this.sheetNo = sheetNo;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getInstalledAddr() {
		return installedAddr;
	}
	public void setInstalledAddr(String installedAddr) {
		this.installedAddr = installedAddr;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getZxStatus() {
		return zxStatus;
	}
	public void setZxStatus(Integer zxStatus) {
		this.zxStatus = zxStatus;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCurrentUpBandwidth() {
		return currentUpBandwidth;
	}
	public void setCurrentUpBandwidth(String currentUpBandwidth) {
		this.currentUpBandwidth = currentUpBandwidth;
	}
	public String getCurrentDownBandwidth() {
		return currentDownBandwidth;
	}
	public void setCurrentDownBandwidth(String currentDownBandwidth) {
		this.currentDownBandwidth = currentDownBandwidth;
	}
	public String getUpBandwidth() {
		return upBandwidth;
	}
	public void setUpBandwidth(String upBandwidth) {
		this.upBandwidth = upBandwidth;
	}
	public String getDownBandwidth() {
		return downBandwidth;
	}
	public void setDownBandwidth(String downBandwidth) {
		this.downBandwidth = downBandwidth;
	}
	@Override
	public String toString() {
		return "TzxBusiVo [id=" + id + ", sheetNo=" + sheetNo + ", productCode=" + productCode + ", customerId="
				+ customerId + ", installedAddr=" + installedAddr + ", customerName=" + customerName + ", zxStatus="
				+ zxStatus + ", companyId=" + companyId + ", currentUpBandwidth=" + currentUpBandwidth
				+ ", currentDownBandwidth=" + currentDownBandwidth + ", upBandwidth=" + upBandwidth + ", downBandwidth="
				+ downBandwidth + "]";
	}
	
}

