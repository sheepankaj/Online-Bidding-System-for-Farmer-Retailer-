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

<h1 class="form-title" align="center">Welcome <%= session.getAttribute("username") %> </h1>
<p align="right"> <button class="button" form="form2">logout</button></p>
<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'Account Details')" id="defaultOpen">Account Details</button>
  <button class="tablinks" onclick="openCity(event, 'View Product Catalogue')">View Product Catalogue</button>
  <button class="tablinks" onclick="openCity(event, 'Manage Contracts')">Manage Contracts and Bids</button>
  <button class="tablinks" onclick="openCity(event, 'Manage Payments')">Manage Payments</button>
  <button class="tablinks" onclick="openCity(event, 'Change Password')">Change Password</button>
</div>


<div id="Account Details" class="tabcontent">
		<h3>Account Details</h3>
	    <p>User Name : <input type="text" id="username"></p><br/>
		<p>User ID : <input type="text" id="ID"></p><br/>
		<p>Address:<input type="text" id="address"></p><br/>
		<p>Contact Number:<input type="text" id="tel"></p><br/>
		<p>Spam:<input type="text" id="spam"></p><br/>
		
	</div>


<div id="View Product Catalogue" class="tabcontent">
  <h3>View Product Catalogue</h3>
  <div style="width: 200px; margin-right: 10px; float:left;">
	  <form method="post" action="../../../RetailerProfileLoaderRequest" id="searchProductStockForm">
	        <select id="product-dropdown" class="input_class" name="product-dropdown"><option value="" disabled selected>---Select your option---</option></select><br>
	        <select id="frequency-dropdown" name="frequency-dropdown" class="input_class">
			  <option value="DAILY">DAILY</option>
			  <option value="WEEKLY">WEEKLY</option>
			  <option value="MONTHLY">MONTHLY</option>
			  <option value="YEARLY">YEARLY</option>
			</select><br>
			<input type="text" id="quantity" name="quantity" placeholder="Quantity(t)" class="input_class"><br>	
			<!-- <input type="text" id="price" name="price" placeholder="Price" class="input_class"><br>	 -->
			<input type="button" value="Search Stock" id="submitSearchProductStock" name="submitSearchProductStock" class="input_class"/>
	   </form>
   </div>
   <div id="searchResults" style="width: 400px; height:600px; float:left; "></div>
</div>

<div id="Manage Contracts" class="tabcontent">
    <div id="place_bid_div" style="width: 200px; margin-right: 10px; float:left;">
    	<h4>Place a bid</h4>
	    <form method="post" action="../../../BidsController" id="placeBidForm">	
			<select id="productCategory-dropdown" name="productCategory-dropdown" class="input_class"></select><br>
			<select id="frequency-dropdown" name="frequency-dropdown" class="input_class">
			  <option value="DAILY">DAILY</option>
			  <option value="WEEKLY">WEEKLY</option>
			  <option value="MONTHLY">MONTHLY</option>
			  <option value="YEARLY">YEARLY</option>
			</select><br>
			<input type="text" id="quantity" name="quantity" placeholder="Quantity(t)" class="input_class"><br>	
			<input type="text" id="price" name="price" placeholder="Price" class="input_class"><br>	
			<input type="button" value="Place Bid" id="submitViewContract" class="input_class"/>	
		</form>
    </div>
    
</div>

<div id="Change Password" class="tabcontent">
		<h3>Change password</h3>
		<p>Enter old password:<input type="text" id="old password"></p><br/>
		<p>Enter new password:<input type="text" id="new password"></p><br/>
		<input type="button" value="Submit">		
</div>

<div id="Manage Payments" class="tabcontent">
	<div id="proceedToPayment" style="width: 300px; margin-right: 10px;">
   		<h4>Select a Contract and proceed to payment</h4>
	    <form method="post" action="../../../PaymentController" id="proceedToPaymentForm">	
			<select id="contract-dropdown" name="contract-dropdown" class="input_class"></select><br>
			<select id="account-dropdown" name="account-dropdown" class="input_class"></select><br>
			<input type="button" value="Proceed" id="submitContractPayment" class="input_class"/>	
		</form>
   	</div>	
   	<div id="fundsAdding" style="width: 300px; margin-right: 10px; float:left;">
   		<h4>Add funds</h4>
	    <form method="post" action="../../../PaymentController" id="addFundsForm">	
	        <select id="addfunds-dropdown" name="addfunds-dropdown" class="input_class"></select><br>
			<input type="text" id="fundAmount" name="fundAmount" placeholder="Amount" class="input_class"><br>
			<input type="button" value="Add" id="submitAddFundsForm" class="input_class"/>	
		</form>
   	</div>
</div>
	


<div id="Logout" class="tabcontent">
  <h3>Logout</h3>
  
  
</div>

  <form id="form2" action="${pageContext.request.contextPath}/" method="post">
  </form>
</body>
</html>