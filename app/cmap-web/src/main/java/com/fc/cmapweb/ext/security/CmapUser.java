package com.fc.cmapweb.ext.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fc.cmapweb.vo.UsrInfoVo;

public class CmapUser implements UserDetails {
	
	private static final long serialVersionUID = -5871870996481319907L;
	
	private Collection<GrantedAuthority> authorities;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private UsrInfoVo usrInfoVo;
	
	public CmapUser(UsrInfoVo usrInfoVo, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities) {
		
		this.usrInfoVo = usrInfoVo;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.authorities = authorities;
		
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return usrInfoVo.getLoginPwd();
	}

	@Override
	public String getUsername() {
		return usrInfoVo.getLoginName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return usrInfoVo.isUsrEnabled();
	}

	public UsrInfoVo getUsrInfoVo() {
		return usrInfoVo;
	}

}
