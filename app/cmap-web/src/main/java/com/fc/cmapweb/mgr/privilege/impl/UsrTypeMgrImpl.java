package com.fc.cmapweb.mgr.privilege.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.privilege.IUsrTypeDao;
import com.fc.cmapweb.mgr.privilege.IUsrTypeMgr;
import com.fc.cmapweb.vo.UsrTypeVo;

@Service("usrTypeMgr")
public class UsrTypeMgrImpl implements IUsrTypeMgr {

	@Autowired
	private IUsrTypeDao usrTypeDao;
	
	@Override
	public UsrTypeVo queryUsrType(int usrTypeId) {
		return usrTypeDao.getUsrType(usrTypeId);
	}

}
