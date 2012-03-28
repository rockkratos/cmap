package com.fc.cmapweb.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSON;

public class StrUtil {
	
	public static String getRestPhoneNbr(String phoneNbr) {
		String prefix = PropUtil.getPolicy("prefix.400");
		return phoneNbr.length() == 4 ? prefix + phoneNbr : phoneNbr;
	}
	
	public static String getEncodeStr(String str) {
		
		String back = "";
		
		try {
			back = URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return back;
		
	}
	
	public static String getLoginNameByEmail(String email) {
		return email.substring(0, email.indexOf("@"));
	}
	
	public static String getSHAEncryptData(String data) {
		return DigestUtils.sha256Hex(data);
	}
	
	public static String lowerInitial(String str) {
		return str.replaceFirst("^[A-Z]", String.valueOf((char) (str.charAt(0) + 32)));
	}
	
	public static String upperInitial(String str) {
		return str.replaceFirst("^[a-z]", String.valueOf((char) (str.charAt(0) - 32)));
	}
	
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
		
		String[] regex = {".+/[0-9a-zA-Z]{32}/[0-9a-zA-Z]{32}$", ".+/[0-9a-zA-Z]{32}$", ".+/[0-9]+$"};
		String[] replaceRegex = {"[0-9a-zA-Z]{32}/[0-9a-zA-Z]{32}$", "[0-9a-zA-Z]{32}$", "[0-9]+$"};
		String[] replaceStr = {"{id}/{id}", "{id}", "{id}"};
		
		for (int i = 0; i < regex.length; i++) {
			
			Pattern p = Pattern.compile(regex[i]);
			Matcher m = p.matcher(tmpUrl);
			
			if (m.matches()) {
				return tmpUrl.replaceAll(replaceRegex[i], replaceStr[i]);
			}
			
		}
		
		return tmpUrl;
		
	}

}
