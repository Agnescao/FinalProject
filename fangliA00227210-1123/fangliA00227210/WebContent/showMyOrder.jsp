<%@ page language="java" import="java.util.*,model.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Order</title>
<link type="text/css" rel="stylesheet" href="css/css.css" />
<%@include file="head.jsp"%>
</head>
<body>
<center>
<h2>My Order</h2>
<h2>Customer information</h2>
<table style="border-collapse: collapse" border="1">
<tr><td colspan="2"> customer information</td></tr>
<tr><td> username</td><td><%=((User)session.getAttribute("user")).getName() %></td></tr>
<tr><td> email</td><td><%=((User)session.getAttribute("user")).getEmail() %></td></tr>
<tr><td> grade</td><td><%=((User)session.getAttribute("user")).getGrade() %></td></tr>
</table>
<table style="border-collapse: collapse" border="1">
<tr><td>bookid</td><td>bookname</td><td>price</td><td>publish</td><td>amount</td></tr>

<%
               ArrayList al=(ArrayList)request.getAttribute("orderinfo");
                for(int i=0;i<al.size();i++){
                	Book book=(Book)al.get(i);
                		%>
                	<tr><td><%=book.getId() %></td><td><%=book.getBookname() %></td><td><%=book.getPrice() %></td><td><%=book.getPublish() %></td><td><%=book.getShoppingnums() %></td></tr>	
                <% 
                }

%>
<tr><td colspan="5">Total Price: <%=request.getAttribute("totalprice") %></td></tr>
</table>
<a href="/fangliA00227210/SubmitOrderServlet">OK</a>
</center>
</body>
</html>