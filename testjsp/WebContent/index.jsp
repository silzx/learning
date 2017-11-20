<%@page import="java.net.URLEncoder"%>
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
  
  <body>
		<%	request.setCharacterEncoding("utf-8");
  			response.setCharacterEncoding("utf-8");
			if("张三".equals(request.getParameter("name")) && "123".equals(request.getParameter("pwd"))){
				request.getSession().invalidate();
				if("save".equals(request.getParameter("check"))){
					Cookie nc=new Cookie("name",URLEncoder.encode(request.getParameter("name"),"utf-8"));
					Cookie pc=new Cookie("pwd",request.getParameter("pwd"));
					nc.setMaxAge(24*60*60);
					pc.setMaxAge(24*60*60);
					nc.setPath("/testjsp");
					pc.setPath("/testjsp");
					response.addCookie(nc);
					response.addCookie(pc);
				}
				request.getSession().setAttribute("name", request.getParameter("name"));
				response.sendRedirect("main.jsp");
// 				request.setAttribute("name", request.getParameter("name"));
// 				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
		
		%>
<%-- 		<%=request.getParameter("name") %><p> --%>
<%-- 		<%=request.getParameter("pwd") %> --%>
		
  </body>
</html>
