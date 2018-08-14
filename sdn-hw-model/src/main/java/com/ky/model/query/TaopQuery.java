package com.ky.model.query;

import com.ky.sdn.common.base.BaseQuery;

public class TaopQuery extends BaseQuery {
	private String proudctCode;
	private String queryTime;
	private String eparchyCode;

	public TaopQuery(String proudctCode, String queryTime, String eparchyCode) {
 		this.proudctCode = proudctCode;
		this.queryTime = queryTime;
		this.eparchyCode = eparchyCode;
	}

	public String getProudctCode() {
		return proudctCode;
	}

	public void setProudctCode(String proudctCode) {
		this.proudctCode = proudctCode;
	}

	public String getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}

	@Override
	public String toString() {
		return "TaopQuery [proudctCode=" + proudctCode + ", queryTime=" + queryTime + ", eparchyCode=" + eparchyCode
				+ "]";
	}

	public String getEparchyCode() {
		return eparchyCode;
	}

	public void setEparchyCode(String eparchyCode) {
		this.eparchyCode = eparchyCode;
	}

}
