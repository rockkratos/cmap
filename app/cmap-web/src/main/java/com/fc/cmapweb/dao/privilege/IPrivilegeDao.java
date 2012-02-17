package com.fc.cmapweb.dao.privilege;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.PrivilegeInfoVo;

public interface IPrivilegeDao {
	
	public List<PrivilegeInfoVo> getAllPrivilege();
	
	public List<PrivilegeInfoVo> getPrivilegeMarkedRole();
	public boolean switchEnableDisable(String privilegeId);
	
	public int getPrivilegeCount(Map<String, Object> queryParams);
	public List<PrivilegeInfoVo> getPrivileges(Map<String, Object> queryParams, int pageIndex, int pageSize);
	
	public PrivilegeInfoVo getPrivilege(String privilegeId);
	public PrivilegeInfoVo insertPrivilege(PrivilegeInfoVo privilegeInfoVo);
	public PrivilegeInfoVo updatePrivilege(PrivilegeInfoVo privilegeInfoVo);
	public void delPrivilege(String privilegeId);
	
}
