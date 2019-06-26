var x;

$(document).ready(function(){
//	  $("#card2body").load(function(){
	x = document.getElementById('card2');
	 x.style.display = "none";
	   // $(".toHide").hide();
	  //});

//	    if(document.getElementById('male').checked == true || document.getElementById('female').checked == true){
//	    	$("#resultButton").click(function(){
//	    		x.style.display = "block";
//	    	    //$(".toHide").show();
//	    	  });
//		}
	    
});





function workPlanFunc()
{
	if(document.getElementById('light').checked == true) {
  	document.bioform.action ="biometrics";
	}
	else if(document.getElementById('heavy').checked == true) {
  	document.bioform.action ="biometrics";
  	//
	}
	return true;
}





//Using button for result

function idealWeight()
{

	// $(document).ready(function(){
	// 	  $("#resultButton").click(function(){
	// 	    $("#resultantText").hide();
	// 	  });
	// 	});
	
	console.log("inside function idealweight");
	
	if(document.getElementById('male').checked == false && document.getElementById('female').checked == false){
		alert("Please select gender !!!");
	}else if(document.getElementById('height').value == "" || document.getElementById('height').value == null){
		alert("Please enter your height !!!");
	}
	else if(document.getElementById('weight').value == "" || document.getElementById('weight').value == null){
		alert("Please enter your weight !!!");
	}
	else if(document.getElementById('age').value == "" || document.getElementById('age').value == null){
		alert("Please enter your age !!!");
	}
	else if(document.getElementById('male').checked) {
		console.log("inside male");
		var ht = document.getElementById('height').value;
	  	var ibw = Math.ceil(50.0 + 2.3 * ((ht / 2.54) - 60.0));  /*Body mass formula for male*/
		weight = document.getElementById('weight').value;
		var result = result(ibw , weight);
		//document.getElementById("id4").innerHTML = "Result"; 
		document.getElementById("resultantText").innerHTML = result; 
		document.getElementById("resultantText").style.color = "white";
		x.style.display = "block";
	}
	else if(document.getElementById('female').checked){
		console.log("inside female");
		var ht = document.getElementById('height').value;
		var ibw = Math.ceil(45.5 + 2.3 * ((ht/ 2.54) - 60.0));  /*Body mass formula for female*/
		weight = document.getElementById('weight').value;
		var result = result(ibw , weight);
		//document.getElementById("id4").innerHTML = "Result"; 
		document.getElementById("resultantText").innerHTML = result;
		console.log("innerhtml: "+ document.getElementById("resultantText").innerHTML);
		document.getElementById("resultantText").style.color = "white"; 
		x.style.display = "block";
	}


	function result(ibw , weight)
	{
		if(weight > ibw)
		{
			console.log("inside result1");
			var res = "Ideal weight = "+ibw+" kgs <br> You need to lose "+(weight - ibw)+" kgs to reach ideal weight";
			return res;
		}
		else if(weight < ibw)
		{
			console.log("inside result2");
			var res = "Ideal weight = "+ibw+" kgs <br> You need to gain "+(ibw - weight)+" kgs to reach ideal weight";
			return res;
		}
		else if(weight = ibw)
		{
			console.log("inside result3");
			var res = "Ideal weight = "+ibw+" kgs <br> You have reached your ideal body weight ! Workout regularly to maintain it !";
			return res;
		}
	
	}
}





