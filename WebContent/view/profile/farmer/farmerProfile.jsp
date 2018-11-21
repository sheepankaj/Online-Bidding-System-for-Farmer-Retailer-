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
<h1 class="form-title" align="center">Welcome <%= session.getAttribute("username") %> </h1>
<p align="right"> <button class="button" form="form1">logout</button></p>

	<div class="tab">
		<button class="tablinks" onclick="openCity(event, 'Account Details')" id="defaultOpen">Account</button>
		<button class="tablinks" onclick="openCity(event, 'Add Products')">Add Products</button>
		<button class="tablinks" onclick="openCity(event, 'Bids')">View Bids</button>
		<button class="tablinks" onclick="openCity(event, 'Contract')">Agree and Sign Contract</button>
		<button class="tablinks" onclick="openCity(event, 'Change password')">Change password</button>
	</div>

	<div id="Account Details" class="tabcontent">
		<h3>Account Details</h3>
		<p>User ID : <input type="text" id="ID"></p><br/>
		<p>User Name :<input type="text" id="username"></p><br/>
		<p>Address:<input type="text" id="address"></p><br/>
		<p>Contact Number:<input type="text" id="telephone"></p><br/>
		<p>Spam:<input type="text" id="spam"></p><br/>
		
		
	</div>
	<form method="post" action="FarmerProfileLoaderRequest">
	<div id="Add Products" class="tabcontent">
		<p>Choose products from below drop down</p><select id="product-dropdown">
		 <option value="" disabled selected>---Select your option---</option></select>
		 <div>
		<p>Specify total Quantity : <input type="text" id="quantity"></p><br/>
		<p>Price of the product: <input type="text" id="price"></p><br/>
		</div>
		<input type="button" value="Submit">
	</div>
	</form>
    <form method="post" action="../../../BidsController" id="acceptBidForm"  target="_blank">    
		<div id="Bids" class="tabcontent">
			<select id="bids-dropdown" name="bids-dropdown"></select>
			<input type="button" value="Accept Bid" id="acceptBidButton">
		</div>
    </form>
	<div id="Contract" class="tabcontent">
		<h3>Manage Contracts</h3>
		<p>sign the contract.</p>
	</div>
	
	<div id="Change password" class="tabcontent">
		<h3>Change password</h3>
		<p>Enter old password:<input type="text" id="old password"></p><br/>
		<p>Enter new password:<input type="text" id="new password"></p><br/>
		<input type="button" value="Submit">		
	</div>
	
  
  <form id="form1" action="${pageContext.request.contextPath}/" method="post">
  </form>
</body>
</html>