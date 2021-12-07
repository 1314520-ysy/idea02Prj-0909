package com.soft2.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft2.dao.FeelDao;
import com.soft2.dao.FriendShipDao;
import com.soft2.dao.HistoryDao;
import com.soft2.dao.MessageDao;
import com.soft2.dao.UserDao;
import com.soft2.model.History;
import com.soft2.model.User;
/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(name = "IndexServlet",value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
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
		String page=request.getParameter("page");
		String qq=request.getParameter("qq");//被访问者
		User user=(User) request.getSession().getAttribute("user");
		System.out.println("session---user="+user);
		int uid=user.getUid();
		if(null==page || page.equals("")) {
			page="MyFeelServlet";
		}
		UserDao userDao=new UserDao();
		request.getSession().setAttribute("other", "/"+page);
		System.out.println("session---other="+page);
		//计算总发布说说数量
		//计算总发布流言
		FeelDao feelDao =new FeelDao();
		request.getSession().setAttribute("feelsCount", feelDao.findFeelsCount(uid));
		System.out.println("session---feelsCount="+feelDao.findFeelsCount(uid));
		//计算总好友数量
		FriendShipDao friendShipDao =new FriendShipDao();
		int fcount=friendShipDao.findFriendCount(uid);
		request.getSession().setAttribute("findFriendCount",fcount );
		System.out.println("session---fcount="+fcount);
		//计算留言数量
		MessageDao messageDao=new MessageDao();
		int count=messageDao.findMessagesCount(uid);
		request.getSession().setAttribute("messagescount", count);
		System.out.println("session---messagescount="+count);
		request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);

		HistoryDao historyDao=new HistoryDao();
		//增加访问记录,避免重复提交
		request.getSession().getAttribute("messagescount");

		if(null!=qq) {
			History history =new History();
			history.setFid(Integer.parseInt(qq));
			history.setUid(uid);
			history.setVisittime(new Date());
			historyDao.insertHistory(history);
		}

		//获取访客
		List<History> historys=historyDao.findHistory(uid);
		System.out.println(historys);
		for (History history : historys) {
			//获取访客信息
			history.setUser(userDao.findOneUserById(history.getFid()));
		}

		request.getSession().setAttribute("historys", historys);
		System.out.println("session---historys="+historys);
	}

}
