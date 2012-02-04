package com.fc.cmapweb.mgr.privilege;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;

public interface IRolePrivilegeMgr {
	
	/**
	 * 查询权限映射
	 * @return Map<String, Map<String, Collection<ConfigAttribute>>>
	 * 		   key format - <HTTP method, <URL, resource path>>
	 * 		   value format - role string list 
	 */
	public Map<String, Map<String, Collection<ConfigAttribute>>> queryResMap();

}
