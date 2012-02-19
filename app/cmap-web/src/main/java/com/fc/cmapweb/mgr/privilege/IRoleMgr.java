package com.fc.cmapweb.mgr.privilege;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.RoleInfoVo;

public interface IRoleMgr {
	
	public List<RoleInfoVo> queryAllEnabledRole();
	public void updateRole(String roleId, Map<String, Object> updateParams, List<String> privilegeIdList);
	public void rmRole(String roleId);
	public boolean updateEnableDisable(String roleId);
	
	public int queryRoleCount(Map<String, Object> queryParams);
	public List<RoleInfoVo> queryRole(Map<String, Object> queryParams, int currentPage, int pageSize);
	
	public RoleInfoVo queryRole(String roleId);
	public RoleInfoVo addRole(RoleInfoVo roleInfoVo, List<String> privilegeIdList);

}
