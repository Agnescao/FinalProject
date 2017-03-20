<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
     <%@ include file="Header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EquipmentModal</title>
<link rel="stylesheet" type="text/css" href="css/gear.css">
<script>
function openDialogofProd(pid){
	// window.location="showDetailsServelt?pid="+pid;
	  window.open("ShowDetailsServelt?type=equipment&pid="+pid,null,
"height=400,width=600,status=yes,toolbar=no,menubar=no,location=no, titlebar=no");
	/*  window.showModelessDialog ("ShowDetailsServelt?type=equipment&pid="+pid, window, "dialogWidth:600px; dialogHeight:400px"); */
 }</script>
</head>
<body>
<h1>Equipment</h1>
<%! String src=null;%>
<div class="container"> 
<%
   for(int i=35;i<=40;i++) { 
	src="imageproduct/"+i+".jpg";
    
     
    if(i==38){
    
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