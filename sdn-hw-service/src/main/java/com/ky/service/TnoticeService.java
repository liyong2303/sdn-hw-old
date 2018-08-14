package com.ky.service;

import com.github.pagehelper.Page;
import com.ky.model.Tnotice;
import com.ky.model.query.SpeedAdjustParams;
import com.ky.model.query.TnoticeQuery;
import com.ky.model.vo.TzxBusiVo;
import com.ky.sdn.common.base.BaseService;


public interface TnoticeService extends BaseService<Tnotice>{
	public Page findPage(TnoticeQuery query);
	public boolean insertTnotice(SpeedAdjustParams params, TzxBusiVo tzxBusiVo,Long speedLogId);

}
