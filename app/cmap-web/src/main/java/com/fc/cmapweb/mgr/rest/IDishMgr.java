package com.fc.cmapweb.mgr.rest;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.DishInfoVo;

public interface IDishMgr {
	
	public void updateDish(String dishId, Map<String, Object> updateParams);
	public DishInfoVo queryDishInfo(String dishId);
	public boolean updateEnableDisable(String dishId);
	public void rmDish(String dishId);
	
	public DishInfoVo addDish(DishInfoVo dishInfoVo);
	public List<DishInfoVo> queryDish(Map<String, Object> queryParams, String restId, int currentPage, int pageSize);
	public int queryDishCount(String restId, Map<String, Object> queryParams);

}
