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
  <button class="tablinks" onclick="openCity(event, 'Change Password')"id="defaultOpen">Change Password</button>
  <button class="tablinks" onclick="openCity(event, 'Logout')"id="defaultOpen">Logout</button>

   
   
   
</div>


<div id="Account" class="tabcontent">
  <h3>Account</h3>
  <ul style="list-style-type:circle">
  <li>Hello Retailer</li>
  <li>ID:</li>
  <li>Name:</li>
  <li>Address:</li>
  <li>Contact Details:</li>
  <li>Register Date:</li>
  <li>Spam</li>
  </ul>
</div>

<div id="View Product Catalogue" class="tabcontent">
  <h3>View Product Catalogue</h3>
  <ul style="list-style-type:circle">
  <li>Vegetables.</li> 
  <li>Fruits</li> 
  <li>Dairy Products.</li> 
  <li>Other Products.</li> 
  </ul>
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
  <p>You have successfully logged out from the system.</p>
</div>
</html>