package com.ky.model.reponse;
/*
 *作者：barret
 *日期：2018年1月31日
 *
*/

public class OperateReponseBodyParams {

	private String WorkOrderNo;
	private String vpnUUID;
	
	/**
	 * 非协同器返回字段
	 * */
	private Long busiId;
	private String productCode;
	
	public Long getBusiId() {
		return busiId;
	}
	public void setBusiId(Long busiId) {
		this.busiId = busiId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public OperateReponseBodyParams() {
		super();
	}
	public OperateReponseBodyParams(String workOrderNo, String vpnUUID) {
		super();
		WorkOrderNo = workOrderNo;
		this.vpnUUID = vpnUUID;
	}
	public String getWorkOrderNo() {
		return WorkOrderNo;
	}
	public void setWorkOrderNo(String workOrderNo) {
		WorkOrderNo = workOrderNo;
	}
	public String getVpnUUID() {
		return vpnUUID;
	}
	public void setVpnUUID(String vpnUUID) {
		this.vpnUUID = vpnUUID;
	}
//	@Override
//	public String toString() {
//		return "OperateReponseBodyParams [WorkOrderNo=" + WorkOrderNo + ", vpnUUID=" + vpnUUID + "]";
//	}
	@Override
	public String toString() {
		return "OperateReponseBodyParams [WorkOrderNo=" + WorkOrderNo + ", vpnUUID=" + vpnUUID + ", busiId=" + busiId
				+ ", productCode=" + productCode + "]";
	}
	
}
