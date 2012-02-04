package com.fc.cmapweb.ext.security;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fc.cmapweb.utils.PropUtil;

public class CmapAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	private PasswordEncoder passwordEncoder;
	private UserDetailsService userDetailsService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
		Object credentials = authentication.getCredentials();
		
		if (null == credentials || credentials.toString().length() == 0) {
            throw new BadCredentialsException(PropUtil.getErrMsg("pwd.empty", null));
        }
		
		String presentedPassword = authentication.getCredentials().toString();
		
		if (!passwordEncoder.isPasswordValid(userDetails.getPassword(), presentedPassword, null)) {
            throw new BadCredentialsException(PropUtil.getErrMsg("pwd.error", null));
        }

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
		UserDetails loadedUser;
		
		try {
            loadedUser = userDetailsService.loadUserByUsername(username);
        } catch (DataAccessException repositoryProblem) {
            throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
		
        if (null == loadedUser) {
        	throw new UsernameNotFoundException(PropUtil.getErrMsg("usr.notFound", new Object[]{username}));
        }
        
        return loadedUser;
        
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

}
