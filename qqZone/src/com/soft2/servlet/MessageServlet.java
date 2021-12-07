package com.soft2.servlet;

import java.io.IOException;
import java.util.List;

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
@WebServlet(name = "MessageServlet",value = "/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=(User) request.getSession().getAttribute("user");
		//��ѯ˵˵
		String fid=request.getParameter("fid");
		if(null==fid || fid.equals("")) {
			fid=user.getUid()+"";
		}
		MessageDao messageDao=new MessageDao();
		List<Message> messages=messageDao.findMessages(user.getUid());
		request.getSession().setAttribute("messages", messages);
		System.out.println(messages);
		int count=messageDao.findMessagesCount(Integer.parseInt(fid));
		request.getSession().setAttribute("messagescount", count);
		request.getRequestDispatcher("/jsp/message.jsp").forward(request,response);
	}

}
