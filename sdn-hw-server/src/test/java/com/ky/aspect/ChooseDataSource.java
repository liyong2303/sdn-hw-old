package com.ky.aspect;
/*
 *作者：barret
 *日期：2018年2月1日
 *
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class ChooseDataSource extends AbstractRoutingDataSource{
	private Logger log  = LoggerFactory.getLogger(ChooseDataSource.class);
	
	public static Map<String,List<String>> METHOD_TYPE_MAP = new HashedMap();

	/**
	 * 实现父类中的抽象方法，获取数据源名称
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHandler.getDataSource();
	}
	
	//设置方法名前缀对应的数据源
	public void setMethodType(Map<String,String> map){
		for(String key : map.keySet()){
			List<String> v = new ArrayList<String>();
			String[] types = map.get(key).split(",");
			for(String type : types){
				if(StringUtils.isNotBlank(type)){
					v.add(type);
				}
			}
			log.info("key:"+key+"\t v:"+v);
			METHOD_TYPE_MAP.put(key, v);
		}
	}
	
	
}
