package com.soft2.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft2.dao.MessageDao;
import com.soft2.model.Message;
import com.soft2.model.User;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet(name = "DeleteMessageServlet",value = "/DeleteMessageServlet")
public class DeleteMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMessageServlet() {
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
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		String context=request.getParameter("context");
		String fid=request.getParameter("fid");
		Message message=new Message();
		message.setContext(context);
		message.setCreatetime(new Date());
		message.setUid(uid);
		if(null==fid || fid.equals("")) {
			message.setFid(uid);
		}else {
			message.setFid(Integer.parseInt(fid));
		}
		MessageDao messageDao =new MessageDao();
		Boolean flag=messageDao.addMessage(message);
		response.sendRedirect("MessageServlet");
	}

}
