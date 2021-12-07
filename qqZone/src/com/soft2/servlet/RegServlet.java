package com.soft2.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft2.dao.UserDao;
import com.soft2.model.User;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet(name = "RegServlet",value = "/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("regist.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String ismarry=request.getParameter("ismarry");
		String secrecy=request.getParameter("secrecy");
		String birthday=request.getParameter("birthday");
		String hometown=request.getParameter("hometown");
		String nowaddress=request.getParameter("nowaddress");
		UserDao userDao =new UserDao();
		User user1=userDao.findOneUser(username);
		if(null == user1) {
			request.getRequestDispatcher("/jsp/register_suc.jsp").forward(request,response);
			return;
		}
		User user=new User();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			user.setBirthday(df.parse(birthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setCreatetime(new Date());
		user.setHeadpic("h1.jpeg");//设置默认的用户头像
		user.setNickname(username);
		user.setUsername(username);
		user.setIsmarry(Integer.parseInt(ismarry));
		user.setHometown(hometown);
		user.setPwd(password);
		user.setSex(Integer.parseInt(sex));
		//动态生成qq号码。
		Random rand=new Random();
		//int i=(int)(Math.random()*10000);       //  生成0-100的随机数，包括0不包括100 -- [0,100)
		int j=rand.nextInt(10000);              // 这里是一个方法的重载，参数的内容是指定范围
		user.setQq(j+"");
		int flag=userDao.regUser(user);
		if(flag==1) {
			System.out.println("注册成功~！"+j);
			request.setAttribute("qq", j);
			request.setAttribute("username", username);
			request.getRequestDispatcher("/jsp/register_suc.jsp").forward(request,response);
		}
	}
}
