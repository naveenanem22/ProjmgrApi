
$(document).ready(function(){
	
	$('.resourceskillcat0').change(function(){
		
			$('.resourceskill0 > option').remove();
			$('.resourceskill0').append('<option value="select">SELECT</option>');
		$.ajax({ 
		    type: 'POST', 
		    url: '/ProjectManagementTool/loadresourceskill',
		    data: { category: $('.resourceskillcat0').val() }, 
		    dataType: 'json',
		    success: function (data) {
		    	for(var i=0;i<data.length;++i)
		    	$('.resourceskill0').append('<option value="'+data[i].id+'">'+data[i].name+'</option>');   	
		       
		    }
		});
		
	});
});


$(document).ready(function(){
	$(document).on('change','.resourceskillcat1',function(){
		
		$('.resourceskill1 > option').remove();
		$('.resourceskill1').append('<option value="select">SELECT</option>');
	$.ajax({ 
	    type: 'POST', 
	    url: '/ProjectManagementTool/loadresourceskill',
	    data: { category: $('.resourceskillcat1').val() }, 
	    dataType: 'json',
	    success: function (data) {
	    	for(var i=0;i<data.length;++i)
	    	$('.resourceskill1').append('<option value="'+data[i].id+'">'+data[i].name+'</option>');   	
	       
	    }
	});
	
		
	});
});



$(document).ready(function(){
	$(document).on('change','.resourceskillcat2',function(){
		
		$('.resourceskill2 > option').remove();
		$('.resourceskill2').append('<option value="select">SELECT</option>');
	$.ajax({ 
	    type: 'POST', 
	    url: '/ProjectManagementTool/loadresourceskill',
	    data: { category: $('.resourceskillcat2').val() }, 
	    dataType: 'json',
	    success: function (data) {
	    	for(var i=0;i<data.length;++i)
	    	$('.resourceskill2').append('<option value="'+data[i].id+'">'+data[i].name+'</option>');   	
	       
	    }
	});
	
		
	});
});




$(document).ready(function(){
	var i=1;
$('.addrow').click(function(){
	   
	   	   
	   $('.addresourceskilldetails').append('<tr class="resourceskilldetailrow'+i+'" name="resourceskilldetailrow'+i+'">'+
			   '<td><input type="checkbox"></input></td>'+
			   
			   '<td><select name="resourceskillcat'+i+'" class="resourceskillcat'+i+'">'+
			   '<option value="select">SELECT</option>'+
			   '<option value="technology">Technology</option>'+
			   '<option value="lifecycle">LifeCycle Management</option>'+
			   '<option value="tools">Tools</option>'+
			   '<option value="domain">Domain</option>'+
			   '</select></td>'+
			   
			   '<td><select name="resourceskill'+i+'" class="resourceskill'+i+'"><option value="select">SELECT</option></select></td>'+
			   
			   '<td><select name="resourceskillcore'+i+'" class="resourceskillcore'+i+'">'+
			   '<option value="select">SELECT</option>'+
			   '<option value="yes">YES</option>'+
			   '<option value="no">NO</option>'+
			   '</select></td>'+
			   
			   '<td><select name="resourceskillrating'+i+'" class="resourceskillrating'+i+'">'+
			   '<option value="select">SELECT</option>'+
			   '<option value="1">1</option>'+
			   '<option value="2">2</option>'+
			   '<option value="3">3</option>'+
			   '<option value="4">4</option>'+
			   '<option value="5">5</option>'+
			   '</select></td>'+
			   '</tr>');
	
	  	    
	i++;  
	
});	
});