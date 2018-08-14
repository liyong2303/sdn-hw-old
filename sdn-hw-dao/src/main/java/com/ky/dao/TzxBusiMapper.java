package com.ky.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.ky.model.TzxBusi;
import com.ky.model.vo.TzxBusiVo;
import com.ky.sdn.common.base.BaseMapper;

public interface TzxBusiMapper extends BaseMapper<TzxBusi>{

	TzxBusiVo findTzxBusiVoById(@Param("id")Long id, @Param("busiType")String busiType);
	
	int updateZxStatusById(@Param("id")Long id,@Param("zxstatus")Long zxstatus, @Param("upSpeed")String upSpeed, @Param("downSpeed")String downSpeed, @Param("endTime")Date endTime);
	
}
