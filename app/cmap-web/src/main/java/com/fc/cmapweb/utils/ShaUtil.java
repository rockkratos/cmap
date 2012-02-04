package com.fc.cmapweb.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class ShaUtil {
	
	public static String getEncryptData(String data) {
		return DigestUtils.sha256Hex(data);
	}

}
