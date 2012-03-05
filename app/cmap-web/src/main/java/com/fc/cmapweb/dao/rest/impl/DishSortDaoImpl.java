package com.fc.cmapweb.dao.rest.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.rest.IDishSortDao;
import com.fc.cmapweb.vo.DishSortVo;

@Repository("dishSortDao")
public class DishSortDaoImpl extends CmapBaseDao implements IDishSortDao {
	
	@Override
	public DishSortVo updateRest(DishSortVo dishSortVo) {
		em.merge(dishSortVo);
		return dishSortVo;
	}
	
	@Override
	public boolean switchEnableDisable(String dishSortId) {
		
		DishSortVo tmp = getDishSort(dishSortId);
		tmp.setDishSortEnabled(tmp.isDishSortEnabled() == true ? false : true);
		
		return tmp.isDishSortEnabled();
		
	}
	
	@Override
	public int getDishSortCount(String restId) {
		
		String jpql = "SELECT COUNT(ds) FROM DishSortVo ds WHERE ds.restInfoVo.restId = ?";
		
		Query rowCountQuery = em.createQuery(jpql);
		rowCountQuery.setParameter(1, restId);
		
		return ((Long) rowCountQuery.getSingleResult()).intValue();
		
	}

	@Override
	public List<DishSortVo> getDishSort(String restId, int currentPage, int pageSize) {
		
		String jpql = "SELECT ds FROM DishSortVo ds WHERE ds.restInfoVo.restId = ? ORDER BY ds.dishSortOrder";
		TypedQuery<DishSortVo> tq = em.createQuery(jpql, DishSortVo.class)
									  .setFirstResult(currentPage * pageSize)
									  .setMaxResults(pageSize);
		tq.setParameter(1, restId);
		
		return tq.getResultList();
		
	}
	
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
