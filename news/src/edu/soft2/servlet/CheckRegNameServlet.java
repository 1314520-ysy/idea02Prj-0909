package edu.soft2.servlet;

import edu.soft2.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "CheckRegNameServlet", value = "/CheckRegNameServlet")
public class CheckRegNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String regName = request.getParameter("regName");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        UserDao userDao = new UserDao();
        out.print(userDao.findUserByName(regName));
        out.flush();//清空
        out.close();//关闭
    }
}
