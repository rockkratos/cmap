package com.fc.cmapweb.mgr.privilege.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.privilege.IPrivilegeDao;
import com.fc.cmapweb.mgr.privilege.IPrivilegeMgr;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.vo.PrivilegeInfoVo;
import com.googlecode.ehcache.annotations.TriggersRemove;

@Service("privilegeMgr")
public class PrivilegeMgrImpl implements IPrivilegeMgr {

	@Autowired
	private IPrivilegeDao privilegeDao;
	
	@Override
	@TriggersRemove(cacheName = "eternalCache")
	public void rmPrivilege(String privilegeId) {
		privilegeDao.delPrivilege(privilegeId);
	}
	
	@Override
	@TriggersRemove(cacheName = "eternalCache")
	public boolean updateEnableDisable(String privilegeId) {
		return privilegeDao.switchEnableDisable(privilegeId);
	}
	
	@Override
	public int queryPrivilegeCount(Map<String, Object> queryParams) {
		return privilegeDao.getPrivilegeCount(queryParams);
	}
	
	@Override
	public List<PrivilegeInfoVo> queryPrivileges(Map<String, Object> queryParams, int pageIndex, int pageSize) {
		
		List<PrivilegeInfoVo> back =  privilegeDao.getPrivileges(queryParams, pageIndex, pageSize);
		PaginationUtil.fillList(back, PrivilegeInfoVo.class, pageSize);
		
		return back;
		
	}

	@Override
	public PrivilegeInfoVo queryPrivilege(String privilegeId) {
		return privilegeDao.getPrivilege(privilegeId);
	}

	@Override
	@TriggersRemove(cacheName = "eternalCache")
	public PrivilegeInfoVo addPrivilege(PrivilegeInfoVo privilegeInfoVo) {
		return privilegeDao.insertPrivilege(privilegeInfoVo);
	}

}
