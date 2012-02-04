package com.fc.cmapweb.mgr.rest;

import com.fc.cmapweb.vo.RestInfoVo;

public interface IRestMgr {
	
	public RestInfoVo addRest(RestInfoVo restInfoVo);
	public RestInfoVo queryRestInfo(String restId);
	public void rmRest(String restId);

}
