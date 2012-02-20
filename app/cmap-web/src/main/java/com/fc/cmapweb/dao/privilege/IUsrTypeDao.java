package com.fc.cmapweb.dao.privilege;

import com.fc.cmapweb.vo.UsrTypeVo;

public interface IUsrTypeDao {
	
	public boolean switchEnableDisable(int usrTypeId, boolean enabled);
	public UsrTypeVo getUsrType(int usrTypeId);
	
}
