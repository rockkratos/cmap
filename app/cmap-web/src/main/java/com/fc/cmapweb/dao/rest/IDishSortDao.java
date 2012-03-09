package com.fc.cmapweb.dao.rest;

import java.util.List;

import com.fc.cmapweb.vo.DishSortVo;

public interface IDishSortDao {
	
	public void delDishSortByRest(String restId);
	
	public List<DishSortVo> getAllDishSort(String restId);
	
	public DishSortVo updateDishSort(DishSortVo dishSortVo);
	
	public boolean switchEnableDisable(String dishSortId);
	public int getDishSortCount(String restId);
	public List<DishSortVo> getDishSort(String restId, int currentPage, int pageSize);
	
	public DishSortVo insertDishSort(DishSortVo dishSortVo);
	public DishSortVo getDishSort(String dishSortId);
	public void delDishSort(String dishSortId);

}
