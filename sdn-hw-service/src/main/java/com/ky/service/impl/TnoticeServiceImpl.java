package com.ky.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ky.dao.TnoticeMapper;
import com.ky.model.Tnotice;
import com.ky.model.query.SpeedAdjustParams;
import com.ky.model.query.TnoticeQuery;
import com.ky.model.vo.TzxBusiVo;
import com.ky.sdn.common.base.BaseServiceImpl;
import com.ky.sdn.common.util.DateUtil;
import com.ky.service.TnoticeService;

@Service
public class TnoticeServiceImpl extends BaseServiceImpl<Tnotice> implements TnoticeService {
	@Autowired
	private TnoticeMapper tnoticeMapper;

	public Page findPage(TnoticeQuery query) {
		PageHelper.startPage(query.getPageNum(), query.getPageSize(), query.isCount());
		return tnoticeMapper.findPage(query);
	}

	@Override
	public boolean insertTnotice(SpeedAdjustParams params, TzxBusiVo tzxBusiVo,Long speedLogId) {
		String Content = "您的"+tzxBusiVo.getInstalledAddr()+"业务已成功由上下行"+tzxBusiVo.getUpBandwidth()+"/"+tzxBusiVo.getDownBandwidth()+"调至"+params.getUpSpeed()+"/"+params.getDownSpeed();
		Tnotice tnotice = new Tnotice();
		tnotice.setCompanyId(tzxBusiVo.getCompanyId());
		tnotice.setBusiId(tzxBusiVo.getId());
		tnotice.setBusiCode("ZXZX");
		tnotice.setBusiTypeId(1L);
		tnotice.setNoticeTypeId(1);
		tnotice.setType(1);
		tnotice.setRedirectId(speedLogId);
		tnotice.setTitle("调速成功");
		tnotice.setContent(Content);
		Date date = DateUtil.getDate(new Date());
		tnotice.setCreateTime(date);
		int numble = tnoticeMapper.insert(tnotice);
		if(numble > 0){
			return true;
		}
		return false;
	}



}