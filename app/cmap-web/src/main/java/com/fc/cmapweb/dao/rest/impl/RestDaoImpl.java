package com.fc.cmapweb.dao.rest.impl;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.rest.IRestDao;
import com.fc.cmapweb.vo.RestInfoVo;

@Repository("restDao")
public class RestDaoImpl extends CmapBaseDao implements IRestDao {

	@Override
	public RestInfoVo insertRest(RestInfoVo restInfoVo) {
		em.persist(restInfoVo);
		return restInfoVo;
	}
	
	@Override
	public RestInfoVo getRestInfo(String restId) {
		
		RestInfoVo back = null;
		String jpql = "select r from RestInfoVo r where r.restId = ?";
		
		TypedQuery<RestInfoVo> tq = em.createQuery(jpql, RestInfoVo.class);
		tq.setParameter(1, restId);
		
		try {
			back = tq.getSingleResult();
		} catch (NoResultException e) {
			back = null;
		} catch (NonUniqueResultException e) {
			back = tq.getResultList().get(0);
		}
		
		return back;
		
	}
	
	@Override
	public void delRest(String restId) {
		em.remove(getRestInfo(restId));
	}
	
}
