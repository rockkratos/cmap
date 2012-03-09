package com.fc.cmapweb.web.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fc.cmapweb.mgr.privilege.IPrivilegeMgr;
import com.fc.cmapweb.mgr.privilege.IRoleMgr;
import com.fc.cmapweb.mgr.rest.IRestMgr;
import com.fc.cmapweb.mgr.usr.IUsrMgr;
import com.fc.cmapweb.vo.PrivilegeInfoVo;
import com.fc.cmapweb.vo.RestInfoVo;
import com.fc.cmapweb.vo.RoleInfoVo;
import com.fc.cmapweb.vo.UsrInfoVo;

@Controller
@RequestMapping("/adminMenu/")
public class AdminMenuCtrl {
	
	@Autowired
	private IPrivilegeMgr privilegeMgr;
	
	@Autowired
	private IRoleMgr roleMgr;
	
	@Autowired
	private IUsrMgr usrMgr;
	
	@Autowired
	private IRestMgr restMgr;
	
	@RequestMapping(value = "/{itemId}", method=RequestMethod.GET)
	public String showPage(@PathVariable String itemId, Model model, HttpServletRequest request) {
		
		if ("menuPrivilegeCfg".equals(itemId)) {
			
			model.addAttribute("privilegeCount", privilegeMgr.queryPrivilegeCount(null));
			model.addAttribute("privilegeInfoVo", new PrivilegeInfoVo());
			return "/admin/privilege/privilegeCfg";
			
		} else if ("menuRoleCfg".equals(itemId)) {
			
			model.addAttribute("allPrivileges", privilegeMgr.queryAllEnabledPrivilege());
			model.addAttribute("roleCount", roleMgr.queryRoleCount(null));
			model.addAttribute("roleInfoVo", new RoleInfoVo());
			return "admin/privilege/roleCfg";
			
		} else if ("menuRoleBinding".equals(itemId)) {
			
			return "/admin/privilege/roleBinding";
			
		} else if ("menuUsrMgr".equals(itemId)) {
			
			model.addAttribute("usrCount", usrMgr.queryUsrCount(null));
			model.addAttribute("usrInfoVo", new UsrInfoVo());
			return "admin/usr/usrMgr";
			
		} else if ("menuRestMgr".equals(itemId)) {
			
			model.addAttribute("restCount", restMgr.queryRestCount(null));
			model.addAttribute("restInfoVo", new RestInfoVo());
			return "/admin/rest/restMgr";
			
		} else {
			
			return "/common/blank";
			
		}
		
	}

}
