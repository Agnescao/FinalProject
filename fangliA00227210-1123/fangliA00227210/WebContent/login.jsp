<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link type="text/css" rel="stylesheet" href="css/css.css" />
<%@include file="head.jsp"%>
</head>
<body>
<center>
<h2>Login</h2>
   <form method="post" action="LoginServlet">
   <table border="1" style="border-collapse: collapse;width: 600px;">
    <tr><td>  Enter name: </td><td><input type="text" name="name" /></td>
    </tr>
      <tr>
      <td> Enter password: </td><td><input type="password" name="password"/></td>
      </tr>
      <tr>
      <td><input type="submit" value="login"></td><td><input type="reset" value="Reset"></td>
      </tr>
       <tr>
      <td>  </td><td> <a href="register.jsp"/>Register</td>
      </tr>
      </table>
   </form>
</center>
</body>
</html>