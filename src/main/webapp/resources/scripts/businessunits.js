/**
 * 
 */

function getEditBusinessunitId(){
	
	var businessunitRows = document.getElementsByName("businessunitrow")
	var checkedBusinessunitRow
	for(var i=0;i<businessunitRows.length;i++){
		if(businessunitRows[i].checked){
			checkedBusinessunitRow = businessunitRows[i]
		}
			
	}
	
	document.getElementById("editbusinessunit").setAttribute('href','/ProjectManagementTool/editbusinessunit/'+(checkedBusinessunitRow.value))
	document.getElementById("editbusinessunit").click()
	
}

function getRemoveBusinessunitId(){
	
	var businessunitRows = document.getElementsByName("businessunitrow")
	var checkedBusinessunitRow
	for(var i=0;i<businessunitRows.length;i++){
		if(businessunitRows[i].checked){
			checkedBusinessunitRow = businessunitRows[i]
		}
			
	}
	
	document.getElementById("removebusinessunit").setAttribute('href','/ProjectManagementTool/removebusinessunit/'+(checkedBusinessunitRow.value))
	document.getElementById("removebusinessunit").click()
	
}

