package com.fc.cmapweb.mgr.usr.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.cmapweb.dao.usr.IDeliveryAddrDao;
import com.fc.cmapweb.mgr.usr.IDeliveryAddrMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.PaginationUtil;
import com.fc.cmapweb.utils.ReflectUtil;
import com.fc.cmapweb.vo.DeliveryAddrVo;

@Service("deliveryAddrMgr")
public class DeliveryAddrMgrImpl implements IDeliveryAddrMgr {
	
	@Autowired
	private IDeliveryAddrDao deliveryAddrDao;
	
	@Override
	public void updateDeliveryAddr(String addrId, Map<String, Object> updateParams) {
		
		DeliveryAddrVo tmpDeliveryAddr = deliveryAddrDao.getDeliveryAddrInfo(addrId);
		
		Set<String> keySet = updateParams.keySet();
		
		for (String tmpKey : keySet) {
			
			if (tmpKey.toLowerCase().contains("default")) {
				ReflectUtil.invokeSet(tmpDeliveryAddr, tmpKey, Boolean.valueOf(String.valueOf(updateParams.get(tmpKey))).booleanValue());
			} else {
				ReflectUtil.invokeSet(tmpDeliveryAddr, tmpKey, String.valueOf(updateParams.get(tmpKey)));
			}
			
		}
		
		deliveryAddrDao.updateDeliveryAddr(tmpDeliveryAddr);
		
	}
	
	@Override
	public void updateDefaultAddrFlag(String usrId, String addrId) {
		
		DeliveryAddrVo tmpDeliveryAddr = deliveryAddrDao.getDeliveryAddrInfo(addrId);
		
		if (tmpDeliveryAddr.isDefaultAddrFlag()) {
			return;
		}
		
		List<DeliveryAddrVo> addrList = deliveryAddrDao.getDeliveryAddr(usrId);
		
		for (int i = 0; i < addrList.size(); i++) {
			
			DeliveryAddrVo tmp = addrList.get(i);
			
			if (tmp.isDefaultAddrFlag()) {
				deliveryAddrDao.switchDefaultAddrFlag(tmp.getAddrId());
				deliveryAddrDao.switchDefaultAddrFlag(tmpDeliveryAddr.getAddrId());
				break;
			}
			
		}
		
	}
	
	@Override
	public DeliveryAddrVo queryDeliveryAddrInfo(String addrId) {
		return deliveryAddrDao.getDeliveryAddrInfo(addrId);
	}
	
	@Override
	public void rmDeliveryAddr(String addrId) {
		
		DeliveryAddrVo tmpAddr = deliveryAddrDao.getDeliveryAddrInfo(addrId);
		
		if (tmpAddr.isDefaultAddrFlag()) {
			
			List<DeliveryAddrVo> addrList = deliveryAddrDao.getDeliveryAddr(tmpAddr.getUsrInfoVo().getUsrId());
			
			for (int i = 0; i < addrList.size(); i++) {
				DeliveryAddrVo tmp = addrList.get(i);
				if (!tmp.isDefaultAddrFlag()) {
					deliveryAddrDao.switchDefaultAddrFlag(tmp.getAddrId());
					break;
				}
			}
			
		}
		
		deliveryAddrDao.delDeliveryAddr(addrId);
		
	}
	
	@Override
	public List<DeliveryAddrVo> queryDeliveryAddr(String usrId) {
		
		List<DeliveryAddrVo> back = deliveryAddrDao.getDeliveryAddr(usrId);
		PaginationUtil.fillList(back, DeliveryAddrVo.class, CmapValues.DEFAULT_PAGE_SIZE);
		
		return back;
		
	}
	
	@Override
	public DeliveryAddrVo addDeliveryAddr(DeliveryAddrVo deliveryAddrVo) {
		
		deliveryAddrVo.setDefaultAddrFlag(true);
		
		List<DeliveryAddrVo> addrList = deliveryAddrDao.getDeliveryAddr(deliveryAddrVo.getUsrInfoVo().getUsrId());
		
		for (int i = 0; i < addrList.size(); i++) {
			
			DeliveryAddrVo tmpAddr = addrList.get(i);
			
			if (tmpAddr.isDefaultAddrFlag()) {
				deliveryAddrDao.switchDefaultAddrFlag(tmpAddr.getAddrId());
				break;
			}
			
		}
		
		return deliveryAddrDao.insertDeliveryAddr(deliveryAddrVo);
		
	}
	
	@Override
	public int queryDeliveryAddrCount(String usrId) {
		return deliveryAddrDao.getDeliveryAddrCount(usrId);
	}

}
