
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
if(eventName == 'Verify')
{
    	
    	$.post('../../../AdminProfileLoaderRequest',
    		    {
    		        tabEvent: eventName
    		    },
    		    function(data, status){
    		        //alert("Data: " + data + "\nStatus: " + status);lll
    		        $.each(data,function(key,value)
    		                {
    		        			if(value.profileType=="FARMER"){
    		        				
    		        				var i=2;
    		        				  $(".Addmore").on('click',function(){
    		        				    var data="<tr><td><input type='checkbox' class='case'/></td><td>"+i+".</td>";
    		        				        data +="<td><input type='text' id=$('#userid').val(value.userID)"+i+"/></td> <td><input type='text' id='Profiletype"+i+"/></td><td><input type='text' id='Username"+i+"/></td><td><input type='text' id='address"+i+"/></td><td><input type='text' id='telephone"+i+"/></td></tr>";
    		        				        $('table').append(data);
    		        				        i++;
    		        				       
    		        				});
    		        				  $(".delete").on('click', function() {
    		        						$('.case:checkbox:checked').parents("tr").remove();
    		        					    $('.check_all').prop("checked", false); 
    		        						check();

    		        					});
    		        				  function select_all() {
    		        						$('input[class=case]:checkbox').each(function(){ 
    		        							if($('input[class=check_all]:checkbox:checked').length == 0){ 
    		        								$(this).prop("checked", false); 
    		        							} else {
    		        								$(this).prop("checked", true); 
    		        							} 
    		        						});
    		        					}

    		        					function check(){
    		        						obj=$('table tr').find('span');
    		        						$.each( obj, function( key, value ) {
    		        						id=value.id;
    		        						$('#'+id).html(key+1);
    		        						});
    		        						}
    		        			
    		        			/*
    		                    $(".userid").val(value.userID);
    		                    $(".Profiletype").val(value.profileType);
    		                    $(".Username").val(value.username);
    		                    $(".address").val(value.farmAddress);
    		                    $(".telephone").val(value.telephone);
    		                    */
    		        			} else if(value.profileType=="RETAILER"){
        		        			
        		        			
        		                    $(".Userid").val(value.userID);
        		                    $(".profiletype").val(value.profileType);
        		                    $(".username").val(value.username);
        		                    $(".Address").val(value.retailAddress);
        		                    $(".Telephone").val(value.telephone);

        		        			}
    		        		
    		                    
    		                });
    		        
    		    });
    }	
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






