package com.fc.cmapweb.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/adminMenu/")
public class AdminMenuCtrl {
	
	@RequestMapping(value = "/{itemId}", method=RequestMethod.GET)
	public String showPage(@PathVariable String itemId) {
		
		if ("menuPrivilegeCfg".equals(itemId)) {
			return "/admin/privilege/privilegeCfg";
		} else {
			return "/common/blank";
		}
		
	}

}
