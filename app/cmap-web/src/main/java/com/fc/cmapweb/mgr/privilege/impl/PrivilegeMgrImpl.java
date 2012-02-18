package com.fc.cmapweb.mgr.privilege.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.privilege.IPrivilegeDao;
import com.fc.cmapweb.mgr.privilege.IPrivilegeMgr;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.vo.HttpMethodTypeVo;
import com.fc.cmapweb.vo.PrivilegeInfoVo;
import com.googlecode.ehcache.annotations.TriggersRemove;

@Service("privilegeMgr")
public class PrivilegeMgrImpl implements IPrivilegeMgr {

	@Autowired
	private IPrivilegeDao privilegeDao;
	
	@Override
	public List<PrivilegeInfoVo> queryAllEnabledPrivilege() {
		return privilegeDao.getAllEnabledPrivilege();
	}
	
	@Override
	public List<PrivilegeInfoVo> queryPrivilegeMarkedRole(String roleId) {
		return privilegeDao.getPrivilegeMarkedRole(roleId);
	}
	
	@Override
	@TriggersRemove(cacheName = "eternalCache")
	public void updatePrivilege(String privilegeId, Map<String, Object> updateParams) {
		
		HttpMethodTypeVo httpMethodTypeVo = new HttpMethodTypeVo();
		httpMethodTypeVo.setMethodTypeId(Integer.valueOf(String.valueOf(updateParams.get("httpMethodTypeVo.methodTypeId"))));
		
		PrivilegeInfoVo tmpPrivilege = new PrivilegeInfoVo();
		tmpPrivilege.setPrivilegeId(privilegeId);
		tmpPrivilege.setHttpMethodTypeVo(httpMethodTypeVo);
		tmpPrivilege.setPrivilegeDesc(String.valueOf(updateParams.get("privilegeDesc")));
		tmpPrivilege.setPrivilegeEnabled(Boolean.valueOf(String.valueOf(updateParams.get("privilegeEnabled"))));
		tmpPrivilege.setPrivilegeName(String.valueOf(updateParams.get("privilegeName")));
		tmpPrivilege.setResPath(String.valueOf(updateParams.get("resPath")));
		
		privilegeDao.updatePrivilege(tmpPrivilege);
		
	}
	
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
	public List<PrivilegeInfoVo> queryPrivilege(Map<String, Object> queryParams, int currentPage, int pageSize) {
		
		List<PrivilegeInfoVo> back =  privilegeDao.getPrivilege(queryParams, currentPage, pageSize);
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
