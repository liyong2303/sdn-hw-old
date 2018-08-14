package com.ky.service;
/*
 *作者：barret
 *日期：2018年1月31日
 *
*/

import java.util.List;

import com.ky.model.UpdateAccessPoint;
import com.ky.model.query.SpeedAdjustParams;
import com.ky.model.vo.TzxBusiVo;

public interface VpnOperateService {

	public String vpnUpdate(String roaRand,String accessSession,List<UpdateAccessPoint> accessPoint);
	public String vpnUpdate(String roaRand,String accessSession,String requestbody);
	public boolean synDbStatus(SpeedAdjustParams params, TzxBusiVo tzxBusiVo);
	public boolean synRecoverDbStatus(SpeedAdjustParams initparams, TzxBusiVo tzxBusiVo);

	public boolean synRecoverDbStatusDown(SpeedAdjustParams initparams, TzxBusiVo tzxBusiVo);
}
