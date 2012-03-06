package com.fc.cmapweb.mgr.rest.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.rest.IDishDao;
import com.fc.cmapweb.mgr.rest.IDishMgr;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.vo.DishInfoVo;

@Service("dishMgr")
public class DishMgrImpl implements IDishMgr {

	@Autowired
	private IDishDao dishDao;
	
	@Override
	public List<DishInfoVo> queryDish(Map<String, Object> queryParams, String restId, int currentPage, int pageSize) {
		
		List<DishInfoVo> back = dishDao.getDish(queryParams, restId, currentPage, pageSize);
		PaginationUtil.fillList(back, DishInfoVo.class, pageSize);
		
		return back;
		
	}
	
	@Override
	public int queryDishCount(String restId) {
		return dishDao.getDishCount(restId);
	}

}
