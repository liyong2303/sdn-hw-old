package com.ky.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 标题: Property文件工具类 
 * 描述: 读取Property文件属性  
 *
 */
public class PropertyUtil {
	private static Logger logger = Logger.getLogger(PropertyUtil.class);

	//用于在内存中存储配置项，首次使用某项配置后将存入内存中，供下次使用
	private static Map<String, String> configureMap = new HashMap<String, String>();
		
	private static Properties properties = null;

	static {
		if (properties == null) {
			properties = new Properties();
		}
	}

	public static String getValue(String key) {
		if(configureMap.containsKey(key)) { 
			
			//如果内存中有就从内存中取
			return (String) configureMap.get(key);
		} else {
			
			//从系统配置文件中取，取完后放入内存中，供下次从内存中取用
			String value = getPropertys().getProperty(key);
			if(value == null) {
				
				logger.warn("未从配置文件中取到系统配置：" + key);
				return "";
			} else {
				configureMap.put(key, value);
				return value;
			}
		}
	}

	public static Properties getPropertys() {
		InputStream is2 = PropertyUtil.class.getClassLoader().getResourceAsStream("properties/config.properties");
		Reader r2 = new InputStreamReader(is2);
		try {
			properties.load(r2);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != r2) {
					r2.close();
				}
				if (null != is2) {
					is2.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
	
	public static Properties getPropertys(String fileName) {
		Properties p=new Properties();
		InputStream is2 = PropertyUtil.class.getClassLoader().getResourceAsStream(fileName);
		Reader r2 = new InputStreamReader(is2);
		try {
			p.load(r2);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != r2) {
					r2.close();
				}
				if (null != is2) {
					is2.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static String getValue(String key, String name){
		String value = getValue(key);
		return value.replace("{1}", name);
	}
	
	/**
	 * 清空内存中的配置,取值将重新加载
	 * （有时需要清空内存中的配置，如修改了系统配置时）
	 */
	public static void flush() {
		configureMap.clear();
		logger.info("清空内存中的系统配置,取值将重新加载");
	}
}
