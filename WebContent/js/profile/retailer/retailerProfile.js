
$( document ).ready(function() {
	
	// Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click();
});
function openCity(evt, eventName) {
	
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(eventName).style.display = "block";
    if(eventName == 'Account Details')
    	{
    	$.ajax(
    			{
    				type: 'POST',
    				url: '../../../RetailerProfileLoaderRequest',
    				data: 'l',
    				success: function (data) 
    				{
    					if(data.page=="retailer")   {
//    						var obj = JSON.parse(data.page);
//
//    						document.getElementById("Account Details").innerHTML =
//    						"Name: " + obj.username;
    						$('#username').val(data.page);
    						$('#ID').val(data.id);
    					}
    				}
    			});		
    	}
    else if(eventName=="View Product Catalogue")
	{
	
	}
    else if(eventName=="Manage Contracts")
	{
		// try to print a contract
    	$.post('../../../RetailerProfileLoaderRequest',
    		    {
    		        tabEvent: eventName
    		    },
    		    function(data, status){
//    		        alert("Data: " + data + "\nStatus: " + status);
//    		        $.each(data,function(key,value)
//    		                {
//    		                    var option = $('<option />').val(value.productID).text(value.name);
//    		               $("#product-dropdown").append(option);
//    		                });
    		        
    		    });	
	}
    else if(eventName=="Change Password")
	{
	
	}
    else
    	{
    	//z
    	}
    evt.currentTarget.className += " active";
}


