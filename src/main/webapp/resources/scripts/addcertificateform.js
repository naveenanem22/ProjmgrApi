/**
 * 
 */

$(document).ready(function(){
	var i = 1;
   $('.addrow').click(function(){
	   
	   var tempcertrownumnameattr = "certnum"+i; 
	   var tempcertrownumclassattr = "certnum"+i;
	   
	   var tempcertnamenameattr = "certname"+i; 
	   var tempcertnameclassattr = "certname"+i;
	   
	   var temporgnamenameattr = "certorg"+i; 
	   var temporgnameclassattr = "certorg"+i;
	   
	   var tempcertdatenameattr = "certdate"+i; 
	   var tempcertdateclassattr = "certdate"+i;
	   
	   var tempvalidtillnameattr = "validtill"+i; 
	   var tempvalidtillclassattr = "validtill"+i;
	   
	   var tempgradenameattr = "grade"+i; 
	   var tempgradeclassattr = "grade"+i;
	   
	   var tempmarksnameattr = "marks"+i; 
	   var tempmarksclassattr = "marks"+i;
	   
	$('.addcertificationdetails').append("<tr class='templaterow' >" +
			"<td><input type='checkbox' class='tempcertrownum' name='tempcertrownum'></input></td>"+
			"<td><input type='text' class='tempcertname' name='tempcertname'></input></td>"+
"<td><input type='text' class='temporgname' name='temporgname'></input></td>"+
"<td><input type='date' class='tempcertdate' name='tempcertdate'/></td>"+
"<td><input type='date' class='tempvalidtill' name='tempvalidtill'/></td>"+
"<td><input type='text' class='tempgrade' name='tempgrade'/></td>"+
"<td><input type='text' class='tempmarks' name='tempmarks'/></td>"+
			"</tr>");
	$('.tempcertrownum').attr("name",tempcertrownumnameattr);	  $('.tempcertrownum').attr("class",tempcertrownumclassattr);
	  $('.tempcertname').attr("name",tempcertnamenameattr);	  $('.tempcertname').attr("class",tempcertnameclassattr);
	  $('.temporgname').attr("name",temporgnamenameattr);	  $('.temporgname').attr("class",temporgnameclassattr);
	  $('.tempcertdate').attr("name",tempcertdatenameattr);	  $('.tempcertdate').attr("class",tempcertdateclassattr);
	  $('.tempvalidtill').attr("name",tempvalidtillnameattr);	  $('.tempvalidtill').attr("class",tempvalidtillclassattr);
	  $('.tempgrade').attr("name",tempgradenameattr);	  $('.tempgrade').attr("class",tempgradeclassattr);
	  $('.tempmarks').attr("name",tempmarksnameattr);	  $('.tempmarks').attr("class",tempmarksclassattr);
	  
	  i++;
   });
   
});

