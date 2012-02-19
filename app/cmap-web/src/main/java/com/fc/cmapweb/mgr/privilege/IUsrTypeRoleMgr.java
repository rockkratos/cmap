package com.fc.cmapweb.mgr.privilege;

import java.util.List;

import com.fc.cmapweb.vo.UsrTypeRoleVo;

public interface IUsrTypeRoleMgr {
	
	public List<UsrTypeRoleVo> queryRoleMarkedUsrType(int usrTypeId);
	public List<UsrTypeRoleVo> queryUsrTypeRoles(int usrTypeId);
	
}
