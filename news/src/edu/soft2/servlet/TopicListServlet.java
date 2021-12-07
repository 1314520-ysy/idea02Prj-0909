package edu.soft2.servlet;

import edu.soft2.dao.TopicDao;
import edu.soft2.pojo.Topic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;
/*
 *查询topic表存入session，跳转到admin.jsp
 */
@WebServlet(name = "TopicListServlet", value = "/TopicListServlet")
public class TopicListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TopicListServlet.doGet");
        List<Topic> list = new TopicDao().findAllTopic();
        HttpSession session = request.getSession();
        if (session.getAttribute("allTopics" )== null) {
            session.setAttribute("allTopics", list);
        }
        System.out.println("跳转....");
        response.sendRedirect("PageControlServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
