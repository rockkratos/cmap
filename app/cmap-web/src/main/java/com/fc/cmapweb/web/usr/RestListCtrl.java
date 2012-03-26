package com.fc.cmapweb.web.usr;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.cmapweb.mgr.frontend.IRestSearchMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.DateUtil;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.web.form.RestSearchFormVo;

@Controller
@RequestMapping("/rest")
public class RestListCtrl {

	@Autowired
	private IRestSearchMgr usrRestMgr;
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ResponseBody
	public String searchRestCount(HttpServletRequest request, Model model) {
		
		RestSearchFormVo queryParams = getQueryParams(request);
		int count = usrRestMgr.searchRestCount(queryParams);
		
		return String.valueOf(count);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String showRestList(@ModelAttribute("restSearchForm") RestSearchFormVo restSearchFormVo, Model model) {
		
		model.addAttribute("restCount", usrRestMgr.searchRestCount(restSearchFormVo));
		model.addAttribute("restSearchFormVo", restSearchFormVo);
		return "/usr/restSearchList";
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String searchRest(HttpServletRequest request, Model model) {
		
		int pageIndex = ParamUtil.getCurrentPage(request);
		
		RestSearchFormVo queryParams = getQueryParams(request);
		model.addAttribute("restList", usrRestMgr.searchRest(queryParams, pageIndex, CmapValues.SEARCH_REST_PAGE_SIZE));
		
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
	
	private RestSearchFormVo getQueryParams(HttpServletRequest request) {
		
		RestSearchFormVo queryParams = new RestSearchFormVo();
		
		queryParams.setCityId(Integer.valueOf(request.getParameter("cityId")));
		queryParams.setCookingTypeId(Integer.valueOf(request.getParameter("cookingTypeId")));
		queryParams.setCustomerLng(Double.valueOf(request.getParameter("customerLng")));
		queryParams.setCustomerLat(Double.valueOf(request.getParameter("customerLat")));
		queryParams.setNowTime(DateUtil.getCurrentTime("HHmm"));
		setRestFarAway(queryParams, request.getParameter("restFarWayId"));
		
		return queryParams;
		
	}
	
}
