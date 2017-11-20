<%@page import="java.net.URLEncoder"%>
<%@page import="com.wzx.service.UserService"%>
<%@page import="com.wzx.service.inter.IUserService"%>
<%@page import="com.wzx.dto.UserDto"%>
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
  	<%
  		request.setCharacterEncoding("utf-8");
  		response.setCharacterEncoding("utf-8");
  		String name=request.getParameter("name");
  		String pwd=request.getParameter("pwd");
  		UserDto user=new UserDto();
  		user.setName(name);
  		user.setPwd(pwd);
  		IUserService us=new UserService();
  		user=us.loginUser(user);
  		if(user!=null){
  			Cookie nameC=new Cookie("nameC",URLEncoder.encode(name,"utf-8"));
			Cookie pwdC=new Cookie("pwdC",pwd);
			//设置cookie失效时间
			nameC.setMaxAge(24*60*60);
			pwdC.setMaxAge(24*60*60);
			//设置cookie保存路径
			nameC.setPath("/jspproject");
			pwdC.setPath("/jspproject");
			//放到相应对象中
			response.addCookie(nameC);
			response.addCookie(pwdC);
			request.getSession().setAttribute("user", user);
		  	response.sendRedirect("midone.jsp");
  		}else{
  			session.setAttribute("error", "账号或者密码错误");
  			response.sendRedirect("index.jsp");
  		}
  		
  	%>
  <body>
  <script type="text/javascript" src="jquery1.8/jquery-1.8.0.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	
  </body>
</html>
