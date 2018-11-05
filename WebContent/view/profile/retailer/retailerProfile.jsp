<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="../../../css/profile/retailer/retailerProfile.css">

<script src="../../../js/jquery-2.2.4.min.js"></script>
<!-- <script src="js/jquery.mobile-1.4.5.min.js"></script>  -->
<script src="../../../js/profile/retailer/retailerProfile.js"></script> 
<title>Admin Profile</title>
</head>
<body>
<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'Account')" id="defaultOpen">Account</button>
  <button class="tablinks" onclick="openCity(event, 'View Product Catalogue')">View Product Catalogue</button>
  <button class="tablinks" onclick="openCity(event, 'Agree and Sign Contract')">Agree and Sign Contract</button>
</div>

<div id="Account" class="tabcontent">
  <h3>Account</h3>
  <p>Hello Retailer.</p>
</div>

<div id="View Product Catalogue" class="tabcontent">
  <h3>View Product Catalogue</h3>
  <p>View Bids.</p> 
</div>

<div id="Agree and Sign Contract" class="tabcontent">
  <h3>Agree and Sign Contract</h3>
  <p>Terms and conditions agreed and signed the contract.</p>
</div>
</body>
</html>