	
$( document ).ready(function() {
	
	// Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click();
	var acceptBidForm = $('#acceptBidForm');
	acceptBidForm.submit(function (e) 
	{	
		$.ajax(
		{
			type: acceptBidForm.attr('method'),
			url: acceptBidForm.attr('action'),
			data: acceptBidForm.serialize(),
			success: function (data) 
			{
				alert(data);
			}
		});		 
		return false;
	});
    $( "#acceptBidButton" ).click(function() {
    	acceptBidForm.submit();
    });	
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
    				url: '../../../FarmerProfileLoaderRequest',
    				data: 'l',
    				success: function (data,message) 
    				{
    					alert("You have logged in successfully!!!");
    					if(data.page=="farmer")   {
    						
    						$('#username').val(data.page);
    						$('#ID').val(data.id);
    						$('#address').val(data.address);
    						$('#telephone').val(data.telephone);
    						$('#spam').val(data.spam);
    						$('#priority').val(data.priority);
    					}
    				}
    			});		
    	}
    else if(eventName=="Add Products"){
    	
    	$.post('../../../FarmerProfileLoaderRequest',
    		    {
    		        tabEvent: eventName
    		    },
    		    function(data, status){
    		       // alert("Data: " + data + "\nStatus: " + status);
    		        $.each(data,function(key,value)
    		                {
    		                    var option = $('<option />').val(value.productID).text(value.name);
    		               $("#product-dropdown").append(option);
    		                });
    		        
    		    });
    }	
    else if(eventName=="Bids")
	{
    	$.post('../../../BidsController',
    		    {
    		        tabEvent: eventName
    		    },
    		    function(data, status){
    		       // alert("Data: " + data + "\nStatus: " + status);
    		        $.each(data,function(key,value)
    		                {
    		                    var option = $('<option />').val(value.bidID).text("[Product : "+value.productStock.product.name+"][Agreed : "+value.agreedFinalPrice+"][Your Price : "+value.productStock.unitPrice+"]");
    		               $("#bids-dropdown").append(option);
    		                });
    		        
    		    });
	}
    else
    	{
    	z
    	}
    evt.currentTarget.className += " active";
}


