package com.fc.cmapweb.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropUtil {
	
	private static Map<PropFileName, Properties> propMap;
	private enum PropFileName {
		
		ERRMSG, 
		POLICY
		
	}
	
	static {
		
		InputStream in = null;
		Properties tmpProp = null;
		propMap = new HashMap<PropFileName, Properties>();
		
		for (PropFileName tmpFileName : PropFileName.values()) {
			
			in = PropUtil.class.getResourceAsStream("/config/" + tmpFileName.toString().toLowerCase() + ".properties");
			tmpProp = new Properties();
			
			try {
				tmpProp.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (null != in) {
						in.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			propMap.put(tmpFileName, tmpProp);
			
		}
		
	}
	
	public static String getErrMsg(String key, Object[] params) {
		
		Properties errMsgProp = propMap.get(PropFileName.ERRMSG);
		
		String value = errMsgProp.getProperty(key, null);
		
		if (null != value && null != params && params.length > 0) {
			value = MessageFormat.format(value, params);
		}
		
		return value;
	}
	
	public static String getPolicy(String key) {
		
		Properties policyProp = propMap.get(PropFileName.POLICY);
		return policyProp.getProperty(key, null);
		
	}
	
}
