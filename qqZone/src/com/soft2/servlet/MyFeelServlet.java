package com.soft2.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft2.dao.FeelDao;
import com.soft2.model.Feel;
import com.soft2.model.User;

/**
 * Servlet implementation class MyFeelServlet
 */
@WebServlet(name = "MyFeelServlet",value = "/MyFeelServlet")
public class MyFeelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFeelServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");System.out.println(user);
		//查询说说
		FeelDao feelDao=new FeelDao();
		System.out.println(user);
		List<Feel> feels=feelDao.findFeels(user.getUid());
		request.getSession().setAttribute("feels", feels);
		System.out.println(feels);
		request.getRequestDispatcher("/jsp/feelmy.jsp").forward(request,response);
	}
}
