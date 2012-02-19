package com.fc.cmapweb.mgr.privilege.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.privilege.IUsrTypeRoleDao;
import com.fc.cmapweb.mgr.privilege.IUsrTypeRoleMgr;
import com.fc.cmapweb.vo.UsrTypeRoleVo;

@Service("usrTypeRoleMgr")
public class UsrTypeRoleMgrImpl implements IUsrTypeRoleMgr {

	@Autowired
	private IUsrTypeRoleDao usrTypeRoleDao;
	
	@Override
	public List<UsrTypeRoleVo> queryRoleMarkedUsrType(int usrTypeId) {
		return usrTypeRoleDao.getRoleMarkedUsrType(usrTypeId);
	}

	@Override
	public List<UsrTypeRoleVo> queryUsrTypeRoles(int usrTypeId) {
		return usrTypeRoleDao.getUsrTypeRoles(usrTypeId);
	}

}
