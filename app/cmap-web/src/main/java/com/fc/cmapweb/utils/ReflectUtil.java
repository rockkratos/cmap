package com.fc.cmapweb.utils;

import java.lang.reflect.Method;

public class ReflectUtil {
	
	private static final String PACKAGE_ROOT = "com.fc.cmapweb.vo.";
	
	public static void invokeSet(Object obj, String propertyName, Object value) {
		
		try {
			
			if (propertyName.contains(".")) {
				
				String fullClassName = getClassName(propertyName);
				Object tmpObj = Class.forName(fullClassName).newInstance();
				String tmpObjMethodName = "set" + StrUtil.upperInitial(propertyName.substring(propertyName.indexOf(".") + 1));
				
				Method tmpObjMethod = tmpObj.getClass().getMethod(tmpObjMethodName, getClass(value));
				tmpObjMethod.invoke(tmpObj, value);
				
				String methodName = "set" + StrUtil.upperInitial(propertyName.substring(0, propertyName.indexOf(".")));
				Method m = obj.getClass().getMethod(methodName, getClass(tmpObj));
				
				m.invoke(obj, tmpObj);
				
			} else {
				
				String methodName = "set" + StrUtil.upperInitial(propertyName);
				Method m = obj.getClass().getMethod(methodName, getClass(value));
				
				m.invoke(obj, value);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static String getClassName(String propertyName) {
		
		String className = StrUtil.upperInitial(propertyName.substring(0, propertyName.indexOf(".")));
		return PACKAGE_ROOT + className;
		
	}
	
	private static Class<?> getClass(Object obj) {
		
		String name = obj.getClass().getName();
		
		if (name.equals("java.lang.Integer")) {
			return Integer.TYPE;
		} else if (name.equals("java.lang.Boolean")) {
			return Boolean.TYPE;
		} else if (name.equals("java.lang.Float")) {
			return Float.TYPE;
		} else if (name.equals("java.lang.Double")) {
			return Double.TYPE;
		} else {
			return obj.getClass();
		}
		
	}

}
