<%--
  Created by IntelliJ IDEA.
  User: 李昱
  Date: 2021/9/14
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
登录页面
    <form name="LogonForm" method="post" action="control.jsp"><br><!--action指明提交给谁,method指明提交方式-->
        <input type="text" name="id" placeholder="请输入账号"><br><!-- 登录账号-->
        <input type="password" name="pwd" placeholder="请输入密码"><br><!-- 登录密码-->
        <input type="submit" value="登录"><!-- 登录-->
    </form>
<%--JSP脚本：声明 --%>
<%! int num1=1,num2=5;
    public void foo(){//声明(定义)方法
        System.out.println("这里是foo()的方法输出");
    }
    public class A{//声明(定义)类
        String   a,b;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }
%>
<%--SP脚本：小脚本(调用方法，创建对象，分支逻辑 循环逻辑，逻辑代码) --%>
<%
    foo();//调用方法
    A aa = new A();//创建对象
    for (int i = 0;i<10;i++){num1++;}
    out.print("<span>num1="+num1+"<br></span>");
    for (int j = 0;j<5;j++){num2++;}
    out.print("<span>num2="+num2+"</span>");
%><br>
<%--SP脚本：表达式部分 --%>
<div>num1*num2=<%=num1*num2%></div>
</body>
</html>
