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
	<center>
		<form action="reg.do" method="post" onsubmit="return checksubmit()">
			用户名：<input type="text" name="name"><font id="error"></font><p>
			密码：<input type="password" name="pwd"> <p>
			<input type="submit" value="注册">
		</form>
	</center>
	<script type="text/javascript">
		$("input[name='name']").blur(function(){
			alert("123");
			$.ajax({
				type:"post",
				url:"check.do",
				dataType:"json",
				data:{"name":$("input[name='name']").val()},
				success:function(date){
					if(date.meg){//传来true说明没有重复用户
						$("#error").attr({"size":"1","color":"green"}).html("可用的用户名");
					}else{
						$("#error").attr({"size":"1","color":"red"}).html("有重复用户名");
						function checksubmit(){
							alert("已存在相同用户名");
							return false;
						}
						
					}
				}
			});
		});
	</script>
  </body>
</html>
