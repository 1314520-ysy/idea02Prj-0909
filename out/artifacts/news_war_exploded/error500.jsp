<%--
  Created by IntelliJ IDEA.
  User: 李昱
  Date: 2021/10/19
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<%
    response.setStatus(HttpServletResponse.SC_OK);
%>
<html>
<head>
    <title>error500</title>
</head>
<body>
程序发生了错误，你可以选择：<br><a href="javascript:history.go(-1)">返回上个页面</a>
<%--<br><a href="index.jsp">返回项目首页</a>--%>
</body>
</html>
