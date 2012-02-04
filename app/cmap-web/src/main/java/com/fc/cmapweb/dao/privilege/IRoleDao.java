package com.fc.cmapweb.dao.privilege;

import java.util.List;

import com.fc.cmapweb.vo.RoleInfoVo;

public interface IRoleDao {
	
	public List<RoleInfoVo> getAllRoles();
	public RoleInfoVo getRole(String roleId);
	public RoleInfoVo insertRole(RoleInfoVo roleInfoVo);
	public RoleInfoVo updateRole(RoleInfoVo roleInfoVo);
	public void delRole(String roleId);
	
}
