<%--
  Created by IntelliJ IDEA.
  User: 李昱
  Date: 2021/9/20
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.write("不同页面下，显示：<strong>"+pageContext.getAttribute("att")+"</strong>");
%>
</body>
</html>
