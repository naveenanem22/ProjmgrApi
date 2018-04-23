/**
 * 
 */

function getEditLocationId(){
	
	var locationRows = document.getElementsByName("locationrow")
	var checkedLocationRow
	for(var i=0;i<locationRows.length;i++){
		if(locationRows[i].checked){
			checkedLocationRow = locationRows[i]
		}
			
	}
	
	document.getElementById("editlocation").setAttribute('href','/ProjectManagementTool/editlocation/'+(checkedLocationRow.value))
	document.getElementById("editlocation").click()
	
}

function getRemoveLocationId(){
	
	var locationRows = document.getElementsByName("locationrow")
	var checkedLocationRow
	for(var i=0;i<locationRows.length;i++){
		if(locationRows[i].checked){
			checkedLocationRow = locationRows[i]
		}
			
	}
	
	document.getElementById("removelocation").setAttribute('href','/ProjectManagementTool/removelocation/'+(checkedLocationRow.value))
	document.getElementById("removelocation").click()
	
}

