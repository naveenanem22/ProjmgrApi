/**
 * 
 */

function getEditClientId(){
	
	var clientRows = document.getElementsByName("clientrow")
	var checkedClientRow
	for(var i=0;i<clientRows.length;i++){
		if(clientRows[i].checked){
			checkedClientRow = clientRows[i]
		}
			
	}
	
	document.getElementById("editclient").setAttribute('href','/ProjectManagementTool/editclient/'+(checkedClientRow.value))
	document.getElementById("editclient").click()
	
}

function getRemoveClientId(){
	
	var clientRows = document.getElementsByName("clientrow")
	var checkedClientRow
	for(var i=0;i<clientRows.length;i++){
		if(clientRows[i].checked){
			checkedClientRow = clientRows[i]
		}
			
	}
	
	document.getElementById("removeclient").setAttribute('href','/ProjectManagementTool/removeclient/'+(checkedClientRow.value))
	document.getElementById("removeclient").click()
	
}


$(document).ready(function(){
	
	$('input[name="search"]').click(function(event){
		event.preventDefault();
		$('table[class="clientresults"]').empty();
		$.ajax({
			type: 'POST',
			url: "/ProjectManagementTool/searchingclient",
			data:{crit:$('input[name="searchbynameorid"]:checked').val(),critval:$('input[name="searchvalue"]').val()},
			datatype: 'json',
			success: function(data){
				console.log(data);
				$('table[class="clientresults"]').append('<tr><td>Client ID</td> <td>Name</td><td>Detail</td><td>City</td></tr>');
				for(var i=0;i<data.length;++i){
					$('table[class="clientresults"]').
					append('<tr><td>'+data[i].id+'</td>'+
							'<td>'+data[i].name+'</td>'+
							'<td>'+data[i].description+'</td>'+
							'<td>'+(data[i].location.city)+'</td></tr>');
				
				}	
				
				}
			
		});
		
	});
	
});


