package com.fc.cmapweb.dao.privilege;

import java.util.List;

import com.fc.cmapweb.vo.RolePrivilegeVo;

public interface IRolePrivilegeDao {
	
	public RolePrivilegeVo insertRolePrivilege(RolePrivilegeVo rolePrivilegeVo);
	public void delAllPrivilegeByRoleId(String roleId);
	public List<RolePrivilegeVo> getValidRolePrivilege();

}
