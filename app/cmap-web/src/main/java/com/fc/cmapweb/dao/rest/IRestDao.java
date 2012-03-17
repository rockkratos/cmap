package com.fc.cmapweb.dao.rest;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.RestInfoVo;

public interface IRestDao {
	
	public RestInfoVo updateRestSmallLogoName(String restId, String logoName);
	public RestInfoVo updateRestBigLogoName(String restId, String logoName);
	public RestInfoVo updateRest(RestInfoVo restInfoVo);
	
	public boolean switchEnableDisable(String restId);
	public List<RestInfoVo> getRest(Map<String, Object> queryParams, int currentPage, int pageSize);
	public int getRestCount(Map<String, Object> queryParams);
	
	public RestInfoVo insertRest(RestInfoVo restInfoVo);
	public RestInfoVo getRestInfo(String restId);
	public void delRest(String restId);
	
}
