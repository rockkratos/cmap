package com.fc.cmapweb.dao.usr.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.usr.IDeliveryAddrDao;
import com.fc.cmapweb.vo.DeliveryAddrVo;

@Repository("deliveryAddrDao")
public class DeliveryAddrDaoImpl extends CmapBaseDao implements IDeliveryAddrDao {
	
	@Override
	public DeliveryAddrVo updateDeliveryAddr(DeliveryAddrVo deliveryAddrVo) {
		em.merge(deliveryAddrVo);
		return deliveryAddrVo;
	}
	
	@Override
	public void switchDefaultAddrFlag(String addrId) {
		DeliveryAddrVo tmp = em.getReference(DeliveryAddrVo.class, addrId);
		tmp.setDefaultAddrFlag(tmp.isDefaultAddrFlag() == true ? false : true);
	}
	
	@Override
	public DeliveryAddrVo getDeliveryAddrInfo(String addrId) {
		return em.find(DeliveryAddrVo.class, addrId);
	}
	
	@Override
	public void delDeliveryAddr(String addrId) {
		em.remove(em.getReference(DeliveryAddrVo.class, addrId));
	}
	
	@Override
	public List<DeliveryAddrVo> getDeliveryAddr(String usrId) {
		
		String jpql = "SELECT da FROM DeliveryAddrVo da WHERE da.usrInfoVo.usrId = ? ORDER BY da.specAddr";
		
		TypedQuery<DeliveryAddrVo> tq = em.createQuery(jpql, DeliveryAddrVo.class);
		tq.setParameter(1, usrId);
		
		return tq.getResultList();
		
	}
	
	@Override
	public DeliveryAddrVo insertDeliveryAddr(DeliveryAddrVo deliveryAddrVo) {
		em.persist(deliveryAddrVo);
		return deliveryAddrVo;
	}
	
	@Override
	public int getDeliveryAddrCount(String usrId) {
		
		String jpql = "SELECT COUNT(da) FROM DeliveryAddrVo da WHERE da.usrInfoVo.usrId = ?";
		
		Query rowCountQuery = em.createQuery(jpql);
		rowCountQuery.setParameter(1, usrId);
		
		return ((Long) rowCountQuery.getSingleResult()).intValue();
		
	}

}
