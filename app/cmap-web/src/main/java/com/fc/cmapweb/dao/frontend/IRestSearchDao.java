package com.fc.cmapweb.dao.frontend;

import java.util.List;

import com.fc.cmapweb.vo.DishInfoVo;
import com.fc.cmapweb.vo.RestInfoVo;
import com.fc.cmapweb.web.form.RestSearchFormVo;

public interface IRestSearchDao {
	
	public List<DishInfoVo> getAllDishByRestId(String restId);
	public int getRestCount(RestSearchFormVo restSearchFormVo);
	public List<RestInfoVo> getRest(RestSearchFormVo restSearchFormVo, int currentPage, int pageSize);
	
}
