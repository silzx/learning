<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.wzx.dto.NewsDto"%>
<%@page import="com.wzx.dao.NewsDao"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
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
	<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<%
		NewsDao nd=new NewsDao();
		List<NewsDto> ns=nd.getAllNews();
		for(NewsDto n:ns){
			out.print("新闻标题:"+n.getTitle()+",新闻内容:"+n.getContext()+"<p>");
		}
	%>
</body>
</html>
