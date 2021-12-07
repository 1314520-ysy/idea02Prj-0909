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
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	     String servletPath = httpServletRequest.getServletPath();  //获取客户端所请求的脚本文件的文件路径
	     System.out.println(servletPath);
		 //不过滤处理登录页面、JS和CSS文件
        if ( !servletPath.endsWith(".js") && !servletPath.endsWith(".css"))
        {
        	System.out.println("====start=====");
        	System.out.println(servletPath);
        	request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;character=UTF-8");
            System.out.println("=====end=====");
        }
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
