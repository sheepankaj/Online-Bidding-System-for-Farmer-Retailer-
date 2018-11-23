<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="../../../css/profile/admin/adminProfile.css">

<script src="../../../js/jquery-2.2.4.min.js"></script>
<!-- <script src="js/jquery.mobile-1.4.5.min.js"></script>  -->
<script src="../../../js/profile/admin/adminProfile.js"></script> 
<title>Admin Profile</title>
</head>
<body>


<h1 class="form-title">Welcome <span id = "username" > <%= session.getAttribute("username") %> </span></h1>


<div class="tab">

  <button class="tablinks" onclick="openCity(event, 'Generate Report')" id="defaultOpen">Generate Report</button>
  <button class="tablinks" onclick="openCity(event, 'Spams')">Spam</button>
  <button class="tablinks" onclick="openCity(event, 'Verify')">Verification</button>
  <button class ="tablinks" onclick="openCity(event, 'Password Change')">Password Change</button>
  <button class="tablinks" onclick="openCity(event, 'Logout')">Logout</button>
  
  
</div>

<!--  <div id="Generate Report" class="tabcontent">
  <h3>Report</h3>
  <p>It will generate business reports on daily, weekly, monthly, quarterly and yearly basis.</p>
  <button class="tablinks" onclick="">Contract Report</button>
  <button class="tablinks" onclick="">Bidding Report</button>
  
  <button class="tablinks" onclick="">Daily</button>
  <button class="tablinks" onclick="">Weekly</button>
  <button class="tablinks" onclick="">Monthly</button>
  <button class="tablinks" onclick="">Quarterly</button>
  <button class="tablinks" onclick="">Yearly</button>
  
</div>-->


<div id="Generate Report" class="tabcontent">
  <h3>Report</h3>
  <p>It will generate business reports on daily, weekly, monthly, quarterly and yearly basis.</p>
  <button class="tablinks" onclick="return showdet();">Contract Report</button>
  <button class="tablinks" onclick="return showdet();">Bidding Report</button>
  <div id='showvars' style="display:none;">
	  <button class="tablinks" onclick="">Daily</button>
	  <button class="tablinks" onclick="">Weekly</button>
	  <button class="tablinks" onclick="">Monthly</button>
	  <button class="tablinks" onclick="">Quarterly</button>
	  <button class="tablinks" onclick="">Yearly</button>
  </div>
</div>




<div id="Spams" class="tabcontent">
  <h3>Remove Spams</h3>
  <button class="tablinks" onclick="">Add Farmer/Retailer</button>
  <p>It will remove the spam farmers and retailers.</p> 
  
 <table class="table">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Action</th>
      </tr>
    </thead>
    
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
        <td><button class="tablinks" onclick="">Remove</button></td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
        <td><button class="tablinks" onclick="">Remove</button></td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
        <td><button class="tablinks" onclick="">Remove</button></td>
      </tr>
    </tbody>
  </table>
 
 
 
 
 
</div>

<div id="Verify" class="tabcontent">
  <h3>Verify Farmer</h3>
  <button class="tablinks" onclick="">Approve Farmer/Retailer</button>
  <p>Verification status of Farmers will display.</p>
  <table class="table">
    <thead>
      <tr>
      	<th>UserID</th>
      	<th>Profile Type</th>
        <th>Username</th>
        <th>Address</th>
        <th>Contact Number</th>
        <th>Action</th>
      </tr>
    </thead>
    
    <tbody>
      <tr>
        <td><p><input type="text" class="userid"></p><br/></td>
        <td><p><input type="text" class="Profiletype"></p><br/></td>
        <td><p><input type="text" class="Username"></p><br/></td>
        <td><p><input type="text" class="address"></p><br/></td>
        <td><p><input type="text" class="telephone"></p><br/>
        <td><button class="tablinks" onclick="">Terminate</button></td>
      </tr>
      
      <tr>
        <td><p><input type="text" class="userid"></p><br/></td>
        <td><p><input type="text" class="Profiletype"></p><br/></td>
        <td><p><input type="text" class="Username"></p><br/></td>
        <td><p><input type="text" class="address"></p><br/></td>
        <td><p><input type="text" class="telephone"></p><br/>
        <td><button class="tablinks" onclick="">Terminate</button></td>
      </tr>
      <tr>
        <td><p><input type="text" class="userid"></p><br/></td>
        <td><p><input type="text" class="Profiletype"></p><br/></td>
        <td><p><input type="text" class="Username"></p><br/></td>
        <td><p><input type="text" class="address"></p><br/></td>
        <td><p><input type="text" class="telephone"></p><br/>
        <td><button class="tablinks" onclick="">Terminate</button></td>
      </tr>
    </tbody>
  </table>
  
  <h3>Verify Retailer</h3>
  <button class="tablinks" onclick="">Approve Farmer/Retailer</button>
  <p>Verification status of Retailers will display.</p>
  
  <table class="table">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Action</th>
      </tr>
    </thead>
    
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
        <td><button class="tablinks" onclick="">Terminate</button></td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
        <td><button class="tablinks" onclick="">Terminate</button></td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
        <td><button class="tablinks" onclick="">Terminate</button></td>
      </tr>
    </tbody>
  </table>
  </div>
  
  <div id="Password Change" class="tabcontent">
  <h3>Password Changed</h3>
  </div>
  
  <div id="Logout" class="tabcontent">
  <h3>Logout</h3>
  
  <form action="${pageContext.request.contextPath}/" method="post">
    <input type="submit" value="Logout" />
  </form>
    
    <p>When clicked on logout button, You will successfully logged out from the system.</p>
  
</div>
</body>
</html>



<script type="text/javascript">

function showdet(){
	$("#showvars").css("display","block");
}


</script>

