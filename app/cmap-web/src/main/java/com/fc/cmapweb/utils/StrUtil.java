package com.fc.cmapweb.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;

public class StrUtil {
	
	public static boolean isNotEmpty(String str) {
		return (null != str && str.length() > 0) ? true : false;
	}
	
	public static boolean isEmpty(String str) {
		return (null == str || str.length() == 0) ? true : false;
	}
	
	public static String getJsonHintMsg(String hintType, String hintMsg) {
		
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put("hintType", hintType);
		tmp.put("hintMsg", hintMsg);
		
		return JSON.toJSONString(tmp);
		
	}
	
	public static String getPrivilegeUrl(String requestUrl) {
		
		String regex = ".+/[0-9a-zA-Z]{32}$";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(requestUrl);
		
		return m.matches() ? requestUrl.replaceAll(regex, "{id}") : requestUrl;
		
	}
	
	public static String getQueryCondition(Map<String, Object> queryCondition) {
		
		StringBuilder buffer = new StringBuilder();
		
		if (null!= queryCondition && queryCondition.size() > 0) {
			
			buffer.append("where ");
			
			Set<String> keySets = queryCondition.keySet();
			
			for (String tmpKey : keySets) {
				
				Object obj = queryCondition.get(tmpKey);
				
				if (obj instanceof String) {
					
					if (isNotEmpty((String) obj)) {
						buffer.append(tmpKey + "'%" + obj + "%' and");
					}
					
				} else {
					
					buffer.append(tmpKey + obj + " and");
					
				}
				
			}
			
			return buffer.toString().replaceAll(" and$", "");
			
		} else {
			
			return "";
			
		}
		
	}

}
