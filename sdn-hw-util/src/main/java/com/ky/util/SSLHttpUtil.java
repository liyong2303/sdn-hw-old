package com.ky.util;
/*
 *作者：barret
 *日期：2018年1月31日
 *
*/

import java.io.IOException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSLHttpUtil {
	private static Logger log = LoggerFactory.getLogger(SSLHttpUtil.class);
	
	@SuppressWarnings("deprecation")
	public static String sendSSLHttp(HttpRequestBase httpRequest){
		CloseableHttpClient client = null;
		try {
			 SSLContextBuilder sslBuilder = SSLContexts.custom();
	            sslBuilder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
	            sslBuilder.useTLS();
	            SSLContext sslContext = sslBuilder.build();
	            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext,
	                    new AllowAllHostnameVerifier());

	            client = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

	            HttpResponse httpResponse = client.execute(httpRequest);
	            int statusCode = httpResponse.getStatusLine().getStatusCode();
                log.info("statusCode:"+statusCode);
                log.info("协同器返回:"+httpResponse.toString());
	            String strRsp = StreamToStringUtil.streamToString(httpResponse.getEntity().getContent());
	            log.info("协同器返回：--------"+strRsp);
	            if(statusCode >=200 && statusCode <=299){
	                return strRsp;
	            }
	            return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if (client != null){
               try{
                   client.close();
               }catch (IOException e) {
                   log.error(e.getMessage(),e);
               }
           }
		}
	}
}
