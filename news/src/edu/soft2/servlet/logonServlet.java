package edu.soft2.servlet;

import edu.soft2.dao.UserDao;
import edu.soft2.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logonServlet", value = "/logonServlet")
public class logonServlet extends HttpServlet {
    /**
     *用来创建Servlet，最先执行
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("开始创建logonServlet");
        super.init();//执行创建操作
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("logonServlet的service()执行");
        super.service(req, resp);
    }

    /**
     * 销毁Servlet,最后执行
     */
    @Override
    public void destroy() {
        System.out.println("开始销毁logonServlet");
        super.destroy();//执行销毁操作
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取表单中的数据
       String username = request.getParameter("username");
       String upwd = request.getParameter("upwd");
        //2.调用findUser()方法，传入参数
       User user = new UserDao().findUser(username,upwd);
        //3.判定返回值，进行跳转
        if(user != null){//查到此人
            HttpSession session = request.getSession();//创建session;
            if (session.getAttribute("logonUser")== null) {
                session.setAttribute("logonUser",user);//把用户对象存入session
                response.sendRedirect("NewsListServlet");//重定向
            }
            //request.getRequestDispatcher("util/do_news_list.jsp").forward(request,response);
        }else{//提示登陆信息无效，请重新登录
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
        this.doGet(request,response);//调用doGet()方法
    }
}
