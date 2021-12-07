<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>My JSP 'info.jsp' starting page</title>
<link href="static/img/css.css" rel="stylesheet"/>
<link href="static/css/easyui.css" rel="stylesheet"/>
</head>
<body>
	<div class="inner">
		<div class="infos">
			<h3>${mmsg}</h3>
			<br>
			<a href="./login.jsp">点击返回登陆页面</a>
		</div>
	</div>
</body>
</html>
