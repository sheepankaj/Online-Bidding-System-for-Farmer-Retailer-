<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="../../../css/profile/retailer/retailerProfile.css">

<script src="../../../js/jquery-2.2.4.min.js"></script>
<!-- <script src="js/jquery.mobile-1.4.5.min.js"></script>  -->
<script src="../../../js/profile/retailer/retailerProfile.js"></script>
<title>Retailer Profile</title>
</head>
<body>
<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'Account Details')" id="defaultOpen">Account Details</button>
  <button class="tablinks" onclick="openCity(event, 'View Product Catalogue')">View Product Catalogue</button>
  <button class="tablinks" onclick="openCity(event, 'Agree and Sign Contract')">Agree and Sign Contract</button>
  <button class="tablinks" onclick="openCity(event, 'Change Password')"id="defaultOpen">Change Password</button>
  <button class="tablinks" onclick="openCity(event, 'Logout')"id="defaultOpen">Logout</button>

   
   
   
</div>


<div id="Account Details" class="tabcontent">
		<h3>Account Details</h3>
	    <p>User Name : <input type="text" id="username"></p><br/>
		<p>User ID : <input type="text" id="ID"></p><br/>
		<p>Address:</p>
		<p>Contact Number:</p>
		<p>Registered Date:</p>
		<p>Spam:</p>
		
	</div>


<div id="View Product Catalogue" class="tabcontent">
  <h3>View Product Catalogue</h3>
        <p>Vegetables</p>
		<p>Fruits</p>
		<p>Dairy Products</p>
		<p>Meat</p>
</div>

<div id="Agree and Sign Contract" class="tabcontent">
  <h3>Agree and Sign Contract</h3>
  <p>Terms and conditions agreed and signed the contract.</p>
</div>

<div id="Change Password" class="tabcontent">
  <h3>Change Password</h3>
  <p>The Password has been changed.</p>
</div>
</body>

<div id="Logout" class="tabcontent">
  <h3>Logout</h3>
  <p>You have successfully logged out from the system. change</p>
</div>
</html>