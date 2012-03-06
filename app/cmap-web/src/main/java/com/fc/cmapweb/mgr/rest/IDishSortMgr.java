package com.fc.cmapweb.mgr.rest;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.DishSortVo;

public interface IDishSortMgr {
	
	public List<DishSortVo> queryAllDishSort(String restId);
	
	public void updateDishSort(String dishSortId, Map<String, Object> updateParams);
	
	public boolean updateEnableDisable(String dishSortId);
	public int queryDishSortCount(String restId);
	public List<DishSortVo> queryDishSort(String restId, int currentPage, int pageSize);
	
	public DishSortVo addDishSort(DishSortVo dishSortVo, String restId);
	public DishSortVo queryDishSort(String dishSortId);
	public void rmDishSort(String dishSortId);
	
}
