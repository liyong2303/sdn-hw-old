package com.ky.service;

import java.util.Map;

import com.ky.model.TzxBusi;

public interface ThourService {
	public void update(TzxBusi t,Integer optType);//更新时长

	public Map<String,String> find(TzxBusi t);//读取时长
}
