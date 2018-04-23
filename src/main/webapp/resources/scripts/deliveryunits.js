/**
 * 
 */

function getEditDeliveryunitId(){
	
	var deliveryunitRows = document.getElementsByName("deliveryunitrow")
	var checkedDeliveryunitRow
	for(var i=0;i<deliveryunitRows.length;i++){
		if(deliveryunitRows[i].checked){
			checkedDeliveryunitRow = deliveryunitRows[i]
		}
			
	}
	
	document.getElementById("editdeliveryunit").setAttribute('href','/ProjectManagementTool/editdeliveryunit/'+(checkedDeliveryunitRow.value))
	document.getElementById("editdeliveryunit").click()
	
}

function getRemoveDeliveryunitId(){
	
	var deliveryunitRows = document.getElementsByName("deliveryunitrow")
	var checkedDeliveryunitRow
	for(var i=0;i<deliveryunitRows.length;i++){
		if(deliveryunitRows[i].checked){
			checkedDeliveryunitRow = deliveryunitRows[i]
		}
			
	}
	
	document.getElementById("removedeliveryunit").setAttribute('href','/ProjectManagementTool/removedeliveryunit/'+(checkedDeliveryunitRow.value))
	document.getElementById("removedeliveryunit").click()
	
}

