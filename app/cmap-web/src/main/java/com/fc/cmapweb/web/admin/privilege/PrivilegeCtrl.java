package com.fc.cmapweb.web.admin.privilege;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/adminPrivilege")
public class PrivilegeCtrl {
	
	@RequestMapping(method=RequestMethod.GET)
	public String showPrivilegePage() {
		return "/admin/privilegeCfg";
	}

}
