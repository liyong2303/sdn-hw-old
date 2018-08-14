package com.ky.util;
/*
 *作者：barret
 *日期：2018年1月31日
 *
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 将输入流转换为字符串<br>
 * @param is 输入流
 * @return 字符串内容
 * @throws ServiceException
 */
public class StreamToStringUtil {
	private static Logger log = LoggerFactory.getLogger(StreamToStringUtil.class);
	
	
	public static String streamToString(InputStream is) throws Exception{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] temp = new byte[4096];

        try{
            int len;
            while ((len = is.read(temp)) > 0){
                bos.write(temp, 0, len);
            }
        }catch (IOException e){
            log.error(e.getMessage(),e);
            throw new Exception(e);
        }finally{
            try{
                is.close();
            }catch (IOException e){
                log.error(e.getMessage(),e);
            }
        }

        return new String(bos.toByteArray());
    }
}
