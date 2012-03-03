package com.fc.cmapweb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static Date getDateObj(String dateStr, String pattern) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String getCurrentTime(String pattern) {
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return sdf.format(c.getTime());
		
	}
	
	public static Date getCurrentTime() {
		return Calendar.getInstance().getTime();
	}

}
