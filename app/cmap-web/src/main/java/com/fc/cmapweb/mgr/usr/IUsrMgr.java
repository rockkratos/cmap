package com.fc.cmapweb.mgr.usr;

import java.util.List;

import com.fc.cmapweb.vo.UsrInfoVo;

public interface IUsrMgr {
	
	public UsrInfoVo queryUsrInfo(String loginName);
	public UsrInfoVo addUsr(UsrInfoVo usrInfoVo);
	public List<String> queryAllUsrRole(String loginName);

}
