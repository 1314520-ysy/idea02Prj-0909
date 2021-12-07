<%--
  Created by IntelliJ IDEA.
  User: 李昱
  Date: 2021/9/21
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //在session对象中放入一个属性
    session.setAttribute("att","hello你好");
    out.write("同页面下，显示：<strong>"
            +session.getAttribute("att")+"</strong><br>");
    //当前页面被转发到TestSessionScope.jsp
    //request.getRequestDispatcher("TestSessionScope.jsp").forward(request,response);
    //当前页面被重定向到TestSessionScope.jsp
    response.sendRedirect("TestSessionScope.jsp");
%>
</body>
</html>
