package com.fc.cmapweb.dao.privilege;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.PrivilegeInfoVo;

public interface IPrivilegeDao {
	
	public List<PrivilegeInfoVo> getAllEnabledPrivilege();
	
	public List<PrivilegeInfoVo> getPrivilegeMarkedRole(String roleId);
	public boolean switchEnableDisable(String privilegeId);
	
	public int getPrivilegeCount(Map<String, Object> queryParams);
	public List<PrivilegeInfoVo> getPrivilege(Map<String, Object> queryParams, int currentPage, int pageSize);
	
	public PrivilegeInfoVo getPrivilege(String privilegeId);
	public PrivilegeInfoVo insertPrivilege(PrivilegeInfoVo privilegeInfoVo);
	public PrivilegeInfoVo updatePrivilege(PrivilegeInfoVo privilegeInfoVo);
	public void delPrivilege(String privilegeId);
	
}
