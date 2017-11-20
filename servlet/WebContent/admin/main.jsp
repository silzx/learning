<%@page import="com.wzx.dto.FenYe"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<style type="text/css">
  		input[name='exit']{position: fixed; right: 200px;height: 200px}
  	</style>
  </head>
  	
  <body>
  <script type="text/javascript" src="jquery1.8/jquery-1.8.0.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<center>
		<div class="jumbotron">
			<h2>欢迎&nbsp;${user.nickname }&nbsp;登录</h2>&nbsp;&nbsp;<h3>当前登录人次：${index }</h3> &nbsp;
		</div>
		<div>
			<form action="<%=basePath%>newsList.do" method="post" id="reset">
				新闻标题：
				<input type="text" name="qtitle" class="input-medium search-query" value="${qtitle }">&nbsp;&nbsp;
				新闻内容：
				<input type="text" name="qcontext" class="input-medium search-query" value="${qcontext }">
				<button type="submit" class="button button-action  button-rounded button-small">搜索</button>
				<a href="javascript:reset()"><input type="button" class="button button-square  button-rounded button-small" value="重置"></a>
				<a href="exit.do"><input type="button" class="button button-highlight button-rounded button-small" value="退出"> </a>
			</form>
			<form action="<%=basePath%>newsList.do?qtitle=${qtitle }&qcontext=${qcontext }" method="post" name="changePage">
				<input type="hidden" value="<%=FenYe.page %>" name="page"/>
				<input type="hidden" value="<%=FenYe.pageCount %>" name="pageCount"/>
			</form>
		</div>
		<div style="width: 1000px">
			<form action="delete" method="post">
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
				<td><input type="checkbox" name="single" value="${n.id }"></td>
				<td>${n.newsid }</td>
				<td>${n.title }</td>
				<td>${n.context }</td>
				<td>${n.newsman }</td>
				<td><fmt:formatDate value="${n.newsdate }" pattern="yyyy年MM月dd日"/></td>
				<td><a href="../img/${n.pic }"><img style="width: 192px;height: 108px" alt="无法显示" src="../img/${n.pic }"></a> </td>
				<td><a href="delete.do?id=${n.id }"><input type="button" class="button button-3d button-caution button-small" value="删除"></a></td>
				<td><a href="queryById.do?id=${n.id }"><input type="button" class="button button-3d button-primary button-small" value="修改"></a></td>
				</tr>
				</c:forEach>
		</table>
			<div class="button-group">
			    <button type="submit" class="button button-royal button-rounded button-raised" onclick="return confirm('是否删除？')">删除选中</button>
			    <button type="button" class="button button-royal button-rounded button-raised" onclick="location.href='add.jsp'">添加新闻</button>
  			</div><p><p>
  			<div>
  				<a href="javascript:firstPage()"><input type="button" class="button button-border button-inverse button-small" value="首页"></a>&nbsp;&nbsp;
  				<a href="javascript:previousPage()"><input type="button" class="button button-border button-inverse button-small" value="上一页"></a>&nbsp;&nbsp;
  				<a href="javascript:nextPage()"><input type="button" class="button button-border button-inverse button-small" value="下一页"></a>&nbsp;&nbsp;
  				<a href="javascript:lastPage()"><input type="button" class="button button-border button-inverse button-small" value="尾页"></a>&nbsp;&nbsp;
  			</div>
  			<div><%=FenYe.page %>/<%=FenYe.pageCount %>页</div>
		</form>
		</div>
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
		  $("input[name='qtitle']").val("");
		  $("input[name='qcontext']").val("");
		  location.href="newsList";
	  }
	  
	  function firstPage(){
		  $("input[name='page']").val(1);
		  $("form[name='changePage']").submit();
	  }
	  
	  function nextPage(){
		  var page=$("input[name='page']").val();
		  page=parseInt(page);
		  var pageCount=$("input[name='pageCount']").val();
		  pageCount=parseInt(pageCount);
		  if(page>=pageCount){
			  alert("已经是最后一页");
		  }else{
			  $("input[name='page']").val(page+1);
			  $("form[name='changePage']").submit();
		  }
	  }
	  
	  function previousPage(){
		  var page=$("input[name='page']").val();
		  page=parseInt(page);
		 if(page==1){
			 alert("已经是第一页");
		 }else{
			 $("input[name='page']").val(page-1);
			 $("form[name='changePage']").submit();
		 }
	  }
	  
	  function lastPage(){
		  var page=$("input[name='page']").val();
		  page=parseInt(page);
		  var pageCount=$("input[name='pageCount']").val();
		  pageCount=parseInt(pageCount);
		  $("input[name='page']").val(pageCount);
		  $("form[name='changePage']").submit();
	  }
	</script>
  </body>
</html>
