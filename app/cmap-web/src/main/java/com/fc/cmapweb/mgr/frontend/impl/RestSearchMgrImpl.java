package com.fc.cmapweb.mgr.frontend.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.frontend.IRestSearchDao;
import com.fc.cmapweb.dao.rest.IDishSortDao;
import com.fc.cmapweb.dao.rest.IRestDao;
import com.fc.cmapweb.mgr.frontend.IRestSearchMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.DateUtil;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.DishInfoVo;
import com.fc.cmapweb.vo.DishSortVo;
import com.fc.cmapweb.vo.RestInfoVo;
import com.fc.cmapweb.web.form.RestSearchFormVo;

@Service("restSearchMgr")
public class RestSearchMgrImpl implements IRestSearchMgr {
	
	@Autowired
	private IRestSearchDao restSearchDao;
	
	@Autowired
	private IRestDao restDao;
	
	@Autowired
	private IDishSortDao dishSortDao;
	
	@Override
	public List<DishInfoVo> queryDish(String restId) {
		return restSearchDao.getAllDishByRestId(restId);
	}
	
	@Override
	public List<DishSortVo> queryDishSort(String restId) {
		return dishSortDao.getAllDishSort(restId);
	}
	
	@Override
	public RestInfoVo queryRestInfo(String restId) {
		
		RestInfoVo back = restDao.getRestInfo(restId);
		back.setRestOpenTime(DateUtil.formatTimeStr(back.getRestOpenTime()));
		back.setRestCloseTime(DateUtil.formatTimeStr(back.getRestCloseTime()));
		back.setRestPhone(StrUtil.getRestPhoneNbr(back.getRestPhone()));
		
		return back;
		
	}
	
	@Override
	public int searchRestCount(RestSearchFormVo restSearchFormVo) {
		return restSearchDao.getRestCount(restSearchFormVo);
	}
	
	@Override
	public List<RestInfoVo> searchRest(RestSearchFormVo restSearchFormVo, int currentPage, int pageSize) {
		
		restSearchFormVo.setNowTime(DateUtil.getCurrentTime("HHmm"));
		List<RestInfoVo> back = restSearchDao.getRest(restSearchFormVo, currentPage, pageSize);
		PaginationUtil.fillList(back, RestInfoVo.class, CmapValues.SEARCH_REST_PAGE_SIZE);
		
		return back;
		
	}

}
