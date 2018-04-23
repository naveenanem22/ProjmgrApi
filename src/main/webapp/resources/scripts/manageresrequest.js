//Global Variables used as Error/Warning messages

var NO_RECORD_SELECTED = 'Pls select atleast one record to Proceed.';
var DIFF_RECRD_SELECTED = 'Pls select records with same status to batch process.';


function loadresreq(){
		
		
	$.ajax({ 
	    type: 'POST', 
	    url: '/ProjectManagementTool/projectmanagement/loadresreq',	     
	    dataType: 'json',
	    success: function (data) {
	    	console.log(data);
	    	for(var i=0;i<data.length;i++){
	    		
	    		$('table.newresrequests tbody').append(
	    				'<tr class="resrequestrow'+i+'">'+
	    				   '<td><input type="checkbox" id="'+data[i].rard_status+'" value="'+data[i].rard_requestDetailId+'"/></td>'+
	    				   '<td>'+data[i].rar_requestId+'</td>'+
	    				   '<td>'+data[i].rard_requestDetailId+'</td>'+
	    				   '<td>'+data[i].rar_project.account.name+'</td>'+
	    				   '<td>'+data[i].rar_project.name+'</td>'+
	    				   '<td>'+data[i].rard_requestType+'</td>'+
	    				   '<td>'+data[i].rard_role+'</td>'+
	    				   '<td>'+data[i].rard_allcType+'</td>'+
	    				   '<td>'+data[i].rard_allcStartdate+'</td>'+
	    				   '<td>'+data[i].rard_allcEnddate+'</td>'+
	    				   '<td>'+data[i].rard_clientInterview+'</td>'+
	    				   '<td>'+data[i].rard_primarySkill.name+'</td>'+
	    				   '<td>'+data[i].rard_secondarySkill.name+'</td>'+
	    				   '<td>'+data[i].rard_domain.name+'</td>'+
	    				   '<td>'+data[i].rard_location.city+'</td>'+
	    				   '<td></td>'+
	    				   '<td></td>'+
	    				   '<td>'+data[i].rard_status+'</>'+
	    				   '</tr>'
	    				);
	    		
	    		
	    		
	    		
	    	}
	    	
	    }
	});
	
}	


$(document).ready(function(){
	loadresreq();	
});


$(document).ready(function(){
	
	
	$('input[value="Accept"]').click(function(event){
		 event.preventDefault();
		 if(checkRecordsAndSubmit())
			 {
			 /*Send request to process*/
			 var reqDetIds = $("input:checkbox:checked").map(function(){
			      return $(this).val();	    	
			    	
			    }).get();
			 
			 console.log(reqDetIds);
			 
			 $.ajax({ 
				    type: 'POST', 
				    url: '/ProjectManagementTool/projectmanagement/manageresreq/new',
				    data: {reqDetIds:reqDetIds.toString()},
				    success: function(data){}
				});
			 
			 
			 /*Reload table with request details*/
			 $.ajax({ 
				    type: 'POST', 
				    url: '/ProjectManagementTool/projectmanagement/loadresreq',	     
				    dataType: 'json',
				    success: function (data) {
				    	console.log(data);
				    	$('table.newresrequests tbody tr').remove();
				    	for(var i=0;i<data.length;i++){
				    		
				    		$('table.newresrequests tbody').append(
				    				'<tr class="resrequestrow'+i+'">'+
				    				   '<td><input type="checkbox" id="'+data[i].rard_status+'" value="'+data[i].rard_requestDetailId+'"/></td>'+
				    				   '<td>'+data[i].rar_requestId+'</td>'+
				    				   '<td>'+data[i].rard_requestDetailId+'</td>'+
				    				   '<td>'+data[i].rar_project.account.name+'</td>'+
				    				   '<td>'+data[i].rar_project.name+'</td>'+
				    				   '<td>'+data[i].rard_requestType+'</td>'+
				    				   '<td>'+data[i].rard_role+'</td>'+
				    				   '<td>'+data[i].rard_allcType+'</td>'+
				    				   '<td>'+data[i].rard_allcStartdate+'</td>'+
				    				   '<td>'+data[i].rard_allcEnddate+'</td>'+
				    				   '<td>'+data[i].rard_clientInterview+'</td>'+
				    				   '<td>'+data[i].rard_primarySkill.name+'</td>'+
				    				   '<td>'+data[i].rard_secondarySkill.name+'</td>'+
				    				   '<td>'+data[i].rard_domain.name+'</td>'+
				    				   '<td>'+data[i].rard_location.city+'</td>'+
				    				   '<td></td>'+
				    				   '<td></td>'+
				    				   '<td>'+data[i].rard_status+'</>'+
				    				   '</tr>'
				    				);
				    		
				    		
				    		
				    		
				    	}
				    	
				    }
				});
			 }
	});	
	
});


function checkSameRecords(reqDetSts){
	if(reqDetSts.length==1){		
		return true;
	}	
	else{
		var same=true;
		for(var i=1;i<reqDetSts.length;i++){
			if(reqDetSts[0]!=reqDetSts[i]){
				same=false;
				break;
			}
		}
		return same;
		
	}
		
}

function checkRecordsAndSubmit(){
	//Getting values of selected records		
	var reqDetIds = $("input:checkbox:checked").map(function(){
      return $(this).val();	    	
    	
    }).get();
    
    
    //Getting status of selected records
    var reqDetSts = $("input:checkbox:checked").map(function(){
      	 return this.id;
    	
    }).get();
    
    if(reqDetSts.length==0){
    	window.alert(NO_RECORD_SELECTED);
    	return false;
    }
    //Verify records have same status
    else if(checkSameRecords(reqDetSts))
    	return true;
    else{
        window.alert(DIFF_RECRD_SELECTED);
    	return false;
    }
}


