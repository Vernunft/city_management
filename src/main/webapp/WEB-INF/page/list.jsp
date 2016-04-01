<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body  >
<h3 align="center">图书列表</h3>
<table  border="1" width="70%"  align="center">
	<tr>
		<th>图书编号</th>
		<th>图书名称</th>
		<th>图书价格</th>
		<th></th>

	</tr>
	<c:forEach items="${itemsCustom}" var="itemsCustom">
	<tr align="center">
		<td>${itemsCustom.id }</td>
		<td>${itemsCustom.name } </td>
		<td>${itemsCustom.price }</td>

		<td>
			<a href="<c:url value='/preEdit.do?id=${ itemsCustom.id}'/>">编辑</a>
			<a href="<c:url value='/delete.do?id=${ itemsCustom.id}'/>">删除</a>
		</td>
	</tr>
	</c:forEach>
</table>
  </body>
</html>
