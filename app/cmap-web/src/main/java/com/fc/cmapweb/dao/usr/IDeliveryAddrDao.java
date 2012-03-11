package com.fc.cmapweb.dao.usr;

import java.util.List;

import com.fc.cmapweb.vo.DeliveryAddrVo;

public interface IDeliveryAddrDao {
	
	public DeliveryAddrVo updateDeliveryAddr(DeliveryAddrVo deliveryAddrVo);
	public void switchDefaultAddrFlag(String addrId);
	
	public DeliveryAddrVo getDeliveryAddrInfo(String addrId);
	public void delDeliveryAddr(String addrId);
	public List<DeliveryAddrVo> getDeliveryAddr(String usrId);
	public DeliveryAddrVo insertDeliveryAddr(DeliveryAddrVo deliveryAddrVo);
	public int getDeliveryAddrCount(String usrId);

}
