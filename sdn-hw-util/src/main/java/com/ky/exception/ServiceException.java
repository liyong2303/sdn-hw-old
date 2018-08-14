package com.ky.exception;
/*
 *作者：barret
 *日期：2018年1月30日
 *
*/

public class ServiceException extends Exception{

	/**
     * 序列化ID
     */
    private static final long serialVersionUID = -6182763319294000267L;
    
    private int statusCode = 500;
    
    /**
     * 构造函数 <br>
     * <br>
     */
    public ServiceException(int code){
        super();
        this.statusCode = code;
    }
    
    /**
     * 构造函数 <br>
     * @param message
     * @param cause
     */
    public ServiceException(String message,Throwable cause){
    	super(message,cause);
    }
    
    /**
     * 构造函数 <br>
     * <br>
     * @param message
     */
    public ServiceException(int statusCode, String message){
        super(message);
    }

    /**
     * 构造函数 <br>
     * <br>
     * @param cause
     */
    public ServiceException(Throwable cause){
        super(cause);
    }

    /**
     * 状态码<br>
     * @return
     */
    public int getStatusCode(){
        return statusCode;
    }

    /**
     * 状态<br>
     * @param statusCode
     */
    public void setStatusCode(int statusCode){
        this.statusCode = statusCode;
    }
}
