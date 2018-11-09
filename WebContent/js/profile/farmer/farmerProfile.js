
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
    				url: '../../../FarmerProfileLoaderRequest',
    				data: 'l',
    				success: function (data) 
    				{
    					alert(data.message);	   
    				}
    			});		
    	}
    else if(eventName=="Add Products")
    	{
    	
    	}
    else if(eventName=="Bids")
    	{
    	
    	}
    else
    	{
    	
    	}
    evt.currentTarget.className += " active";
}


