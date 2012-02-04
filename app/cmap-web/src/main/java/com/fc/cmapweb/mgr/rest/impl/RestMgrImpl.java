package com.fc.cmapweb.mgr.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.rest.IRestDao;
import com.fc.cmapweb.mgr.rest.IRestMgr;
import com.fc.cmapweb.vo.RestInfoVo;

@Service("restMgr")
public class RestMgrImpl implements IRestMgr {

	@Autowired
	private IRestDao restDao;
	
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
