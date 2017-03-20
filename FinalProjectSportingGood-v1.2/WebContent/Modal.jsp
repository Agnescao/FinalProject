<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="model.*" %> 
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gear</title>

<%
Product p=(Product)request.getSession().getAttribute("productselected");
String cid = "1";
String path=p.getImagepath();
out.println(path);
if (null != p){
	cid = p.getId()+"";
	cid =cid.trim();
}
%>
<base target="_self"/>
</head>
<body>

<img src="imageproduct/<%=cid%>.jpg"><br>
 <form action="AddTocartServlet" method="post">
<input type="hidden" value="<%=p.getId() %>" name="productid"/>
         
        <c:out value="<%=p.getName() %>" /><br><br>
       <c:out value="<%=p.getDescription() %>"/><br><br>
       $<c:out value="<%=p.getPrice() %>" /><br><br>
       
        Quality <input type="text" name="quantity" min="1" max="100" placeholder="1">
        <!-- Link button -->
        <input type="hidden" value="gear" name="typeOfProduct"/>
        <input type="submit" value="Add to cart" onclick="alert('Add to cart already !')"/> 
     	<!-- <button type="submit"  >Add to cart</button> --> 
    
      </form>

</body>
</html>