 <%@page import="model.*" %> 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
>

<html>

<head>
	<title>Let's Chat by Servlet</title>
	<meta name="version"
		content="$Id: chat.jsp,v 1.2 2004/02/09 03:34:01 ian Exp $" />
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	
</head>

<body>
<h2>Your comments !</h2>
<%

%>
 <c:forEach items="${comments}" var="line">
 <c:out value="${line.id}"/>

 <c:out value="${line.date}"/><br></br>
 <c:out value="${line.comment}"/><br></br>
 </c:forEach>
<h3>Leave your comment here</h3>
<form action="ChatServlet" method="post">
<p>

<textarea name="chat" rows="13" cols="60">

</textarea>
<br/>

<input type="submit" name="do_it" value="commit"/>
</p>
</form>
</body>
</html>

