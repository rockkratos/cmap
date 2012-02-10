package com.fc.cmapweb.mgr.privilege.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.privilege.IPrivilegeDao;
import com.fc.cmapweb.mgr.privilege.IPrivilegeMgr;
import com.fc.cmapweb.vo.PrivilegeInfoVo;

@Service("privilegeMgr")
public class PrivilegeMgrImpl implements IPrivilegeMgr {

	@Autowired
	private IPrivilegeDao privilegeDao;
	
	@Override
	public List<PrivilegeInfoVo> queryPrivileges(PrivilegeInfoVo queryCondition) {
		return privilegeDao.getAllPrivileges();
	}

	@Override
	public PrivilegeInfoVo queryPrivilege(String privilegeId) {
		return privilegeDao.getPrivilege(privilegeId);
	}

	@Override
	public PrivilegeInfoVo addPrivilege(PrivilegeInfoVo privilegeInfoVo) {
		return privilegeDao.insertPrivilege(privilegeInfoVo);
	}

}
