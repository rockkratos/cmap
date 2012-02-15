package com.fc.cmapweb.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;

public class StrUtil {
	
	public static boolean isInteger(String str) {
		
		String regex = "^[-|+]?\\d+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		
		return m.matches();
		
	}
	
	public static boolean isDigit(String str) {
		
		String regex = "^[-|+]?\\d+([.]\\d+)?$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		
		return m.matches();
		
	}
	
	public static boolean isNotEmpty(String str) {
		return (null != str && str.length() > 0) ? true : false;
	}
	
	public static boolean isEmpty(String str) {
		return (null == str || str.length() == 0) ? true : false;
	}
	
	public static String getJsonHintMsg(String hintType, String hintMsg, Map<String, String> otherParams) {
		
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put("hintType", hintType);
		tmp.put("hintMsg", hintMsg);
		
		Set<String> keySet = otherParams.keySet();
		
		for (String tmpKey : keySet) {
			tmp.put(tmpKey, otherParams.get(tmpKey));
		}
		
		return JSON.toJSONString(tmp);
		
	}
	
	public static String getJsonHintMsg(String hintType, String hintMsg) {
		
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put("hintType", hintType);
		tmp.put("hintMsg", hintMsg);
		
		return JSON.toJSONString(tmp);
		
	}
	
	public static String getPrivilegeUrl(String requestUrl) {
		
		String tmpUrl = requestUrl.replaceAll("\\?.*$", "");
		String regex = ".+/[0-9a-zA-Z]{32}$";
		String replaceRegex = "[0-9a-zA-Z]{32}$";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(tmpUrl);
		
		return m.matches() ? tmpUrl.replaceAll(replaceRegex, "{id}") : tmpUrl;
		
	}

}
