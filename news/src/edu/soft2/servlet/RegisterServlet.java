package edu.soft2.servlet;

import edu.soft2.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取表单中的数据
        String username = request.getParameter("username");
        String upwd = request.getParameter("upwd");
        //2.调用findUser()方法，传入参数
        UserDao userDao = new UserDao();
        //3.判定返回值，进行跳转
        if(userDao.findUserByName(username)==0) {
            boolean user = new UserDao().addUser(username,upwd);
            if (user == false) {//查到此人
                HttpSession session = request.getSession();//创建session;
                session.setAttribute("logonUser", username);//把用户对象存入session
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write("<script language='javascript'>" +
                        "alert('注册成功，返回登录页面登录');" +
                        "window.location.href='index.jsp'" +
                        "</script>");
                }
            } else {//提示登陆信息无效，请重新登录
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write("<script language='javascript'>" +
                        "alert('注册失败');" +
                        "window.location.href='register.jsp'" +
                        "</script>");
            }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);//调用doGet()方法
    }
}
