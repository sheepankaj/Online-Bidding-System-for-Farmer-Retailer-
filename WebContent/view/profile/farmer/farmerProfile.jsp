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
	<div class="tab">
		<button class="tablinks" onclick="openCity(event, 'Account Details')" id="defaultOpen">Account</button>
		<button class="tablinks" onclick="openCity(event, 'Add Products')">Add Products</button>
		<button class="tablinks" onclick="openCity(event, 'Bids')">View Bids</button>
		<button class="tablinks" onclick="openCity(event, 'Contract')">Agree and Sign Contract</button>
		<button class="tablinks" onclick="openCity(event, 'Change password')">Change password</button>
		<button class="tablinks" onclick="openCity(event, 'Logout')">Logout</button>
	</div>

	<div id="Account Details" class="tabcontent">
		<h3>Account Details</h3>
		<p>Hello Farmer</p>
		<p>   </p>
		<p>ID:</p>
		<p>Name:</p>
		<p>Address:</p>
		<p>Contact Number:</p>
		<p>Registered Date:</p>
		<p>Spam:</p>
		
	</div>

	<div id="Add Products" class="tabcontent">
		<h3>Add Products</h3>
		<p>Vegetables</p>
		<p>Fruits</p>
		<p>Dairy Products</p>
		<p>Meat</p>
	</div>

	<div id="Bids" class="tabcontent">
		<h3>View Bids</h3>
		<p>Currently there are no bids for you.</p>
	</div>

	<div id="Contract" class="tabcontent">
		<h3>Tokyo</h3>
		<p>Tokyo is the capital of Japan.</p>
	</div>
</body>
</html>