<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加学生</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jquery/jquery.datepick.css'/>">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>


	
<style type="text/css">
	.error {color:red;}
</style>
  </head>
  
  <body>
<h3 align="center">添加图书</h3>
<form action="<c:url value='/BookServlet'/>" method="post">
	<input type="hidden" name="method" value ="addStudent"/>
<table border="0" align="center" width="20%" style="margin-left">
	<tr>
		<td>图书编号</td>
		<td>
			<input type="text" name="ID" />
		</td>
	</tr>
	<tr>
		<td width="100px">图书名称</td>
		<td width="40%">
			<input type="text" name="name"/>
		</td>

	</tr>

		<td>图书价格</td>
		<td>
			<input type="text" name="result"/>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>
			<input type="submit" value="添加图书"  />
			<input type="reset" value="重置"/>
		</td>
	</tr>
</table>
</form>
  </body>
</html>
