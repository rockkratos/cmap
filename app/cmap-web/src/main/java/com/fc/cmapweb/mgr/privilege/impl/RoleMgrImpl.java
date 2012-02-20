package com.fc.cmapweb.mgr.privilege.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.privilege.IRoleDao;
import com.fc.cmapweb.dao.privilege.IRolePrivilegeDao;
import com.fc.cmapweb.dao.privilege.IUsrTypeRoleDao;
import com.fc.cmapweb.mgr.privilege.IRoleMgr;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.vo.PrivilegeInfoVo;
import com.fc.cmapweb.vo.RoleInfoVo;
import com.fc.cmapweb.vo.RolePrivilegeVo;
import com.googlecode.ehcache.annotations.TriggersRemove;

@Service("roleMgr")
public class RoleMgrImpl implements IRoleMgr {

	@Autowired
	private IRoleDao roleDao;
	
	@Autowired
	private IRolePrivilegeDao rolePrivilegeDao;
	
	@Autowired
	private IUsrTypeRoleDao usrTypeRoleDao;
	
	@Override
	@TriggersRemove(cacheName = "eternalCache")
	public void updateRole(String roleId, Map<String, Object> updateParams, List<String> privilegeIdList) {
		
		RoleInfoVo tmpRole = new RoleInfoVo();
		tmpRole.setRoleId(roleId);
		tmpRole.setRoleDesc(String.valueOf(updateParams.get("roleDesc")));
		tmpRole.setRoleEnabled(Boolean.valueOf(String.valueOf(updateParams.get("roleEnabled"))));
		tmpRole.setRoleName(String.valueOf(updateParams.get("roleName")));
		
		roleDao.updateRole(tmpRole);
		rolePrivilegeDao.delAllPrivilegeByRoleId(roleId);
		
		if (null != privilegeIdList && privilegeIdList.size() > 0) {
			
			for (int i = 0; i < privilegeIdList.size(); i++) {
				
				PrivilegeInfoVo tmpPrivilege = new PrivilegeInfoVo();
				tmpPrivilege.setPrivilegeId(privilegeIdList.get(i));
				
				RolePrivilegeVo tmpRolePrivilege = new RolePrivilegeVo();
				tmpRolePrivilege.setRoleInfoVo(tmpRole);
				tmpRolePrivilege.setPrivilegeInfoVo(tmpPrivilege);
				
				rolePrivilegeDao.insertRolePrivilege(tmpRolePrivilege);
				
			}
			
		}
		
	}
	
	@Override
	@TriggersRemove(cacheName = "eternalCache")
	public void rmRole(String roleId) {
		rolePrivilegeDao.delAllPrivilegeByRoleId(roleId);
		usrTypeRoleDao.delUsrTypeRole(roleId);
		roleDao.delRole(roleId);
	}
	
	@Override
	@TriggersRemove(cacheName = "eternalCache")
	public boolean updateEnableDisable(String roleId) {
		return roleDao.switchEnableDisable(roleId);
	}
	
	@Override
	public List<RoleInfoVo> queryRole(Map<String, Object> queryParams, int currentPage, int pageSize) {
		
		List<RoleInfoVo> back =  roleDao.getRole(queryParams, currentPage, pageSize);
		PaginationUtil.fillList(back, RoleInfoVo.class, pageSize);
		
		return back;
		
	}
	
	@Override
	public int queryRoleCount(Map<String, Object> queryParams) {
		return roleDao.getRoleCount(queryParams);
	}

	@Override
	public RoleInfoVo queryRole(String roleId) {
		return roleDao.getRole(roleId);
	}

	@Override
	@TriggersRemove(cacheName = "eternalCache")
	public RoleInfoVo addRole(RoleInfoVo roleInfoVo, List<String> privilegeIdList) {
		
		roleDao.insertRole(roleInfoVo);
		
		if (null != privilegeIdList && privilegeIdList.size() > 0) {
			
			for (int i = 0; i < privilegeIdList.size(); i++) {
				
				PrivilegeInfoVo tmpPrivilege = new PrivilegeInfoVo();
				tmpPrivilege.setPrivilegeId(privilegeIdList.get(i));
				
				RolePrivilegeVo tmpRolePrivilege = new RolePrivilegeVo();
				tmpRolePrivilege.setRoleInfoVo(roleInfoVo);
				tmpRolePrivilege.setPrivilegeInfoVo(tmpPrivilege);
				
				rolePrivilegeDao.insertRolePrivilege(tmpRolePrivilege);
				
			}
			
		}
		
		return roleInfoVo;
		
	}
	
}
