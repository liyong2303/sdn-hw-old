package com.ky.service;

import com.github.pagehelper.Page;
import com.ky.model.TfkSheet;
import com.ky.model.query.TfkSheetQuery;
import com.ky.sdn.common.base.BaseService;


public interface TfkSheetService extends BaseService<TfkSheet>{
public Page findPage(TfkSheetQuery query);

}
