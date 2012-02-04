package com.fc.cmapweb.ext.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.fc.cmapweb.mgr.privilege.IRolePrivilegeMgr;

/**
 * 该类用于加载资源与对应角色到缓存及查找资源的可访问角色
 * @author RockKratos
 *
 */
public class CmapInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	private IRolePrivilegeMgr rolePrivilegeMgr;
	
	/**
	 * 根据请求URL和HTTP method，查找对应Role
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object obj) throws IllegalArgumentException {
		
		FilterInvocation fi = (FilterInvocation) obj;
		String reqUrl = fi.getRequestUrl();
		String reqMethod = fi.getRequest().getMethod().toUpperCase();
		
		Map<String, Map<String, Collection<ConfigAttribute>>> resMap = rolePrivilegeMgr.queryResMap();
		
		Map<String, Collection<ConfigAttribute>> urlMap = resMap.get(reqMethod);
		
		if (null == urlMap) {
			return null;
		} else {
			return urlMap.get(reqUrl);
		}
		
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		
		Set<ConfigAttribute> allCfgAttrs = new HashSet<ConfigAttribute>();
		Map<String, Map<String, Collection<ConfigAttribute>>> resMap = rolePrivilegeMgr.queryResMap();
		Set<String> allKeys = resMap.keySet();
		
		for (String tmpKey : allKeys) {
			
			Map<String, Collection<ConfigAttribute>> urlMap = resMap.get(tmpKey);
			
			for (Entry<String, Collection<ConfigAttribute>> tmpEntry : urlMap.entrySet()) {
				allCfgAttrs.addAll(tmpEntry.getValue());
			}
			
		}
		
		return allCfgAttrs;
		
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}
	
	public void loadResourceDefine() {
		rolePrivilegeMgr.queryResMap(); // save to cache
	}

	public void setRolePrivilegeMgr(IRolePrivilegeMgr rolePrivilegeMgr) {
		this.rolePrivilegeMgr = rolePrivilegeMgr;
	}
	
}
