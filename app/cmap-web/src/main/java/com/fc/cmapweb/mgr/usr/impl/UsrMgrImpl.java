package com.fc.cmapweb.mgr.usr.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.usr.IUsrDao;
import com.fc.cmapweb.mgr.usr.IUsrMgr;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.UsrInfoVo;

@Service("usrMgr")
public class UsrMgrImpl implements IUsrMgr {

	@Autowired
	private IUsrDao usrDao;
	
	@Override
	public void rmUsr(String usrId) {
		usrDao.delUsr(usrId);
	}
	
	@Override
	public boolean updateEnableDisable(String usrId) {
		return usrDao.switchEnableDisable(usrId);
	}
	
	@Override
	public List<UsrInfoVo> queryUsr(Map<String, Object> queryParams, int currentPage, int pageSize) {
		
		List<UsrInfoVo> back = usrDao.getUsr(queryParams, currentPage, pageSize);
		PaginationUtil.fillList(back, UsrInfoVo.class, pageSize);
		
		return back;
		
	}
	
	@Override
	public int queryUsrCount(Map<String, Object> queryParams) {
		return usrDao.getUsrCount(queryParams);
	}
	
	@Override
	public UsrInfoVo queryUsrInfo(String loginName) {
		
		if (StrUtil.isNotEmpty(loginName)) {
			return usrDao.getUsrInfo(loginName);
		} else {
			return null;
		}
		
	}

	@Override
	public UsrInfoVo addUsr(UsrInfoVo usrInfoVo) {
		return usrDao.insertUsr(usrInfoVo);
	}
	
	@Override
	public List<String> queryAllUsrRole(String loginName) {
		return usrDao.getAllUsrRole(loginName);
	}

}
