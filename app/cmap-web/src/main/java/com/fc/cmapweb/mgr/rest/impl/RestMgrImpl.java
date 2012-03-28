package com.fc.cmapweb.mgr.rest.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.rest.IDishDao;
import com.fc.cmapweb.dao.rest.IDishSortDao;
import com.fc.cmapweb.dao.rest.IRestDao;
import com.fc.cmapweb.mgr.rest.IRestMgr;
import com.fc.cmapweb.utils.DateUtil;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.utils.ReflectUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.DishSortVo;
import com.fc.cmapweb.vo.RestInfoVo;

@Service("restMgr")
public class RestMgrImpl implements IRestMgr {

	@Autowired
	private IRestDao restDao;
	
	@Autowired
	private IDishDao dishDao;
	
	@Autowired
	private IDishSortDao dishSortDao;
	
	@Override
	public void updateRestSmallLogoName(String restId, String logoName) {
		restDao.updateRestSmallLogoName(restId, logoName);
	}
	
	@Override
	public void updateRestBigLogoName(String restId, String logoName) {
		restDao.updateRestBigLogoName(restId, logoName);
	}
	
	@Override
	public void updateRest(String restId, Map<String, Object> updateParams) {
		
		RestInfoVo tmpRest = restDao.getRestInfo(restId);
		
		Set<String> keySet = updateParams.keySet();
		
		for (String tmpKey : keySet) {
			
			String lowerKey = tmpKey.toLowerCase();
			
			if (lowerKey.contains("enabled") || lowerKey.contains("signed")) {
				
				ReflectUtil.invokeSet(tmpRest, tmpKey, Boolean.valueOf(String.valueOf(updateParams.get(tmpKey))).booleanValue());
				
			} else if (lowerKey.contains(".")) {
				
				ReflectUtil.invokeSet(tmpRest, tmpKey, Integer.valueOf(String.valueOf(updateParams.get(tmpKey))).intValue());
				
			} else if (lowerKey.contains("lng") || lowerKey.contains("lat")) {
				
				ReflectUtil.invokeSet(tmpRest, tmpKey, Double.valueOf(String.valueOf(updateParams.get(tmpKey))).doubleValue());
				
			} else if (lowerKey.contains("radius") || lowerKey.contains("amount") || lowerKey.contains("fee")) {
				
				ReflectUtil.invokeSet(tmpRest, tmpKey, Float.valueOf(String.valueOf(updateParams.get(tmpKey))).floatValue());
				
			} else if (lowerKey.contains("starttime") || lowerKey.contains("endtime")) {
				
				ReflectUtil.invokeSet(tmpRest, tmpKey, DateUtil.getDateObj(String.valueOf(updateParams.get(tmpKey)), "yyyy-MM-dd"));
				
			} else {
				
				ReflectUtil.invokeSet(tmpRest, tmpKey, String.valueOf(updateParams.get(tmpKey)));
				
			}
			
		}
		
		if (StrUtil.isEmpty(tmpRest.getPrintJointNum())) {
			tmpRest.setPrintJointNum(null);
		}
		
		restDao.updateRest(tmpRest);
		
	}
	
	@Override
	public boolean updateEnableDisable(String restId) {
		return restDao.switchEnableDisable(restId);	
	}
	
	@Override
	public List<RestInfoVo> queryRest(Map<String, Object> queryParams, int currentPage, int pageSize) {
		
		List<RestInfoVo> back = restDao.getRest(queryParams, currentPage, pageSize);		
		PaginationUtil.fillList(back, RestInfoVo.class, pageSize);
		
		return back;
		
	}
	
	@Override
	public int queryRestCount(Map<String, Object> queryParams) {
		return restDao.getRestCount(queryParams);
	}
	
	@Override
	public RestInfoVo addRest(RestInfoVo restInfoVo) {
		return restDao.insertRest(restInfoVo);
	}
	
	@Override
	public RestInfoVo queryRestInfo(String restId) {
		return restDao.getRestInfo(restId);
	}
	
	@Override
	public void rmRest(String restId) {
		
		List<DishSortVo> dishSortList = dishSortDao.getAllDishSort(restId);
		
		for (int i = 0; i < dishSortList.size(); i++) {
			
			String dishSortId = dishSortList.get(i).getDishSortId();
			dishDao.delDishByDishSort(dishSortId);
			
		}
		
		dishSortDao.delDishSortByRest(restId);
		restDao.delRest(restId);
		
	}

}
