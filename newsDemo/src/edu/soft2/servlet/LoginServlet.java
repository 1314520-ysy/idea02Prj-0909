package edu.soft2.servlet;

import edu.soft2.dao.UserDao;
import edu.soft2.impl.UserDaoImpl;
import edu.soft2.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受index.jsp的数据(username,upwd)
        String username = request.getParameter("username");
        String upwd = request.getParameter("upwd");
        //2.查询数据库news_user表，有否数据(username,upwd)
        UserDao userDao = new UserDaoImpl();//接口多态
        User user = userDao.findUser(username,upwd);
        //3.根据查询结果，进行判定，进行跳转
        if(user == null){
            //跳转回去
            response.sendRedirect("../index.jsp");
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("logonUser",user);
            //跳转至登录页
            response.sendRedirect("NewslistServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
