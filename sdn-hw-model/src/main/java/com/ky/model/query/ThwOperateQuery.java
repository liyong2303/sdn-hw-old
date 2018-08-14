package com.ky.model.query;


import com.ky.sdn.common.base.BaseQuery;



public class ThwOperateQuery extends BaseQuery  {
 
    

	/** id */
	private java.lang.Integer id;
	/** workOrderNo */
	private java.lang.String workOrderNo;
	/** vpnUuid */
	private java.lang.String vpnUUID;

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.String getWorkOrderNo() {
		return this.workOrderNo;
	}
	
	public void setWorkOrderNo(java.lang.String value) {
		this.workOrderNo = value;
	}

	public java.lang.String getVpnUUID() {
		return vpnUUID;
	}

	public void setVpnUUID(java.lang.String vpnUUID) {
		this.vpnUUID = vpnUUID;
	}

	@Override
	public String toString() {
		return "ThwOperateQuery [id=" + id + ", workOrderNo=" + workOrderNo + ", vpnUUID=" + vpnUUID + "]";
	}

	
}

