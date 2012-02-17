package com.fc.cmapweb.web.admin.privilege;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.cmapweb.mgr.privilege.IPrivilegeMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.PropUtil;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.PrivilegeInfoVo;

@Controller
@RequestMapping("/adminPrivilege")
public class PrivilegeCtrl {
	
	@Autowired
	private IPrivilegeMgr privilegeMgr;
	
	@RequestMapping(value = "/{privilegeId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deletePrivilege(@PathVariable String privilegeId, HttpServletRequest request) {
		
		privilegeMgr.rmPrivilege(privilegeId);
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = privilegeMgr.queryPrivilegeCount(queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("delete.success", null), otherParams);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String addPrivilege(@ModelAttribute("privilegeInfoVo") PrivilegeInfoVo privilegeInfoVo) {
		
		// TODO: 数据校验
		
		privilegeMgr.addPrivilege(privilegeInfoVo);
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("add.success", null));
		
	}
	
	@RequestMapping(value = "/edit/{privilegeId}", method = RequestMethod.PUT)
	@ResponseBody
	public String updatePrivilege(@PathVariable String privilegeId, HttpServletRequest request) {
		
		Map<String, Object> updateParams = ParamUtil.getParams(request, CmapValues.PREFIX_DETAIL);
		privilegeMgr.updatePrivilege(privilegeId, updateParams);
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = privilegeMgr.queryPrivilegeCount(queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("update.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/{privilegeId}", method = RequestMethod.GET)
	public String showPrivilegeInfo(@PathVariable String privilegeId, Model model) {
		
		model.addAttribute("privilegeInfoVo", privilegeMgr.queryPrivilege(privilegeId));
		return "/admin/privilege/privilegeInfo";
		
	}
	
	@RequestMapping(value = "/{privilegeId}", method = RequestMethod.PUT)
	@ResponseBody
	public String enableDisablePrivilege(@PathVariable String privilegeId) {
		
		boolean flag = privilegeMgr.updateEnableDisable(privilegeId);
		
		if (flag) {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("enable.success", null));
		} else {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("disable.success", null));
		}
		
	}
	
	@RequestMapping(value = "/privilegeCount", method = RequestMethod.GET)
	@ResponseBody
	public String queryPrivilegeCount(HttpServletRequest request) {
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = privilegeMgr.queryPrivilegeCount(queryParams);
		
		return String.valueOf(count);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String queryPrivilege(Model model, HttpServletRequest request) {
		
		int pageIndex = ParamUtil.getCurrentPage(request);
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		
		List<PrivilegeInfoVo> privilegeList = privilegeMgr.queryPrivileges(queryParams, pageIndex, CmapValues.DEFAULT_PAGE_SIZE);
		
		model.addAttribute("privilegeList", privilegeList);
		
		return "/admin/privilege/privilegeList";
		
	}

}
