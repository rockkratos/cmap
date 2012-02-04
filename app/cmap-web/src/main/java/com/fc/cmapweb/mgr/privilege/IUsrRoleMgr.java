package com.fc.cmapweb.mgr.privilege;

import java.util.List;

import com.fc.cmapweb.vo.UsrRoleVo;

public interface IUsrRoleMgr {
	
	public List<UsrRoleVo> queryAllUsrRoles();
	public List<UsrRoleVo> queryUsrRoles(String loginName);

}
