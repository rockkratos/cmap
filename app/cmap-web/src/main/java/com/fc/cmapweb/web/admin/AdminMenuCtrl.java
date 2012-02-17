package com.fc.cmapweb.web.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fc.cmapweb.mgr.privilege.IPrivilegeMgr;
import com.fc.cmapweb.mgr.privilege.IRoleMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.vo.PrivilegeInfoVo;
import com.fc.cmapweb.vo.RoleInfoVo;

@Controller
@RequestMapping("/adminMenu/")
public class AdminMenuCtrl {
	
	@Autowired
	private IPrivilegeMgr privilegeMgr;
	
	@Autowired
	private IRoleMgr roleMgr;
	
	@RequestMapping(value = "/{itemId}", method=RequestMethod.GET)
	public String showPage(@PathVariable String itemId, Model model, HttpServletRequest request) {
		
		Map<String, Object> queryParams = null;
		
		if ("menuPrivilegeCfg".equals(itemId)) {
			
			queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
			
			model.addAttribute("privilegeCount", privilegeMgr.queryPrivilegeCount(queryParams));
			model.addAttribute("privilegeInfoVo", new PrivilegeInfoVo());
			return "/admin/privilege/privilegeCfg";
			
		} else if ("menuRoleCfg".equals(itemId)) {
			
			queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
			
			model.addAttribute("allPrivileges", privilegeMgr.queryAllPrivilege());
			model.addAttribute("roleCount", roleMgr.queryRoleCount(queryParams));
			model.addAttribute("roleInfoVo", new RoleInfoVo());
			return "admin/role/roleCfg";
			
		} else {
			
			return "/common/blank";
			
		}
		
	}

}
