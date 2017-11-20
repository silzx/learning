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
  </head>
  
  <body>
  <script type="text/javascript" src="jquery1.8/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<center>
		<form action="update.do" method="post" enctype="multipart/form-data"><p>
			<input type="hidden" name="id" value="${ee.id }">
			员工编号：<input type="text" name="empid" value="${ee.empid }"><p>
			员工用户：<input type="text" name="ename" value="${ee.ename }"><p>
			员工密码：<textarea rows="5" name="epad" cols="23">${ee.epad }</textarea><p>
			员工简介：<input type="text" name="econtext" value="${ee.econtext }"><p>
			入职日期：<input type="text" name="edate" class="Wdate" onclick="WdatePicker()" value="${ee.edate }"><p>
			员工头像：<input type="file" name="epic" value="${n.pic }"><p>
			<input type="submit" class="button button-raised button-pill button-inverse button-small " value="修改">
		</form>
	</center>
  </body>
</html>
