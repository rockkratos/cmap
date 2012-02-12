package com.fc.cmapweb.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class QueryUtil {
	
	public static int getCurrentPage(HttpServletRequest request) {
		return Integer.valueOf(request.getParameter(CmapValues.PAGE_INDEX));
	}
	
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> getQueryParams(HttpServletRequest request) {
		
		Map<String, Object> queryCondition = new HashMap<String, Object>();
		
		Enumeration params = request.getParameterNames();
		
		while (params.hasMoreElements()) {
			
			String paramKey = params.nextElement().toString();
			
			if (paramKey.startsWith("query")) {
				
				String param = request.getParameter(paramKey);
				
				if (StrUtil.isNotEmpty(param)) {
					
					if (StrUtil.isDigit(param)) {
						
						if (StrUtil.isInteger(param)) {
							queryCondition.put(paramKey.replaceAll("^query", ""), Integer.valueOf(param));
						} else {
							queryCondition.put(paramKey.replaceAll("^query", ""), Double.valueOf(param));
						}
						
					} else {
						queryCondition.put(paramKey.replaceAll("^query", ""), param);
					}
					
				}
				
			}
			
		}
		
		return queryCondition;
		
	}
	
	public static String getQueryConditionJPQL(Map<String, Object> queryParams, String prefix) {
		
		StringBuilder buffer = new StringBuilder();
		
		if (null!= queryParams && queryParams.size() > 0) {
			
			buffer.append("where ");
			
			Set<String> keySets = queryParams.keySet();
			
			for (String tmpKey : keySets) {
				
				Object obj = queryParams.get(tmpKey);
				
				if (obj instanceof String) {
					
					if (StrUtil.isNotEmpty((String) obj)) {
						buffer.append(prefix + "." + tmpKey + "'%" + obj + "%' and");
					}
					
				} else {
					
					buffer.append(prefix + "." + tmpKey + obj + " and");
					
				}
				
			}
			
			return buffer.toString().replaceAll(" and$", "");
			
		} else {
			
			return "";
			
		}
		
	}

}
