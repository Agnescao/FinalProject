<%@ page language="java" import="java.util.*,model.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/css.css" />
<%@include file="head.jsp"%>
</head>
<body>
<center>
<h2>Welcome to Shopping Hall</h2>
Current user: ${sessionScope.user.getName()}
<br>
<form action="ReserchServlet" method="get">
<td colspan="5"><input type="text" name="bookname" value="bookname"/><input type='submit' value='search'/></td>
</form>
<table border="1">
<tr><td>bookid</td><td>bookname</td><td>price</td><td>Product</td><td>Add to cart</td></tr>
<% 
   ArrayList al=(ArrayList)request.getAttribute("books");
   for(int i=0;i<al.size();i++){
	   Book book=(Book)al.get(i);
%>
	<tr><td><%=book.getId() %></td>
	<td><%=book.getBookname() %></td>
	<td><%=book.getPrice() %></td>
	<td><%=book.getPublish() %></td>
	<td><a href='/fangliA00227210/ShoppingServlet?type=add&id=<%=book.getId() %>'>Add to cart</a></td></tr>
<%
    }
%>
<tr><td><a href='/fangliA00227210/ShoppingServlet?type=check'>Check my cart</a></td><td><a href="login.jsp">Go Back</a></td></tr>
</table>
</center>
</body>
</html>