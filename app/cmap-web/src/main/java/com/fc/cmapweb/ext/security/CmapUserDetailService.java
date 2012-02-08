package com.fc.cmapweb.ext.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fc.cmapweb.mgr.privilege.IUsrRoleMgr;
import com.fc.cmapweb.mgr.usr.IUsrMgr;
import com.fc.cmapweb.utils.PropUtil;
import com.fc.cmapweb.vo.UsrInfoVo;
import com.fc.cmapweb.vo.UsrRoleVo;

public class CmapUserDetailService implements UserDetailsService {

	private IUsrMgr usrMgr;
	private IUsrRoleMgr usrRoleMgr;
	
	@Override
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException, DataAccessException {
		
		UsrInfoVo usr = usrMgr.queryUsrInfo(loginName);
		
		if (null == usr) {
			return null;
		}
		
		Collection<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		List<UsrRoleVo> usrRoleList = usrRoleMgr.queryUsrRoles(loginName);
		
		for (UsrRoleVo tmpUsrRole : usrRoleList) {
			roles.add(new SimpleGrantedAuthority(tmpUsrRole.getRoleInfoVo().getRoleName()));
		}
		
		CmapUser userdetail = new CmapUser(usr.getLoginName(), usr.getLoginPwd(), usr.isUsrEnabled(), true, true, usr.getBadPwdCount() < Integer.parseInt(PropUtil.getPolicy("bad.pwd.count")), usr.getUsrTypeVo().getUsrTypeId(), roles);
		
		return userdetail;
		
	}

	public void setUsrMgr(IUsrMgr usrMgr) {
		this.usrMgr = usrMgr;
	}

	public void setUsrRoleMgr(IUsrRoleMgr usrRoleMgr) {
		this.usrRoleMgr = usrRoleMgr;
	}

}
