package edu.soft2.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "logonFilter",urlPatterns = "/newspages/*")
public class logonFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化logonFilter.init");
    }

    public void destroy() {
        System.out.println("销毁过滤器logonFilter.destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("执行过滤...");
        //类型转换：ServletRequest转换为HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;
        //获取HttpServletRequest
        HttpSession session =  req.getSession();
        //判定session中有无logonUser
        if (session.getAttribute("logonUser") == null) {
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }else {
            //有的话，放行
            //没有的话，转到登录页面
            chain.doFilter(request, response);
        }

    }
}
