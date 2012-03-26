package com.fc.cmapweb.web.usr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fc.cmapweb.web.form.RestSearchFormVo;

@Controller
@RequestMapping("/")
public class UsrCtrl {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String showLogin(Model model) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUsrIdx(Model model) {
		
		model.addAttribute("restSearchForm", new RestSearchFormVo());
		return "/usr/usrIdx";
		
	}
	
}
