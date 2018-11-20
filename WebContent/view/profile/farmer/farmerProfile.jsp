<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="../../../css/profile/farmer/farmerProfile.css">

<script src="../../../js/jquery-2.2.4.min.js"></script>
<!-- <script src="js/jquery.mobile-1.4.5.min.js"></script>  -->
<script src="../../../js/profile/farmer/farmerProfile.js"></script>
<title>Farmer Profile</title>
</head>
<body>

<h1 class="form-title">Welcome <span id = "username" > </span> <input type="submit" value="Logout" /></h1>

	<div class="tab">
		<button class="tablinks" onclick="openCity(event, 'Account Details')" id="defaultOpen">Account</button>
		<button class="tablinks" onclick="openCity(event, 'Add Products')">Add Products</button>
		<button class="tablinks" onclick="openCity(event, 'Bids')">View Bids</button>
		<button class="tablinks" onclick="openCity(event, 'Contract')">Agree and Sign Contract</button>
		<button class="tablinks" onclick="openCity(event, 'Change password')">Change password</button>
	</div>

	<div id="Account Details" class="tabcontent">
		<h3>Account Details</h3>
		<p>User Name : <input type="text" id="username"></p><br/>
		<p>User ID : <input type="text" id="ID"></p><br/>
		<p>Address:<input type="text" id="addr"></p><br/>
		<p>Contact Number:</p>
		<p>Registered Date:</p>
		<p>Spam:</p>
		
	</div>
	<form method="post" action="FarmerProfileLoaderRequest">
	<div id="Add Products" class="tabcontent">
		<select id="product-dropdown"></select>
		<p>Quantity : <input type="text" id="quantity"></p><br/>
		<p>Product Price : <input type="text" id="price"></p><br/>
		<input type="button" value="Submit">
	</div>
	</form>

	<div id="Bids" class="tabcontent">
		<h3>View Bids</h3>
		<p>Currently there are no bids for you.</p>
	</div>

	<div id="Contract" class="tabcontent">
		<h3>Manage Contracts</h3>
		<p>sign the contract.</p>
	</div>
	
	<div id="Logout" class="tabcontent">
  <h3>Logout</h3>
  
  <form action="${pageContext.request.contextPath}/" method="post">
    <input type="submit" value="Logout" />
   
 </form>
 </div>
</body>
</html>