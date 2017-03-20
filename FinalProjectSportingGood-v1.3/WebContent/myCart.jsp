<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" trimDirectiveWhitespaces="true"%>
<%@ page import="java.io.*" %>
<%@ page import="java.net.*" %>

<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <title>My Cart</title>
  <script src="js/updateQuantity.js"></script>
</head>
<body>

<div class="container">
  <h2><c:out value="${cartName}"/></h2>
  
  <c:choose>
  <c:when test="${not empty items}">       
  <table class="table">
   
    <thead>
      <tr>
        <th>Product</th>
        <th>Items</th>
        <th>Quantity</th>
        <th>TotalPrice</th>
      </tr>
    </thead>
 
    <tbody>
    
    <!-- print out each item of product of a certain customer -->
      <c:forEach items="${items}" var="line">
   
       <tr>
        <td>
        
          <img src="imageproduct/${line.product.id}.jpg"/>
        <input type="hidden" value="${line.id}" name="orderID"/></td>
        <td  style="font-size:20px;"><c:out value="${line.product.name}" /><br>
        <a href="RemoveItemsServlet?orderID=${line.id}" style="font-size:15px;">Remove Items</a></td>
        <!-- When you leave the input field, a function is triggered which transforms the input text to upper case. -->
        <td><input type="text" name="name" value="${line.quantity}" onblur="change(${line.id},this) " /></td>
        <td><c:out value="${line.totalPrice}"/></td>
      </tr>
  	 </c:forEach>

     <tr>
     <td colspan="2" ><a href="RemoveAllItemsServlet?userId=${sessionScope.user.getId()}"><h3>Remove all items</h3></a></td>
     <c:set var="total" value="0"/>
     <c:forEach items="${items}" var="line">
     <c:set var="total" value="${total+line.totalPrice}"/>
     </c:forEach> 
     <td colspan="2"><h3>Total Price : &nbsp $ <c:out value="${total}"></c:out> </h3>  </td>
     </tr>
						
   </tbody>
  </table>
 
  <div ><button type="button" class="btn btn-success">Check out</button></div>
   </c:when>
<c:otherwise>
<h3> Your shopping cart is empty ! </h3>
</c:otherwise>
</c:choose>
</div>

</body>
</html>
