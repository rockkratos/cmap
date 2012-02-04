package com.fc.cmapweb.dao.privilege;

import java.util.List;

import com.fc.cmapweb.vo.UsrRoleVo;

public interface IUsrRoleDao {
	
	public List<UsrRoleVo> getAllUsrRoles();
	public List<UsrRoleVo> getUsrRoles(String loginName);

}
