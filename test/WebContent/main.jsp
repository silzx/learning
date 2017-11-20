<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<form action="info.do" method="post" id="reset">
			用户名：
			<input type="text" name="ename" value="${q.qname }">&nbsp;&nbsp;
			入职日期：
			<input type="text" name="edate" value="${q.qdate }" class="Wdate" onclick="WdatePicker()">
			<button type="submit" class="button button-action  button-rounded button-small">搜索</button>
			<a href="javascript:reset()"><input type="button" class="button button-square  button-rounded button-small" value="重置"></a>
			<a href="exit.do"><input type="button" class="button button-highlight button-rounded button-small" value="退出"> </a>
		</form>
		<form action="delete.do" method="post">
			<table border="0" class="table table-striped table-hover">
				<tr>
					<td>
						<input type="checkbox" name="selAll" style="display: none;">
						<input type="button" class="btn btn-warning" value="全选" onclick="aclick()">
					</td>
					<td>员工编号</td>
					<td>员工用户名</td>
					<td>入职日期</td>
					<td>员工头像</td>
					<td>员工简介</td>
					<td>员工操作</td>
				</tr>
					<c:forEach items="${ep }" var="e">
						<tr>
							<td><input type="checkbox" name="single" value="${e.id }"></td>
							<td>${e.empid }</td>
							<td>${e.ename }</td>
							<td><fmt:formatDate value="${e.edate }" pattern="yyyy年MM月dd日"/> </td>
							<td><a href="../img/${e.epic }"><img style="width: 192px;height: 108px" alt="无法显示" src="../img/${e.epic }"></a> </td>
							<td>${e.econtext }</td>
							<td><a href="queryEmployee.do?id=${e.id }">完善信息</a><p><a href="delete.do?id=${e.id }">删除</a></td>
						</tr>
					</c:forEach>
			</table>
			<div class="button-group">
			    <button type="submit" class="button button-royal button-rounded button-raised" onclick="return confirm('是否删除？')">删除选中</button>
			    <button type="button" class="button button-royal button-rounded button-raised" onclick="location.href='reg.jsp'">添加员工</button>
  			</div><p><p>
		</form>
	</center>
	<script type="text/javascript">
	var isCheck=false;
	  function aclick(){
		 if(isCheck){
			 isCheck=false;
			 $("input[name='selAll']").attr("checked",false);
		 }else{
			 isCheck=true;
			 $("input[name='selAll']").attr("checked","checked");
		 }
		 if($("input[name='selAll']").attr("checked")){
			 $("input[name='single']").attr("checked","checked");
		 }else{
			 $("input[name='single']").attr("checked",false);
		 }
	  }
	  
	  function reset(){
		  $("input[name='ename']").val("");
		  $("input[name='edate']").val("");
		  location.href="info.do";
	  }
	</script>
  </body>
</html>
