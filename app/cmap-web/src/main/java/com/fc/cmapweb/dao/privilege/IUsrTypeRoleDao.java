package com.fc.cmapweb.dao.privilege;

import java.util.List;

import com.fc.cmapweb.vo.UsrTypeRoleVo;

public interface IUsrTypeRoleDao {
	
	public List<UsrTypeRoleVo> getRoleMarkedUsrType(int usrTypeId);
	public void delUsrTypeRole(String roleId);
	public List<UsrTypeRoleVo> getUsrTypeRoles(int usrTypeId);
	
}
