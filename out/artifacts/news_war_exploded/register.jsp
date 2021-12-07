<%--
  Created by IntelliJ IDEA.
  User: 李昱
  Date: 2021/9/23
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新闻中国</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script language="javascript">
        /* function check(){
             //alert("进入校验");
             //return false;
             // 获取表单中账号username的数据
             var id_username = document.getElementById("id_username").value;//Document Object Model文档对象模型
             // var id_username = document.getElementsByName("username")[0].value;
             alert("id_username"+id_username);
             //获取表单中密码pwd的数据
             var id_upwd = document.getElementById("id_upwd").value;//Document Object Model文档对象模型
             if(id_username == null|| id_username==""){//判断数据是否为空
                 alert("账号为空，返回请重新注册");//提示账号为空，返回注册
                 document.getElementById("usernameError").innerHTML="账号不能为空";
                 document.getElementById("id_username").focus();
                 return false;//执行返回,且带返回值
             }
             if (id_upwd==null || id_upwd == "") {
                 alert("密码不能为空，返回请重新注册！");//提示密码为空，返回注册
                 document.getElementById("usernameError").innerHTML = "密码不能为空";
                 document.getElementById("id_upwd").focus();
                 return false;//执行返回，且带返回值
                }
                    return true;//验证通过

         // function check(){
         //     //alert("进入校验");
         //     //return false;
         //     var username = $("#id_username").val();
         //     var upwd = $("#id_upwd").val();
         //     if(username == null|| username==""){
         //         alert("用户名不能为空!请重新填入！");
         //         $("usernameError").html("用户名不能为空");
         //         return false;
         //     }else if (upwd == "" || upwd == null){
         //         alert("密码不能为空!请重新填入！");
         //         $("upwdError").html("密码不能为空");
         //         return false;
         //     }
         //     alert("通过空值校验");
         //     return true;
         }*/
        function jqueryCheck(){
            const id_username = $("#id_username").val();
            const id_upwd = $("#id_upwd").val();
            if (id_username=="" || id_username == null){
                $("#usernameError").html("账号不能为空");
                $("#id_username").focus();//聚集到此控件
                return false;
            }
            if(id_upwd=="" || id_upwd== null){
                $("#usernameError").html("密码不能为空");
                $("#id_upwd").focus();//聚集到此控件
                return false;
            }
            alert("空值校验通过!")
            return true;
        }
        function focusOnLogin(){
            // var login_username = document.getElementById("username");
            // login_username.focus();
            $("#id_username").focus();
        }

        var xhr;//声明XMLHttpRequest对象
        function createXHR() {//获取XMLHttpRequest
            try{
                return new XMLHttpRequest();//创建XMLHttpRequest对象
            }catch (e) {
                return new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
      /*  function checkRegName(regName){
            // alert("失去焦点");
            xhr=createXHR();//调用函数，为变量赋值
            xhr.onreadystatechange = callback;//当状态改变，调用回调函数
            xhr.open("get","CheckRegNameServlet?regName="+regName,true);
            xhr.send(null);
        }*/

        function callback(){//回调函数
            if(xhr.readyState == 4 && xhr.status == 200){
                var result = xhr.responseText;
                // alert("result="+result);
                //根据result结果进行判断
                if(result==1){//没找到username
                    //通过DOM改写页面提示
                    document.getElementById("usernameError").innerHTML=
                        "<font style='color: red'>用户名已被占用(js原生写法)</font>";
                }else if(result==0){
                    document.getElementById("usernameError").innerHTML=
                        "<font style='color: green'>用户名可以使用(js原生写法)</font>";
                } else{
                    alert("数据有误")
                }
            }
        }
//***********************jquery的$.get()方法与$.post()方法*******************
        /*function checkRegName(){
            $.get(
                "CheckRegNameServlet",
                {regName:$("#id_username").val()},
                function  callback(data){//callback回调函数(以servlet作为返回值)callback可以省略不写
                    if (data==0){
                        $("#usernameError").html("用户名可以注册！(jquery的get方法)");
                        $("#usernameError").css("color","green");
                        $("#regBtn").disabled=false;//注册按钮可用
                    }else {
                        $("#usernameError").html("用户名已被占用！(jquery的get方法)");
                        $("#usernameError").css("color","red");
                        $("#regBtn").disabled=true;//注册按钮不可用
                    }
            }
            )
        }*/
        /*function checkRegName(){
            $.post(
                "CheckRegNameServlet",
                {regName:$("#id_username").val()},
                function  callback(data){
                    if (data==0){
                        $("#usernameError").html("用户名可以注册！(jquery的post方法)");
                        $("#usernameError").css("color","green");
                    }else {
                        $("#usernameError").html("用户名已被占用！(jquery的post方法)");
                        $("#usernameError").css("color","red");
                    }
                }
            )
        }*/
//***********************jquery的ajax方法*******************
        function checkRegName(){
            $.ajax({
                url:"CheckRegNameServlet",//访问的servlet的url
                type:"post",//访问servlet时提交数据所用的方式"get"或"post"均可
                data:{
                    regName:$("#id_username").val()//访问servlet时提交的数据(可以是多个)
                },
                dataType:"text",//从servlet获取的返回值类型
                success:function (data){//success代表(xhr.readyState == 4 && xhr.status == 200)结果为true
                    //以下部分为callback的函数体
                    if (data==0){
                        $("#usernameError").html("用户名可以注册！(ajax方法)");
                        $("#usernameError").css("color","green");
                        // document.getElementById("regBtn").disabled = false;//设置按钮可用
                        $("#regBtn").attr("disabled",false);//设置按钮可用
                    }else {
                        $("#usernameError").html("用户名已被占用！(ajax方法)");
                        $("#usernameError").css("color","red");
                        // document.getElementById("regBtn").disabled = true;//设置按钮不可用
                        $("#regBtn").attr("disabled",true);//设置按钮不可用
                    }
                }
            })
        }
    </script>
</head>
<body onload="focusOnLogin()">
<div id="header">
    <div id="top_login" style="height:25px;">

        <%--<form action="logonServlet" method="post">
            <input login_input/>
            <label id="error"> </label>
            <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
        </form>--%>
    </div>
    <div id="nav">
        <div id="logo"> <img src="images/logo.jpg" alt="新闻中国" /> </div>
        <div id="a_b01"> <img src="images/a_b01.gif" alt="" /> </div>
        <!--mainnav end-->
    </div>
</div>
<div id="container">
    <div class="main">
        <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
        <div class="content">
            <form action="RegisterServlet" method="post" onsubmit="return jqueryCheck()">
                <label> 用户名 </label>
                <input onblur="checkRegName(this.value)" id="id_username" name="username" placeholder="请输入账号" class="login_input" />
                <label id="usernameError" style="height:25px;"> </label>
                <br><br><label> 密&#160;&#160;&#160;码 </label>
                <input type="password" id="id_upwd" name="upwd" placeholder="请输入密码" class="login_input" />
                <label id="upwdError" style="height:25px;"> </label>
                <br><br><input type="submit" class="login_sub" value="注册" id="regBtn"/>
                <input type="button" class="login_sub" value="返回" onclick="javascritpt:window.location.href='index.jsp'" />
            </form>
        </div>
        <%--        <%@include file="index-elements/index_rightbar.html"%>--%>
    </div>
</div>
<%@include file="index-elements/index_bottom.html"%>
</body>
</html>
