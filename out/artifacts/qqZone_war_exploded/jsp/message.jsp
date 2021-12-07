<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'message.jsp' starting page</title>
</head>
<script src="static/js/jquery.js" type="text/javascript"></script>
<script src="static/js/v2js.js" type="text/javascript"></script>
<script src="static/js/iframe.js" type="text/javascript"></script>
<link href="static/img/css.css" rel="stylesheet"/>
<body>
	<div class="layout-body">
		<div class="w960  clf">
			<div class="m1_main">
				<div class="inner">
					<div class="hd">
					 	<h3>${user.username}的留言本</h3>
					</div>
						<c:forEach items="${messages}" var="message" varStatus="status">
							<div class="comm_content">
								<div class="c_list clf">
									<div class="c_hpic">
										<img src="static/headpic/${message.user.headpic }" alt="#"
											height="50" width="50">
									</div>
									<div class="c_fr">
										<p class="c_meta">
											<a href="#" target="_blank">${message.user.username}</a>
											<span class="c_time">${message.createtime}</span>
											<span class="c_time"> #<c:out value="${messagescount-status.index}"/></span>
											<span class="c_time">
												<c:if test="${sessionScope.user.uid==message.fid }">
											  	   <a href="<%=path %>/deletemessage?messageid=${message.id}"  onclick="return operaconfirm('删除');">删除</a>
												</c:if>
											</span>
										</p>
										<div class="c_nr">${message.context }</div>
									</div>
								</div>
							</div>
						</c:forEach>
				</div>
				<div class="comm_content">
				   <c:if test="${!empty showMessageback }">
				   		<div class="c_list clf">
						   <div id="pl_page">
								<div class="pagelistbox">
									<span> 
									  ${showMessageback }
									</span>
								</div>
						   </div> 
					    </div>
				   </c:if>
				</div>
				<br>
				<div class="inner">
					<div class="hd">
						<h3>留言</h3>
					</div>
					<div class="quote_f">
						<form action="<%=path %>/AddMessageServlet" method="post">
							<input name="senderid" value="${sessionScope.user.uid }" type="hidden">
							<input name="receiveid" value="${sessionScope.user.uid }" type="hidden">
							<textarea style="color: rgb(0, 0, 0);" cols="60" name="context" rows="5" id="msg"></textarea>
							<br> <input id="pltj" value="提&nbsp;交" class="anbu"
								type="submit">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function operaconfirm(opera) {
			question = confirm("你确认要"+opera+"么");
			if (question != "0") {
				return true;
			}
			return false;
		}
	</script>
</body>
</html>
