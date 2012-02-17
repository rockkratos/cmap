package com.fc.cmapweb.mgr.privilege;

import java.util.Map;

import com.fc.cmapweb.vo.RoleInfoVo;

public interface IRoleMgr {
	
	public int queryRoleCount(Map<String, Object> queryParams);
	
	public RoleInfoVo queryRole(String roleId);
	public RoleInfoVo addRole(RoleInfoVo roleInfoVo);

}
