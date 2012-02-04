package com.fc.cmapweb.mgr.rest;

import com.fc.cmapweb.vo.DishSortVo;

public interface IDishSortMgr {
	
	public DishSortVo addDishSort(DishSortVo dishSortVo);
	public DishSortVo queryDishSort(String dishSortId);
	public void rmDishSort(String dishSortId);

}
