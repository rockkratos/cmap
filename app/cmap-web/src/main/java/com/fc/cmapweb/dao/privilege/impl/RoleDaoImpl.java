package com.fc.cmapweb.dao.privilege.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.privilege.IRoleDao;
import com.fc.cmapweb.vo.RoleInfoVo;

@Repository("roleDao")
public class RoleDaoImpl extends CmapBaseDao implements IRoleDao {

	@Override
	public List<RoleInfoVo> getAllRoles() {	
		TypedQuery<RoleInfoVo> tq = em.createQuery("select r from RoleInfoVo r", RoleInfoVo.class);
		return tq.getResultList();
	}

	@Override
	public RoleInfoVo getRole(String roleId) {
		return em.find(RoleInfoVo.class, roleId);
	}

	@Override
	public RoleInfoVo insertRole(RoleInfoVo roleInfoVo) {
		em.persist(roleInfoVo);
		return roleInfoVo;
	}

	@Override
	public RoleInfoVo updateRole(RoleInfoVo roleInfoVo) {
		em.merge(roleInfoVo);
		return roleInfoVo;
	}

	@Override
	public void delRole(String roleId) {
		em.remove(em.getReference(RoleInfoVo.class, roleId));
	}

}
