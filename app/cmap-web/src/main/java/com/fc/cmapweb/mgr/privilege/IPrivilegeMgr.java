package com.fc.cmapweb.mgr.privilege;

import java.util.List;

import com.fc.cmapweb.vo.PrivilegeInfoVo;

public interface IPrivilegeMgr {
	
	public List<PrivilegeInfoVo> queryAllPrivileges();
	public PrivilegeInfoVo queryPrivilege(String privilegeId);
	public PrivilegeInfoVo addPrivilege(PrivilegeInfoVo privilegeInfoVo);

}
