package com.soft2.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft2.dao.FeelDao;
import com.soft2.model.Feel;
import com.soft2.model.User;

/**
 * Servlet implementation class PublishServlet
 */
@WebServlet(name = "PublishServlet",value = "/PublishServlet")
public class PublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		String context=request.getParameter("feelcontent");
		Feel feel=new Feel();
		feel.setCreatetime(new Date());
		FeelDao feelDao=new FeelDao();
		feel.setContext(context);
		feel.setUid(uid);
		boolean flg=feelDao.addFeels(feel);
		if(flg) {
			response.sendRedirect("MyFeelServlet");
		}else {
			response.sendRedirect("IndexServlet");
		}
		
	}

}
