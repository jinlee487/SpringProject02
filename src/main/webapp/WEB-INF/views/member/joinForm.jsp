<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Member Join Form **</title>

</head>
<body>
<c:if test="${not empty message}">
	<h3>${message}</h3>
</c:if>
<c:if test="${not empty emailError}">
	<h3>${emailError}</h3>
</c:if>
<form action="/registration" method="post" enctype="utf8">
    <div>
    <label for="userName"><b>UserName</b></label><br>
    <input type="text" id="userName" placeholder="Enter User Name" name="userName" class="input" required><br>
    </div>
    <div>
    <label for="lastName"><b>LastName</b></label><br>
    <input type="text" id="lastName" placeholder="Enter Last Name" name="lastName" class="input" required><br>
    </div>
    <div>
    <label for="firstName"><b>firstName</b></label><br>
    <input type="text" id="firstName" placeholder="Enter First Name" name="firstName" class="input" required><br>
    </div>
    <div>
    <label for="email"><b>Email</b></label><br>
    <input type="text" id="email" placeholder="Enter Email" name="email" class="input" required><br>
    </div>
    <div>
    <label for="password"><b>Password</b></label><br>
    <input type=password id="password" placeholder="Enter Password" name="password" class="input" required><br>
    </div>
    <div>
    <label for="matchingPassword"><b>Matching Password</b></label><br>
    <input type="password" id="matchingPassword" placeholder="Enter Matching Password" name="matchingPassword" class="input"/>
    </div>
    <button type="reset" class="cancelbtn">Cancel</button>
    <button id="signupbtn" type="submit" class="signupbtn">Sign Up</button>
</form>
<a href="/home"> [Home]</a>
</body>
</html>