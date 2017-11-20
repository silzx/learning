<%@page import="java.net.URLDecoder"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
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
  	<%	String name="";
  		String pwd="";
  		request.setCharacterEncoding("utf-8");
  		response.setCharacterEncoding("utf-8");
  		Cookie ck[]= request.getCookies();
  		if(ck!=null){
  			for(Cookie c : ck){
  				if("name".equals(c.getName())){
  					name=c.getValue();
  					name=URLDecoder.decode(name, "utf-8");
  				}
  				if("pwd".equals(c.getName())){
  				pwd=c.getValue();
  				}
  			}
  		}
  	%>
  <body>
	<form action="index.jsp" method="post">
		账号：<input type="text" name="name" value=<%=name %>><p>
		密码：<input type="password" name="pwd" value=<%=pwd %>><p>
		<button type="submit">登录</button><input type="checkbox" name="check" value="save">是否保存登录信息
	</form>
	
  </body>
</html>
