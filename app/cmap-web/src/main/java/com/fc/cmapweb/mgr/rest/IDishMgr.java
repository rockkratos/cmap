package com.fc.cmapweb.mgr.rest;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.DishInfoVo;

public interface IDishMgr {
	
	public List<DishInfoVo> queryDish(Map<String, Object> queryParams, String restId, int currentPage, int pageSize);
	public int queryDishCount(String restId);

}
