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
//    out.write(
//            "request被重定向过来，后显示：<strong>"
//                +request.getAttribute("att")+"</strong>");
    out.write(
            "request被转发过来，后显示：<strong>"
                    +request.getAttribute("att")+"</strong>");
%>
</body>
</html>
