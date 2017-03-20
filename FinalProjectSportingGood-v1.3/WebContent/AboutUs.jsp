<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>bxSlider Plugin</title>
    <!-- Normal style sheet -->
    <link href="css/styles.css" rel="stylesheet">
    <!-- bxSlider styles -->
	<link href="css/jquery.bxslider.css" rel="stylesheet">
    <!-- jQuery library -->
     <script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
    <!-- The bxSlider plugin -->
    <script src="js/jquery.bxslider.min.js"></script>
    <!-- Call to the bxSlider function -->
    <script>
    	$(document).ready(function() {
        	$("#slider").bxSlider({
			  auto: true,
			  autoControls: true,
			  captions: true,
			  minSlides: 2,
			  maxSlides: 2,
			  slideWidth: 450,
			  slideMargin: 100
			});
    	});
    </script>
</head>

<body>
    <section>
        <h1>About Us</h1>
        <p>This is online shopping website, provide you any what you want!</p>
        <ul id="slider">
            <li><img src="images/18.jpg" alt="" title="pants"></li>
            <li><img src="images/19.jpg" alt="" title="sunglasses"></li>
            <li><img src="images/20.jpg" alt="" title="legging"></li>
            <li><img src="images/22.jpg" alt="" title="outwear"></li>
            <li><img src="images/23.jpg" alt="" title="T-shirt"></li>
        </ul>
    </section>
</body>
</html>
