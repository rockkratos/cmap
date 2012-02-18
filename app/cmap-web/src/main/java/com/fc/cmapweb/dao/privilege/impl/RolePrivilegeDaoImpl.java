package com.fc.cmapweb.dao.privilege.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.privilege.IRolePrivilegeDao;
import com.fc.cmapweb.vo.RolePrivilegeVo;

@Repository("rolePrivilegeDao")
public class RolePrivilegeDaoImpl extends CmapBaseDao implements IRolePrivilegeDao {
	
	@Override
	public RolePrivilegeVo insertRolePrivilege(RolePrivilegeVo rolePrivilegeVo) {
		em.persist(rolePrivilegeVo);
		return rolePrivilegeVo;
	}
	
	@Override
	public void delAllPrivilegeByRoleId(String roleId) {
		
		String jpql = "DELETE FROM RolePrivilegeVo rp WHERE rp.roleInfoVo.roleId = ?";
		Query q = em.createQuery(jpql);
		q.setParameter(1, roleId);
		
		q.executeUpdate();
		
	}
	
	@Override
	public List<RolePrivilegeVo> getValidRolePrivilege() {
		
		String jpql = "select rp from RolePrivilegeVo rp where rp.roleInfoVo.roleEnabled = true and rp.privilegeInfoVo.privilegeEnabled = true";
		
		TypedQuery<RolePrivilegeVo> tq = em.createQuery(jpql, RolePrivilegeVo.class);
		return tq.getResultList();
		
	}

}
