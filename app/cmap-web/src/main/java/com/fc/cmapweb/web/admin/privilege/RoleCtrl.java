package com.fc.cmapweb.web.admin.privilege;

import java.util.Arrays;
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
import com.fc.cmapweb.mgr.privilege.IRoleMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.utils.PropUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.RoleInfoVo;

@Controller
@RequestMapping("/adminRole")
public class RoleCtrl {
	
	@Autowired
	private IRoleMgr roleMgr;
	
	@Autowired
	private IPrivilegeMgr privilegeMgr;
	
	@RequestMapping(value = "/edit/{roleId}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateRole(@PathVariable String roleId, HttpServletRequest request) {
		
		String[] editPrivilegeIdArray = request.getParameterValues("editRolePrivilegeId");
		
		Map<String, Object> updateParams = ParamUtil.getParams(request, CmapValues.PREFIX_DETAIL);
		roleMgr.updateRole(roleId, updateParams, Arrays.asList(editPrivilegeIdArray));
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = roleMgr.queryRoleCount(queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("update.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/{roleId}", method = RequestMethod.GET)
	public String showPrivilegeInfo(@PathVariable String roleId, Model model) {
		
		model.addAttribute("roleInfoVo", roleMgr.queryRole(roleId));
		model.addAttribute("privilegeMarkedRole", privilegeMgr.queryPrivilegeMarkedRole(roleId));
		
		return "/admin/privilege/roleInfo";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String addPrivilege(@ModelAttribute("roleInfoVo") RoleInfoVo roleInfoVo, HttpServletRequest request) {
		
		// TODO: 数据校验
		
		String[] privilegeIdArray = request.getParameterValues("setRolePrivilegeId");
		
		roleMgr.addRole(roleInfoVo, Arrays.asList(privilegeIdArray));
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = roleMgr.queryRoleCount(queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("add.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/{roleId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteRole(@PathVariable String roleId, HttpServletRequest request) {
		
		roleMgr.rmRole(roleId);
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = roleMgr.queryRoleCount(queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("delete.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/{roleId}", method = RequestMethod.PUT)
	@ResponseBody
	public String enableDisableRole(@PathVariable String roleId) {
		
		boolean flag = roleMgr.updateEnableDisable(roleId);
		
		if (flag) {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("enable.success", null));
		} else {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("disable.success", null));
		}
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String queryRole(Model model, HttpServletRequest request) {
		
		int pageIndex = ParamUtil.getCurrentPage(request);
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		
		List<RoleInfoVo> roleList = roleMgr.queryRole(queryParams, pageIndex, CmapValues.DEFAULT_PAGE_SIZE);
		
		model.addAttribute("roleList", roleList);
		
		return "/admin/privilege/roleList";
		
	}
	
	@RequestMapping(value = "/roleCount", method = RequestMethod.GET)
	@ResponseBody
	public String queryRoleCount(HttpServletRequest request) {
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = roleMgr.queryRoleCount(queryParams);
		
		return String.valueOf(count);
		
	}

}
