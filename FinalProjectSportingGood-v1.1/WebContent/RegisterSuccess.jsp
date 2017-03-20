<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Hello  <%= request.getParameter("name")%> , You are our website member</h2>
<p>The following is your profile</p>
<table>
<tr>
<td>Your Name is: </td>
<td><%= request.getParameter("name")%> </td>
</tr>
<tr>
<td>Your email is: </td>
<td><%= request.getParameter("email")%> </td>
</tr>
<tr>
<td>Your phone number is: </td>
<td><%= request.getParameter("phone")%> </td>
</tr>
<tr>
<td>Your address is: </td>
<td><%= request.getParameter("address")%> </td>
</tr>
<tr>
<td>You are from : </td>
<td><%= request.getParameter("city")%> </td>
</tr>

<a href="index.jsp">Go back to Home</a>

</table>



</body>
</html>