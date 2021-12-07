package edu.soft2.servlet;

import edu.soft2.dao.NewsDao;
import edu.soft2.impl.NewsDaoImpl;
import edu.soft2.pojo.News;
import edu.soft2.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewslistServlet", value = "/NewslistServlet")
public class NewslistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.查询所有的News,使用NewsDao的findAllNews()方法
        NewsDao newsDao = new NewsDaoImpl();
        List<News> list = newsDao.findAllNews();
        //2.将查询的list放入session
        HttpSession session =request.getSession();
        session.setAttribute("allNews",list);
        //3.跳转至/newspages/admin.jsp
        response.sendRedirect("newspages/admin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
