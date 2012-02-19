package com.fc.cmapweb.mgr.privilege;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;

import com.fc.cmapweb.vo.RolePrivilegeVo;

public interface IRolePrivilegeMgr {
	
	public List<RolePrivilegeVo> queryPrivilegeMarkedRole(String roleId);
	
	/**
	 * 查询权限映射
	 * @return Map<String, Map<String, Collection<ConfigAttribute>>>
	 * 		   key format - <HTTP method, <URL, resource path>>
	 * 		   value format - role string list 
	 */
	public Map<String, Map<String, Collection<ConfigAttribute>>> queryResMap();
	
}
