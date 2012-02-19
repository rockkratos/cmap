package com.fc.cmapweb.web.admin.privilege;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fc.cmapweb.mgr.privilege.IUsrTypeRoleMgr;

@Controller
@RequestMapping("/adminUsrTypeRole")
public class UsrTypeRoleCtrl {
	
	@Autowired
	private IUsrTypeRoleMgr usrTypeRoleMgr;
	
	@RequestMapping(value = "/{usrTypeId}", method = RequestMethod.GET)
	public String queryRoleMarkedUsrType(@PathVariable int usrTypeId, Model model) {
		
		model.addAttribute("roleMarkedUsrType", usrTypeRoleMgr.queryRoleMarkedUsrType(usrTypeId));
		return "/admin/privilege/roleBindingList";
		
	}

}
