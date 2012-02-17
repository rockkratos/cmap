package com.fc.cmapweb.ext.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.fc.cmapweb.utils.CmapValues;

public class CmapVoter implements AccessDecisionVoter<Object> {
	
	private String rolePrefix = "ROLE_";
	
	@Override
	public boolean supports(ConfigAttribute attribute) {
		
		if (attribute.getAttribute().equals("IS_ANONYMOUS") 
				|| attribute.getAttribute().equals("ONLY_AUTHENTICATED") 
				|| attribute.getAttribute().equals("IS_AUTHENTICATED")) {
			return true;
		}
		
		if ((attribute.getAttribute() != null) && attribute.getAttribute().startsWith(getRolePrefix())) {
            return true;
        } else {
            return false;
        }
		
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
		
		if (!CmapValues.PRIVILEGE_CHECK) {
			return ACCESS_GRANTED;
		}
		
		int result = ACCESS_ABSTAIN;
        Collection<? extends GrantedAuthority> authorities = extractAuthorities(authentication);

        for (ConfigAttribute attribute : attributes) {
            
        	if (this.supports(attribute)) {
        		
                result = ACCESS_DENIED;
                
                if (attribute.getAttribute().equals("IS_ANONYMOUS")) {
                	result = ACCESS_GRANTED;
                	break;
                } else if (attribute.getAttribute().equals("ONLY_AUTHENTICATED") 
                		&& !(authentication instanceof AnonymousAuthenticationToken) 
                		&& authentication.isAuthenticated()) {
                	result = ACCESS_GRANTED;
                	break;
                }
                
                // Attempt to find a matching granted authority
                for (GrantedAuthority authority : authorities) {
                	
                    if (!(authentication instanceof AnonymousAuthenticationToken) 
                    		&& attribute.getAttribute().equals(authority.getAuthority())) {
                        return ACCESS_GRANTED;
                    }
                    
                }
                
            }
        	
        }

        return result;
        
	}
	
	private Collection<? extends GrantedAuthority> extractAuthorities(Authentication authentication) {
        return authentication.getAuthorities();
    }
	
	public String getRolePrefix() {
        return rolePrefix;
    }
	
	public void setRolePrefix(String rolePrefix) {
        this.rolePrefix = rolePrefix;
    }

}
