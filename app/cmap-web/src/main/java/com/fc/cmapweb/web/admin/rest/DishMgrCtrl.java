package com.fc.cmapweb.web.admin.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fc.cmapweb.mgr.rest.IDishMgr;
import com.fc.cmapweb.mgr.rest.IDishSortMgr;
import com.fc.cmapweb.mgr.rest.IRestMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.ParamUtil;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public String queryDish(Model model, HttpServletRequest request) {
		
		int pageIndex = ParamUtil.getCurrentPage(request);
		Map<String, Object> queryParams = ParamUtil.getParams(request, CmapValues.PREFIX_QUERY);
		
		String restId = request.getParameter("restId");
		
		List<DishInfoVo> dishList = dishMgr.queryDish(queryParams, restId, pageIndex, CmapValues.DEFAULT_PAGE_SIZE);
		model.addAttribute("dishList", dishList);
		
		return "/admin/rest/dishList";
		
	}
	
	@RequestMapping(value = "/{restId}", method = RequestMethod.GET)
	public String showDishPage(@PathVariable String restId, Model model) {
		
		model.addAttribute("dishCount", dishMgr.queryDishCount(restId));
		model.addAttribute("dishSortList", dishSortMgr.queryAllDishSort(restId));
		model.addAttribute("restId", restId);
		model.addAttribute("restName", restMgr.queryRestInfo(restId).getRestName());
		model.addAttribute("dishInfoVo", new DishInfoVo());
		return "/admin/rest/dishMgr";
		
	}
	
}
