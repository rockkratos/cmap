package com.fc.cmapweb.web.admin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fc.cmapweb.mgr.rest.IRestMgr;
import com.fc.cmapweb.vo.DishInfoVo;

@Controller
@RequestMapping("/adminDishMgr")
public class DishMgrCtrl {
	
	@Autowired
	private IRestMgr restMgr;
	
	@RequestMapping(value = "/{restId}", method = RequestMethod.GET)
	public String showDishPage(@PathVariable String restId, Model model) {
		
		model.addAttribute("restId", restId);
		model.addAttribute("restName", restMgr.queryRestInfo(restId).getRestName());
		model.addAttribute("dishInfoVo", new DishInfoVo());
		return "/admin/rest/dishMgr";
		
	}
	
}
