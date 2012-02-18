package com.fc.cmapweb.mgr.privilege;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.PrivilegeInfoVo;

public interface IPrivilegeMgr {
	
	public List<PrivilegeInfoVo> queryAllEnabledPrivilege();
	public List<PrivilegeInfoVo> queryPrivilegeMarkedRole(String roleId);
	public void updatePrivilege(String privilegeId, Map<String, Object> updateParams);
	public void rmPrivilege(String privilegeId);
	public boolean updateEnableDisable(String privilegeId);
	public int queryPrivilegeCount(Map<String, Object> queryParams);
	
	/**
	 * 查询权限
	 * @param queryParams		查询条件
	 * @param currentPage		当前页码
	 * @param pageSize				每页显示记录数
	 * @return
	 */
	public List<PrivilegeInfoVo> queryPrivilege(Map<String, Object> queryParams, int currentPage, int pageSize);
	public PrivilegeInfoVo queryPrivilege(String privilegeId);
	public PrivilegeInfoVo addPrivilege(PrivilegeInfoVo privilegeInfoVo);
	
}
