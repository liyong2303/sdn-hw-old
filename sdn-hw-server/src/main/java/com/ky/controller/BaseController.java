package com.ky.controller;
/*
 *作者：barret
 *日期：2018年1月30日
 *
*/

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class BaseController {

	private final static Logger log = LoggerFactory.getLogger(BaseController.class);
	
	/**
	 * 通用成功
	 */
	public final static int SUCCESS = 200;
	
	/**
	 * 通用错误
	 */
	public final static int FAIL = 500;
	
	/**
	 * 通用参数错误
	 */
	public final static int PARAM_ERROR = 400;
	
	protected static final String DATE_FORMAT = "yyyy-MM-dd";
	protected static final String TIME_FORMAT = "HH:mm:ss";
	protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	protected static final Gson GSON = new Gson();
	protected static final Gson GSON_DATE_TIME = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	protected static final Gson GSON_DATE = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	
	protected String getErrors(BindingResult br){
		StringBuilder msg = new StringBuilder();
		List fieldErrors = br.getFieldErrors();
		for(int i = 0;i < fieldErrors.size();i++){
			if(i > 0){
				msg.append(",");
			}
			msg.append(((FieldError) fieldErrors.get(i)).getDefaultMessage() + " ");
		}
		return msg.toString();
	}
	
	protected String getConditionErrors(BindingResult br, String... fields){
		StringBuilder msg = new StringBuilder();
		for(String field : fields){
			if(br.hasFieldErrors(field)){
				msg.append(br.getFieldError(field).getDefaultMessage() + " ");
			}
		}
		return msg.toString();
	}
	
	protected boolean hasConditionErrors(BindingResult br, String... fields) {
		boolean flag = false;
		for (String field : fields) {
			if (br.hasFieldErrors(field)) {
				flag = true;
				break;
			}
		}
		return flag;
	} 
}
