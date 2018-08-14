package com.ky.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ky.dao.TspeedLogMapper;
import com.ky.model.TspeedLog;
import com.ky.model.query.SpeedAdjustParams;
import com.ky.model.query.TspeedLogQuery;
import com.ky.model.vo.TzxBusiVo;
import com.ky.sdn.common.base.BaseServiceImpl;
import com.ky.sdn.hw.common.zx.ZxPackageUtil;
import com.ky.service.TspeedLogService;

@Service
public class TspeedLogServiceImpl extends BaseServiceImpl<TspeedLog> implements TspeedLogService {
	@Autowired
	private TspeedLogMapper tspeedLogMapper;

	public Page findPage(TspeedLogQuery query) {
		PageHelper.startPage(query.getPageNum(), query.getPageSize(), query.isCount());
		return tspeedLogMapper.findPage(query);
	}

	@Override
	public TspeedLog insertSpeedLog(SpeedAdjustParams params, TzxBusiVo tzxBusiVo,Date beginTime) {
		TspeedLog tspl = new TspeedLog();
		tspl.setBusiId(tzxBusiVo.getId());
		tspl.setFinished(0);
		TspeedLog one = tspeedLogMapper.queryOne(tspl);
		if(one != null){    //已经存在，不再插入
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		TspeedLog tspeedLog = new TspeedLog();
		tspeedLog.setBusiId(params.getZxid());
		tspeedLog.setCompanyId(tzxBusiVo.getCompanyId());
		tspeedLog.setUserId(params.getUserId());
		tspeedLog.setUpBandwidth(tzxBusiVo.getUpBandwidth());
		tspeedLog.setDownBandwidth(tzxBusiVo.getDownBandwidth());
		tspeedLog.setUpBandwidthSpeeded(params.getUpSpeed());
		tspeedLog.setDownBandwidthSpeeded(params.getDownSpeed());
		tspeedLog.setCurrentMonth(Integer.valueOf(sdf.format(Calendar.getInstance().getTime())));
		tspeedLog.setProductCode(tzxBusiVo.getProductCode());
		int optType = swithOptType(params,tzxBusiVo);
		if(optType == -1){
			return null;
		}
		tspeedLog.setOptType(optType);
		tspeedLog.setBeginTime(beginTime);
		tspeedLog.setFinished(0);
		//TODO 
		int number = tspeedLogMapper.insert(tspeedLog);
		if(number > 0){
			return tspeedLog;
		}
		return null;
		
		
	}

	
	private Integer swithOptType(SpeedAdjustParams params, TzxBusiVo tzxBusiVo){
		Map<String, String> maxSpeed = ZxPackageUtil.getMaxBandwith(tzxBusiVo.getUpBandwidth(), tzxBusiVo.getDownBandwidth());
//		if(query.getUpBandwidth().equals("10M")||query.getUpBandwidth().equals("20M")||query.getUpBandwidth().equals("30M")||query.getUpBandwidth().equals("50M")||(query.getUpBandwidth().equals("100M")&&t.getUpBandwidth().equals("100M"))){
		if(params.getUpSpeed().equals("10M") || params.getUpSpeed().equals("20M") || params.getUpSpeed().equals("30M") || params.getUpSpeed().equals("50M") || (params.getUpSpeed().equals("100M")&& tzxBusiVo.getUpBandwidth().equals("100M"))){
			return 2;
		}
		if(params.getDownSpeed().equals("10M")||params.getDownSpeed().equals("20M")||params.getDownSpeed().equals("30M")||params.getDownSpeed().equals("50M")||(params.getDownSpeed().equals("100M")&&tzxBusiVo.getDownBandwidth().equals("100M"))){
			return 1;
		}
		if(params.getUpSpeed().equals(maxSpeed.get("upBandwidth")) && params.getDownSpeed().equals(maxSpeed.get("downBandwidth"))){
			return 0;
		}
		return -1;
	}

	@Override
	public boolean updateSpeedLogByZxId(Long id,String upSpeed,String downSpeed,Long updateUserId,int countMins, Date endTime) {
		int number = tspeedLogMapper.updateSpeedLogByZxIdAndFinished(id,1L,upSpeed,downSpeed,updateUserId, countMins, endTime);
		if(number > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSpeedLogByZxId(Long id, Long updateUserId,int countMins, Date endTime) {
		int number = tspeedLogMapper.updateAsySpeedLogByZxIdAndFinished(id,1L,updateUserId, countMins, endTime);
		if(number > 0){
			return true;
		}
		return false;
	}

}