<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="buttons/buttons.css">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		button[name='login']{position: fixed;right: 643px;top: 250px}
		button[name='reg']{position: fixed;right: 643px;top: 290px}
		div[name='reset']{position: relative;right: -20px}
		div[name='pwd']{position: relative;right: 25px;}
	</style>
  </head>
   
   
   
   
   
   
   
   
   
   
   
  <body>
  <script type="text/javascript" src="jquery1.8/jquery-1.8.0.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<center>
		<br><br><br><br>
		<fieldset style="width: 600px"><legend>login</legend>
				<span style="color: red;visibility: hidden;" id="error" >账号或密码错误</span><p>
				<div name="reset">
					账号：<input type="text" name="name">
				<button type="button" class="button button-glow button-rounded button-caution button-small" onclick="reset()">重置</button>
				</div>
				<p/>
				<div name="pwd">密码：<input type="password" name="pwd"><p><br/></div>
				<button class="button button-raised button-pill button-inverse button-small" name="login" onclick="login()">登录</button>
				<button class="button button-raised button-pill button-inverse button-small" name="reg" onclick="window.location.href='reg.jsp'">注册</button>
		</fieldset>
	</center>
  </body>
</html>
