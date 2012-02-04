package com.fc.cmapweb.dao.rest;

import com.fc.cmapweb.vo.RestInfoVo;

public interface IRestDao {
	
	public RestInfoVo insertRest(RestInfoVo restInfoVo);
	public RestInfoVo getRestInfo(String restId);
	public void delRest(String restId);
	
}
