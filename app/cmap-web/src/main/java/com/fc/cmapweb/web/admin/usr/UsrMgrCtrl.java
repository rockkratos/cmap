package com.fc.cmapweb.web.admin.usr;

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

import com.fc.cmapweb.mgr.usr.IUsrMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.DateUtil;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.utils.PropUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.UsrInfoVo;

@Controller
@RequestMapping("/adminUsrMgr")
public class UsrMgrCtrl {
	
	@Autowired
	private IUsrMgr usrMgr;
	
	@RequestMapping(value = "/edit/{usrId}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateUsr(@PathVariable String usrId, HttpServletRequest request) {
		
		Map<String, Object> updateParams = ParamUtil.getParams(request, CmapValues.PREFIX_DETAIL);
		
		usrMgr.updateUsr(usrId, updateParams);
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = usrMgr.queryUsrCount(queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("update.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/{usrId}", method = RequestMethod.GET)
	public String showUsrInfo(@PathVariable String usrId, Model model) {
		
		model.addAttribute("usrInfoVo", usrMgr.queryUsrInfoByUsrId(usrId));
		return "/admin/usr/usrInfo";
		
	}
	
	@RequestMapping(value = "/{usrId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deletePrivilege(@PathVariable String usrId, HttpServletRequest request) {
		
		usrMgr.rmUsr(usrId);
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = usrMgr.queryUsrCount(queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("delete.success", null), otherParams);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String addUsr(@ModelAttribute("usrInfoVo") UsrInfoVo usrInfoVo, HttpServletRequest request) {
		
		// TODO: 数据校验
		
		usrInfoVo.setRegTime(DateUtil.getCurrentTime());
		usrMgr.addUsr(usrInfoVo);
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = usrMgr.queryUsrCount(queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("add.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/{usrId}", method = RequestMethod.PUT)
	@ResponseBody
	public String enableDisablePrivilege(@PathVariable String usrId) {
		
		boolean flag = usrMgr.updateEnableDisable(usrId);
		
		if (flag) {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("enable.success", null));
		} else {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("disable.success", null));
		}
		
	}
	
	@RequestMapping(value = "/usrCount", method = RequestMethod.GET)
	@ResponseBody
	public String queryUsrCount(HttpServletRequest request) {
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = usrMgr.queryUsrCount(queryParams);
		
		return String.valueOf(count);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String queryRole(Model model, HttpServletRequest request) {
		
		int pageIndex = ParamUtil.getCurrentPage(request);
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		
		List<UsrInfoVo> usrList = usrMgr.queryUsr(queryParams, pageIndex, CmapValues.DEFAULT_PAGE_SIZE);
		
		model.addAttribute("usrList", usrList);
		
		return "/admin/usr/usrList";
		
	}

}
