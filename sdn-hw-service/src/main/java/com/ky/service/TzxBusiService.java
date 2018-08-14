package com.ky.service;

import com.github.pagehelper.Page;
import com.ky.model.TzxBusi;
import com.ky.model.query.SpeedAdjustParams;
import com.ky.model.query.TzxBusiQuery;
import com.ky.model.vo.TzxBusiVo;
import com.ky.sdn.common.base.BaseService;


public interface TzxBusiService extends BaseService<TzxBusi>{

	public Page findPage(TzxBusiQuery query);

	public TzxBusiVo findTzxBusiVoById(Long id,String busiType);
	
	public boolean updateZxStatus(SpeedAdjustParams params, TzxBusiVo tzxBusiVo);
}
