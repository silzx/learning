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
	<div class="container" >
		<div class="row">
			<center>
				<div class="col-md-12 jumbotron">
				<h2>欢迎&nbsp;${user.nickname }&nbsp;登录</h2>&nbsp;&nbsp;<h3>当前登录人次：${index }</h3> &nbsp;
				</div>
			</center>
		</div>
		<div class="row">
			<div class="col-md-3">
				<ul>
					<li><a href="#">权限</a></li>
					<li><a href="#">权限</a></li>
					<li><a href="#">权限</a></li>
					<li><a href="#">权限</a></li>
					<li><a href="#">权限</a></li>
					<li><a href="#">权限</a></li>
					<li><a href="#">权限</a></li>
				</ul>
			</div>
			<div class="col-md-9">
				<form action="">
					<table border="0" class="table table-striped table-hover">
			<tr align="center">
				<td>
				<input type="checkbox" name="selAll" style="display: none;">
				<input type="button" class="btn btn-warning" value="全选" onclick="aclick()">
				</td> 
				<td>新闻编号</td>
				<td>新闻标题</td>
				<td>新闻内容</td>
				<td>新闻作者</td>
				<td>新闻日期</td>
				<td>新闻图片</td>
				<td>删除</td>
				<td>修改</td>
			</tr>
				<c:forEach items="${news }" var="n" varStatus="status">
				<tr align="center">
				<td><input type="checkbox" name="ids" value="${n.id }"></td>
				<td>${n.newsid }</td>
				<td>${n.title }</td>
				<td>${n.context }</td>
				<td>${n.newsman }</td>
				<td><fmt:formatDate value="${n.newsdate }" pattern="yyyy年MM月dd日"/></td>
				<td><a href="../img/${n.pic }"><img style="width:192px;height: 108px" alt="无法显示" src="../img/${n.pic }" class="img-rounded"></a> </td>
				<td><a href="NewsAction/del.action?ids=${n.id }"><input type="button" class="button button-3d button-caution button-small" value="删除"></a></td>
				<td><a href="NewsAction/toUpdate.action?ids=${n.id }"><input type="button" class="button button-3d button-primary button-small" value="修改"></a></td>
				</tr>
				</c:forEach>
		</table>
				</form>
			</div>
		</div>
	</div>
  </body>
</html>
