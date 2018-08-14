package com.ky.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ky.dao.TzxBusiMapper;
import com.ky.model.TzxBusi;
import com.ky.model.query.SpeedAdjustParams;
import com.ky.model.query.TzxBusiQuery;
import com.ky.model.vo.TzxBusiVo;
import com.ky.sdn.common.base.BaseServiceImpl;
import com.ky.sdn.common.util.DateUtil;
import com.ky.service.TzxBusiService;

@Service
public class TzxBusiServiceImpl extends BaseServiceImpl<TzxBusi> implements TzxBusiService {
	@Autowired
	private TzxBusiMapper tzxBusiMapper;

	public Page findPage(TzxBusiQuery query) {
		PageHelper.startPage(query.getPageNum(), query.getPageSize(), query.isCount());
		return tzxBusiMapper.findPage(query);
	}

	@Override
	public TzxBusiVo findTzxBusiVoById(Long id, String busiType) {
		return tzxBusiMapper.findTzxBusiVoById(id, busiType);
	}

	
	@Override
	public boolean updateZxStatus(SpeedAdjustParams params, TzxBusiVo tzxBusiVo) {
//		throw new RuntimeException("runtime e");   //这里用来测试service调用service是否可以回滚事务的，测试时可以的
		int num = 0;
		Date endTime = DateUtil.getDate(new Date());
		//TODO 判断降速还是升速的条件:传过来和查到的如果都一致就是降速
		if(params.getUpSpeed().equals(tzxBusiVo.getUpBandwidth()) && params.getDownSpeed().equals(tzxBusiVo.getDownBandwidth())){
			num = tzxBusiMapper.updateZxStatusById(params.getZxid(),0L,params.getUpSpeed(),params.getDownSpeed(), endTime);
		}else{
			num = tzxBusiMapper.updateZxStatusById(params.getZxid(), 1L,params.getUpSpeed(),params.getDownSpeed(), endTime);
		}
		if(num > 0){
			return true;
		}
		return false;
	}

}