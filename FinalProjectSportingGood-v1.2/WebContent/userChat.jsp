 <%@page import="model.*" %> 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
>

<html>

<head>
	<title>Contact to our Administrator</title>
	<meta name="version"
		content="$Id: chat.jsp,v 1.2 2004/02/09 03:34:01 ian Exp $" />
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<link rel="stylesheet" type="text/css" href="css/chat.css"/>
	<script type="text/javascript" src="js/ajax.js"> 
	<script type="text/javascript" src="js/demo.js">
</script>

</head>

<body>
<h3>Leave your message here</h3>
<form action="ChatServlet" method="post">

                    <textarea  name="chat" rows="13" cols="60" class="comment" >What do you want to say...</textarea>
                    <button class="btn ">Commit</button>
                    <span class="word"><span class="length">0</span>/140</span>
               
</form>
<h3>Answer !</h3>
<ul id="list">
 <c:forEach items="${comments}" var="line">
  <li class="box clearfix">
   <a class="close" href="javascript:;">X</a>
   <div><c:out value="${line.id}"/>&nbsp&nbsp</div>
   <div class="content">
     <div class="main"><p class="txt"><span class="user"><c:out value="${user} :"/></span><c:out value="${line.comment}"/></p></div>
     <div class="info clearfix"><span class="time"><c:out value="${line.date}"/></span></div>
     <div>
     
     <input type="button" onclick="showAnswer(${line.id})" value="see reply"/><br></br>
     <ul name="replys"></ul>
  </div>

  </div>
  </li> 


</c:forEach>
</ul>

</body>
</html>

