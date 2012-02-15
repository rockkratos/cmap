package com.fc.cmapweb.mgr.privilege;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.PrivilegeInfoVo;

public interface IPrivilegeMgr {
	
	public void rmPrivilege(String privilegeId);
	public boolean updateEnableDisable(String privilegeId);	
	public int queryPrivilegeCount(Map<String, Object> queryParams);
	
	/**
	 * 查询权限
	 * @param queryParams		查询条件
	 * @param pageIndex			当前页码
	 * @param pageSize			每页显示记录数
	 * @return
	 */
	public List<PrivilegeInfoVo> queryPrivileges(Map<String, Object> queryParams, int pageIndex, int pageSize);
	public PrivilegeInfoVo queryPrivilege(String privilegeId);
	public PrivilegeInfoVo addPrivilege(PrivilegeInfoVo privilegeInfoVo);
	
}
