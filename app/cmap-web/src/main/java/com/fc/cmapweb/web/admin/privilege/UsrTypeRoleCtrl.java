package com.fc.cmapweb.web.admin.privilege;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fc.cmapweb.mgr.privilege.IUsrTypeMgr;
import com.fc.cmapweb.mgr.privilege.IUsrTypeRoleMgr;
import com.fc.cmapweb.utils.CmapValues;
import com.fc.cmapweb.utils.PropUtil;
import com.fc.cmapweb.utils.StrUtil;
import com.fc.cmapweb.vo.UsrTypeRoleVo;
import com.fc.cmapweb.vo.UsrTypeVo;

@Controller
@RequestMapping("/adminUsrTypeRole")
public class UsrTypeRoleCtrl {
	
	@Autowired
	private IUsrTypeRoleMgr usrTypeRoleMgr;
	
	@Autowired
	private IUsrTypeMgr usrTypeMgr;
	
	@RequestMapping(value = "/edit/{usrTypeId}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateUsrTypeRole(@PathVariable int usrTypeId, HttpServletRequest request) {
		
		String[] roleIdArray = request.getParameterValues("setRoleId");
		boolean usrTypeEnabled = Boolean.valueOf(request.getParameter("usrTypeEnabled"));
		
		usrTypeRoleMgr.updateUsrTypeRole(usrTypeEnabled, usrTypeId, null == roleIdArray ? null : Arrays.asList(roleIdArray));
		
		return StrUtil.getJsonHintMsg(CmapValues.HINT_SUCCESS, PropUtil.getHintMsg("save.success", null));
		
	}
	
	@RequestMapping(value = "/{usrTypeId}", method = RequestMethod.GET)
	@ResponseBody
	public String queryRoleMarkedUsrType(@PathVariable int usrTypeId, Model model) {
		
		UsrTypeVo usrTypeVo = usrTypeMgr.queryUsrType(usrTypeId);
		
		Map<String, String> back = new HashMap<String, String>();
		back.put("usrTypeEnabled", String.valueOf(usrTypeVo.isUsrTypeEnabled()));
		
		List<UsrTypeRoleVo> usrTypeRoleVoList = usrTypeRoleMgr.queryRoleMarkedUsrType(usrTypeId);
		
		if (null != usrTypeRoleVoList && usrTypeRoleVoList.size() > 0) {
			
			StringBuilder buffer = new StringBuilder();
			
			for (UsrTypeRoleVo tmpUsrTypeRole : usrTypeRoleVoList) {
				
				buffer.append("<li>");
				buffer.append("<input name=\"setRoleId\" type=\"checkbox\" value=\"" + tmpUsrTypeRole.getRoleInfoVo().getRoleId() + "\" ");
				if (tmpUsrTypeRole.getUsrTypeVo().getUsrTypeId() != -1) {
					buffer.append("checked = \"checked\" ");
				}
				buffer.append("/>");
				buffer.append("<span>");
				buffer.append(tmpUsrTypeRole.getRoleInfoVo().getRoleDesc() + " -- " + tmpUsrTypeRole.getRoleInfoVo().getRoleName());
				buffer.append("</span>");
				buffer.append("</li>");
				
			}
			
			
			back.put("roleList", buffer.toString());
			
		}
		
		return JSON.toJSONString(back);
		
//		model.addAttribute("roleMarkedUsrType", usrTypeRoleMgr.queryRoleMarkedUsrType(usrTypeId));
//		return "/admin/privilege/roleBindingList";
		
	}

}
