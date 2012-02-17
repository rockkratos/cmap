package com.fc.cmapweb.web.admin.privilege;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.cmapweb.mgr.privilege.IRoleMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.ParamUtil;

@Controller
@RequestMapping("/adminRole")
public class RoleCtrl {
	
	@Autowired
	private IRoleMgr roleMgr;
	
	@RequestMapping(value = "/roleCount", method = RequestMethod.GET)
	@ResponseBody
	public String queryRoleCount(HttpServletRequest request) {
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = roleMgr.queryRoleCount(queryParams);
		
		return String.valueOf(count);
		
	}

}
