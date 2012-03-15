package com.fc.cmapweb.utils;

import java.io.File;

public class FileUtil {
	
	public static int checkLogoExist(String restId) {
		
		int back = 0;
		String logoRootPath = PropUtil.getPolicy("restlogo.rootpath");
		String[] postfix = {"_b", "_s"};
		
		File logo = new File(logoRootPath + "/" +restId + postfix[0] + ".jpg");
		if (logo.exists()) {
			back = back | CmapValues.REST_LOGO_BIG;
		}
		
		logo = new File(logoRootPath + "/" +restId + postfix[1] + ".jpg");
		if (logo.exists()) {
			back = back | CmapValues.REST_LOGO_SMALL;
		}
		
		return back;
		
	}

}
