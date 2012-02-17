package com.fc.cmapweb.dao.usr;

import java.util.List;

import com.fc.cmapweb.vo.UsrInfoVo;

public interface IUsrDao {
	
	public UsrInfoVo getUsrInfo(String loginName);
	public UsrInfoVo insertUsr(UsrInfoVo usrInfoVo);
	public List<String> getAllUsrRole(String loginName);

}
