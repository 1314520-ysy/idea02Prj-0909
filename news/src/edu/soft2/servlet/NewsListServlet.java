package edu.soft2.servlet;

import edu.soft2.dao.impl.NewsDaoImpl;
import edu.soft2.pojo.News;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewsListServlet", value = "/NewsListServlet")
public class NewsListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //session中存入news对象集合
        //1.获取NewsDao，查询
        List<News> list = new NewsDaoImpl().findAllNews();
        //2.将集合存入session
        HttpSession session = request.getSession();
        if(session.getAttribute("allNews")==null)
        session.setAttribute("allNews",list);
        //3.重定向跳转到admin页面
        response.sendRedirect("TopicListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
