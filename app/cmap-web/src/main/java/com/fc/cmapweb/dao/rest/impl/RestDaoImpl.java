package com.fc.cmapweb.dao.rest.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.rest.IRestDao;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.vo.RestInfoVo;

@Repository("restDao")
public class RestDaoImpl extends CmapBaseDao implements IRestDao {
	
	@Override
	public RestInfoVo updateRest(RestInfoVo restInfoVo) {
		em.merge(restInfoVo);
		return restInfoVo;
	}
	
	@Override
	public boolean switchEnableDisable(String restId) {
		
		RestInfoVo tmp = getRestInfo(restId);
		tmp.setRestEnabled(tmp.isRestEnabled() == true ? false : true);
		
		return tmp.isRestEnabled();
		
	}
	
	@Override
	public List<RestInfoVo> getRest(Map<String, Object> queryParams, int currentPage, int pageSize) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("SELECT r FROM RestInfoVo r ");
		buffer.append(ParamUtil.getQueryConditionJPQL(queryParams, "r"));
		buffer.append(" ORDER BY r.restName");
		
		return em.createQuery(buffer.toString(), RestInfoVo.class)
				 .setFirstResult(currentPage * pageSize)
				 .setMaxResults(pageSize)
				 .getResultList();
		
	}

	@Override
	public int getRestCount(Map<String, Object> queryParams) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("SELECT COUNT(r) FROM RestInfoVo r ");
		buffer.append(ParamUtil.getQueryConditionJPQL(queryParams, "r"));
		
		Query rowCountQuery = em.createQuery(buffer.toString());
		return ((Long) rowCountQuery.getSingleResult()).intValue();
		
	}
	
	@Override
	public RestInfoVo insertRest(RestInfoVo restInfoVo) {
		em.persist(restInfoVo);
		return restInfoVo;
	}
	
	@Override
	public RestInfoVo getRestInfo(String restId) {
		return em.find(RestInfoVo.class, restId);		
	}
	
	@Override
	public void delRest(String restId) {
		em.remove(em.getReference(RestInfoVo.class, restId));
	}
	
}
