package com.fc.cmapweb.web.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class ErrorCtrl {

	@RequestMapping(value = "/{errorCode}", method=RequestMethod.GET)
	public String showErrorPage(HttpServletRequest request, @PathVariable String errorCode, Model model) {
		
		model.addAttribute("errorCode", errorCode);
		String url = (String) request.getAttribute("javax.servlet.forward.servlet_path");
		
		if (url.contains("admin")) {
			return "error/adminErrorPage";
		} else {
			return "error/usrErrorPage";
		}
		
	}
	
}
