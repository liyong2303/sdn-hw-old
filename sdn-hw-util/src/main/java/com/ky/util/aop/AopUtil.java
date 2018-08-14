package com.ky.util.aop;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ky.model.query.TaopQuery;
import com.ky.model.vo.TaopResult;
import com.ky.sdn.common.util.AppConfig;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * @author kk<br>
 * AOP返回400、200、500、501的通讯码，501表示AOP中查询不到对应的数据
 *
 */
public class AopUtil {

	private final static String URL = AppConfig.getInstance().get("aop.url");
	private static final Logger log = LoggerFactory.getLogger(AopUtil.class);

	public static TaopResult queryAop(TaopQuery query) {
		TaopResult result = new TaopResult();
		try {
			ClientConfig cc = new DefaultClientConfig();
			Client client = Client.create(cc);
			WebResource resource = client.resource(URL);
			JSONObject req = new JSONObject();
			req.put("productCode", query.getProudctCode());
			req.put("eparchyCode", query.getEparchyCode());
			req.put("queryTime", query.getQueryTime());
			log.debug(req.toString());
			ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, req);
			log.debug(response.toString());
			JSONObject resp = response.getEntity(JSONObject.class);
			log.debug(resp.toString());
			log.info("freeTimeLeft:" + resp.getJSONObject("data").getString("freeTimeLeft") + "\trealTotalCost:"+resp.getJSONObject("data").getString("realTotalCost"));
            result.setFreeTimeLeft(resp.getJSONObject("data").getString("freeTimeLeft"));
            result.setRealTotalCost(resp.getJSONObject("data").getString("realTotalCost"));
            result.setMsg(resp.getString("msg"));
		} catch (Exception e) {
			log.error("", e);
		}
		return result;

	}
}
