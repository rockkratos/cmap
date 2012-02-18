package com.fc.cmapweb.dao.privilege.impl;

import java.util.List;
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
	public boolean switchEnableDisable(String roleId) {
		
		RoleInfoVo tmp = getRole(roleId);
		tmp.setRoleEnabled(tmp.isRoleEnabled() == true ? false : true);
		
		em.merge(tmp);
		
		return tmp.isRoleEnabled();
		
	}
	
	@Override
	public List<RoleInfoVo> getRole(Map<String, Object> queryParams, int currentPage, int pageSize) {
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("SELECT r FROM RoleInfoVo r ");
		buffer.append(ParamUtil.getQueryConditionJPQL(queryParams, "r"));
		buffer.append(" ORDER BY r.roleName");
		
		return em.createQuery(buffer.toString(), RoleInfoVo.class)
						.setFirstResult(currentPage * pageSize)
						.setMaxResults(pageSize)
						.getResultList();
		
	}

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
