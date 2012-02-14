package com.fc.cmapweb.ext.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.fc.cmapweb.mgr.privilege.IRolePrivilegeMgr;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.utils.XmlUtil;

/**
 * 该类用于加载资源与对应角色到缓存及查找资源的可访问角色
 * @author RockKratos
 *
 */
public class CmapInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	private IRolePrivilegeMgr rolePrivilegeMgr;
	private List<Map<String, Collection<ConfigAttribute>>> globalRequestMapList;
	
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
			
			for (Map<String, Collection<ConfigAttribute>> globalRequestMap : globalRequestMapList) {
				
				Set<String> globalReqKey = globalRequestMap.keySet();
				
				for (String tmpKey : globalReqKey) {
					
					Pattern p = Pattern.compile(tmpKey);
					Matcher m = p.matcher(reqUrl);
					
					if (m.matches()) {
						return globalRequestMap.get(tmpKey);
					}
					
				}
				
			}
			
			return null;
			
		} else {
			return urlMap.get(StrUtil.getPrivilegeUrl(reqUrl));
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
		globalRequestMapList = XmlUtil.getGlobalACList();
	}

	public void setRolePrivilegeMgr(IRolePrivilegeMgr rolePrivilegeMgr) {
		this.rolePrivilegeMgr = rolePrivilegeMgr;
	}
	
}
