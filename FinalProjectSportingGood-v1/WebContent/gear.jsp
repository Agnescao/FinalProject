<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*" %>
<%@ include file="Header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gear</title>
<link rel="stylesheet" type="text/css" href="css/gear.css">

 <script >
 function openDialogofProd(pid){
		// window.location="showDetailsServelt?pid="+pid;
		 
		 window.showModelessDialog ("ShowDetailsServelt?type=gear&pid="+pid, window, "dialogWidth:600px; dialogHeight:400px");
	 }</script>

</head>
<body>
<%! String src=null;%>
<h1>Gear</h1>
<div class="container"> 
<%
   for(int i=1;i<=6;i++) { 
	src="imageproduct/gear/"+i+".jpg";
    
     
    if(i==3){
    
 %><br>
 <% } %>
   <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-body"><img src=<%=src %> class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">
        
        <button type="button" class="btn btn-info btn-lg" onclick="openDialogofProd(<%=i %>)">Quick View</button></div>     
      </div>
    </div>
 <% }%>    
</div>




</body>
</html>