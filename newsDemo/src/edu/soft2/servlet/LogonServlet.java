package edu.soft2.servlet;

import edu.soft2.impl.UserDaoImpl;
import edu.soft2.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogonServlet", value = "/LogonServlet")
public class LogonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获取index中表单数据，作为参数传入UserDao()方法，获取返回值
        User user = new UserDaoImpl().findUser(
                request.getParameter("username"),
                request.getParameter("pwd")
        );
    //判定跳转(登录对象放入session)
    if(user!=null){
        HttpSession session = request.getSession();
        session.setAttribute("logonUser",user);
        response.sendRedirect("jsp/success.jsp");
    } else{//提示登陆信息无效，请重新登录
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("<script language='javascript'>"+
                "alert('登陆失败，请重新登陆');"+
                "window.location.href='index.jsp'"+
                "</script>");
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request, response);
    }
}
