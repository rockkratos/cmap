package com.fc.cmapweb.web.admin.privilege;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.cmapweb.mgr.privilege.IPrivilegeMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.PropUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.PrivilegeInfoVo;

@Controller
@RequestMapping("/adminPrivilege")
public class PrivilegeCtrl {
	
	@Autowired
	private IPrivilegeMgr privilegeMgr;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showPrivilegePage() {
		return "/admin/privilegeCfg";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String addPrivilege(@ModelAttribute("privilegeInfoVo") PrivilegeInfoVo privilegeInfoVo) {
		
		// TODO: 数据校验
		
		privilegeMgr.addPrivilege(privilegeInfoVo);
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("add.success", null));
		
	}

}
