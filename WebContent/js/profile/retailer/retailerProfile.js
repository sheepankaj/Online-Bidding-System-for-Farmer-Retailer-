
$( document ).ready(function() {
	
	// Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click();
	var placeBidForm = $('#placeBidForm');
	placeBidForm.submit(function (e) 
	{	
		$.ajax(
		{
			type: placeBidForm.attr('method'),
			url: placeBidForm.attr('action'),
			data: placeBidForm.serialize(),
			success: function (data) 
			{
				
			}
		});		 
		return false;
	});
    $( "#submitViewContract" ).click(function() {
    	placeBidForm.submit();
    });
    var proceedToPaymentForm = $('#proceedToPaymentForm');
    proceedToPaymentForm.submit(function (e) 
	{	
		$.ajax(
		{
			type: proceedToPaymentForm.attr('method'),
			url: proceedToPaymentForm.attr('action'),
			data: proceedToPaymentForm.serialize(),
			success: function (data) 
			{
				alert(data.message);
			}
		});		 
		return false;
	});
    $( "#submitContractPayment" ).click(function() {
    	proceedToPaymentForm.submit();
    });	
    var addFundsForm = $('#addFundsForm');
    addFundsForm.submit(function (e) 
	{	
		$.ajax(
		{
			type: addFundsForm.attr('method'),
			url: addFundsForm.attr('action'),
			data: addFundsForm.serialize(),
			success: function (data) 
			{
				alert(data.message);
			}
		});		 
		return false;
	});
    $( "#submitAddFundsForm" ).click(function() {
    	addFundsForm.submit();
    });	
    var searchProductStockForm = $('#searchProductStockForm');
    searchProductStockForm.submit(function (e) 
	{	
		$.ajax(
		{
			type: searchProductStockForm.attr('method'),
			url: searchProductStockForm.attr('action'),
			data: searchProductStockForm.serialize(),
			success: function (data) 
			{
				var sortedData = sortByKey(data, 'priority');
				$('#searchResults').html('');
				$.each(sortedData,function(key,value)
                {
					if( $('#searchResults').is(':empty') ) {
						$('#searchResults').append(
						'<div id="result_'+key+'" style="border: 1px solid black;">'+'Qty : ['+value["quantitiy"]+']<br>'+'Frequency : ['+value["frequency"]+']<br>'+'UnitPrice : ['+value["unitPrice"]+']<br>'+'FarmerID : ['+value["farmerID"]+']<br>'+'ProductStockID : ['+value["productStockID"]+']<br></div>');
					}
					else
					{
						var div=$('<div id="result_'+key+'" style="border: 1px solid black;">'+'Qty : ['+value["quantitiy"]+']<br>'+'Frequency : ['+value["frequency"]+']<br>'+'UnitPrice : ['+value["unitPrice"]+']<br>'+'FarmerID : ['+value["farmerID"]+']<br>'+'ProductStockID : ['+value["productStockID"]+']<br></div>');
						var sopra=$('#result_'+(key-1));
						$( sopra ).after( div );
					}
                });
			}
		});		 
		return false;
	});
    $( "#submitSearchProductStock" ).click(function() {
    	searchProductStockForm.submit();
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
    				url: '../../../RetailerProfileLoaderRequest',
    				data: 'l',
    				success: function (data) 
    				{
    					alert("You have logged in successfully!!!");
    					if(data.page=="sulthan")   {
   						
    						$('#username').val(data.page);
    						$('#ID').val(data.id);
    						$('#address').val(data.address);
    						$('#tel').val(data.tel);
    						$('#spam').val(data.spam);
    					}
    				}
    			});		
    	}
    else if(eventName=="View Product Catalogue")
	{
    	$.post('../../../RetailerProfileLoaderRequest',
    		    {
    		        tabEvent: eventName
    		    },
    		    function(data, status)
    		    {
    		       // alert("Data: " + data + "\nStatus: " + status);
    		    	$('#product-dropdown').html('');
    		    	var empty = $('<option />').val("-1").text("--Select--");
    		    	$("#product-dropdown").append(empty);
    		        $.each(data,function(key,value)
	                {
	                    var option = $('<option />').val(value.productID).text(value.name);
	                    $("#product-dropdown").append(option);
	                });    		        
    		    });
	}
    else if(eventName=="Manage Contracts")
	{
		// try to print a contract
    	$.post('../../../RetailerProfileLoaderRequest',
    		    {
    		        tabEvent: eventName
    		    },
    		    function(data, status)
    		    {
    		    	$('#productCategory-dropdown').html('');
    		    	var empty = $('<option />').val("-1").text("--Select--");
   		    	    $("#productCategory-dropdown").append(empty);
    		        $.each(data,function(key,value)
	                {
    		        	var option = $('<option />').val(value.productID).text(value.name);
	        	     	$("#productCategory-dropdown").append(option);
	                });
    		        
    		    });	
	}
    else if(eventName=="Manage Payments")
	{
    	$.post('../../../RetailerProfileLoaderRequest',
    		    {
    		        tabEvent: eventName
    		    },
    		    function(data, status)
    		    {
    		    	$('#contract-dropdown').html('');
    		    	var empty = $('<option />').val("-1").text("--Select--");
   		    	    $("#contract-dropdown").append(empty);
    		        $.each(data.contracts,function(key,value)
	                {
    		        	var option = $('<option />').val(value.contractID).text('[Product :'+value.agreedBid.productStock.product.name+']'+'[Qty :'+value.agreedBid.productStock.quantitiy+']'+'[Agreed Price :'+value.agreedBid.agreedFinalPrice+']');
	        	     	$("#contract-dropdown").append(option);
	                });
    		        
    		        $('#account-dropdown').html('');
    		    	var empty = $('<option />').val("-1").text("--Select--");
   		    	    $("#account-dropdown").append(empty);
    		        $.each(data.accounts,function(key,value)
	                {
    		        	var option = $('<option />').val(value.accountNumber).text(value.accountType);
	        	     	$("#account-dropdown").append(option);
	                });
    		        
    		        $('#addfunds-dropdown').html('');
    		    	var empty = $('<option />').val("-1").text("--Select--");
   		    	    $("#addfunds-dropdown").append(empty);
    		        $.each(data.accounts,function(key,value)
	                {
    		        	var option = $('<option />').val(value.accountNumber).text(value.accountType);
	        	     	$("#addfunds-dropdown").append(option);
	                });
    		        
    		    });	
	}
    else if(eventName=="Change Password")
	{
	
	}
    else
	{
	
	}
    evt.currentTarget.className += " active";
}

function sortByKey(array, key) {
	return array.sort(function(a, b) {
	    var x = a[key]; var y = b[key];
	    return ((x < y) ? -1 : ((x > y) ? 1 : 0));
	});
	}


