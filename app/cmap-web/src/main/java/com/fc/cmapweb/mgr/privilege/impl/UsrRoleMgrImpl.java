package com.fc.cmapweb.mgr.privilege.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.privilege.IUsrRoleDao;
import com.fc.cmapweb.mgr.privilege.IUsrRoleMgr;
import com.fc.cmapweb.vo.UsrRoleVo;

@Service("usrRoleMgr")
public class UsrRoleMgrImpl implements IUsrRoleMgr {

	@Autowired
	private IUsrRoleDao usrRoleDao;
	
	@Override
	public List<UsrRoleVo> queryAllUsrRoles() {
		return usrRoleDao.getAllUsrRoles();
	}

	@Override
	public List<UsrRoleVo> queryUsrRoles(String loginName) {
		return usrRoleDao.getUsrRoles(loginName);
	}

}
