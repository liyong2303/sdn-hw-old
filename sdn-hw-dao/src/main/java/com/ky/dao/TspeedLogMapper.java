package com.ky.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.ky.model.TspeedLog;
import com.ky.sdn.common.base.BaseMapper;

public interface TspeedLogMapper extends BaseMapper<TspeedLog>{

	int insert(TspeedLog tspeedLog);

	int updateSpeedLogByZxIdAndFinished(@Param("busiId")Long busiId, @Param("finished")Long finished, @Param("upspeed")String upSpeed, @Param("downspeed")String downSpeed, @Param("updateUserId")Long updateUserId,  @Param("countMins")int countMins, @Param("endTime")Date endTime);

	int updateAsySpeedLogByZxIdAndFinished(@Param("busiId")Long busiId, @Param("finished")Long finished, @Param("updateUserId")Long updateUserId,@Param("countMins")int countMins, @Param("endTime")Date endTime);
	
	public int querySum(TspeedLog tspeedLog);
}
