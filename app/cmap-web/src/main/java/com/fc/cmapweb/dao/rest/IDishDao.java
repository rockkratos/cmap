package com.fc.cmapweb.dao.rest;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.DishInfoVo;

public interface IDishDao {
	
	public void delDishByDishSort(String dishSortId);
	
	public DishInfoVo updateDish(DishInfoVo dishInfoVo);
	public boolean switchEnableDisable(String dishId);
	public void delDish(String dishId);
	
	public DishInfoVo getDishInfo(String dishId);
	public DishInfoVo insertDish(DishInfoVo dishInfoVo);
	public List<DishInfoVo> getDish(Map<String, Object> queryParams, String restId, int currentPage, int pageSize);
	public int getDishCount(String restId, Map<String, Object> queryParams);

}
