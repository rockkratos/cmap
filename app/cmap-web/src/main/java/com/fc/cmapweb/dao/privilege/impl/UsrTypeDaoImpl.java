package com.fc.cmapweb.dao.privilege.impl;

import org.springframework.stereotype.Repository;

import com.fc.cmapweb.dao.CmapBaseDao;
import com.fc.cmapweb.dao.privilege.IUsrTypeDao;
import com.fc.cmapweb.vo.UsrTypeVo;

@Repository("usrTypeDao")
public class UsrTypeDaoImpl extends CmapBaseDao implements IUsrTypeDao {

	@Override
	public boolean switchEnableDisable(int usrTypeId, boolean enabled) {
		
		UsrTypeVo usrTypeVo = em.find(UsrTypeVo.class, usrTypeId);
		
		if (usrTypeVo.isUsrTypeEnabled() != enabled) {
			usrTypeVo.setUsrTypeEnabled(enabled);
		}
		
		return usrTypeVo.isUsrTypeEnabled();
		
	}
	
	@Override
	public UsrTypeVo getUsrType(int usrTypeId) {
		return em.find(UsrTypeVo.class, usrTypeId);
	}

}
