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
	<title>Answer</title>
	<meta name="version"
		content="$Id: chat.jsp,v 1.2 2004/02/09 03:34:01 ian Exp $" />
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<link rel="stylesheet" type="text/css" href="css/chat.css"/>
	<!--  <script type="text/javascript" src="js/demo.js"></script> -->
	<script type="text/javascript" src="js/ajax.js"> </script>
</head>

<body>
<h3>Please answer the queries below !</h3>


<ul id="list">
 <c:forEach items="${comments}" var="line">
  <li class="box clearfix">
   <a class="close" href="javascript:;">x</a>
   <div> <input type="hidden" value="${line.id}" name="commentID"/>
   <c:out value="${line.id}"/>&nbsp&nbsp</div>
   <div class="content">
     <div class="main"><p class="txt"><span class="user"><c:out value="${line.userid} :"/></span><c:out value="${line.comment}"/></p></div>
     <div class="info clearfix"><span class="time"><c:out value="${line.date}"/></span></div>
    <div>
    <ul name="replys"></ul>
    </div>
  </div>

   <div class="text-box">
                    <textarea name="query" rows="5" cols="60"  >Please answer here !</textarea>
                    <button type="submit"  onclick="saveReply(${line.id})">reply</button>
                    <span class="word"><span class="length">0</span>/140</span>
                </div>
 
  </li> 


</c:forEach>
</ul>
</body>
</html>

