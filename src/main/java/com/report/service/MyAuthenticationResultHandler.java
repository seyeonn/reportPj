package com.report.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.report.dto.User;
import com.report.service.MyAuthenticationProvider.MyAuthenticaion;




@Component
public class MyAuthenticationResultHandler implements AuthenticationFailureHandler, AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex)
            throws IOException, ServletException {
        String url = "/guest/login?";
        if (ex instanceof LockedException) url += "locked";
        else if (ex instanceof BadCredentialsException) url += "count=" + ex.getMessage();
        else url += "error";
        response.sendRedirect(request.getContextPath() + url);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        User user = ((MyAuthenticaion)authentication).getUser();

        switch(user.getUserType()) {
        case "학생" :
        	redirectStrategy.sendRedirect(request, response, "/student/studentMain");
        	break;
        case "교수" :
        	redirectStrategy.sendRedirect(request, response, "/professor/professorMain");
        	break;
        case "TA" :
        	redirectStrategy.sendRedirect(request, response, "/ta/taMain");

        }

    }
}