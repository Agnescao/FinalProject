<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<!-- <script type="text/javascript" src="checkName.css"></script> -->
<script type="text/javascript">
function checkIfNull()
{
var username=document.getElementById("demo1").value;
var password=document.getElementById("demo2").value;
if(username=="" || password=="" )
	{
	alert("Please enter your user name and your password");
	}
}

</script>
	
	
</head>

<body>
	<h2 style="text-align:center">Login</h2>

	<form method="post" action="LoginServlet" id="loginForm" >
		

		<div class="form-group center">
			<label for="usrname"><span class="glyphicon glyphicon-user"></span>Username</label>	<span id="aviname" style="color: red">*</span> 
			<input type="text"  id="demo1" name="name" class="form-control" 
				placeholder="Enter name">
			
		</div>
		<div class="form-group center">
			<label for="psw"><span class="glyphicon glyphicon-user"></span>Password</label> <span id="avipwd" style="color: red">*</span>
			<input type="password" id="demo2" name="password" class="form-control"
				 placeholder="Enter password">
		</div>
		<div class="checkbox center">
			<label><input type="checkbox" value="" checked>Remember
				me</label>
		</div>
		<div class="center">
		<button type="submit"  class="btn btn-default btn-success btn-block" onclick="checkIfNull()" style="align:center">
			<span class="glyphicon glyphicon-off"></span> Login
		</button>
		
		</div>
	</form>
	
	<div class="modal-footer">
		
		<p>
			Not a member? <a href="register.jsp">Sign Up</a>
		</p>
		<p>
			Forgot <a href="#">Password?</a>
		</p>
	</div>


	</form>

</body>


</html>