package com.fc.cmapweb.dao.privilege;

import java.util.List;

import com.fc.cmapweb.vo.RolePrivilegeVo;

public interface IRolePrivilegeDao {
	
	public List<RolePrivilegeVo> getValidRolePrivileges();

}
