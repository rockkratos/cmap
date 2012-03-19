package com.fc.cmapweb.mgr.frontend;

import java.util.List;

import com.fc.cmapweb.vo.DishInfoVo;
import com.fc.cmapweb.vo.DishSortVo;
import com.fc.cmapweb.vo.RestInfoVo;
import com.fc.cmapweb.web.form.RestSearchFormVo;

public interface IRestSearchMgr {
	
	public List<DishInfoVo> queryDish(String restId);
	public List<DishSortVo> queryDishSort(String restId);
	public RestInfoVo queryRestInfo(String restId);
	public int searchRestCount(RestSearchFormVo restSearchFormVo);
	public List<RestInfoVo> searchRest(RestSearchFormVo restSearchFormVo, int currentPage, int pageSize);

}
