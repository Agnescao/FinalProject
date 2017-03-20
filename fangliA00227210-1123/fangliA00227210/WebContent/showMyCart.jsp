<%@ page language="java" import="java.util.*,model.Book" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/css.css" />
<%@include file="head.jsp"%>
 <!--  <script type="text/javascript">
 function update(){
	wimdow.location.href="/fangliA00227210/ShoppingServlet?type=update";}
</script> -->
</head>
<body>
<center>
<h2>My Cart</h2>

<form action="UpdateServlet" method="get">
<table border="1" style="border-collapse: collapse;width: 600px;">
<tr>
<td>bookid</td><td>bookname</td><td>price</td><td>product</td><td>amount</td><td>delete</td>
</tr>
<%
       ArrayList al=(ArrayList)request.getAttribute("booklist");
       for(int i=0;i<al.size();i++){
	   Book book=(Book)al.get(i);
%>
	<tr>
    <td><%=book.getId() %><input type='hidden' name="id" value="<%=book.getId() %>"/></td>
    <td><%=book.getBookname() %></td>
    <td><%=book.getPrice() %></td>
    <td><%=book.getPublish() %></td>
    <td><input type='text' name='booknum' value="<%=book.getShoppingnums()%>"></td>
    <td><a href='/fangliA00227210/ShoppingServlet?type=del&id=<%=book.getId() %>'>delete</a></td>
   <!--   <td><a href='/fangliA00227210/ShoppingServlet?type=update&id=<%=book.getId() %>'>update</a></td>-->
    </tr>
<% 
     }
%>
 <tr>
<td colspan="6"><input type='submit' value='update'/></td>
</tr> 
<tr>
<td colspan="6">Total Price: ${totalPrice} EUR</td></tr>
</table>
</form>
<a href="/fangliA00227210/GoMyOrderServlet">submit the order</a>
</center>
</body>
</html>