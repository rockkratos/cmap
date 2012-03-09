package com.fc.cmapweb.dao.rest.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.rest.IDishDao;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.vo.DishInfoVo;

@Repository("dishDao")
public class DishDaoImpl extends CmapBaseDao implements IDishDao {
	
	@Override
	public void delDishByDishSort(String dishSortId) {
		
		String jpql = "DELETE FROM DishInfoVo di WHERE di.dishSortVo.dishSortId = ?";
		
		Query q = em.createQuery(jpql);
		q.setParameter(1, dishSortId);
		
		q.executeUpdate();
		
	}
	
	@Override
	public DishInfoVo updateDish(DishInfoVo dishInfoVo) {
		em.merge(dishInfoVo);
		return dishInfoVo;
	}
	
	@Override
	public DishInfoVo getDishInfo(String dishId) {
		return em.find(DishInfoVo.class, dishId);
	}
	
	@Override
	public boolean switchEnableDisable(String dishId) {
		
		DishInfoVo tmp = getDishInfo(dishId);
		tmp.setDishEnabled(tmp.isDishEnabled() == true ? false : true);
		
		return tmp.isDishEnabled();
		
	}
	
	@Override
	public void delDish(String dishId) {
		em.remove(em.getReference(DishInfoVo.class, dishId));
	}

	@Override
	public DishInfoVo insertDish(DishInfoVo dishInfoVo) {
		em.persist(dishInfoVo);
		return dishInfoVo;
	}
	
	@Override
	public List<DishInfoVo> getDish(Map<String, Object> queryParams, String restId, int currentPage, int pageSize) {
		
		queryParams.put("dishSortVo.restInfoVo.restId", restId);
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("SELECT d FROM DishInfoVo d ");
		buffer.append(ParamUtil.getQueryConditionJPQL(queryParams, "d"));
		buffer.append(" ORDER BY d.dishName");
		
		TypedQuery<DishInfoVo> tq = em.createQuery(buffer.toString(), DishInfoVo.class).setFirstResult(currentPage * pageSize).setMaxResults(pageSize);
		
		return tq.getResultList();
		
	}
	
	@Override
	public int getDishCount(String restId, Map<String, Object> queryParams) {
		
		queryParams.put("dishSortVo.restInfoVo.restId", restId);
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("SELECT COUNT(di) FROM DishInfoVo di ");
		buffer.append(ParamUtil.getQueryConditionJPQL(queryParams, "di"));
		
		Query rowCountQuery = em.createQuery(buffer.toString());
		
		return ((Long) rowCountQuery.getSingleResult()).intValue();
		
	}

}
