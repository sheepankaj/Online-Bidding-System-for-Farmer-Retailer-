
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
    if(eventName == 'Generate Report')
	{
    	loadGenerateReportTab();
	}
    evt.currentTarget.className += " active";



document.getElementById(eventName).style.display = "block";
	if(eventName == 'Product')
	{
		
		$.post('../../../AdminProfileLoaderRequest',
	    {
	        tabEvent: eventName
	    },
	    function(data, status)
	    {
	       $.each(data,function(key,value)
	        {
	    	    var buttonText = (value["disabled"])? 'Enable':'Disable';
	        	var newRow = '<tr><td>'+value["productID"]+'</td><td>'+value["name"]+'</td><td><button class="tablinks" id="action_button_'+value["productID"]+'" onclick="disableProduct(\''+value["productID"]+'\')">'+buttonText+'</button></td></tr>';
	            $("#product_table tbody").append(newRow);  
	        });    		        
	    });
	}	
}

function disableProduct(productID)
{
	$.post('../../../AdminProfileLoaderRequest',
		    {
		        disableProduct: productID
		    },
		    function(data, status)
		    {
		       alert(data.message);	  
		       $("#action_button_"+productID).html(data.changedto);
		    });
}
function loadGenerateReportTab()
{
	
	$.ajax(
			{
				type: 'POST',
				
				url: '../../../AdminProfileLoaderRequest',
				data: 'l',
				success: function (data) 
				{
					alert(data.message);	   
				}
			});	

		}






