<%--
  Created by IntelliJ IDEA.
  User: 李昱
  Date: 2021/9/21
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
        out.write(
            "重定向过来，从session中获取的数据显示：<strong>"
                +session.getAttribute("att")+"</strong>");
%>
</body>
</html>
