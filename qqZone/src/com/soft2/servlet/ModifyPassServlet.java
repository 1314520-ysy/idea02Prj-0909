package com.soft2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft2.dao.UserDao;
import com.soft2.model.User;

@WebServlet(name = "ModifyPassServlet",value = "/ModifyPassServlet")
public class ModifyPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ModifyPassServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpassword=request.getParameter("oldpassword");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		User user=(User) request.getSession().getAttribute("user");
		if(user.getPwd().equals(oldpassword) && repassword.equals(password)) {
			UserDao userDao=new UserDao();
			int flag=userDao.updatePassword(user.getUsername(), password);
			if(flag==1) {//修改密码成功跳转成功页面
				request.getSession().setAttribute("mmsg","修改密码成功");
			}else {
				request.getSession().setAttribute("mmsg","修改密码失败");
			}
			request.getRequestDispatcher("/jsp/passsuccess.jsp").forward(request,response);
		}
	}
}

