package com.ky.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.ky.dao.TspeedLogMapper;
import com.ky.model.TspeedLog;
import com.ky.model.TzxBusi;
import com.ky.sdn.common.util.DateUtil;
import com.ky.service.ThourService;

@Component
public class ThourServiceImpl implements ThourService {
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private TspeedLogMapper tspeedLogMapper;
	private static final String KEY_PREFIX = "SDN_MINS_";
	private static final String KEY_LAST="latestOptTime";
	private static final String KEY_MINUTES="minutes";

	/**
	 * @param t
	 * @param optType 1=提速2=降速
	 */
	@Override
	public void update(TzxBusi t,Integer optType) {

		// key值的规则 SDN_MINS__${product_code}
		String key = KEY_PREFIX + t.getProductCode();

		if (redisTemplate.hasKey(key)) {
			if(optType.intValue()==2){
				//降速，回写时长
				int minutes=Integer.parseInt(redisTemplate.opsForHash().get(key, KEY_MINUTES)+"");
				long mills=Long.parseLong(redisTemplate.opsForHash().get(key, KEY_LAST)+"");
				long current=System.currentTimeMillis();
				Date d1=new Date();
				d1.setTime(mills);
				Date d2=new Date();
				d2.setTime(current);
				int mis=DateUtil.countMin(d1, d2);
				int sum=minutes+mis;
				redisTemplate.opsForHash().put(key, KEY_MINUTES, sum+"");


				
			}else{
				//提速，回写操作时间
				redisTemplate.opsForHash().put(key, KEY_LAST, System.currentTimeMillis()+"");
			}

		} else {
            if(optType.intValue()==2){
            	//进行了停止加速的操作，这种情况下不可能key不存在的;存在这种情况则表示key丢失了可能是人为删除，可能是redis服务器数据挂过;这种情况下要到数据库获取并且重set key值
            	TspeedLog log = new TspeedLog();
        		log.setBusiId(t.getId());
        		log.setCurrentMonth(DateUtil.getCurrentYearMonth());
        		int minutes=tspeedLogMapper.querySum(log);
        	 	HashMap<String,String> map=new HashMap<String,String>();
				map.put(KEY_LAST,System.currentTimeMillis()+"");
				map.put(KEY_MINUTES,minutes+"");
	    		redisTemplate.opsForHash().putAll(key, map);
            }else{
            	//表示进行了加速的操作；而且是首次加速
            	HashMap<String,String> map=new HashMap<String,String>();
				map.put(KEY_LAST,System.currentTimeMillis()+"");
				map.put(KEY_MINUTES,"0");
	    		redisTemplate.opsForHash().putAll(key, map);
            	
            }
		}

	}

	@Override
	public Map<String,String> find(TzxBusi t) {
		String key = KEY_PREFIX + t.getProductCode();
		Map<String,String> map=new HashMap<String,String>();
 
		if(redisTemplate.hasKey(key)){
			
			map=redisTemplate.opsForHash().entries(key);

		}else{
			map.put(KEY_MINUTES, "0");
			map.put(KEY_LAST, "0");
		}
		
		return map;

	}

}
