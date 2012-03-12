package com.fc.cmapweb.web.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.cmapweb.mgr.usr.IUsrMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.PropUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.UsrInfoVo;

@Controller
@RequestMapping("/adminUsrProfile")
public class UsrProfileCtrl {
	
	@Autowired
	private IUsrMgr usrMgr;
	
	@RequestMapping(value = "/changePwd/{usrId}", method = RequestMethod.PUT)
	@ResponseBody
	public String changePwd(@PathVariable String usrId, HttpServletRequest request) {
		
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		String cfmPwd = request.getParameter("cfmPwd");
		
		if (StrUtil.isEmpty(oldPwd)) {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_ERROR, PropUtil.getHintMsg("err.oldpwd.empty", null));
		} else if (StrUtil.isEmpty(newPwd)) {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_ERROR, PropUtil.getHintMsg("err.newpwd.empty", null));
		} else if (StrUtil.isEmpty(cfmPwd)) {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_ERROR, PropUtil.getHintMsg("err.cfmpwd.empty", null));
		} else if (!newPwd.equals(cfmPwd)) {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_ERROR, PropUtil.getHintMsg("err.newpwd.not.match", null));
		} else if (!checkOldPwd(usrId, oldPwd)) {
			return StrUtil.getJsonHintMsg(CmapValues.HINT_ERROR, PropUtil.getHintMsg("err.oldpwd.not.match", null));
		}
		
		usrMgr.updatePwd(usrId, newPwd);
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("modify.success", null));
		
	}
	
	private boolean checkOldPwd(String usrId, String oldPwd) {
		
		UsrInfoVo usr = usrMgr.queryUsrInfoByUsrId(usrId);
		String encryptOldPwd = StrUtil.getSHAEncryptData(oldPwd);
		
		return encryptOldPwd.equals(usr.getLoginPwd()) ? true : false;
		
	}

}
