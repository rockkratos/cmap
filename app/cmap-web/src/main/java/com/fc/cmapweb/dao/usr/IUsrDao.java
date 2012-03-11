package com.fc.cmapweb.dao.usr;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.UsrInfoVo;

public interface IUsrDao {
	
	public UsrInfoVo updateUsr(UsrInfoVo usrInfoVo);
	public void delUsr(String usrId);
	public boolean switchEnableDisable(String usrId);
	
	public List<UsrInfoVo> getUsr(boolean isCustomer, Map<String, Object> queryParams, int currentPage, int pageSize);
	public int getUsrCount(boolean isCustomer, Map<String, Object> queryParams);
	
	public UsrInfoVo getUsrInfoByUsrId(String usrId);
	public UsrInfoVo getUsrInfo(String loginName);
	public UsrInfoVo insertUsr(UsrInfoVo usrInfoVo);
	public List<String> getAllUsrRole(String loginName);
	
}
