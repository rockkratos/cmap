package com.fc.cmapweb.dao.usr;

import com.fc.cmapweb.vo.UsrInfoVo;

public interface IUsrDao {
	
	public UsrInfoVo getUsrInfo(String loginName);
	public UsrInfoVo insertUsr(UsrInfoVo usrInfoVo);

}
