package com.fc.cmapweb.dao.frontend;

import java.util.List;

import com.fc.cmapweb.vo.RestInfoVo;
import com.fc.cmapweb.web.form.RestSearchFormVo;

public interface IRestDao {
	
	public int getRestCount(RestSearchFormVo restSearchFormVo);
	public List<RestInfoVo> getRest(RestSearchFormVo restSearchFormVo);
	
}
