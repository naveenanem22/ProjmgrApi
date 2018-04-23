

function loadskill(j){
		
		$('select[name="primaryskill'+j+'"] > option').remove();
		$('select[name="secondaryskill'+j+'"] > option').remove();
		$('select[name="primaryskill'+j+'"]').append('<option value="select">SELECT</option>');
		$('select[name="secondaryskill'+j+'"]').append('<option value="select">SELECT</option>');
	$.ajax({ 
	    type: 'POST', 
	    url: '/ProjectManagementTool/loadresourceskill',
	    data: { category: ''}, 
	    dataType: 'json',
	    success: function (data) {
	    	for(var i=0;i<data.length;++i){
	    	$('select[name="primaryskill'+j+'"]').append('<option value="'+data[i].id+'">'+data[i].name+'</option>');   	
	    	$('select[name="secondaryskill'+j+'"]').append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
	    	}
	    }
	});
	
}	

function loadlocation(j){
	
	$('select[name="location'+j+'"] > option').remove();
	$('select[name="location'+j+'"]').append('<option value="select">SELECT</option>');
	
$.ajax({ 
    type: 'POST', 
    url: '/ProjectManagementTool/loadlocation',
    dataType: 'json',
    success: function (data) {
    	for(var i=0;i<data.length;++i){
    		$('select[name="location'+j+'"]').append('<option value="'+data[i].id+'">'+data[i].city+'</option>');   	
    	
    	}
    }
});

}





$(document).ready(function(){
	var i=1;
$('.addrow').click(function(){
	   
	   	   
	   $('tbody.resreqdetails').append(
			   '<tr class="resrequestrow'+i+'">'+
			   '<td>'+
			   '<select name="requesttype'+i+'">'+
			   '<option value="select">SELECT</option>'+
			   '<option value="New">New</option>'+
			   '<option value="Replacement">Replacement</option>'+
			   '</select>'+
			   '</td>'+
			   
			   '<td><input name="rolerequired'+i+'" type="text" required/></td>'+
			   '<td><input name="rescount'+i+'" type="number" required="required" min="1" max="10"/></td>'+
			   
			   '<td>'+
			   '<select name="allctype'+i+'">'+
			   '<option value="Billing">Billing</option>'+
			   '<option value="Buffer">Buffer</option>'+
			   '</select>'+
			   '</td>'+
			   
			   '<td><input name="allcstartdate'+i+'" type="date"/></td>'+


			   '<td><input name="allcenddate'+i+'" type="date"/></td>'+

			   '<td>'+
			   '<select name="clientinterview'+i+'">'+
			   '<option value="select">SELECT</option>'+
			   '<option value="YES">YES</option>'+
			   '<option value="NO">NO</option>'+
			   '</select>'+
			   '</td>'+


			   '<td>'+
			   '<select name="competencygrp'+i+'">'+
			   '<option value="Functional Testing">Functional Testing</option> <option value="Automation Testing">Automation Testing</option> <option value="Performance Testing">Performance Testing</option>'+
			   '<option value="Security Testing">Security Testing</option> <option value="Development">Development</option> <option value="SME">SME</option>'+
			   '<option value="Project Management">Project Management</option> <option value="Testing Services">Testing Services</option>'+
			   '</select>'+
			   '</td>'+
			   
			   '<td>'+
			   '<select name="primaryskill'+i+'">'+
			   '<option value="select">SELECT</option>'+			   
			   '</select>'+
			   '</td>'+


			   '<td>'+
			   '<select name="secondaryskill'+i+'">'+
			   '<option value="select">SELECT</option>'+
			   '</select>'+
			   '</td>'+

			   '<td>'+
			   '<select name="domain'+i+'">'+
			   '<option value="select">SELECT</option>'+
			   '</select>'+
			   '</td>'+




			   '<td>'+
			   '<select name="location'+i+'">'+
			   '<option value="select">SELECT</option>'+
			   '</select>'+
			   '</td>'+

			
			   '</tr>');
	
	
	loadskill(i);
	loadlocation(i);
	i++;  
	
});	



});

