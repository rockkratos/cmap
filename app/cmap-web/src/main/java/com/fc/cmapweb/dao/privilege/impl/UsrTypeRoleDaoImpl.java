package com.fc.cmapweb.dao.privilege.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.privilege.IUsrTypeRoleDao;
import com.fc.cmapweb.vo.RoleInfoVo;
import com.fc.cmapweb.vo.UsrTypeRoleVo;
import com.fc.cmapweb.vo.UsrTypeVo;

@Repository("usrTypeRoleDao")
public class UsrTypeRoleDaoImpl extends CmapBaseDao implements IUsrTypeRoleDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UsrTypeRoleVo> getRoleMarkedUsrType(int usrTypeId) {
		
		List<UsrTypeRoleVo> back = new ArrayList<UsrTypeRoleVo>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT role_info.role_id, ");
		sql.append("role_info.role_name, ");
		sql.append("role_info.role_desc, ");
		sql.append("tmp_tab.usr_type_id ");
		sql.append("FROM role_info LEFT OUTER JOIN (");
		sql.append("SELECT * ");
		sql.append("FROM usr_type_role ");
		sql.append("WHERE usr_type_role.usr_type_id = ?) tmp_tab ");
		sql.append("ON role_info.role_id = tmp_tab.role_id ");
		sql.append("WHERE role_info.enabled = true ");
		sql.append("ORDER BY role_info.role_name");
		
		Query q = em.createNativeQuery(sql.toString());
		q.setParameter(1, usrTypeId);
		
		List<Object[]> list = q.getResultList();
		
		for(Object[] tmp : list) {
			
			RoleInfoVo tmpRole = new RoleInfoVo();
			tmpRole.setRoleId(String.valueOf(tmp[0]));
			tmpRole.setRoleName(String.valueOf(tmp[1]));
			tmpRole.setRoleDesc(String.valueOf(tmp[2]));
			
			UsrTypeVo tmpUsrType = new UsrTypeVo();
			tmpUsrType.setUsrTypeId(null == tmp[3] ? -1 : Integer.valueOf(String.valueOf(tmp[3])));
			
			UsrTypeRoleVo tmpUsrTypeRole = new UsrTypeRoleVo();
			tmpUsrTypeRole.setRoleInfoVo(tmpRole);
			tmpUsrTypeRole.setUsrTypeVo(tmpUsrType);
			
			back.add(tmpUsrTypeRole);
			
		}
		
		return back;
		
	}
	
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
