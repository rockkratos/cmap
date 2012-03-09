package com.fc.cmapweb.web.admin.rest;

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

import com.fc.cmapweb.mgr.rest.IDishMgr;
import com.fc.cmapweb.mgr.rest.IDishSortMgr;
import com.fc.cmapweb.mgr.rest.IRestMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.utils.PropUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.DishInfoVo;

@Controller
@RequestMapping("/adminDishMgr")
public class DishMgrCtrl {
	
	@Autowired
	private IRestMgr restMgr;
	
	@Autowired
	private IDishSortMgr dishSortMgr;
	
	@Autowired
	private IDishMgr dishMgr;
	
	@RequestMapping(value = "/edit/{restId}/{dishId}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateDishSort(@PathVariable String restId, @PathVariable String dishId, HttpServletRequest request) {
		
		Map<String, Object> updateParams = ParamUtil.getParams(request, CmapValues.PREFIX_DETAIL);
		dishMgr.updateDish(dishId, updateParams);
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = dishMgr.queryDishCount(restId, queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("update.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/detail/{restId}/{dishId}", method = RequestMethod.GET)
	public String showRestInfo(@PathVariable String restId, @PathVariable String dishId, Model model) {
		
		model.addAttribute("dishSortList", dishSortMgr.queryAllDishSort(restId));
		model.addAttribute("dishInfoVo", dishMgr.queryDishInfo(dishId));
		model.addAttribute("restId", restId);
		return "/admin/rest/dishInfo";
		
	}
	
	@RequestMapping(value = "/{dishId}", method = RequestMethod.PUT)
	@ResponseBody
	public String enableDisableRest(@PathVariable String dishId) {
		
		boolean flag = dishMgr.updateEnableDisable(dishId);
		
		if (flag) {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("enable.success", null));
		} else {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("disable.success", null));
		}
		
	}
	
	@RequestMapping(value = "/{restId}/{dishId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteRest(@PathVariable String restId, @PathVariable String dishId, HttpServletRequest request) {
		
		dishMgr.rmDish(dishId);
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = dishMgr.queryDishCount(restId, queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("delete.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/dishCount/{restId}", method = RequestMethod.GET)
	@ResponseBody
	public String queryDishCount(@PathVariable String restId, HttpServletRequest request) {
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = dishMgr.queryDishCount(restId, queryParams);
		
		return String.valueOf(count);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String addRest(@ModelAttribute("dishInfoVo") DishInfoVo dishInfoVo, HttpServletRequest request) {
		
		// TODO: 数据校验
		
		dishMgr.addDish(dishInfoVo);
		
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		int count = dishMgr.queryDishCount(request.getParameter("restId"), queryParams);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("add.success", null), otherParams);
		
	}
	
	@RequestMapping(value="/list/{restId}", method = RequestMethod.GET)
	public String queryDish(@PathVariable String restId, Model model, HttpServletRequest request) {
		
		int pageIndex = ParamUtil.getCurrentPage(request);
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		
		List<DishInfoVo> dishList = dishMgr.queryDish(queryParams, restId, pageIndex, CmapValues.DEFAULT_PAGE_SIZE);
		model.addAttribute("dishList", dishList);
		model.addAttribute("restId", restId);
		
		return "/admin/rest/dishList";
		
	}
	
	@RequestMapping(value = "/{restId}", method = RequestMethod.GET)
	public String showDishPage(@PathVariable String restId, Model model, HttpServletRequest request) {
		
		model.addAttribute("dishCount", dishMgr.queryDishCount(restId, new HashMap<String, Object>()));
		model.addAttribute("dishSortList", dishSortMgr.queryAllDishSort(restId));
		model.addAttribute("restId", restId);
		model.addAttribute("restName", restMgr.queryRestInfo(restId).getRestName());
		model.addAttribute("dishInfoVo", new DishInfoVo());
		return "/admin/rest/dishMgr";
		
	}
	
}
