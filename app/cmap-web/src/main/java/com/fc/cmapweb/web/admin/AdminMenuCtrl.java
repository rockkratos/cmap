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
import com.fc.cmapweb.utils.QueryUtil;
import com.fc.cmapweb.vo.PrivilegeInfoVo;

@Controller
@RequestMapping("/adminMenu/")
public class AdminMenuCtrl {
	
	@Autowired
	private IPrivilegeMgr privilegeMgr;
	
	@RequestMapping(value = "/{itemId}", method=RequestMethod.GET)
	public String showPage(@PathVariable String itemId, Model model, HttpServletRequest request) {
		
		if ("menuPrivilegeCfg".equals(itemId)) {
			
			Map<String, Object> queryParams = QueryUtil.getQueryParams(request);
			
			model.addAttribute("privilegeCount", privilegeMgr.queryPrivilegeCount(queryParams));
			model.addAttribute("privilegeInfoVo", new PrivilegeInfoVo());
			return "/admin/privilege/privilegeCfg";
			
		} else {
			
			return "/common/blank";
			
		}
		
	}

}
