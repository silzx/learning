<%@page import="com.wzx.dto.NewsDto"%>
<%@page import="com.wzx.service.inter.INewsService"%>
<%@page import="com.wzx.service.NewsService"%>
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
  <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
  <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<br><br><br>
	<center>
		<form action="NewsAction/update.action" method="post" enctype="multipart/form-data"><p>
			<input type="hidden" name="n.id" value="${n.id }">
			新闻编号：<input type="text" name="n.newsid" value="${n.newsid }" readonly="readonly"><p>
			新闻标题：<input type="text" name="n.title" value="${n.title }"><p>
			新闻内容：<textarea rows="5" name="n.context" cols="23">${n.context }</textarea><p>
			新闻记者：<input type="text" name="n.newsman" value="${n.newsman }"><p>
			发布日期：<input type="text" name="n.newsdate" class="Wdate" onclick="WdatePicker()" readonly="readonly" value="${n.newsdate }"><p>
			新闻图片：<input type="file" name="img" value="${n.pic }"><p>
			<input type="submit" class="button button-raised button-pill button-inverse button-small " value="修改">
		</form>
	</center>
  </body>
</html>
