package com.fc.cmapweb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	protected static ApplicationContext ctx;
	
	@BeforeSuite
	public void beforeSuite() {
		
		ctx = new ClassPathXmlApplicationContext("spring/**/applicationContext*.xml");
		
	}

}
