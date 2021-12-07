package edu.soft2.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/*@WebFilter(filterName = "charSetFilter",
           urlPatterns = "/*",
         initParams ={@WebInitParam( name="charset",value="utf-8")})*/
public class charSetFilter implements Filter {
    private String filterName;
    private String charSet;
    public void init(FilterConfig config) throws ServletException {
        filterName = config.getFilterName();
        charSet = config.getInitParameter("charset");
        System.out.println("过滤器"+filterName+"启动,设置字符集编码为"+charSet);
    }

    public void destroy() {
        System.out.println("过滤器charSetFilter.destroy销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        /*request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");*/
        request.setCharacterEncoding(charSet);
        response.setCharacterEncoding(charSet);
        System.out.println("过滤器"+filterName+"的doFilter()执行字符集"+charSet+"过滤...");
        chain.doFilter(request, response);//放行到下个过滤器，或者某个web资源
    }
}
