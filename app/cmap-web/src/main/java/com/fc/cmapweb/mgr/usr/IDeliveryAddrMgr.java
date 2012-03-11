package com.fc.cmapweb.mgr.usr;

import java.util.List;
import java.util.Map;

import com.fc.cmapweb.vo.DeliveryAddrVo;

public interface IDeliveryAddrMgr {

	public void updateDeliveryAddr(String addrId, Map<String, Object> updateParams);
	public void updateDefaultAddrFlag(String usrId, String addrId);
	
	public DeliveryAddrVo queryDeliveryAddrInfo(String addrId);
	public void rmDeliveryAddr(String addrId);
	public List<DeliveryAddrVo> queryDeliveryAddr(String usrId);
	public DeliveryAddrVo addDeliveryAddr(DeliveryAddrVo deliveryAddrVo);
	public int queryDeliveryAddrCount(String usrId);
	
}
