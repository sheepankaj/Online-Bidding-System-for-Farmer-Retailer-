$( document ).ready(function() {
	var form = $('#loginForm');
	form.submit(function (e) 
	{	
		$.ajax(
		{
			type: form.attr('method'),
			url: form.attr('action'),
			data: form.serialize(),
			success: function (data) 
			{
				if(data.page == "FARMER")
				{
					window.location = 'view/profile/farmer/farmerProfile.jsp';
				}
				else if(data.page == "ADMIN")
				{
					window.location = 'view/profile/admin/adminProfile.jsp';
				}
				else if(data.page == "RETAILER")
				{
					window.location = 'view/profile/retailer/retailerProfile.jsp';
				}
			}
		});		 
		return false;
	});
    $( "#submitButton" ).click(function() {
    	form.submit();
    });	
});