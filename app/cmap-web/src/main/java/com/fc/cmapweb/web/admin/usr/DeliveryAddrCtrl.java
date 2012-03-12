package com.fc.cmapweb.web.admin.usr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.cmapweb.mgr.usr.IDeliveryAddrMgr;
import com.fc.cmapweb.mgr.usr.IUsrMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.ParamUtil;
import com.fc.cmapweb.utils.PropUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.DeliveryAddrVo;
import com.fc.cmapweb.vo.UsrInfoVo;

@Controller
@RequestMapping("/adminDeliveryAddr")
public class DeliveryAddrCtrl {
	
	@Autowired
	private IUsrMgr usrMgr;
	
	@Autowired
	private IDeliveryAddrMgr deliveryAddrMgr;
	
	@RequestMapping(value = "/edit/{usrId}/{addrId}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateDeliveryAddr(@PathVariable String usrId, @PathVariable String addrId, HttpServletRequest request) {
		
		Map<String, Object> updateParams = ParamUtil.getParams(request, CmapValues.PREFIX_DETAIL);
		
		deliveryAddrMgr.updateDeliveryAddr(addrId, updateParams);
		
		int count = deliveryAddrMgr.queryDeliveryAddrCount(usrId);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("update.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/{usrId}/{addrId}", method = RequestMethod.PUT)
	@ResponseBody
	public String setDefaultAddr(@PathVariable String usrId, @PathVariable String addrId) {
		
		deliveryAddrMgr.updateDefaultAddrFlag(usrId, addrId);
		
		int count = deliveryAddrMgr.queryDeliveryAddrCount(usrId);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("set.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/detail/{usrId}/{addrId}", method = RequestMethod.GET)
	public String showUsrInfo(@PathVariable String usrId, @PathVariable String addrId, Model model) {
		
		model.addAttribute("deliveryAddrVo", deliveryAddrMgr.queryDeliveryAddrInfo(addrId));
		model.addAttribute("usrId", usrId);
		return "/admin/usr/deliveryAddrInfo";
		
	}
	
	@RequestMapping(value = "/{usrId}/{addrId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteDeliveryAddr(@PathVariable String usrId, @PathVariable String addrId) {
		
		deliveryAddrMgr.rmDeliveryAddr(addrId);
		
		int count = deliveryAddrMgr.queryDeliveryAddrCount(usrId);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("delete.success", null), otherParams);
		
	}
	
	@RequestMapping(value = "/list/{usrId}", method = RequestMethod.GET)
	public String queryDeliveryAddr(@PathVariable String usrId, Model model, HttpServletRequest request) {
		
		List<DeliveryAddrVo> deliveryAddrList = deliveryAddrMgr.queryDeliveryAddr(usrId);
		model.addAttribute("deliveryAddrList", deliveryAddrList);
		model.addAttribute("usrId", usrId);
		
		return "/admin/usr/deliveryAddrList";
		
	}
	
	@RequestMapping(value = "/{usrId}", method = RequestMethod.POST)
	@ResponseBody
	public String addDeliveryAddr(@PathVariable String usrId, @ModelAttribute("deliveryAddrVo") DeliveryAddrVo deliveryAddrVo) {
		
		// TODO: 数据校验
		
		int count = deliveryAddrMgr.queryDeliveryAddrCount(usrId);
		
		if (count >= Integer.parseInt(PropUtil.getPolicy("delivery.addr.num"))) {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_ERROR, PropUtil.getHintMsg("err.delivery.addr.num", null));
		}
		
		UsrInfoVo usr = new UsrInfoVo();
		usr.setUsrId(usrId);
		
		deliveryAddrVo.setUsrInfoVo(usr);
		
		deliveryAddrMgr.addDeliveryAddr(deliveryAddrVo);
		
//		count = deliveryAddrMgr.queryDeliveryAddrCount(usrId);
		
		Map<String, String> otherParams = new HashMap<String, String>();
		otherParams.put("recordCount", String.valueOf(count + 1));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("add.success", null), otherParams);
		
	}

	@RequestMapping(value = "/{usrId}", method = RequestMethod.GET)
	public String showDeliveryAddrPage(@PathVariable String usrId, Model model) {
		
		UsrInfoVo tmpUsr = usrMgr.queryUsrInfoByUsrId(usrId);
		
		model.addAttribute("usrId", usrId);
		model.addAttribute("usrName", tmpUsr.getLoginName());
		model.addAttribute("deliveryAddrVo", new DeliveryAddrVo());
		model.addAttribute("deliveryAddrCount", deliveryAddrMgr.queryDeliveryAddrCount(usrId));
		
		return "/admin/usr/deliveryAddr";
		
	}
	
}
