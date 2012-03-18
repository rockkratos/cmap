package com.fc.cmapweb.mgr.frontend.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.frontend.IRestDao;
import com.fc.cmapweb.mgr.frontend.IRestMgr;
import com.fc.cmapweb.utils.DateUtil;
import com.fc.cmapweb.vo.RestInfoVo;
import com.fc.cmapweb.web.form.RestSearchFormVo;

@Service("usrRestMgr")
public class RestMgrImpl implements IRestMgr {
	
	@Autowired
	private IRestDao usrRestDao;
	
	@Override
	public int searchRestCount(RestSearchFormVo restSearchFormVo) {
		return usrRestDao.getRestCount(restSearchFormVo);
	}
	
	@Override
	public List<RestInfoVo> searchRest(RestSearchFormVo restSearchFormVo) {
		
		restSearchFormVo.setNowTime(DateUtil.getCurrentTime("HHmm"));
		return usrRestDao.getRest(restSearchFormVo);
		
	}

}
