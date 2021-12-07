<%--
  Created by IntelliJ IDEA.
  User: 李昱
  Date: 2021/10/19
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true"%>
    <%
        response.setStatus(HttpServletResponse.SC_OK);
    %>
<html>
<head>
    <title>error404</title>
</head>
<body>
你所访问的资源不存在
<a href="javascript:history.go(-1)">返回上个页面</a>
</body>
</html>
