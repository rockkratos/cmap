package com.fc.cmapweb.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

public class XmlUtil {

	public static List<Map<String, Collection<ConfigAttribute>>> getGlobalACList() {
		
		List<Map<String, Collection<ConfigAttribute>>> back = new ArrayList<Map<String, Collection<ConfigAttribute>>>();
		
		String path = (XmlUtil.class.getResource("/config") + "/global-ac.xml");
		
		if (System.getProperty("os.name").equals("Linux")) {
			path = path.replaceAll("^file:", "");
		} else {
			path = path.replaceAll("^file:/", "");
		}
		
		File f = new File(path);
		
		SAXReader reader = new SAXReader();
		
		try {
			
			Document doc = reader.read(f);
			Element element = doc.getRootElement();
			
			for (Iterator<?> i = element.elementIterator(); i.hasNext(); ) {
				
				Element tmpElement = (Element) i.next();
				Map<String, Collection<ConfigAttribute>> urlParams = new HashMap<String, Collection<ConfigAttribute>>();
				
				ConfigAttribute ca = new SecurityConfig(tmpElement.attributeValue("access"));
				Collection<ConfigAttribute> list = new ArrayList<ConfigAttribute>();
				list.add(ca);
				
				urlParams.put(tmpElement.attributeValue("pattern"), list);
				back.add(urlParams);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return back;
		
	}
	
}
