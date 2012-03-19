package com.fc.cmapweb.web.usr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fc.cmapweb.mgr.frontend.IRestSearchMgr;

@Controller
@RequestMapping("/detail")
public class RestDetailCtrl {
	
	@Autowired
	private IRestSearchMgr restSearchMgr;
	
	@RequestMapping(method = RequestMethod.POST)
	public String showDetailPage(@RequestParam String restId, @RequestParam String customerAddr, @RequestParam double customerLng, @RequestParam double customerLat, Model model) {
		
		model.addAttribute("dishList", restSearchMgr.queryDish(restId));
		model.addAttribute("dishSortList", restSearchMgr.queryDishSort(restId));
		model.addAttribute("restInfo", restSearchMgr.queryRestInfo(restId));
		model.addAttribute("customerAddr", customerAddr);
		
		return "/usr/restDetail";
		
	}
	
}
