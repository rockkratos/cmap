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
	public List<DishInfoVo> getDish(Map<String, Object> queryParams, String restId, int currentPage, int pageSize) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("SELECT d FROM DishInfoVo d ");
		buffer.append(ParamUtil.getQueryConditionJPQL(queryParams, "d"));
		buffer.append("AND d.dishSortVo.restInfoVo.restId = ?");
		buffer.append(" ORDER BY d.dishName");
		
		TypedQuery<DishInfoVo> tq = em.createQuery(buffer.toString(), DishInfoVo.class).setFirstResult(currentPage * pageSize).setMaxResults(pageSize);
		tq.setParameter(1, restId);
		
		return tq.getResultList();
		
	}
	
	@Override
	public int getDishCount(String restId) {
		
		String jpql = "SELECT COUNT(di) FROM DishInfoVo di WHERE di.dishSortVo.restInfoVo.restId = ?";
		
		Query rowCountQuery = em.createQuery(jpql);
		rowCountQuery.setParameter(1, restId);
		
		return ((Long) rowCountQuery.getSingleResult()).intValue();
		
	}

}
