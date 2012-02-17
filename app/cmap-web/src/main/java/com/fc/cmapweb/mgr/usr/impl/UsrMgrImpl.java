package com.fc.cmapweb.mgr.usr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.usr.IUsrDao;
import com.fc.cmapweb.mgr.usr.IUsrMgr;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.UsrInfoVo;

@Service("usrMgr")
public class UsrMgrImpl implements IUsrMgr {

	@Autowired
	private IUsrDao usrDao;
	
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
