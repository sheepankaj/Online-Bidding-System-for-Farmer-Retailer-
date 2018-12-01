<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../css/main.css">
<script src="../../js/jquery-2.2.4.min.js"></script>
<!-- <script src="js/jquery.mobile-1.4.5.min.js"></script>  -->
<script src="../../js/register/registerFarmer.js"></script>
<title>Register</title>
</head>
<body>
	<form class="form" action="../../RegisterFarmerForm" method="post" id="registerFarmer">
		<h1 class="form-title">Register</h1>
		<input type="text" class="form-input" placeholder="Username" autofocus name="username"> 
		<input type="password" class="form-input" placeholder="Password" name="password" id="password"> 
		<input type="password" class="form-input" placeholder="Retype-password" name="retype_password" id="confirm_password"> 
		<input type="text" class="form-input" placeholder="Farm Address" autofocus name="farmAddress"> 
		<input type="text" class="form-input" placeholder="Telephone" autofocus name="telephone">
		<input type="button" value="Submit" class="login-button" id="submitButton">
	</form>
</body>
</html>