<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<table width=800 border="1">
<tr align="center" height=30 bgcolor="pink">
	<td>I D</td><td>active</td><td>password</td>
	<td>role</td><td>username</td>
</tr>
<c:forEach var="list" items="${list}">
<tr align="center" height=30>
	<td>${list.id}</td>
	<td>${list.active}</td>
	<td>${list.password}</td>
	<!-- => lev 등급표시하기   A:관리자   B:나무   C:잎새    D:새싹 -->
	<td>${list.roles}
	</td>
	<td>${list.userName}</td>
</tr>
</c:forEach>
</table>
<hr>
<c:if test="${message != null}">
 => ${message}
</c:if>
<a href="/home">[Home]</a>
</body>
</html>