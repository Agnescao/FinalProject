<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.*" %>
    <%@ page import="java.io.*,java.util.*" %>
  <%@ include file="Header.jsp"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>

<script>
function openDialogofProd(pid){
	// window.location="showDetailsServelt?pid="+pid;
	  window.open("ShowDetailsServelt?type=search&pid="+pid,null,
"height=400,width=600,status=yes,toolbar=no,menubar=no,location=no, titlebar=no");
	 
}
</script>
</head>
<body>
<h3 style="text-align:center;">Search Result</h3>
<table class="table">
 <%
List<Product> l=(List<Product>)request.getAttribute("productList");
if(null !=l){
 %>
<c:forEach items="${productList}" var="m">

<tr>
<div class="col-sm-4">
<div class="panel panel-primary">
<div class="panel-body"><img src="imageproduct/${m.id}.jpg" class="img-responsive" style="width:80% ;" alt="Image"></div>
<div class="panel-footer">
       
<button type="button" class="btn btn-info btn-lg" onclick="openDialogofProd(${m.id })" >Quick View</button>
  </div> 
  </div> 
  </div>
</tr>
</c:forEach>	
<%}
else {
out.println("NO ITEM FOR WHANT YOU WANT,SORRY !");
}
%>
</table>
</body>
</html>