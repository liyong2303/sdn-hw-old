package com.ky.model.query;
import com.ky.sdn.common.base.BaseQuery;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TzxBusiQuery extends BaseQuery implements Serializable {
 
    
    private static final long serialVersionUID = 1L;

    

	/** 主键 */
	private Long id;
	/** 开通的工单号，冗余 */
	private String sheetNo;
	/** 产品ID */
	private String productCode;
	/** 客户公司ID */
	private Long companyId;
	/** 客户经理用户ID */
	private Long mangerUserId;
	/** 装机地址 */
	private String installedAddr;
	/**
     * 区号       db_column: EPARCHY_CODE 
     */	
	private String eparchyCode;
	/** 上行带宽 */
	private String upBandwidth;
	/** 下行带宽 */
	private String downBandwidth;
	/** 当前上行 */
	private String currentUpBandwidth;
	/** 当前下行 */
	private String currentDownBandwidth;
	/** IP数量 */
	private Integer ipNum;
	/** IP地址 */
	private String ip;
	/** 0=当前未加速；1=当前正在加速 */
	private Integer zxStatus;
	/** 当月已使用时长，单位，分钟 */
	private Integer freeBandwidthUsed;
	/** 当月免费时长额度，单位，分钟 */
	private Integer freeBandwidthLimit;
	/** 创建时间 */
	private java.util.Date createTime;
	private java.util.Date createTimeBegin;
	private java.util.Date createTimeEnd;
	/** 更新时间 */
	private java.util.Date updateTime;
	private java.util.Date updateTimeBegin;
	private java.util.Date updateTimeEnd;
	/** 1=正常状态，2=停机状态，禁用调速 */
	private Integer type;
    
	/** 专线类型,ZXZX,YWZX */
	private String busiCode;
	/** 0=故障，1=正常，YWZX */
	private Integer normal;
	/** 1=最近创建，2=最近告警 */
	private Integer timeSeq;
	/** 故障处理状态，1=待处理2=处理中 */
	private Integer breakDownStatus;
	
	//=============非数据库字段=======
	
	private String zxUpParam;
	private String zxDownParam;

	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long value) {
		this.id = value;
	}
	
	public String getSheetNo() {
		return this.sheetNo;
	}
	
	public void setSheetNo(String value) {
		this.sheetNo = value;
	}
	
	public String getProductCode() {
		return this.productCode;
	}
	
	public void setProductCode(String value) {
		this.productCode = value;
	}
	
	public Long getCompanyId() {
		return this.companyId;
	}
	
	public void setCompanyId(Long value) {
		this.companyId = value;
	}
	
	public Long getMangerUserId() {
		return this.mangerUserId;
	}
	
	public void setMangerUserId(Long value) {
		this.mangerUserId = value;
	}
	
	public String getInstalledAddr() {
		return this.installedAddr;
	}
	
	public void setInstalledAddr(String value) {
		this.installedAddr = value;
	}
	
	public String getUpBandwidth() {
		return this.upBandwidth;
	}
	
	public void setUpBandwidth(String value) {
		this.upBandwidth = value;
	}
	
	public String getDownBandwidth() {
		return this.downBandwidth;
	}
	
	public void setDownBandwidth(String value) {
		this.downBandwidth = value;
	}
	
	public String getCurrentUpBandwidth() {
		return this.currentUpBandwidth;
	}
	
	public void setCurrentUpBandwidth(String value) {
		this.currentUpBandwidth = value;
	}
	
	public String getCurrentDownBandwidth() {
		return this.currentDownBandwidth;
	}
	
	public void setCurrentDownBandwidth(String value) {
		this.currentDownBandwidth = value;
	}
	
	public Integer getZxStatus() {
		return this.zxStatus;
	}
	
	public void setZxStatus(Integer value) {
		this.zxStatus = value;
	}
	
	public Integer getFreeBandwidthUsed() {
		return this.freeBandwidthUsed;
	}
	
	public void setFreeBandwidthUsed(Integer value) {
		this.freeBandwidthUsed = value;
	}
	
	public Integer getFreeBandwidthLimit() {
		return this.freeBandwidthLimit;
	}
	
	public void setFreeBandwidthLimit(Integer value) {
		this.freeBandwidthLimit = value;
	}
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
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
	
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}
	
	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	
	public java.util.Date getUpdateTimeBegin() {
		return this.updateTimeBegin;
	}
	
	public void setUpdateTimeBegin(java.util.Date value) {
		this.updateTimeBegin = value;
	}	
	
	public java.util.Date getUpdateTimeEnd() {
		return this.updateTimeEnd;
	}
	
	public void setUpdateTimeEnd(java.util.Date value) {
		this.updateTimeEnd = value;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer value) {
		this.type = value;
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

	public Integer getTimeSeq() {
		return timeSeq;
	}

	public void setTimeSeq(Integer timeSeq) {
		this.timeSeq = timeSeq;
	}

	public Integer getBreakDownStatus() {
		return breakDownStatus;
	}

	public void setBreakDownStatus(Integer breakDownStatus) {
		this.breakDownStatus = breakDownStatus;
	}

	public String getZxUpParam() {
		return zxUpParam;
	}

	public void setZxUpParam(String zxUpParam) {
		this.zxUpParam = zxUpParam;
	}

	public String getZxDownParam() {
		return zxDownParam;
	}

	public void setZxDownParam(String zxDownParam) {
		this.zxDownParam = zxDownParam;
	}

	@Override
	public String toString() {
		return "TzxBusiQuery [id=" + id + ", sheetNo=" + sheetNo + ", productCode=" + productCode + ", companyId="
				+ companyId + ", mangerUserId=" + mangerUserId + ", installedAddr=" + installedAddr + ", eparchyCode="
				+ eparchyCode + ", upBandwidth=" + upBandwidth + ", downBandwidth=" + downBandwidth
				+ ", currentUpBandwidth=" + currentUpBandwidth + ", currentDownBandwidth=" + currentDownBandwidth
				+ ", ipNum=" + ipNum + ", ip=" + ip + ", zxStatus=" + zxStatus + ", freeBandwidthUsed="
				+ freeBandwidthUsed + ", freeBandwidthLimit=" + freeBandwidthLimit + ", createTime=" + createTime
				+ ", createTimeBegin=" + createTimeBegin + ", createTimeEnd=" + createTimeEnd + ", updateTime="
				+ updateTime + ", updateTimeBegin=" + updateTimeBegin + ", updateTimeEnd=" + updateTimeEnd + ", type="
				+ type + ", busiCode=" + busiCode + ", normal=" + normal + ", timeSeq=" + timeSeq + ", breakDownStatus="
				+ breakDownStatus + ", zxUpParam=" + zxUpParam + ", zxDownParam=" + zxDownParam + "]";
	}

	public String getEparchyCode() {
		return eparchyCode;
	}

	public void setEparchyCode(String eparchyCode) {
		this.eparchyCode = eparchyCode;
	}
 
 

 
}

