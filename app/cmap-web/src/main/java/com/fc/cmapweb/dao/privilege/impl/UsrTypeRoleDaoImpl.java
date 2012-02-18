package com.fc.cmapweb.dao.privilege.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.privilege.IUsrTypeRoleDao;
import com.fc.cmapweb.vo.UsrTypeRoleVo;

@Repository("usrTypeRoleDao")
public class UsrTypeRoleDaoImpl extends CmapBaseDao implements IUsrTypeRoleDao {
	
	@Override
	public void delUsrTypeRole(String roleId) {
		
		String jpql = "DELETE FROM UsrTypeRoleVo ur WHERE ur.roleInfoVo.roleId = ?";
		
		Query q = em.createQuery(jpql);
		q.setParameter(1, roleId);
		
		q.executeUpdate();
		
	}
	
	@Override
	public List<UsrTypeRoleVo> getUsrTypeRoles(int usrTypeId) {
		
		String jpql = "select ur from UsrTypeRoleVo ur where ur.usrTypeVo.usrTypeId = ?";
		
		TypedQuery<UsrTypeRoleVo> tq = em.createQuery(jpql, UsrTypeRoleVo.class);
		tq.setParameter(1, usrTypeId);
		
		return tq.getResultList();
		
	}

}
