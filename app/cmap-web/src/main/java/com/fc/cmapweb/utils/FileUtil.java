package com.fc.cmapweb.utils;


public class FileUtil {
	
	public static String getLogoFileName(String restId, String prefix) {
		return prefix + restId + "_" + DateUtil.getCurrentTime("yyyyMMddHHmmssSSS") + ".jpg";
	}

}
