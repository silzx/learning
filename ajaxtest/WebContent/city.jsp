<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<select name="pros" id="province">
			<c:forEach items="${pros }" var="pros"><!-- 遍历省份集合 -->
				      	<option value="${pros.proname}" id="proid">${pros.proname}</option>
			</c:forEach>
		</select><p>
		<select name="citys" id="city">
			<option></option>
		</select>
	</center>
	
	<script type="text/javascript">
		$("#province").change(function(){
			$("#city").empty();			  //每次触发该事件，先把城市的值置空
			$.ajax( {  
                type : "post",  //请求的方式，为post或者get
                url : "getCity",  	//发送请求的地址
                data : {"proname":$("#province option:selected").val()},//要发送到服务器的数据
                dataType : "json",  //预期服务器返回的数据类型
                success : function(date) {  //请求成功后调用的回调函数，date是后台返回的值
                    var str = "<option>请选择</option>";  
                    for ( var i = 0; i < date.length; i++) {  
                        str += "<option value='" +date[i].cityname+"'>" + date[i].cityname + "</option>";  
                    }  
                    $("#city").append(str); 
                },  
                error : function() {  
                    alert("error");  
                }
			});
		})
	</script>
  </body>
</html>
