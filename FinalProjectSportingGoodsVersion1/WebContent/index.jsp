<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
 <link rel="stylesheet" href="F:\FinalProject\FinalProjectSportingGoods\WebContent\css\main2.css">

</head>


<body>
 <header>
  	
   <h2>Sporting Goods</h2>
   
	<div id="nav_bar">
    <ul>
		<li><a href="index.html">Home</a></li>
		<li><a href="#.html">Product</a></li>
		<li><a href="#.html" class="current">
				SecondHand</a></li>
		<li><a href="#.html">About Us</a></li>
		<li><a href="#.html">Shopping Cart</a></li>
	</ul>
	</div>
  </header>

<main>
<c:if test="${sessionScope.user != null}">
	You are logged in as  <c:out value="${sessionScope.user.name}"/>
</c:if>

<p>
<a href="register.jsp"> Register</a> <br>
<p>
<a href="login.jsp"> Login</a><br>
<p>
<a href="LogoutServlet"> Logout</a><br>
<a href="Page/register1.jsp"> Register</a> <br>
<a href="MainPage.jsp"> Login</a><br>
</p>
</main>

<foot>
<p>&copy; 2016 Lei Cao</p>
</foot>
</body>


</html>