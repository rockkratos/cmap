package com.fc.cmapweb.mgr.privilege.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.privilege.IRoleDao;
import com.fc.cmapweb.mgr.privilege.IRoleMgr;
import com.fc.cmapweb.vo.RoleInfoVo;

@Service("roleMgr")
public class RoleMgrImpl implements IRoleMgr {

	@Autowired
	private IRoleDao roleDao;
	
	@Override
	public int queryRoleCount(Map<String, Object> queryParams) {
		return roleDao.getRoleCount(queryParams);
	}

	@Override
	public RoleInfoVo queryRole(String roleId) {
		return roleDao.getRole(roleId);
	}

	@Override
	public RoleInfoVo addRole(RoleInfoVo roleInfoVo) {
		return roleDao.insertRole(roleInfoVo);
	}

}
