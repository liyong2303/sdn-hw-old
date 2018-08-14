package com.ky.service;

import java.util.Date;

import com.github.pagehelper.Page;
import com.ky.model.TspeedLog;
import com.ky.model.query.SpeedAdjustParams;
import com.ky.model.query.TspeedLogQuery;
import com.ky.model.vo.TzxBusiVo;
import com.ky.sdn.common.base.BaseService;


public interface TspeedLogService extends BaseService<TspeedLog>{
	
	public Page findPage(TspeedLogQuery query);
	public TspeedLog insertSpeedLog(SpeedAdjustParams params, TzxBusiVo tzxBusiVo, Date beginTime);
	public boolean updateSpeedLogByZxId(Long id, String upSpeed, String downSpeed, Long updateUserId,int countMins, Date endTime);
	public boolean updateSpeedLogByZxId(Long id, Long userId, int countMins, Date endTime);

}
