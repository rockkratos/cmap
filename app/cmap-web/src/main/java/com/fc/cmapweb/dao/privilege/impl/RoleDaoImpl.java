package com.fc.cmapweb.dao.privilege.impl;

import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.privilege.IRoleDao;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.vo.RoleInfoVo;

@Repository("roleDao")
public class RoleDaoImpl extends CmapBaseDao implements IRoleDao {

	@Override
	public int getRoleCount(Map<String, Object> queryParams) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("SELECT COUNT(r) FROM RoleInfoVo r ");
		buffer.append(ParamUtil.getQueryConditionJPQL(queryParams, "r"));
		
		Query rowCountQuery = em.createQuery(buffer.toString());
		return ((Long) rowCountQuery.getSingleResult()).intValue();
		
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
