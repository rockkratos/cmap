package com.fc.cmapweb.mgr.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.rest.IDishSortDao;
import com.fc.cmapweb.mgr.rest.IDishSortMgr;
import com.fc.cmapweb.vo.DishSortVo;

@Service("dishSortMgr")
public class DishSortMgrImpl implements IDishSortMgr {

	@Autowired
	private IDishSortDao dishSortDao;
	
	@Override
	public DishSortVo addDishSort(DishSortVo dishSortVo) {
		return dishSortDao.insertDishSort(dishSortVo);
	}
	
	@Override
	public DishSortVo queryDishSort(String dishSortId) {
		return dishSortDao.getDishSort(dishSortId);
	}
	
	@Override
	public void rmDishSort(String dishSortId) {
		dishSortDao.delDishSort(dishSortId);
	}

}
