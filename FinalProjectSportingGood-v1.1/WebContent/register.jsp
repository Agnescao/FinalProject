<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
    	* {
    		margin: 0;
    		padding: 0;
    	}
		body {
			font: 87.5% Arial, Helvetica, sans-serif;
			width: 500px;
		    margin: 20px auto;
		    padding: 20px;
		    border: 2px solid blue;
		}
		h1 {
			color: blue; 
			font-size: 140%;
		}
		h2 {
			font-size: 115%;
			padding: .5em 0;
		}
		label {
			color: blue;
			float: left;
			width: 8em;
			font-weight: bold;
			text-align: left;
		}
		input {
			width: 15em;
			margin: 0 0 .5em 1em;
			required;
		}
		input:focus {
				border: 2px solid ; }
		input:invalid{border: 2px solid red; }
		input:valid{border: 2px solid green; }
		input[type="checkbox"]{ width:1em; }
		#button, #reset {
			width: 7em;
			background-color: silver;
			box-shadow: 2px 2px 0 blue; }
		#button {
			margin-left: 9em;
		}
	</style>
</head>

<body>
<h1>Please complete our details</h1>
<form name="myform" method="post" action="RegisterServlet">
	
	
	
	<label for="name">Name:</label>
    <input type="text" id="n" name="name" autofocus required><br>
   <label for="pwd">Password:</label>
   <input type="password" id="pwd" name="password" min="8" required  placeholder="Please enter more than 8 characters !"> <br>
	<label for="email">Email:</label>
	<input type="email" id="e" name="email" required> <br>
	<label for="phone">Phone:</label>
	<input type="number" id="p" name="phone" required> <br>	
	<label for="address">Address:</label>
	<input type="text"id="add" name="address" required> <br>	
	<label for="city">City:</label>
	<input type="text" id="c" name="city" required> <br>		
		
	
    <input type="submit" name="register" id="button" value="Submit">
    <input type="reset" name="reset" id="reset" value="Reset"> 
    
</form>

</body>

</html>