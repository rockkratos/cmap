package com.fc.cmapweb.web.usr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/usr")
public class UsrCtrl {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(Model model) {
		return null;
	}
	
}
