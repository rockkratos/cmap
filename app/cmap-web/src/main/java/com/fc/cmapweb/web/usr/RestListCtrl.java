package com.fc.cmapweb.web.usr;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fc.cmapweb.mgr.frontend.IRestMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.DateUtil;
import com.fc.cmapweb.web.form.RestSearchFormVo;

@Controller
@RequestMapping("/rest")
public class RestListCtrl {

	@Autowired
	private IRestMgr usrRestMgr;
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ResponseBody
	public String searchRestCount(HttpServletRequest request, Model model) {
		
		RestSearchFormVo queryParams = new RestSearchFormVo();
		queryParams.setCityId(Integer.valueOf(request.getParameter("cityId")));
		queryParams.setCookingTypeId(Integer.valueOf(request.getParameter("cookingTypeId")));
		queryParams.setCustomerLng(Double.valueOf(request.getParameter("customerLng")));
		queryParams.setCustomerLat(Double.valueOf(request.getParameter("customerLat")));
		queryParams.setNowTime(DateUtil.getCurrentTime("HHmm"));
		setRestFarAway(queryParams, request.getParameter("restFarWayId"));
		
		int count = usrRestMgr.searchRestCount(queryParams);
		
		Map<String, String> backParams = new HashMap<String, String>();
		backParams.put("recordCount", String.valueOf(count));
		
		return JSON.toJSONString(backParams);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String showRestList(@ModelAttribute("idxFormVo") RestSearchFormVo restSearchFormVo, Model model) {
		
		model.addAttribute("restList", usrRestMgr.searchRest(restSearchFormVo));
//		model.addAttribute("cookingType", restSearchFormVo.getCookingTypeId());
		model.addAttribute("restCount", usrRestMgr.searchRestCount(restSearchFormVo));
//		model.addAttribute("customerAddr", restSearchFormVo.getCustomerAddr());
		model.addAttribute("restSearchFormVo", restSearchFormVo);
		return "/usr/restSearchList";
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String searchRest() {
		return "/usr/restSearchResult";
	}
	
	private void setRestFarAway(RestSearchFormVo restSearchFormVo, String restFarAway) {
		
		int flag = Integer.valueOf(restFarAway);
		
		switch (flag) {
		case CmapValues.REST_FAR_AWAY_HALF_KM:
			restSearchFormVo.setRestFarAway(500);
			break;
		case CmapValues.REST_FAR_AWAY_1KM:
			restSearchFormVo.setRestFarAway(1000);
			break;
		case CmapValues.REST_FAR_AWAY_2KM:
			restSearchFormVo.setRestFarAway(2000);
		}
		
	}
	
}
