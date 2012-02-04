package com.fc.cmapweb.dao.privilege;

import java.util.List;

import com.fc.cmapweb.vo.PrivilegeInfoVo;

public interface IPrivilegeDao {
	
	public List<PrivilegeInfoVo> getAllPrivileges();
	public PrivilegeInfoVo getPrivilege(String privilegeId);
	public PrivilegeInfoVo insertPrivilege(PrivilegeInfoVo privilegeInfoVo);
	public PrivilegeInfoVo updatePrivilege(PrivilegeInfoVo privilegeInfoVo);
	public void delPrivilege(String privilegeId);

}
