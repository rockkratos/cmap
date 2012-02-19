package com.fc.cmapweb.mgr.privilege.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.privilege.IRolePrivilegeDao;
import com.fc.cmapweb.mgr.privilege.IRolePrivilegeMgr;
import com.fc.cmapweb.vo.RolePrivilegeVo;
import com.googlecode.ehcache.annotations.Cacheable;

@Service("rolePrivilegeMgr")
public class RolePrivilegeMgrImpl implements IRolePrivilegeMgr {

	@Autowired
	private IRolePrivilegeDao rolePrivilegeDao;
	
	@Override
	public List<RolePrivilegeVo> queryPrivilegeMarkedRole(String roleId) {
		return rolePrivilegeDao.getPrivilegeMarkedRole(roleId);
	}
	
	/**
	 * 查询权限映射
	 * @return Map<String, Map<String, Collection<ConfigAttribute>>>
	 * 		   key format - <HTTP method, <URL, resource path>>
	 * 		   value format - role string list 
	 */
	@Cacheable(cacheName = "eternalCache")
	public Map<String, Map<String, Collection<ConfigAttribute>>> queryResMap() {
		
		Map<String, Map<String, Collection<ConfigAttribute>>> resMap = new HashMap<String, Map<String, Collection<ConfigAttribute>>>();
		List<RolePrivilegeVo> rolePrivilegeList = rolePrivilegeDao.getValidRolePrivilege();
		
		for (RolePrivilegeVo tmp : rolePrivilegeList) {
			
			String methodType = tmp.getPrivilegeInfoVo().getHttpMethodTypeVo().getMethodType().toUpperCase();
			addUrlMapToResMap(resMap, methodType, tmp.getPrivilegeInfoVo().getResPath(), tmp.getRoleInfoVo().getRoleName().toUpperCase().replaceAll(" ", "_"));
			
		}
		
		return resMap;
		
	}
	
	private void addUrlMapToResMap(Map<String, Map<String, Collection<ConfigAttribute>>> resMap, String methodType, String resPath, String roleName) {
		
		Map<String, Collection<ConfigAttribute>> urlMap = resMap.get(methodType);
		
		if (null == urlMap) {
			
			urlMap = new HashMap<String, Collection<ConfigAttribute>>();
			addRoleToUrlMap(urlMap, resPath, roleName);
			resMap.put(methodType, urlMap);
			
		} else {
			
			addRoleToUrlMap(urlMap, resPath, roleName);
			
		}
		
	}
	
	private void addRoleToUrlMap(Map<String, Collection<ConfigAttribute>> urlMap, String key, String roleName) {
		
		ConfigAttribute ca = new SecurityConfig(roleName);
		
		if (urlMap.containsKey(key)) {
			
			Collection<ConfigAttribute> roleList = urlMap.get(key);
			roleList.add(ca);
			urlMap.put(key, roleList);
			
		} else {
			
			Collection<ConfigAttribute> roleList = new ArrayList<ConfigAttribute>();
			roleList.add(ca);
			urlMap.put(key, roleList);
			
		}
		
	}

}
