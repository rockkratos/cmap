package com.fc.cmapweb.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static String getCurrentTime(String pattern) {
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return sdf.format(c.getTime());
		
	}
	
	public static Date getCurrentTime() {
		return Calendar.getInstance().getTime();
	}

}
