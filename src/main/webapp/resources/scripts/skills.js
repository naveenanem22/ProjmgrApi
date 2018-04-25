/**
 * 
 */

function getEditSkillId(){
	
	var skillRows = document.getElementsByName("skillrow")
	var checkedSkillRow
	for(var i=0;i<skillRows.length;i++){
		if(skillRows[i].checked){
			checkedSkillRow = skillRows[i]
		}
			
	}
	
	document.getElementById("editskill").setAttribute('href','/projmgr/editskill/'+(checkedSkillRow.value))
	document.getElementById("editskill").click()
	
}

function getRemoveSkillId(){
	
	var skillRows = document.getElementsByName("skillrow")
	var checkedSkillRow
	for(var i=0;i<skillRows.length;i++){
		if(skillRows[i].checked){
			checkedSkillRow = skillRows[i]
		}
			
	}
	
	document.getElementById("removeskill").setAttribute('href','/projmgr/removeskill/'+(checkedSkillRow.value))
	document.getElementById("removeskill").click()
	
}

