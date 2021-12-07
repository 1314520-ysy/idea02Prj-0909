<%@ page import="edu.soft2.pojo.Users" %>
<%@ page import="edu.soft2.dao.UsersDao" %><%--
  Created by IntelliJ IDEA.
  User: 李昱
  Date: 2021/9/14
  Time: 9:19
  用来处理从logon.jsp发送的Request请求
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //utf-8(中文&其他文字),GBK(简体&繁体)，GB2312(简体)
    request.setCharacterEncoding("utf-8");//设置Request字符编码
    response.setCharacterEncoding("utf-8");//设置response字符编码
//1.获取Request请求中的数据(id和pwd)
    String  id = request.getParameter("id");
    System.out.println("control.jsp获取的id="+id);
    String  pwd = request.getParameter("pwd");
    System.out.println("control.jsp获取的pwd="+pwd);
    //在Request中添加一个属性(属性名,属性值)
    request.setAttribute("msg","从control.jsp来的问候");
//2.调用UsersDao中的findUser()方法,获取返回值
    Users user = new UsersDao().findUser(id,pwd);
//3.判定返回值,页面跳转
    if (user!=null){
        Cookie c_id = new Cookie("msg1",id);//创建一个cookie
        Cookie c_pwd = new Cookie("msg2",pwd);//创建一个cookie
        c_id.setMaxAge(15);//设置有效时间15秒
        c_pwd.setMaxAge(15);//设置有效时间15秒
        response.addCookie(c_id);//添加cookie到response
        response.addCookie(c_pwd);//添加cookie到response
        Integer counter = null;//用来记录登录访问人数
        counter = (Integer) application.getAttribute("counter");
        //由于无法控制是第几个用户访问网站，所以先通过getAttribute()方法取值
        if (counter == null){//是一个访问本网站的登录用户，赋值1
            counter = 1;//初值
        }else {
            counter++;//不是第一个访问的登录用户，自增1
        }
        application.setAttribute("counter",counter);
        //跳转方式1：重定向(服务器告诉客户端：我不给你发数据只告诉客户端该访问另一个url)
        //response带着cookie一同发给客户端
          response.sendRedirect("index.jsp");//重定向的跳转方式，给index.jsp响应
          //session.setAttribute("id",id);//将id放入session
        //跳转方式2：转发(服务器内部人事调换，但客户端不知道要跳转页面)
       // request.getRequestDispatcher("index.jsp").forward(request,response);//转发
    } else{
        response.sendRedirect("logon.jsp");//重定向的跳转方式，给logon.jsp响应
    }
%>
</body>
</html>





