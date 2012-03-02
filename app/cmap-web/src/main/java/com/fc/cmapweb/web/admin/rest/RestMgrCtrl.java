package com.fc.cmapweb.web.admin.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.cmapweb.mgr.rest.IRestMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.utils.PropUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.RestInfoVo;

@Controller
@RequestMapping("/adminRestMgr")
public class RestMgrCtrl {
	
	@Autowired
	private IRestMgr restMgr;
	
	@RequestMapping(value = "/{restId}", method = RequestMethod.GET)
	public String showRestInfo(@PathVariable String restId, Model model) {
		
		model.addAttribute("restInfoVo", restMgr.queryRestInfo(restId));
		return "/admin/rest/restInfo";
		
	}
	
	@RequestMapping(value = "/{restId}", method = RequestMethod.PUT)
	@ResponseBody
	public String enableDisableRest(@PathVariable String restId) {
		
		boolean flag = restMgr.updateEnableDisable(restId);
		
		if (flag) {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("enable.success", null));
		} else {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("disable.success", null));
		}
		
	}
	
	@RequestMapping(value = "/{restId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteRest(@PathVariable String restId, HttpServletRequest request) {
		
		restMgr.rmRest(restId);
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = restMgr.queryRestCount(queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("delete.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/restCount", method = RequestMethod.GET)
	@ResponseBody
	public String queryRestCount(HttpServletRequest request) {
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = restMgr.queryRestCount(queryParams);
		
		return String.valueOf(count);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String addRest(@ModelAttribute("restInfoVo") RestInfoVo restInfoVo, HttpServletRequest request) {
		
		// TODO: 数据校验
		
		restMgr.addRest(restInfoVo);
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = restMgr.queryRestCount(queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("add.success", null), otherParams);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String queryRest(Model model, HttpServletRequest request) {
		
		int pageIndex = ParamUtil.getCurrentPage(request);
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		
		List<RestInfoVo> restList = restMgr.queryRest(queryParams, pageIndex, CmapValues.DEFAULT_PAGE_SIZE);		
		model.addAttribute("restList", restList);
		
		return "/admin/rest/restList";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
