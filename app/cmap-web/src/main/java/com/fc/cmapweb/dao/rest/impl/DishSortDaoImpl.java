package com.fc.cmapweb.dao.rest.impl;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.rest.IDishSortDao;
import com.fc.cmapweb.vo.DishSortVo;

@Repository("dishSortDao")
public class DishSortDaoImpl extends CmapBaseDao implements IDishSortDao {

	@Override
	public DishSortVo insertDishSort(DishSortVo dishSortVo) {
		em.persist(dishSortVo);
		return dishSortVo;
	}
	
	@Override
	public DishSortVo getDishSort(String dishSortId) {
		return em.find(DishSortVo.class, dishSortId);		
	}
	
	@Override
	public void delDishSort(String dishSortId) {		
		em.remove(em.getReference(DishSortVo.class, dishSortId));
	}

}
