package com.fc.cmapweb.mgr.rest;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.RestInfoVo;

public interface IRestMgr {
	
	public List<RestInfoVo> queryRest(Map<String, Object> queryParams, int currentPage, int pageSize);
	public int queryRestCount(Map<String, Object> queryParams);
	
	public RestInfoVo addRest(RestInfoVo restInfoVo);
	public RestInfoVo queryRestInfo(String restId);
	public void rmRest(String restId);

}
