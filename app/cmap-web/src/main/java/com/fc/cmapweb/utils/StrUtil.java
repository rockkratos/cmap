package com.fc.cmapweb.utils;

import java.util.HashMap;
import java.util.Map;

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

}
