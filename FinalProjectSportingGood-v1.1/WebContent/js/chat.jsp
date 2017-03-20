 <%@page import="model.*" %> 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
>

<html>

<head>
	<title>Let's Chat by Servlet</title>
	<meta name="version"
		content="$Id: chat.jsp,v 1.2 2004/02/09 03:34:01 ian Exp $" />
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<script type="text/javascript">

function showtext()

{

document.getElementById('text_a').style.display = 'block';

}

</script>
</head>

<body>
<h2>Your comments !</h2>
<ul id="list">
 <c:forEach items="${comments}" var="line">
  <li class="box clearfix">
   <a class="close" href="javascript:;">×</a>
   <div class="content">
     <div class="main"><p class="txt"><span class="user">${sessionScope.user.getName()}</span><c:out value="${line.comment}"/></p></div>
     <div class="info clearfix"><span class="time"><c:out value="${line.date}"/></span><a class="praise" href="javascript:;">Like</a></div>
     <div class="praises-total" total="4" style="display:block;">4 people like</div>
     <ul class="comment-list">
       <li  class="comment-box clearfix" user="self"></li>
       <div class="comment-content"><p class="comment-text"><span >${sessionScope.user.getName()}</span><c:out value="${line.reply}"/></p></div>
    </ul>
  </div>
   <div class="text-box">
                    <textarea class="comment" autocomplete="off">comment</textarea>
                    <button class="btn ">reply</button>
                    <span class="word"><span class="length">0</span>/140</span>
                </div>
  </li> 
 
 
 <li>
 <c:out value="${line.id}"/>&nbsp&nbsp</li> 



<%-- <ul>
 <c:forEach items="${replys}" var="line">
<li><c:out value="${line.reply}"/></li>
</c:forEach>
</ul> --%>
<li><a href="deleteCommentServlet?ID=${line.id}">Delete</a>&nbsp&nbsp<a href="javascript:showtext();">reply</a> </li>
<%-- <form action="responeCommentServlet" method="post">
<input type="hidden" name="commentID" value="${line.id}"/>
<li><textarea name="reply" rows="13" cols="60" style="display:none;" id="text_a"></textarea>
<button type="submit" >submit</button></li>
</form>--%>
 </c:forEach> 
 </ul>
<h3>Leave your comment here</h3>
<form action="ChatServlet" method="post">
<p>

<textarea name="chat" rows="13" cols="60">

</textarea>
<br/>

<input type="submit" name="do_it" value="commit"/>
</p>
</form>
</body>
</html>

