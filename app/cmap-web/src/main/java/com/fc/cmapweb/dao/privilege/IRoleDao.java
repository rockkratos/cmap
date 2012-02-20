package com.fc.cmapweb.dao.privilege;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.RoleInfoVo;

public interface IRoleDao {
	
	public boolean switchEnableDisable(String roleId);
	
	public int getRoleCount(Map<String, Object> queryParams);
	public List<RoleInfoVo> getRole(Map<String, Object> queryParams, int currentPage, int pageSize);
	
	public RoleInfoVo getRole(String roleId);
	public RoleInfoVo insertRole(RoleInfoVo roleInfoVo);
	public RoleInfoVo updateRole(RoleInfoVo roleInfoVo);
	public void delRole(String roleId);
	
}
