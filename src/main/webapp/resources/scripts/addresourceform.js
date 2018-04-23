$(document).ready(function(){
	$('select[name="noe"]').change(function(){
		var noe = $('select[name="noe"]').val();
		if(noe=="Permanent"){
			$('tr[class="csd"]').hide();
			$('tr[class="ced"]').hide();
		}
		if(noe=="Contract"){
			$('tr[class="csd"]').show();
			$('tr[class="ced"]').show();
		}
	});
	
	
});