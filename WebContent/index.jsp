<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport"
	content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="css/jquery.mobile-1.4.5.min.css">-->



<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/jquery-2.2.4.min.js"></script>
<!-- <script src="js/jquery.mobile-1.4.5.min.js"></script>  -->
<script src="js/login/login.js"></script>
<title>Login</title>
</head>
<body>



	<form class="form" action="LoginForm" method="post" id="loginForm">
		<h1 class="form-title">User Login</h1>
		<input type="text" class="form-input" placeholder="Username" autofocus
			name="username"> <input type="password" class="form-input"
			placeholder="Password" name="password"> <input type="button"
			value="Sign In" class="login-button" id="submitButton" />
		<p class="login-lost">
			<a href="view/register/registerRetailer.jsp">Register for a
				Retailer</a> <a href="view/register/registerFarmer.jsp">| Register
				for a Farmer</a>
		</p>
	</form>
	<!-- <div data-role="page">
  
        <div data-role="header">
            <h1>Login</h1>
        </div>/header
 
        <div role="main" class="ui-content">
            <p>Hello world</p>
        </div>/content
 
        <div data-role="footer">
            <h4></h4>
        </div>/footer
 
    </div>/page -->

</body>
</html>