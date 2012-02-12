package com.fc.cmapweb.web.admin.privilege;

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
import com.fc.cmapweb.utils.QueryUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.PrivilegeInfoVo;

@Controller
@RequestMapping("/adminPrivilege")
public class PrivilegeCtrl {
	
	@Autowired
	private IPrivilegeMgr privilegeMgr;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String addPrivilege(@ModelAttribute("privilegeInfoVo") PrivilegeInfoVo privilegeInfoVo) {
		
		// TODO: 数据校验
		
		privilegeMgr.addPrivilege(privilegeInfoVo);
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("add.success", null));
		
	}
	
	@RequestMapping(value = "/{privilegeId}", method = RequestMethod.GET)
	public String showPrivilegeInfo(@PathVariable String privilegeId, Model model) {
		
		
		return "/admin/privilege/privilegeInfo";
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String queryPrivilege(Model model, HttpServletRequest request) {
		
		int pageIndex = QueryUtil.getCurrentPage(request);
		Map<String, Object> queryParams = QueryUtil.getQueryParams(request);
		
		List<PrivilegeInfoVo> resultList = privilegeMgr.queryPrivileges(queryParams, pageIndex, CmapValues.DEFAULT_PAGE_SIZE);
		
		model.addAttribute("resultList", resultList);
		
		return "***";
		
	}

}
