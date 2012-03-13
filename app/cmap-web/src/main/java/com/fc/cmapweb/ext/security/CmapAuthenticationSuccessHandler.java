package com.fc.cmapweb.ext.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.fc.cmapweb.utils.CmapValues;

public class CmapAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException, ServletException {
		
//		System.out.println("------- " + getDefaultTargetUrl());
		
		if ("true".equals(req.getHeader("X-Ajax-call"))) {
			
//			System.out.println("*****");
			PrintWriter out = resp.getWriter();
			out.write("中文");
			out.flush();
			out.close();
			
			clearAuthenticationAttributes(req);
			
		} else {
			
			CmapUser userDetails = (CmapUser) auth.getPrincipal();
			int usrType = userDetails.getUsrInfoVo().getUsrTypeVo().getUsrTypeId();
			
			if (usrType == CmapValues.USR_TYPE_CUSTOMER && req.getRequestURI().contains("admin")) {
				req.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION", new BadCredentialsException("非法用户"));
				resp.sendRedirect(req.getContextPath() + "/admin/login");
				return;
			}
			
			// TODO: 根据请求URL设置target URL
			super.onAuthenticationSuccess(req, resp, auth);
			
		}
		
	}

}
