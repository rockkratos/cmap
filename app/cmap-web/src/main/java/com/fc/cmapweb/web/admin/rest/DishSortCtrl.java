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

import com.fc.cmapweb.mgr.rest.IDishSortMgr;
import com.fc.cmapweb.mgr.rest.IRestMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.utils.PropUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.DishSortVo;
import com.fc.cmapweb.vo.RestInfoVo;

@Controller
@RequestMapping("/adminDishSort")
public class DishSortCtrl {
	
	@Autowired
	private IRestMgr restMgr;
	
	@Autowired
	private IDishSortMgr dishSortMgr;
	
	@RequestMapping(value = "/{restId}/{dishSortId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteRest(@PathVariable String restId, @PathVariable String dishSortId) {
		
		dishSortMgr.rmDishSort(dishSortId);
		
		int count = dishSortMgr.queryDishSortCount(restId);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("delete.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/{restId}", method = RequestMethod.POST)
	@ResponseBody
	public String addRest(@ModelAttribute("dishSortVo") DishSortVo dishSortVo, @PathVariable String restId) {
		
		// TODO: 数据校验
		
		dishSortMgr.addDishSort(dishSortVo, restId);
		
		int count = dishSortMgr.queryDishSortCount(restId);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("add.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/{restId}", method = RequestMethod.GET)
	public String showDishSort(@PathVariable String restId, Model model) {
		
		RestInfoVo tmpRest = restMgr.queryRestInfo(restId);
		
		model.addAttribute("restId", restId);
		model.addAttribute("restName", tmpRest.getRestName());
		model.addAttribute("dishSortVo", new DishSortVo());
		model.addAttribute("dishSortCount", dishSortMgr.queryDishSortCount(restId));
		
		return "/admin/rest/dishSortCfg";
		
	}
	
	@RequestMapping(value = "/list/{restId}", method = RequestMethod.GET)
	public String queryDishSort(@PathVariable String restId, Model model, HttpServletRequest request) {
		
		int pageIndex = ParamUtil.getCurrentPage(request);
		
		List<DishSortVo> dishSortList = dishSortMgr.queryDishSort(restId, pageIndex, CmapValues.DEFAULT_PAGE_SIZE);		
		model.addAttribute("dishSortList", dishSortList);
		model.addAttribute("restId", restId);
		
		return "/admin/rest/dishSortList";
		
	}

}
