
<%@ page import="edu.soft2.pojo.News" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.soft2.pojo.User" %>
<%@ page import="edu.soft2.tools.Page" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//当前url地址

%>
<%
    Page pages = (Page) request.getAttribute("pages");
    if (pages == null) {
        response.sendRedirect("pageControlServlet?pageIndex=1");
    }else{
%>
<html>
<head>
        <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>添加主题--管理后台</title>
    <link href="<%=basePath%>/../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
    <div id="welcome">欢迎使用新闻管理系统！</div>
    <div id="nav">
        <div id="logo"><img src="<%=basePath%>/../images/logo.jpg" alt="新闻中国" /></div>
        <div id="a_b01"><img src="<%=basePath%>/../images/a_b01.gif" alt="" /></div>
    </div>
</div>
<div id="admin_bar">
    <div id="status">管理员：
        <%--<%
            String username = ((User)session.getAttribute("logonUser")).getUsername();
        %>
        <%=username%>--%>
        <%--        ${sessionScope.logonUser.username}--%>
        <c:out value="匿名" default="" escapeXml=""></c:out>
        <%--        <c:out value="${logonUser.username}" default="匿名" escapeXml="false"></c:out>--%>
        登录  &#160;&#160;&#160;&#160; <a href="LogoutServlet">login out</a></div>
    <div id="channel"> </div>
</div>
<div id="main">
    <%@include file="console_element/left.html" %>
    <div id="opt_area">
        <script language="javascript">
            function clickdel(){
                return confirm("删除请点击确认");
            }
        </script>
        <%--        <c:choose>
                    <c:when test="${sessionScope.allNews==null}">
                        <script type="text/javascript">
                            alert("没有查询到新闻！")
                        </script>
                        <% response.sendRedirect("NewsListServlet"); %>
                    </c:when>
                    <c:otherwise>
                        &lt;%&ndash;<ul>
                            <c:forEach var="news" items="${sessionScope.allNews}" varStatus="status">
                                <li <c:if test="${status.count%2==0}" > style="color: red"</c:if>>
                                    <span>${status.count}</span>&#160;&#160;&#160;&#160;
                                    <span>标题：${news.NTitle}</span> &#160;&#160;&#160;&#160;
                                    <span>日期：${news.NCreateDate}</span> &#160;&#160;&#160;&#160;
                                    <span>内容：${news.NContent}</span>&#160;&#160;&#160;&#160;
                                    <span> 作者：${sessionScope.logonUser.username} &#160;&#160;&#160;&#160;
                          <a href='#'>修改</a> &#160;&#160;&#160;&#160;
                          <a href='#' onclick='return clickdel()'>删除</a>
                      </span>
                                </li>
                            </c:forEach>
                        </ul>&ndash;%&gt;
                    </c:otherwise>
                </c:choose>--%>
        <ul>
            <%
                int totalPages=pages.getTotalPageCount();//总页码
                System.out.println("totalPages="+totalPages);
                int pageIndex=pages.getCurrPageNo();
                System.out.println("pageIndex="+pageIndex);
                List<News> list = pages.getNewsList();
                for (News news :list){
            %>
            <li>
                <span>标题：<%=news.getNTitle()%></span> &#160;&#160;&#160;&#160;
                <span>日期：<%=news.getNCreateDate()%></span> &#160;&#160;&#160;&#160;
                <span>内容：<%=news.getNContent()%></span>&#160;&#160;&#160;&#160;
                <a href='#'>修改</a> &#160;&#160;&#160;&#160;
                <a href='#' onclick='return clickdel()'>删除</a>
                </span>
            </li>
            <%
                }
            %>
        </ul>
        <br>
        当前页数：[<%=pageIndex%>/<%=totalPages%>]

        <%
            if (pageIndex >1) {
        %>
        <a href="<%=path%>/PageControlServlet?pageIndex=1">首页</a>&nbsp;
        <a href="<%=path%>/PageControlServlet?pageIndex=<%=pageIndex-1%>">上一页</a>
        <%
            }
        %>
        <%
            if (pageIndex < totalPages) {
        %>
        <a href="<%=path%>/PageControlServlet?pageIndex=<%=pageIndex+1%>">下一页</a>
        <a href="<%=path%>/PageControlServlet?pageIndex=<%=totalPages%>">末页</a>
        <%
            }
        %>
        <%--  <table border="1">
              <tr><th>No.</th><th>主题名称</th></tr>
              <c:forEach var="topic" items="${sessionScope.allTopics}" varStatus="i">
                  <tr>
                      <td>${i.count}</td>
                      <td>${topic.tname}</td>
                  </tr>
              </c:forEach>
          </table>--%>
        <%--<ul class="classlist">
            <%
                //1.获取session中的list
                List<News> list = (List<News>) session.getAttribute("allNews");
                //2.解析list，将其中的News对象显示到页面中
                if(list==null){
                    response.sendRedirect("../util/do_news_list.jsp");
                    return;
                }else{
                    session.removeAttribute("list");
                    int n=0;
                    for(News tempNews:list){
                        n++;
            %>
            <li><%=tempNews.getNTitle() %>&#160;&#160;<%=tempNews.getNContent() %>
                <span> 作者：<%=tempNews.getNAuthor() %> &#160;&#160;&#160;&#160;
                  <a href='#'>修改</a> &#160;&#160;&#160;&#160;
                  <a href='#' onclick='return clickdel()'>删除</a>
              </span>
            </li>
            <%if(n%5==0){ %>
            <li class='space'></li>
            <%}} }%>
        </ul>--%>
    </div>
</div>
<div id="footer">
    <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
<%
    }
%>