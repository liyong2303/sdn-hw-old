package com.ky.model;
/*
 *作者：barret
 *日期：2018年1月30日
 *
*/

import java.io.Serializable;

public class UpdateAccessPoint implements Serializable{
	
	private String qosAdjustPolicyName;
	private Integer qosBandWidth;
	private String tpTemplateName;
	
	
	public UpdateAccessPoint() {
		super();
	}
	public UpdateAccessPoint(String qosAdjustPolicyName, Integer qosBandWidth, String tpTemplateName) {
		super();
		this.qosAdjustPolicyName = qosAdjustPolicyName;
		this.qosBandWidth = qosBandWidth;
		this.tpTemplateName = tpTemplateName;
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
	public String getTpTemplateName() {
		return tpTemplateName;
	}
	public void setTpTemplateName(String tpTemplateName) {
		this.tpTemplateName = tpTemplateName;
	}
	@Override
	public String toString() {
		return "UpdateAccessPoint [qosAdjustPolicyName=" + qosAdjustPolicyName + ", qosBandWidth=" + qosBandWidth
				+ ", tpTemplateName=" + tpTemplateName + "]";
	}
	
}
