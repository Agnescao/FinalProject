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
<h2>My History Order</h2>
<br>
<center>
<table border="1">
<tr><td>orderid</td><td>ordername</td><td>totalprice</td></tr>
<% 
   ArrayList al=(ArrayList)request.getAttribute("orders");
   for(int i=0;i<al.size();i++){
	   Order order=(Order)al.get(i);
%>
	<tr><td><%=order.getId() %></td>
	<td><%=i+1 %></td>
	<td><%=order.getTotalprice() %></td>
	</tr>
<%
    }
%>
<td><a href='/fangliA00227210/LogoutServlet'>Logout</a></td>
</table>
</center>
</body>
</html>