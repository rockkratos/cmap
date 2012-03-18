package com.fc.cmapweb.mgr.frontend;

import java.util.List;

import com.fc.cmapweb.vo.RestInfoVo;
import com.fc.cmapweb.web.form.RestSearchFormVo;

public interface IRestMgr {
	
	public int searchRestCount(RestSearchFormVo restSearchFormVo);
	public List<RestInfoVo> searchRest(RestSearchFormVo restSearchFormVo);

}
