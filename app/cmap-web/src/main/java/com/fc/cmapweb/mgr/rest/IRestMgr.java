package com.fc.cmapweb.mgr.rest;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.RestInfoVo;

public interface IRestMgr {
	
	public void updateRestSmallLogoName(String restId, String logoName);
	public void updateRestBigLogoName(String restId, String logoName);
	public void updateRest(String restId, Map<String, Object> updateParams);
	
	public boolean updateEnableDisable(String restId);
	public List<RestInfoVo> queryRest(Map<String, Object> queryParams, int currentPage, int pageSize);
	public int queryRestCount(Map<String, Object> queryParams);
	
	public RestInfoVo addRest(RestInfoVo restInfoVo);
	public RestInfoVo queryRestInfo(String restId);
	public void rmRest(String restId);

}
