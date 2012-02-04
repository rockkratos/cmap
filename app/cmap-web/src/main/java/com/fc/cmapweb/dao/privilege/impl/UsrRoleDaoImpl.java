package com.fc.cmapweb.dao.privilege.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.privilege.IUsrRoleDao;
import com.fc.cmapweb.vo.UsrRoleVo;

@Repository("usrRoleDao")
public class UsrRoleDaoImpl extends CmapBaseDao implements IUsrRoleDao {

	@Override
	public List<UsrRoleVo> getAllUsrRoles() {
		
		String jpql = "select ur from UsrRoleVo ur";
		
		TypedQuery<UsrRoleVo> tq = em.createQuery(jpql, UsrRoleVo.class);
		return tq.getResultList();
		
	}
	
	@Override
	public List<UsrRoleVo> getUsrRoles(String loginName) {
		
		String jpql = "select ur from UsrRoleVo ur where ur.usrInfoVo.loginName = ?";
		
		TypedQuery<UsrRoleVo> tq = em.createQuery(jpql, UsrRoleVo.class);
		tq.setParameter(1, loginName);
		
		return tq.getResultList();
		
	}

}
