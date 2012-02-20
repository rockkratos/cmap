package com.fc.cmapweb.dao.privilege.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.privilege.IRolePrivilegeDao;
import com.fc.cmapweb.vo.PrivilegeInfoVo;
import com.fc.cmapweb.vo.RoleInfoVo;
import com.fc.cmapweb.vo.RolePrivilegeVo;

@Repository("rolePrivilegeDao")
public class RolePrivilegeDaoImpl extends CmapBaseDao implements IRolePrivilegeDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RolePrivilegeVo> getPrivilegeMarkedRole(String roleId) {
		
		List<RolePrivilegeVo> back = new ArrayList<RolePrivilegeVo>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT privilege_info.privilege_id, ");
		sql.append("privilege_info.privilege_name, ");
		sql.append("privilege_info.privilege_desc, ");
		sql.append("tmp_tab.role_id ");
		sql.append("FROM privilege_info LEFT OUTER JOIN ");
		sql.append("(SELECT * FROM role_privilege WHERE role_privilege.role_id = ?) tmp_tab ");
		sql.append("ON privilege_info.privilege_id = tmp_tab.privilege_id ");
		sql.append("WHERE privilege_info.enabled = true ");
		sql.append("ORDER BY privilege_info.privilege_name");
		
		Query q = em.createNativeQuery(sql.toString());
		q.setParameter(1, roleId);
		
		List<Object[]> list = q.getResultList();
		
		for(Object[] tmp : list) {
			
			PrivilegeInfoVo tmpPrivilege = new PrivilegeInfoVo();
			tmpPrivilege.setPrivilegeId(String.valueOf(tmp[0]));
			tmpPrivilege.setPrivilegeName(String.valueOf(tmp[1]));
			tmpPrivilege.setPrivilegeDesc(String.valueOf(tmp[2]));
			
			RoleInfoVo tmpRole = new RoleInfoVo();
			tmpRole.setRoleId(null == tmp[3] ? null : String.valueOf(tmp[3]));
			
			RolePrivilegeVo tmpRolePrivilege = new RolePrivilegeVo();
			tmpRolePrivilege.setPrivilegeInfoVo(tmpPrivilege);
			tmpRolePrivilege.setRoleInfoVo(tmpRole);
			
			back.add(tmpRolePrivilege);
			
		}
		
		return back;
		
	}
	
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
		
		String jpql = "SELECT rp FROM RolePrivilegeVo rp WHERE rp.roleInfoVo.roleEnabled = TRUE AND rp.privilegeInfoVo.privilegeEnabled = TRUE";
		
		TypedQuery<RolePrivilegeVo> tq = em.createQuery(jpql, RolePrivilegeVo.class);
		return tq.getResultList();
		
	}

}
