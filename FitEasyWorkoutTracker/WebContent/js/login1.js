
//hide the alert onload
window.onload = function() {
	$("#failed").hide();
}


$(document).ready(function(){
//get the modal
var modal1 = document.getElementById('id01');

var modal2 = document.getElementById('id02');

var failedmodal = document.getElementById('failedmodal');

var btn1 = document.getElementById("btn1");

var span = document.getElementsByClassName("close");

var btn2 = document.getElementById("btn2");

var btn3 = document.getElementById("btn3");

var btn4 = document.getElementById("btn4");

btn1.onclick = function() {
  modal1.style.display = "block";    //open login modal
}

$("#loginbtn").click(function() {
//	console.log("works");
	$("#failed").show();
	 var email = document.getElementById("emailLogIn").value;
	 var psw = document.getElementById("psw").value;
	 	 
	  $("#failedtext").load("login?email="+email+"&psw="+psw,function(responseValue, statusValue, xhr){
		  if(responseValue.trim() == 'success'){
			  console.log("inside success condition");
			  location.replace("checkbio");
		  }
	  });
	  modal1.style.display = "none"; //close login modal
	  //failedmodal.style.display = "block";

	  //$("#failedmodal").modal('show');
});

for(var i = 0; i < span.length; i++){
	span[i].onclick = function() {
	  modal1.style.display = "none";
	  modal2.style.display = "none"; //close login modal
	}
}

btn2.onclick = function() {
  modal1.style.display = "none";     //close login modal
}

btn3.onclick = function() {
  modal2.style.display = "block";    //open signup modal
}

btn4.onclick = function() {
  modal2.style.display = "none";     //close signup modal
}
});


//form validations
function formValidate() {
	var name = document.forms["form1"]["userName"];

	var mobile = document.forms["form1"]["contact"];

	var password = document.forms["form1"]["password"];

	var confirmPassword = document.forms["form1"]["psw-repeat"];

	var phoneno = /^\d{10}$/;

	var paswd = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;

	var uname = /^[a-zA-Z]+$/;

	if (!name.value.match(uname)) {
	window.alert("Please enter name in characters only..");
	name.focus();
	return false;
	}

	if (!mobile.value.match(phoneno)) {
	window.alert("Mobile number should be 10 digit!");
	mobile.focus();
	return false;
	}

	if (!password.value.match(paswd)) {
	window.alert("password should be 7 to 15 characters with atleast one digit and one special character!")
	password.focus();
	return false;

	}

	if (password.value != confirmPassword.value) {
	window.alert("Passwords do not match...");
	confirmPassword.focus();
	return false;
	}

	 return true;
	}


