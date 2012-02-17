package com.fc.cmapweb.dao.privilege;

import java.util.Map;

import com.fc.cmapweb.vo.RoleInfoVo;

public interface IRoleDao {
	
	public int getRoleCount(Map<String, Object> queryParams);
	
	public RoleInfoVo getRole(String roleId);
	public RoleInfoVo insertRole(RoleInfoVo roleInfoVo);
	public RoleInfoVo updateRole(RoleInfoVo roleInfoVo);
	public void delRole(String roleId);
	
}
