package com.fc.cmapweb.utils;

public class StrUtil {
	
	public static boolean isNotEmpty(String str) {
		return (null != str && str.length() > 0) ? true : false;
	}
	
	public static boolean isEmpty(String str) {
		return (null == str || str.length() == 0) ? true : false;
	}

}
