package com.fc.cmapweb.mgr.privilege;

import java.util.List;

import com.fc.cmapweb.vo.RoleInfoVo;

public interface IRoleMgr {
	
	public List<RoleInfoVo> queryAllRoles();
	public RoleInfoVo queryRole(String roleId);
	public RoleInfoVo addRole(RoleInfoVo roleInfoVo);

}
