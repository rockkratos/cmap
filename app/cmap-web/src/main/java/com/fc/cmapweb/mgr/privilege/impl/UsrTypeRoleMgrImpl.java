package com.fc.cmapweb.mgr.privilege.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.privilege.IUsrTypeDao;
import com.fc.cmapweb.dao.privilege.IUsrTypeRoleDao;
import com.fc.cmapweb.mgr.privilege.IUsrTypeRoleMgr;
import com.fc.cmapweb.vo.RoleInfoVo;
import com.fc.cmapweb.vo.UsrTypeRoleVo;
import com.fc.cmapweb.vo.UsrTypeVo;
import com.googlecode.ehcache.annotations.TriggersRemove;

@Service("usrTypeRoleMgr")
public class UsrTypeRoleMgrImpl implements IUsrTypeRoleMgr {

	@Autowired
	private IUsrTypeRoleDao usrTypeRoleDao;
	
	@Autowired
	private IUsrTypeDao usrTypeDao;
	
	@Override
	@TriggersRemove(cacheName = "eternalCache")
	public void updateUsrTypeRole(boolean enabled, int usrTypeId, List<String> roleIdList) {
		
		usrTypeRoleDao.delAllRoleByUsrType(usrTypeId);
		usrTypeDao.switchEnableDisable(usrTypeId, enabled);
		
		UsrTypeVo tmpUsrType = new UsrTypeVo();
		tmpUsrType.setUsrTypeId(usrTypeId);
		
		if (null != roleIdList && roleIdList.size() > 0) {
			
			for (int i = 0; i < roleIdList.size(); i++) {
				
				RoleInfoVo tmpRole = new RoleInfoVo();
				tmpRole.setRoleId(roleIdList.get(i));
				
				UsrTypeRoleVo tmpUsrTypeRole = new UsrTypeRoleVo();
				tmpUsrTypeRole.setUsrTypeVo(tmpUsrType);
				tmpUsrTypeRole.setRoleInfoVo(tmpRole);
				
				usrTypeRoleDao.insertUsrTypeRole(tmpUsrTypeRole);
				
			}
			
		}
		
	}
	
	@Override
	public List<UsrTypeRoleVo> queryRoleMarkedUsrType(int usrTypeId) {
		return usrTypeRoleDao.getRoleMarkedUsrType(usrTypeId);
	}

}
