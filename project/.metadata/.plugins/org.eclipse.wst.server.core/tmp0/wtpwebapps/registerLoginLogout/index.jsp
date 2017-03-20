<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Say Hello Form</title>
</head>
<body>

<body>
<h2>Welcome</h2>

<c:if test="${sessionScope.user != null}">
	Current user: <c:out value="${sessionScope.user.name}"/>
</c:if>

<p>
<a href="register.jsp"> Register</a> <br>
<p>
<a href="login.jsp"> Login</a><br>
<p>
<a href="LogoutServlet"> Logout</a><br>

</body>

</body>
</html>