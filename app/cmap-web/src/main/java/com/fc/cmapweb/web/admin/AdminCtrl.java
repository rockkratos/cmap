package com.fc.cmapweb.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fc.cmapweb.vo.UsrInfoVo;

@Controller
@RequestMapping("/admin")
public class AdminCtrl {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(Model model) {
		model.addAttribute("usr", new UsrInfoVo());
		return "admin/adminLogin";
	}
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String showIdx() {		
		return "admin/adminIdx";		
	}
	
}
