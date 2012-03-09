package com.fc.cmapweb.mgr.rest.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.rest.IDishDao;
import com.fc.cmapweb.mgr.rest.IDishMgr;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.utils.ReflectUtil;
import com.fc.cmapweb.vo.DishInfoVo;

@Service("dishMgr")
public class DishMgrImpl implements IDishMgr {

	@Autowired
	private IDishDao dishDao;
	
	@Override
	public void updateDish(String dishId, Map<String, Object> updateParams) {
		
		DishInfoVo tmpDish = dishDao.getDishInfo(dishId);
		
		Set<String> keySet = updateParams.keySet();
		
		for (String tmpKey : keySet) {
			
			String lowerKey = tmpKey.toLowerCase();
			
			if (lowerKey.contains("enabled") || lowerKey.equals("dishprmt")) {
				ReflectUtil.invokeSet(tmpDish, tmpKey, Boolean.valueOf(String.valueOf(updateParams.get(tmpKey))).booleanValue());
			} else if (lowerKey.contains("price")) {
				ReflectUtil.invokeSet(tmpDish, tmpKey, Float.valueOf(String.valueOf(updateParams.get(tmpKey))).floatValue());
			} else {
				ReflectUtil.invokeSet(tmpDish, tmpKey, String.valueOf(updateParams.get(tmpKey)));
			}
			
		}
		
		dishDao.updateDish(tmpDish);
		
	}
	
	@Override
	public DishInfoVo queryDishInfo(String dishId) {
		return dishDao.getDishInfo(dishId);
	}
	
	@Override
	public boolean updateEnableDisable(String dishId) {
		return dishDao.switchEnableDisable(dishId);
	}
	
	@Override
	public void rmDish(String dishId) {
		dishDao.delDish(dishId);
	}
	
	@Override
	public DishInfoVo addDish(DishInfoVo dishInfoVo) {
		return dishDao.insertDish(dishInfoVo);
	}
	
	@Override
	public List<DishInfoVo> queryDish(Map<String, Object> queryParams, String restId, int currentPage, int pageSize) {
		
		List<DishInfoVo> back = dishDao.getDish(queryParams, restId, currentPage, pageSize);
		PaginationUtil.fillList(back, DishInfoVo.class, pageSize);
		
		return back;
		
	}
	
	@Override
	public int queryDishCount(String restId, Map<String, Object> queryParams) {
		return dishDao.getDishCount(restId, queryParams);
	}

}
