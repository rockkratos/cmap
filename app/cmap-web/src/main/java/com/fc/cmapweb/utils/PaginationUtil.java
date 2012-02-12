package com.fc.cmapweb.utils;

import java.util.List;


public class PaginationUtil {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void fillList(List queryList, Class clazz, int pageSize) {
		
		int listSize = queryList.size();
		
		if (listSize < pageSize) {
			
			for (int i = 0; i < pageSize - listSize; i++) {
				try {
					queryList.add(clazz.newInstance());
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
