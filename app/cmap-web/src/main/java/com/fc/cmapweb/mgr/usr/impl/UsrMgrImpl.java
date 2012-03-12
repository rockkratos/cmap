package com.fc.cmapweb.mgr.usr.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.usr.IUsrDao;
import com.fc.cmapweb.mgr.usr.IUsrMgr;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.utils.ReflectUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.UsrInfoVo;

@Service("usrMgr")
public class UsrMgrImpl implements IUsrMgr {

	@Autowired
	private IUsrDao usrDao;
	
	@Override
	public void updatePwd(String usrId, String newPwd) {
		usrDao.updatePwd(usrId, newPwd);
	}
	
	@Override
	public void updateUsr(String usrId, Map<String, Object> updateParams) {
		
		UsrInfoVo tmpUsr = usrDao.getUsrInfoByUsrId(usrId);
		
		Set<String> keySet = updateParams.keySet();
		
		for (String tmpKey : keySet) {
			
			if (tmpKey.toLowerCase().contains("enabled")) {
				ReflectUtil.invokeSet(tmpUsr, tmpKey, Boolean.valueOf(String.valueOf(updateParams.get(tmpKey))).booleanValue());
			} else if (tmpKey.contains(".")) {
				ReflectUtil.invokeSet(tmpUsr, tmpKey, Integer.valueOf(String.valueOf(updateParams.get(tmpKey))).intValue());
			} else {
				ReflectUtil.invokeSet(tmpUsr, tmpKey, String.valueOf(updateParams.get(tmpKey)));
			}
			
		}
		
		usrDao.updateUsr(tmpUsr);
		
	}
	
	@Override
	public UsrInfoVo queryUsrInfoByUsrId(String usrId) {
		return usrDao.getUsrInfoByUsrId(usrId);
	}
	
	@Override
	public void rmUsr(String usrId) {
		usrDao.delUsr(usrId);
	}
	
	@Override
	public boolean updateEnableDisable(String usrId) {
		return usrDao.switchEnableDisable(usrId);
	}
	
	@Override
	public List<UsrInfoVo> queryUsr(boolean isCustomer, Map<String, Object> queryParams, int currentPage, int pageSize) {
		
		List<UsrInfoVo> back = usrDao.getUsr(isCustomer, queryParams, currentPage, pageSize);
		PaginationUtil.fillList(back, UsrInfoVo.class, pageSize);
		
		return back;
		
	}
	
	@Override
	public int queryUsrCount(boolean isCustomer, Map<String, Object> queryParams) {
		return usrDao.getUsrCount(isCustomer, queryParams);
	}
	
	@Override
	public UsrInfoVo queryUsrInfo(String loginName) {
		
		if (StrUtil.isNotEmpty(loginName)) {
			return usrDao.getUsrInfo(loginName);
		} else {
			return null;
		}
		
	}

	@Override
	public UsrInfoVo addUsr(UsrInfoVo usrInfoVo) {
		return usrDao.insertUsr(usrInfoVo);
	}
	
	@Override
	public List<String> queryAllUsrRole(String loginName) {
		return usrDao.getAllUsrRole(loginName);
	}

}
