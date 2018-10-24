$( document ).ready(function() {
	var form = $('#registerRetailer');
	form.submit(function (e) 
	{	
		$.ajax(
		{
			type: form.attr('method'),
			url: form.attr('action'),
			data: form.serialize(),
			success: function (data) 
			{
				alert(data.message);	   
			}
		});		 
		return false;
	});
    $( "#submitButton" ).click(function() {
    	form.submit();
    });	
});