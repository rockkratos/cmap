package com.fc.cmapweb.dao.privilege.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.privilege.IPrivilegeDao;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.vo.PrivilegeInfoVo;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends CmapBaseDao implements IPrivilegeDao {
	
	@Override
	public List<PrivilegeInfoVo> getAllEnabledPrivilege() {
		
		String jpql = "SELECT p FROM PrivilegeInfoVo p WHERE p.privilegeEnabled = true ORDER BY p.privilegeName";
		TypedQuery<PrivilegeInfoVo> tq = em.createQuery(jpql, PrivilegeInfoVo.class);
		
		return tq.getResultList();
		
	}
	
	@Override
	public boolean switchEnableDisable(String privilegeId) {
		
		PrivilegeInfoVo tmp = getPrivilege(privilegeId);
		tmp.setPrivilegeEnabled(tmp.isPrivilegeEnabled() == true ? false : true);
		
		return tmp.isPrivilegeEnabled();
		
	}
	
	@Override
	public int getPrivilegeCount(Map<String, Object> queryParams) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("SELECT COUNT(p) FROM PrivilegeInfoVo p ");
		buffer.append(ParamUtil.getQueryConditionJPQL(queryParams, "p"));
		
		Query rowCountQuery = em.createQuery(buffer.toString());
		return ((Long) rowCountQuery.getSingleResult()).intValue();
		
	}
	
	@Override
	public List<PrivilegeInfoVo> getPrivilege(Map<String, Object> queryParams, int currentPage, int pageSize) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("SELECT p FROM PrivilegeInfoVo p ");
		buffer.append(ParamUtil.getQueryConditionJPQL(queryParams, "p"));
		buffer.append(" ORDER BY p.privilegeName");
		
		return em.createQuery(buffer.toString(), PrivilegeInfoVo.class)
				 .setFirstResult(currentPage * pageSize)
				 .setMaxResults(pageSize)
				 .getResultList();
		
	}

	@Override
	public PrivilegeInfoVo getPrivilege(String privilegeId) {
		return em.find(PrivilegeInfoVo.class, privilegeId);
	}

	@Override
	public PrivilegeInfoVo insertPrivilege(PrivilegeInfoVo privilegeInfoVo) {
		em.persist(privilegeInfoVo);
		return privilegeInfoVo;
	}

	@Override
	public PrivilegeInfoVo updatePrivilege(PrivilegeInfoVo privilegeInfoVo) {
		em.merge(privilegeInfoVo);
		return privilegeInfoVo;
	}

	@Override
	public void delPrivilege(String privilegeId) {
		em.remove(em.getReference(PrivilegeInfoVo.class, privilegeId));
	}

}
