<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
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
  
  <%
 	String message="";
  	String msg=(String)request.getAttribute("msg");
  	if(msg!=null){
  		message=msg;
  	}
   %>
  
 <h1 align="center">登录</h1>
  <font color="RED"><p align="center"><%=message %></p></font>
 <form action="<c:url value='/AdministratorServlet'/>" method="post">
 	<input type="hidden" name="method" value="login" />
 <table  width="20%" align="center">
 	<tr>
 		<td align="right">用户名:</td>
 		<td><input type="text" name="username" size="12"/></td>
 	</tr>
	<tr>
 		<td align="right">密&nbsp;码:</td>
 		<td><input type="password" name="password" size="12"/></td>
 	</tr>
 	<tr>
		<td></td>
 	</tr>
 	<tr>
 		<td align="right">		 	
 		</td>
 		<td>
 			<input type="submit" value="登录"/>
 			<input type="reset" value="重置"/>
 		</td>
 	</tr>
 </table>
 
 </form>
  </body>
</html>
