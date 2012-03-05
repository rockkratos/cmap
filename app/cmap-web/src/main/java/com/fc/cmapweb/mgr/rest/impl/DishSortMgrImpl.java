package com.fc.cmapweb.mgr.rest.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.rest.IDishSortDao;
import com.fc.cmapweb.mgr.rest.IDishSortMgr;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.utils.ReflectUtil;
import com.fc.cmapweb.vo.DishSortVo;
import com.fc.cmapweb.vo.RestInfoVo;

@Service("dishSortMgr")
public class DishSortMgrImpl implements IDishSortMgr {

	@Autowired
	private IDishSortDao dishSortDao;
	
	@Override
	public void updateDishSort(String dishSortId, Map<String, Object> updateParams) {
		
		DishSortVo tmpDishSort = dishSortDao.getDishSort(dishSortId);
		
		Set<String> keySet = updateParams.keySet();
		
		for (String tmpKey : keySet) {
			
			String lowerKey = tmpKey.toLowerCase();
			
			if (lowerKey.contains("enabled")) {
				ReflectUtil.invokeSet(tmpDishSort, tmpKey, Boolean.valueOf(String.valueOf(updateParams.get(tmpKey))).booleanValue());
			} else if (lowerKey.contains("order")) {
				ReflectUtil.invokeSet(tmpDishSort, tmpKey, Integer.valueOf(String.valueOf(updateParams.get(tmpKey))).intValue());
			} else {
				ReflectUtil.invokeSet(tmpDishSort, tmpKey, String.valueOf(updateParams.get(tmpKey)));
			}
			
		}
		
		dishSortDao.updateRest(tmpDishSort);
		
	}
	
	@Override
	public boolean updateEnableDisable(String dishSortId) {
		return dishSortDao.switchEnableDisable(dishSortId);
	}
	
	@Override
	public int queryDishSortCount(String restId) {
		return dishSortDao.getDishSortCount(restId);
	}
	
	@Override
	public List<DishSortVo> queryDishSort(String restId, int currentPage, int pageSize) {
		
		List<DishSortVo> back = dishSortDao.getDishSort(restId, currentPage, pageSize);
		PaginationUtil.fillList(back, DishSortVo.class, pageSize);
		
		return back;
		
	}
	
	@Override
	public DishSortVo addDishSort(DishSortVo dishSortVo, String restId) {
		
		RestInfoVo tmpRest = new RestInfoVo();
		tmpRest.setRestId(restId);
		
		dishSortVo.setRestInfoVo(tmpRest);
		
		return dishSortDao.insertDishSort(dishSortVo);
		
	}
	
	@Override
	public DishSortVo queryDishSort(String dishSortId) {
		return dishSortDao.getDishSort(dishSortId);
	}
	
	@Override
	public void rmDishSort(String dishSortId) {
		dishSortDao.delDishSort(dishSortId);
	}

}
