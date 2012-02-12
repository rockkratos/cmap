package com.fc.cmapweb.mgr.privilege.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.privilege.IPrivilegeDao;
import com.fc.cmapweb.mgr.privilege.IPrivilegeMgr;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.vo.PrivilegeInfoVo;

@Service("privilegeMgr")
public class PrivilegeMgrImpl implements IPrivilegeMgr {

	@Autowired
	private IPrivilegeDao privilegeDao;
	
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
	public PrivilegeInfoVo addPrivilege(PrivilegeInfoVo privilegeInfoVo) {
		return privilegeDao.insertPrivilege(privilegeInfoVo);
	}

}
