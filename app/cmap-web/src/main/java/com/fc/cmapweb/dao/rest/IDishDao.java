package com.fc.cmapweb.dao.rest;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.DishInfoVo;

public interface IDishDao {
	
	public List<DishInfoVo> getDish(Map<String, Object> queryParams, String restId, int currentPage, int pageSize);
	public int getDishCount(String restId);

}
