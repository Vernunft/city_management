<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

 <form action="<c:url value='/loginc.do'/>" method="post">
 	
 <table  width="20%" align="center">
 	
 	<tr>
 		<td align="right">用户名:</td>
 		<td><input type="text" name="telephoneNumber" size="12"/></td>
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
 			<input type="submit" value="denglu"/>
 			<input type="reset" value="reset"/>
 		</td>
 	</tr>
 </table>
 
 </form>
  </body>
</html>

</body>
</html>
