package com.fc.cmapweb.ext.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class CmapAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
		
		System.out.println("------- login failure ");
		
		if ("true".equals(req.getHeader("X-Ajax-call"))) {
			
			System.out.println("*****");
			PrintWriter out = resp.getWriter();
			out.write("登录错误");
			out.flush();
			
			HttpSession session = req.getSession(false);
			
            if (session != null) {
                req.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
            }
            
			out.close();
			
		} else {
			
			super.onAuthenticationFailure(req, resp, exception);
			
		}
		
	}

}
