<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../css/main.css">
<title>Register</title>
</head>
<body>

<form class="form">
   	<h1 class="form-title">Register</h1>
    <input type="text" class="form-input" placeholder="Username" autofocus>
    <input type="password" class="form-input" placeholder="Password">
    <input type="text" class="form-input" placeholder="Business Name" autofocus>
    <input type="text" class="form-input" placeholder="Business Address" autofocus>
    <select class="form-input" style="width:297px; height:33px;" >
	  <option value="0">-- Select --</option>
	  <option value="1">Retailer</option>
	  <option value="2">Farmer</option>
	</select>
    <input type="submit" value="Submit" class="login-button">
</form>

</body>
</html>