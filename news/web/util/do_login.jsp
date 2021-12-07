<%@ page import="edu.soft2.dao.UserDao" %>
<%@ page import="edu.soft2.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 李昱
  Date: 2021/9/23
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //1.接受index.jsp的数据(username,upwd)
    String username = request.getParameter("username");
    String upwd = request.getParameter("upwd");
    //2.查询数据库news_user表，有否数据(username,upwd)
    User user = new UserDao().findUser(username,upwd);
    //3.根据查询结果，进行判定，进行跳转
    if(user == null){
        //跳转回去
        response.sendRedirect("../index.jsp");
    }else{
        session.setAttribute("logonUser",user);
        //跳转至登录页
        response.sendRedirect("do_news_list.jsp");
    }

%>
</body>
</html>
