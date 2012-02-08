package com.fc.cmapweb.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fc.cmapweb.vo.PrivilegeInfoVo;

@Controller
@RequestMapping("/adminMenu/")
public class AdminMenuCtrl {
	
	@RequestMapping(value = "/{itemId}", method=RequestMethod.GET)
	public String showPage(@PathVariable String itemId, Model model) {
		
		if ("menuPrivilegeCfg".equals(itemId)) {
			model.addAttribute("privilegeInfoVo", new PrivilegeInfoVo());
			return "/admin/privilege/privilegeCfg";
		} else {
			return "/common/blank";
		}
		
	}

}
