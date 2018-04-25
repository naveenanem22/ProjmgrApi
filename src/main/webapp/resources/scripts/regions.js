/**
 * 
 */

function getEditRegionId(){
	
	var regionRows = document.getElementsByName("regionrow")
	var checkedRegionRow
	for(var i=0;i<regionRows.length;i++){
		if(regionRows[i].checked){
			checkedRegionRow = regionRows[i]
		}
			
	}
	
	document.getElementById("editregion").setAttribute('href','/projmgr/editregion/'+(checkedRegionRow.value))
	document.getElementById("editregion").click()
	
}

function getRemoveRegionId(){
	
	var regionRows = document.getElementsByName("regionrow")
	var checkedRegionRow
	for(var i=0;i<regionRows.length;i++){
		if(regionRows[i].checked){
			checkedRegionRow = regionRows[i]
		}
			
	}
	
	document.getElementById("removeregion").setAttribute('href','/projmgr/removeregion/'+(checkedRegionRow.value))
	document.getElementById("removeregion").click()
	
}

