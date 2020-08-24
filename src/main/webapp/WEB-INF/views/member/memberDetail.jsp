<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Mybatis My Information **</title>
<link rel="stylesheet" type="text/css" href="resources/jqLib/myStyle.css">
</head>
<body>
<h2><pre>

* I     D : ${user.id}
* Password: ${user.password}
* N a m e : ${user.userName}
* active   : ${user.active}
* Roles	: ${user.roles}

</pre>
</h2>
<hr>
<h3>
<a href="/logout">[Logout]</a>&nbsp;&nbsp;
<a href="/home">[Home]</a>
</h3>
</body>
</html>