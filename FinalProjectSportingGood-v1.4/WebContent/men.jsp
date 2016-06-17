<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Men</title>
<link rel="stylesheet" type="text/css" href="css/gear.css">

 <script>
 function openDialogofProd(pid){
	
	 window.open("ShowDetailsServelt?type=men&pid="+pid,null,
"height=400,width=600,status=yes,toolbar=no,menubar=no,location=no, titlebar=no");
	
 }
 </script>
</head>
<body>

<h1>Men</h1>
<%! String src=null;%>
<div class="container"> 
<%
   for(int i=24;i<=29;i++) { 
	src="imageproduct/"+i+".jpg";
    
     
    if(i==27){
    
 %><br>
 <% } %>
   <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-body"><img src=<%=src %> class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">
    
        <button type="button" class="btn btn-info btn-lg" onclick="openDialogofProd(<%=i %>)">Quick
						View</button></div>     
      </div>
    </div>
 <% }%>    
</div>


</body>
</html>