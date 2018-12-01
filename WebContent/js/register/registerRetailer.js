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
				if(data.state == 'success')
				{
					window.location = "../../";
				}
			}
		});		 
		return false;
	});
    $( "#submitButton" ).click(function() {
    	form.submit();
    });	
    $('#password, #confirm_password').on('keyup', function (){
    	  if ($('#password').val() == $('#confirm_password').val()) 
    	  {
    	    $('#confirm_password').css('border-color', 'green');
    	    $('#submitButton').prop("disabled",false);
    	    $('#submitButton').css('background', '#f0776c');
    	  }
    	   else 
    	   {
    		$('#confirm_password').css('border-color', 'red');
       	    $('#submitButton').prop("disabled",true);
       	    $('#submitButton').css('background', '#efc4c0');
    	   }
    	    
    	});
});