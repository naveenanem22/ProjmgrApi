/**
 * 
 */

$(document).ready(function(){
    var $li = $('#menu li').click(function() {
        $li.removeClass('selected');
        $(this).addClass('selected');
    });
});

function myFunction() {
    
	var divtext = "The project section which provides links to maintain Projects." +
			"The project section which provides links to maintain Projects." +
			"The project section which provides links to maintain Projects." +
			"The project section which provides links to maintain Projects." +
			"The project section which provides links to maintain Projects." +
			"The project section which provides links to maintain Projects." +
			"The project section which provides links to maintain Projects." +
			"The project section which provides links to maintain Projects." +
			"The project section which provides links to maintain Projects."+
			"The project section which provides links to maintain Projects."+
			"The project section which provides links to maintain Projects."+
			"The project section which provides links to maintain Projects."+
			"The project section which provides links to maintain Projects."
			
			
	var mydiv = document.getElementById("linkdetail")    
    mydiv.innerHTML = divtext
   var aTag = document.createElement('a');
   aTag.setAttribute('href',"/ProjectManagementTool/projects");
    aTag.innerHTML = "MaintainProjects";
    mydiv.appendChild(aTag);
}





function skills() {
    
	var divtext = "Skill refers to the technial capabilities of the resources. Each skills is categorized into Automation," +
	"Manual etc., based on Cigniti's business. The importance of categorization of Skills is of great importance with respect to" +
	"allocation and de-allocation of resources to projects." +
	"As part of this section, Add, Edit, Remove and Search options are provided to manage skill repository."
	
	
var mydiv = document.getElementById("linkdetail")    
mydiv.innerHTML = divtext
var aTag = document.createElement('a');
aTag.setAttribute('href',"/ProjectManagementTool/skills");
aTag.innerHTML = "Maintain Skills";
mydiv.appendChild(aTag);

}


function clients() {
    
	var divtext = "Clients in its normal sense refers to the buyers or users of Cigniti's Testing Services." +
	"As part of this section, Add, Edit, Remove and Search options are provided to manage client repository."
	
	
var mydiv = document.getElementById("linkdetail")    
mydiv.innerHTML = divtext
var aTag = document.createElement('a');
aTag.setAttribute('href',"/ProjectManagementTool/clients");
aTag.innerHTML = "Maintain Clients";
mydiv.appendChild(aTag);

}

function regions() {
    
	var divtext = "Regions in its normal sense refers to the buyers or users of Cigniti's Testing Services." +
	"As part of this section, Add, Edit, Remove and Search options are provided to manage client repository."
	
	
var mydiv = document.getElementById("linkdetail")    
mydiv.innerHTML = divtext
var aTag = document.createElement('a');
aTag.setAttribute('href',"/ProjectManagementTool/regions");
aTag.innerHTML = "Maintain Regions";
mydiv.appendChild(aTag);

}

function locations() {
    
	var divtext = "Locations in its normal sense refers to the buyers or users of Cigniti's Testing Services." +
	"As part of this section, Add, Edit, Remove and Search options are provided to manage client repository."
	
	
var mydiv = document.getElementById("linkdetail")    
mydiv.innerHTML = divtext
var aTag = document.createElement('a');
aTag.setAttribute('href',"/ProjectManagementTool/locations");
aTag.innerHTML = "Maintain Locations";
mydiv.appendChild(aTag);

}

function businessunits() {
    
	var divtext = "Businessunits in its normal sense refers to the buyers or users of Cigniti's Testing Services." +
	"As part of this section, Add, Edit, Remove and Search options are provided to manage client repository."
	
	
var mydiv = document.getElementById("linkdetail")    
mydiv.innerHTML = divtext
var aTag = document.createElement('a');
aTag.setAttribute('href',"/ProjectManagementTool/businessunits");
aTag.innerHTML = "Maintain Businessunits";
mydiv.appendChild(aTag);

}


function deliveryunits() {
    
	var divtext = "Deliveryunits refers to the technial capabilities of the resources. Each skills is categorized into Automation," +
	"Manual etc., based on Cigniti's business. The importance of categorization of Skills is of great importance with respect to" +
	"allocation and de-allocation of resources to projects." +
	"As part of this section, Add, Edit, Remove and Search options are provided to manage skill repository."
	
	
var mydiv = document.getElementById("linkdetail")    
mydiv.innerHTML = divtext
var aTag = document.createElement('a');
aTag.setAttribute('href',"/ProjectManagementTool/deliveryunits");
aTag.innerHTML = "Maintain Deliveryunits";
mydiv.appendChild(aTag);

}

function resources() {
    
	var divtext = "Resources in its normal sense refers to the buyers or users of Cigniti's Testing Services." +
	"As part of this section, Add, Edit, Remove and Search options are provided to manage client repository."
	
	
var mydiv = document.getElementById("linkdetail")    
mydiv.innerHTML = divtext
var aTag = document.createElement('a');
aTag.setAttribute('href',"/ProjectManagementTool/resources");
aTag.innerHTML = "Maintain Resources";
mydiv.appendChild(aTag);

}

function accounts() {
    
	var divtext = "Accounts in its normal sense refers to the buyers or users of Cigniti's Testing Services." +
	"As part of this section, Add, Edit, Remove and Search options are provided to manage account repository."
	
	
var mydiv = document.getElementById("linkdetail")    
mydiv.innerHTML = divtext
var aTag = document.createElement('a');
aTag.setAttribute('href',"/ProjectManagementTool/accounts");
aTag.innerHTML = "Maintain Accounts";
mydiv.appendChild(aTag);

}



function setPlaceHolder(){

       var radioValue = document.forms[0];
              if(radioValue[0].checked){
                     document.getElementById('searchvalueid').placeholder="Enter Skill ID";
              } else {
                     document.getElementById('searchvalueid').placeholder="Enter Skill Name";
              }

}

