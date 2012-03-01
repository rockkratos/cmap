package com.fc.cmapweb.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class ParamUtil {
	
	public static int getCurrentPage(HttpServletRequest request) {
		return Integer.valueOf(request.getParameter(CmapValues.PAGE_INDEX));
	}
	
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> getParams(HttpServletRequest request, String prefix) {
		
		Map<String, Object> back = new HashMap<String, Object>();
		
		Enumeration params = request.getParameterNames();
		
		while (params.hasMoreElements()) {
			
			String paramKey = params.nextElement().toString();
			
			if (paramKey.startsWith(prefix)) {
				
				String param = request.getParameter(paramKey);
				String tmpKey = paramKey.replaceAll("^" + prefix, "");
				tmpKey = tmpKey.replace(tmpKey.charAt(0), (char)(tmpKey.charAt(0) + 32));
				
				if (StrUtil.isNotEmpty(param)) {
					
					if (!tmpKey.contains("Cell") && StrUtil.isDigit(param)) {
						
						if (StrUtil.isInteger(param)) {
							back.put(tmpKey, Integer.valueOf(param));
						} else {
							back.put(tmpKey, Double.valueOf(param));
						}
						
					} else {
						back.put(tmpKey, param);
					}
					
				}
				
			}
			
		}
		
		return back;
		
	}
	
	public static String getQueryConditionJPQL(Map<String, Object> queryParams, String prefix) {
		
		StringBuilder buffer = new StringBuilder();
		
		if (null!= queryParams && queryParams.size() > 0) {
			
			buffer.append("where ");
			
			Set<String> keySets = queryParams.keySet();
			
			for (String tmpKey : keySets) {
				
				Object obj = queryParams.get(tmpKey);

				if (tmpKey.contains("Cell") || (obj instanceof String && StrUtil.isNotEmpty((String) obj))) {
					
					String tmpStr = (String) obj;
					
					if ("true".equals(tmpStr) || "false".equals(tmpStr)) {
						buffer.append(prefix + "." + tmpKey + " = " + obj + " and ");
					} else {
						buffer.append(prefix + "." + tmpKey + " like '%" + tmpStr + "%' and ");
					}
					
				} else {
					
					buffer.append(prefix + "." + tmpKey + " = " + obj + " and ");
					
				}
				
			}
			
			return buffer.toString().replaceAll(" and $", " ");
			
		} else {
			
			return "";
			
		}
		
	}

}
