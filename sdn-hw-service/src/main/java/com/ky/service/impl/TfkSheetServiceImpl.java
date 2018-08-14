package com.ky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ky.dao.TfkSheetMapper;
import com.ky.model.TfkSheet;
import com.ky.model.query.TfkSheetQuery;
import com.ky.sdn.common.base.BaseServiceImpl;
import com.ky.service.TfkSheetService;

@Service
public class TfkSheetServiceImpl extends BaseServiceImpl<TfkSheet> implements TfkSheetService {
	@Autowired
	private TfkSheetMapper tfkSheetMapper;

	public Page findPage(TfkSheetQuery query) {
		PageHelper.startPage(query.getPageNum(), query.getPageSize(), query.isCount());
		return tfkSheetMapper.findPage(query);
	}



}