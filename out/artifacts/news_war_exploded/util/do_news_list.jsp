<%@ page import="edu.soft2.pojo.User" %>
<%@ page import="edu.soft2.dao.impl.NewsDaoImpl" %>
<%@ page import="edu.soft2.pojo.News" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.soft2.dao.impl.NewsDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: 李昱
  Date: 2021/9/23
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%
   User user = (User) session.getAttribute("logonUser");
   String username = user.getUsername();
%>
欢迎<%= username %>登录<br>
<h1>新闻页面!</h1>--%>

<%
    out.write("欢迎你"+((User)session.getAttribute("logonUser")).getUsername()+"先生/女士");
    //1.查询所有的News,使用NewsDao的findAllNews()方法
    List<News> list = new NewsDaoImpl().findAllNews();
    //2.将查询的list放入session
    session.setAttribute("allNews",list);
    //3.跳转至/newspages/admin.jsp
    response.sendRedirect("../newspages/admin.jsp");
%>
</body>
</html>
