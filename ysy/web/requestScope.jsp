<%--
  Created by IntelliJ IDEA.
  User: 李昱
  Date: 2021/9/20
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //在request对象中放入一个属性
    request.setAttribute("att","hello你好");
    out.write("同页面下，显示：<strong>"+request.getAttribute("att")+"</strong><br>");
    //当前页面被转发到TestRequestScope.jsp
    request.getRequestDispatcher("TestRequestScope.jsp").forward(request,response);
    //response.sendRedirect("TestRequestScope.jsp");
%>
</body>
</html>
