package com.soft2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft2.model.User;
@WebFilter(filterName = "LoginFilter",urlPatterns = "/jsp/*")
public class LoginFilter implements Filter{
	@Override
	public void destroy() {
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//用户登录状态判断
		//获取session
		HttpServletRequest req =(HttpServletRequest) request;
		User user=(User) req.getSession().getAttribute("user");
		if(null == user) {//判断用户登录信息是否存在
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
