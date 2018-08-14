package com.ky.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ky.model.CommonInfo;
import com.ky.model.HwConstant;
import com.ky.model.UpdateAccessPoint;
import com.ky.model.UpdateServiceInfo;
import com.ky.model.query.LoginRequestBodyParams;

/*
 *作者：barret
 *日期：2018年1月30日
 *
*/

public class BuildRequestBodyUtil {

	/**
	 * 创建登录请求body
	 * @return
	 */
	public static String buildLogonBody(){
		return JSONObject.toJSONString(new LoginRequestBodyParams(PropertyUtil.getValue("grantType"), PropertyUtil.getValue("userName"), PropertyUtil.getValue("value")));
	}
	
	/**
	 * 创建调速请求body
	 * @param accessPoint
	 * @return
	 */
	public static String buildBodRequestBody(List<UpdateAccessPoint> accessPoint){
		return "{" +"\"commonInfo\":"+JSONObject.toJSONString(new CommonInfo(PropertyUtil.getValue("workOrderNo"), "", "BOD", PropertyUtil.getValue("customerID"), PropertyUtil.getValue("customerName"), PropertyUtil.getValue("customerAddress"), PropertyUtil.getValue("orderNumber"), PropertyUtil.getValue("orderType"), PropertyUtil.getValue("businessType")))
		+","+"\"serviceInfo\":"+JSONObject.toJSONString(new UpdateServiceInfo("", PropertyUtil.getValue("businessID"), PropertyUtil.getValue("serviceType"), PropertyUtil.getValue("name"), "", accessPoint))+"}";
	}
	
	/**
	 * 创建调速请求body
	 * @param commonInfo 公共对象
	 * @param serviceInfo 调速对象
	 * @return
	 */
	public static String buildBodRequestBody(CommonInfo commonInfo,UpdateServiceInfo serviceInfo){
		return "{" +"\"commonInfo\":"+JSONObject.toJSONString(commonInfo)
		+","+"\"serviceInfo\":"+JSONObject.toJSONString(serviceInfo)+"}";
	}
	
	
	
	public static void main(String[] args) {
		List<UpdateAccessPoint> accessPoint = new ArrayList<>();
		UpdateAccessPoint uppoint = new UpdateAccessPoint(HwConstant.SDUTN_10M_10M, 10000, "UNI");
		UpdateAccessPoint downpoint = new UpdateAccessPoint(HwConstant.SDUTN_10M_10M, 10000, "UNI");
		accessPoint.add(uppoint);
		accessPoint.add(downpoint);
		System.out.println(buildBodRequestBody(accessPoint));
	}
	
}
