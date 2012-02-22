package com.fc.cmapweb.mgr.usr;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.UsrInfoVo;

public interface IUsrMgr {
	
	public void rmUsr(String usrId);
	public boolean updateEnableDisable(String usrId);
	
	public List<UsrInfoVo> queryUsr(Map<String, Object> queryParams, int currentPage, int pageSize);
	public int queryUsrCount(Map<String, Object> queryParams);
	
	public UsrInfoVo queryUsrInfo(String loginName);
	public UsrInfoVo addUsr(UsrInfoVo usrInfoVo);
	public List<String> queryAllUsrRole(String loginName);

}
