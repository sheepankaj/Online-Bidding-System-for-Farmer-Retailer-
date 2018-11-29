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
	<div id="Add Products" class="tabcontent">
		<div id="submit_stock_div" style="width: 200px; margin-right: 10px; float:left;">
			    	<h4>Add a product stock</h4>
				    <form method="post" action="../../../FarmerProfileLoaderRequest" id="submitProductForm">	
						<select id="product-dropdown" name="product-dropdown"" class="input_class"></select><br>
						<select id="frequency-dropdown" name="frequency-dropdown" class="input_class">
						  <option value="DAILY">DAILY</option>
						  <option value="WEEKLY">WEEKLY</option>
						  <option value="MONTHLY">MONTHLY</option>
						  <option value="YEARLY">YEARLY</option>
						</select><br>
						<input type="text" id="quantity" name="quantity" placeholder="Quantity(t)" class="input_class"><br>	
						<input type="text" id="price" name="price" placeholder="Price" class="input_class"><br>	
						<input type="button" value="Submit Stock" id="submitProductStock" class="input_class"/>	
					</form>
		</div>
</div>
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
	<form method="post" action="FarmerProfileLoaderRequest" id="passwordForm">
	<div id="Change password" class="tabcontent">
		<h3>Change password</h3>
		<p>Enter old password:<input type="text" name="old password"></p><br/>
		<p>Enter new password:<input type="text" name="new password"></p><br/>
		<input type="button" value="Submit" id="submitPasswordForm">
	</div>
	</form>
	<div class='error' style='display:none'id="notificationText"></div>
  
  <form id="form1" action="${pageContext.request.contextPath}/" method="post">
  </form>
</body>
</html>