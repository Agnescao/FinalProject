<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
	  background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Sporting Goods</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">Home</a></li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" >Product<span class="caret"></span></a>
				<ul class="dropdown-menu">
          			<li><a href="gear.jsp">Gear</a></li>
         			 <li><a href="men.jsp">Man's</a></li>
         			 <li><a href="women.jsp">Woman's</a></li> 
         			 <li><a href="Equipment.jsp">Equipment</a></li> 
        		</ul>
				
				</li>
				
        <li><a href="createProduct.jsp">NewProduct</a></li>
        <li><a href="AboutUs.jsp">About us</a></li>
        <li> 
        <c:choose><c:when test="${sessionScope.user.getName()!= 'Administrator'}">
         <a href="ShowCommentServlet">Contact</a></c:when>
        <c:otherwise><a href="ShowAllQueriesServlet">Answer</a></c:otherwise> </c:choose></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
       <c:choose>
        <c:when test="${sessionScope.user.getName()== null}"> 
        <li class="dropdown"><a  class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a>
        </c:when>
         <c:otherwise>
        <li class="dropdown"><a  class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> ${sessionScope.user.getName()}</a>
         </c:otherwise>
         </c:choose>
        <ul class="dropdown-menu">
         <c:choose>
        <c:when test="${sessionScope.user.getName()== null}">
  
		    <li><a href="login.jsp">Login</a></li>
            <li><a href="register.jsp">Sign up</a></li>
        </c:when>
  
      <c:otherwise>
        <li><a href="LogoutServlet">Logout</a></li>
       </c:otherwise>
      </c:choose>
        
        </ul>
        
        <li><a href="showCart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>