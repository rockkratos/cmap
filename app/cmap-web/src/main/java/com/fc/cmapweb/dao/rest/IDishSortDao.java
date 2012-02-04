package com.fc.cmapweb.dao.rest;

import com.fc.cmapweb.vo.DishSortVo;

public interface IDishSortDao {
	
	public DishSortVo insertDishSort(DishSortVo dishSortVo);
	public DishSortVo getDishSort(String dishSortId);
	public void delDishSort(String dishSortId);

}
