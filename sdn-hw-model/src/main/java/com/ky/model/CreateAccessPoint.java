package com.ky.model;

import java.io.Serializable;

/*
 *作者：barret
 *日期：2018年1月30日
 *
*/

public class CreateAccessPoint implements Serializable{

	/** CPE设备ID或设备名称*/
	private String neKey;
	/** 所选的CPE上的端口ID或端口名称*/
	private String tpKey;
	/** 接入类型*/
	private String accessType;
	/** 流在接口上的动作*/
	private String accessAction;
	/** VLANID*/
	private String vlanID;
	/** Qos调整策略*/
	private String qosAdjustPolicyName;
	/** 下行带宽*/
	private Integer qosBandWidth;
	/** 上行带宽*/
	private Integer upstreamQosBandWidth;
	/** TP模板名称*/
	private String tpTemplateName;
	
	
	public CreateAccessPoint() {
		super();
	}

	public CreateAccessPoint(String neKey, String tpKey, String accessType, String accessAction, String vlanID,
			String qosAdjustPolicyName, Integer qosBandWidth, Integer upstreamQosBandWidth, String tpTemplateName) {
		super();
		this.neKey = neKey;
		this.tpKey = tpKey;
		this.accessType = accessType;
		this.accessAction = accessAction;
		this.vlanID = vlanID;
		this.qosAdjustPolicyName = qosAdjustPolicyName;
		this.qosBandWidth = qosBandWidth;
		this.upstreamQosBandWidth = upstreamQosBandWidth;
		this.tpTemplateName = tpTemplateName;
	}

	public String getNeKey() {
		return neKey;
	}

	public void setNeKey(String neKey) {
		this.neKey = neKey;
	}

	public String getTpKey() {
		return tpKey;
	}

	public void setTpKey(String tpKey) {
		this.tpKey = tpKey;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getAccessAction() {
		return accessAction;
	}

	public void setAccessAction(String accessAction) {
		this.accessAction = accessAction;
	}

	public String getVlanID() {
		return vlanID;
	}

	public void setVlanID(String vlanID) {
		this.vlanID = vlanID;
	}

	public String getQosAdjustPolicyName() {
		return qosAdjustPolicyName;
	}

	public void setQosAdjustPolicyName(String qosAdjustPolicyName) {
		this.qosAdjustPolicyName = qosAdjustPolicyName;
	}

	public Integer getQosBandWidth() {
		return qosBandWidth;
	}

	public void setQosBandWidth(Integer qosBandWidth) {
		this.qosBandWidth = qosBandWidth;
	}

	public Integer getUpstreamQosBandWidth() {
		return upstreamQosBandWidth;
	}

	public void setUpstreamQosBandWidth(Integer upstreamQosBandWidth) {
		this.upstreamQosBandWidth = upstreamQosBandWidth;
	}

	public String getTpTemplateName() {
		return tpTemplateName;
	}

	public void setTpTemplateName(String tpTemplateName) {
		this.tpTemplateName = tpTemplateName;
	}

	@Override
	public String toString() {
		return "AccessPoint [neKey=" + neKey + ", tpKey=" + tpKey + ", accessType=" + accessType + ", accessAction="
				+ accessAction + ", vlanID=" + vlanID + ", qosAdjustPolicyName=" + qosAdjustPolicyName
				+ ", qosBandWidth=" + qosBandWidth + ", upstreamQosBandWidth=" + upstreamQosBandWidth
				+ ", tpTemplateName=" + tpTemplateName + "]";
	}
	
}
