<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Header.jsp"%>
  
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>upload your product</title>

  <meta name="viewport" content="width=80%, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
   <link rel="stylesheet" type="text/css"  href="css/createProduct.css">
  
</head>
<body>

<h2>upload product</h2>
<form  method="post" action="UploadFile.jsp"  class="col-xs-3 " enctype="multipart/form-data">
	   
	  <div class="form-group bootstrap-overwrite">
	    <label for="Name">Name:</label>
	    <input type="text" name="pName" class="form-control" id="nameid" />
	  </div>
	  <div class="form-group">
	    <label for="price">Price:</label>
	    <input type="text" name="price" class="form-control" id="priceid">
	  </div>
	  <div class="form-group">
	    <label for="Description">Description:</label>
	    <input type="text" name="description" class="form-control" id="Descriptionid">
	  </div>
	   <div class="form-group">
	    <label for="category">Category:</label>
	    <select name="categoryName">
	     <option value="Gear">Gear</option>
	     <option value="Woman">Woman</option>
	     <option value="Man">Man</option>
	     <option value="Equipment">Equipment</option>
	</select>
	  </div>
	 <div>
	 <p>Upload picture of product</p>
	 <input type="file" name="images" accept="image/x-png, image/gif, image/jpeg" />
	 </div>
	  <button type="submit"  class="btn btn-default">Submit</button>
</form>
</body>
</html>