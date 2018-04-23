/**
 * 
 */

function getEditAccountId(){
	
	var accountRows = document.getElementsByName("accountrow")
	var checkedAccountRow
	for(var i=0;i<accountRows.length;i++){
		if(accountRows[i].checked){
			checkedAccountRow = accountRows[i]
		}
			
	}
	
	document.getElementById("editaccount").setAttribute('href','/ProjectManagementTool/editaccount/'+(checkedAccountRow.value))
	document.getElementById("editaccount").click()
	
}

function getRemoveAccountId(){
	
	var accountRows = document.getElementsByName("accountrow")
	var checkedAccountRow
	for(var i=0;i<accountRows.length;i++){
		if(accountRows[i].checked){
			checkedAccountRow = accountRows[i]
		}
			
	}
	
	document.getElementById("removeaccount").setAttribute('href','/ProjectManagementTool/removeaccount/'+(checkedAccountRow.value))
	document.getElementById("removeaccount").click()
	
}

