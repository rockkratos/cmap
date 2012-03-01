package com.fc.cmapweb.mgr.rest.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.rest.IRestDao;
import com.fc.cmapweb.mgr.rest.IRestMgr;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.vo.RestInfoVo;

@Service("restMgr")
public class RestMgrImpl implements IRestMgr {

	@Autowired
	private IRestDao restDao;
	
	@Override
	public List<RestInfoVo> queryRest(Map<String, Object> queryParams, int currentPage, int pageSize) {
		
		List<RestInfoVo> back = restDao.getRest(queryParams, currentPage, pageSize);
		PaginationUtil.fillList(back, RestInfoVo.class, pageSize);
		
		return back;
		
	}
	
	@Override
	public int queryRestCount(Map<String, Object> queryParams) {
		return restDao.getRestCount(queryParams);
	}
	
	@Override
	public RestInfoVo addRest(RestInfoVo restInfoVo) {
		return restDao.insertRest(restInfoVo);
	}
	
	@Override
	public RestInfoVo queryRestInfo(String restId) {
		return restDao.getRestInfo(restId);
	}
	
	@Override
	public void rmRest(String restId) {
		restDao.delRest(restId);
	}

}
