package com.ky.model;
import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.ky.sdn.common.base.BaseEntity;


public class TzxBusi extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键       db_column: ID 
     */	
	private Long id;
    /**
     * 开通的工单号，冗余       db_column: SHEET_NO 
     */	
	private String sheetNo;
    /**
     * 产品ID       db_column: PRODUCT_CODE 
     */	
	private String productCode;
    /**
     * 客户公司ID       db_column: COMPANY_ID 
     */	
	private Long companyId;
    /**
     * 客户经理用户ID       db_column: MANGER_USER_ID 
     */	
	
	private Long mangerUserId;
    /**
     * 装机地址       db_column: INSTALLED_ADDR 
     */	
	private String installedAddr;
    /**
     * 上行带宽       db_column: UP_BANDWIDTH 
     */	
	private String upBandwidth;
    /**
     * 下行带宽       db_column: DOWN_BANDWIDTH 
     */	
	private String downBandwidth;
    /**
     * 当前上行       db_column: CURRENT_UP_BANDWIDTH 
     */	
	private String currentUpBandwidth;
    /**
     * 当前下行       db_column: CURRENT_DOWN_BANDWIDTH 
     */	
	private String currentDownBandwidth;
    /**
     * IP数量       db_column: IP_NUM 
     */	
	private Integer ipNum;
    /**
     * IP地址       db_column: IP 
     */	
	private String ip;
    /**
     * 0=当前未加速；1=当前正在加速       db_column: ZX_STATUS 
     */	
	private Integer zxStatus;
    /**
     * 当月已使用时长，单位，分钟       db_column: FREE_BANDWIDTH_USED 
     */	
	private Integer freeBandwidthUsed;
    /**
     * 当月免费时长额度，单位，分钟       db_column: FREE_BANDWIDTH_LIMIT 
     */	
	private Integer freeBandwidthLimit;
    /**
     * 创建时间       db_column: CREATE_TIME 
     */	
	private java.util.Date createTime;
    /**
     * 更新时间       db_column: UPDATE_TIME 
     */	
	private java.util.Date updateTime;
    /**
     * 1=正常状态，2=停机状态，禁用调速       db_column: TYPE 
     */	
	private Integer type;
	
    /**
     * 专线类型,ZXZX,YWZX       db_column: BUSI_CODE 
     */	
	private String busiCode;
    /**
     * 0=故障，1=正常，YWZX       db_column: NORMAL 
     */	
	private Integer normal;
	
	   /**
     * 故障处理状态，1=待处理2=处理中       db_column: BREAK_DOWN_STATUS 
     */	
	private Integer breakDownStatus;
	/**
     * 区号       db_column: EPARCHY_CODE 
     */	
	private String eparchyCode;
	//----非数据库字段
	private String mangerName;
	private String companyName;
	
	private String zxMaxUpParam;
	private String zxMaxDownParam;
	/**
	 * 服务器当前时间戳
	 */
	private Long serverTime;
	/**加速时长
	 * 
	 */
	private Integer bandWithUsed;
	
	/**
	 * 上次提速时间
	 */
	private Long lastOptTime;
	//columns END

	public TzxBusi(){
	}

	public TzxBusi(
		java.lang.Long id
	){
		this.id = id;
	}


	public TzxBusi(Long id, Long companyId) {
		this.id = id;
		this.companyId = companyId;
	}

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}

	public Integer getNormal() {
		return normal;
	}

	public void setNormal(Integer normal) {
		this.normal = normal;
	}

	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setSheetNo(String value) {
		this.sheetNo = value;
	}
	
	public String getSheetNo() {
		return this.sheetNo;
	}

	public void setProductCode(String value) {
		this.productCode = value;
	}
	
	public String getProductCode() {
		return this.productCode;
	}

	public void setCompanyId(Long value) {
		this.companyId = value;
	}
	
	public Long getCompanyId() {
		return this.companyId;
	}

	public void setMangerUserId(Long value) {
		this.mangerUserId = value;
	}
	
	public Long getMangerUserId() {
		return this.mangerUserId;
	}

	public void setInstalledAddr(String value) {
		this.installedAddr = value;
	}
	
	public String getInstalledAddr() {
		return this.installedAddr;
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

	public void setCurrentUpBandwidth(String value) {
		this.currentUpBandwidth = value;
	}
	
	public String getCurrentUpBandwidth() {
		return this.currentUpBandwidth;
	}

	public void setCurrentDownBandwidth(String value) {
		this.currentDownBandwidth = value;
	}
	
	public String getCurrentDownBandwidth() {
		return this.currentDownBandwidth;
	}

	public void setZxStatus(Integer value) {
		this.zxStatus = value;
	}
	
	public Integer getZxStatus() {
		return this.zxStatus;
	}

	public void setFreeBandwidthUsed(Integer value) {
		this.freeBandwidthUsed = value;
	}
	
	public Integer getFreeBandwidthUsed() {
		return this.freeBandwidthUsed;
	}

	public void setFreeBandwidthLimit(Integer value) {
		this.freeBandwidthLimit = value;
	}
	
	public Integer getFreeBandwidthLimit() {
		return this.freeBandwidthLimit;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
	}

	public Integer getIpNum() {
		return ipNum;
	}

	public void setIpNum(Integer ipNum) {
		this.ipNum = ipNum;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	 

	public String getMangerName() {
		return mangerName;
	}

	public void setMangerName(String mangerName) {
		this.mangerName = mangerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

 
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TzxBusi == false) return false;
		if(this == obj) return true;
		TzxBusi other = (TzxBusi)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

	public Integer getBreakDownStatus() {
		return breakDownStatus;
	}

	public void setBreakDownStatus(Integer breakDownStatus) {
		this.breakDownStatus = breakDownStatus;
	}

	public Long getServerTime() {
		return serverTime;
	}

	public void setServerTime(Long serverTime) {
		this.serverTime = serverTime;
	}

	public Integer getBandWithUsed() {
		return bandWithUsed;
	}

	public void setBandWithUsed(Integer bandWithUsed) {
		this.bandWithUsed = bandWithUsed;
	}

	public Long getLastOptTime() {
		return lastOptTime;
	}

	public void setLastOptTime(Long lastOptTime) {
		this.lastOptTime = lastOptTime;
	}

	public String getZxMaxUpParam() {
		return zxMaxUpParam;
	}

	public void setZxMaxUpParam(String zxMaxUpParam) {
		this.zxMaxUpParam = zxMaxUpParam;
	}

	public String getZxMaxDownParam() {
		return zxMaxDownParam;
	}

	public void setZxMaxDownParam(String zxMaxDownParam) {
		this.zxMaxDownParam = zxMaxDownParam;
	}

	public String getEparchyCode() {
		return eparchyCode;
	}

	public void setEparchyCode(String eparchyCode) {
		this.eparchyCode = eparchyCode;
	}

 
 

 
}

