<%--
  Created by IntelliJ IDEA.
  User: 李昱
  Date: 2021/9/16
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logout</title>
</head>
<body>
<%
    session.invalidate();//从session中注销登录用户的信息(当前用户的session失效)
    response.sendRedirect("logon.jsp");//跳转至登录页
%>
</body>
</html>
