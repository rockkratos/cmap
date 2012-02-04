package com.fc.cmapweb.dao.privilege.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.privilege.IRolePrivilegeDao;
import com.fc.cmapweb.vo.RolePrivilegeVo;

@Repository("rolePrivilegeDao")
public class RolePrivilegeDaoImpl extends CmapBaseDao implements IRolePrivilegeDao {
	
	@Override
	public List<RolePrivilegeVo> getValidRolePrivileges() {
		
		String jpql = "select rp from RolePrivilegeVo rp where rp.roleInfoVo.enabled = true and rp.privilegeInfoVo.enabled = true";
		
		TypedQuery<RolePrivilegeVo> tq = em.createQuery(jpql, RolePrivilegeVo.class);
		return tq.getResultList();
		
	}

}
