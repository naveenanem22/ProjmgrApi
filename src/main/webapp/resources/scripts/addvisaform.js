/**
 * 
 */

$(document).ready(function(){
	var i = 1;
   $('.addrow').click(function(){
	   
	   var tempvisarownumnameattr = "visarownum"+i; 
	   var tempvisarownumclassattr = "visarownum"+i;
	   
	   var tempvisacountrynameattr = "visacountry"+i; 
	   var tempvisacountryclassattr = "visacountry"+i;
	   
	   var tempvisatypenameattr = "visatype"+i; 
	   var tempvisatypeclassattr = "visatype"+i;
	   
	 
	   
	   var tempvalidtillnameattr = "validtill"+i; 
	   var tempvalidtillclassattr = "validtill"+i;
	   
	   
	   
	$('.addvisadetails').append("<tr class='templaterow' >" +
			"<td><input type='checkbox' class='tempvisarownum' name='tempvisarownum'></input></td>"+
			"<td><input type='text' class='tempvisacountry' name='tempvisacountry'></input></td>"+
"<td><input type='text' class='tempvisatype' name='tempvisatype'></input></td>"+
"<td><input type='date' class='tempvalidtill' name='tempvalidtill'/></td>"+
			"</tr>");
	  $('.tempvisarownum').attr("name",tempvisarownumnameattr);	  $('.tempvisarownum').attr("class",tempvisarownumclassattr);
	  $('.tempvisacountry').attr("name",tempvisacountrynameattr);	  $('.tempvisacountry').attr("class",tempvisacountryclassattr);
	  $('.tempvisatype').attr("name",tempvisatypenameattr);	  $('.tempvisatype').attr("class",tempvisatypeclassattr);
	  $('.tempvalidtill').attr("name",tempvalidtillnameattr);	  $('.tempvalidtill').attr("class",tempvalidtillclassattr);
	  	    
	  i++;
   });
   
});

