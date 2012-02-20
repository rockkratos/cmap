package com.fc.cmapweb.mgr.privilege;

import java.util.List;

import com.fc.cmapweb.vo.UsrTypeRoleVo;

public interface IUsrTypeRoleMgr {
	
	public void updateUsrTypeRole(boolean enabled, int usrTypeId, List<String> roleIdList);
	public List<UsrTypeRoleVo> queryRoleMarkedUsrType(int usrTypeId);
	
}
