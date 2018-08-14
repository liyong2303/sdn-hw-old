package com.ky.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置信息
 * <br>
 */
public final class Config{
    /**
     * 单实例
     */
    private static final Config instance = new Config();

    private Properties props;
    
    public static Config getInstance(){
        return instance;
    }
    
    private Config(){
        props = new Properties();
        InputStream in = null;
        try{
	        in = ClassLoader.class.getResourceAsStream("/properties/config.properties");
            props.load(in);
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(in!=null){
                try{
                	in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public String getProperty(String propName){
        return this.props.getProperty(propName);
    }
    
}