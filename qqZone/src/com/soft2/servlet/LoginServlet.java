package com.soft2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft2.dao.UserDao;
import com.soft2.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet",value ="/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDao userDao=new UserDao();
		User user=userDao.findOneUser(username, password);
		System.out.println(user);
		if(null!=user) {
			request.getSession().setAttribute("user", user);
		}
		
		response.sendRedirect("IndexServlet");
	}

}
