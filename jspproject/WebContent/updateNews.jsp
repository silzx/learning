<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="com.wzx.service.NewsService"%>
<%@page import="com.wzx.service.inter.INewsService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.wzx.dto.NewsDto"%>
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
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  
	<%	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		INewsService ns=new NewsService();
		NewsDto news = new NewsDto();
		DiskFileItemFactory dis=new DiskFileItemFactory();
		ServletFileUpload sf=new ServletFileUpload(dis);
		//news.setPic(null);
		List<FileItem>up=sf.parseRequest(request);
		for(FileItem f:up){
			if(f.isFormField()){
				if("newsid".equals(f.getFieldName())){
					news.setNewsid(f.getString("utf-8"));
				}
				if("title".equals(f.getFieldName())){
					news.setTitle(f.getString("utf-8"));
				}
				if("context".equals(f.getFieldName())){
					news.setContext(f.getString("utf-8"));
				}
				if("newsman".equals(f.getFieldName())){
					news.setNewsman(f.getString("utf-8"));
				}
				if("newsdate".equals(f.getFieldName())){
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					news.setNewsdate(sdf.parse(f.getString("utf-8")));
				}
				if("id".equals(f.getFieldName())){
					news.setId(f.getString("utf-8"));
				}
			}else{
				if(f.getSize()!=0){
					String picname=f.getName();
					picname=UUID.randomUUID().toString()+picname.substring(picname.lastIndexOf("."));
					File file=new File("D:/apache-tomcat-7.0.81/webapps/img/"+picname);
					f.write(file);
					news.setPic("../img/"+picname);
				}
				
			}
		}
		ns.update(news);
		response.sendRedirect("main.jsp");
	%>
	
  </body>
</html>
