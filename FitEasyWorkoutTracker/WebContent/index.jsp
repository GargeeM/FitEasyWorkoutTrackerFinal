
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<!--Bootsrap 4 CDN-->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

 <!--Fontawesome CDN-->
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
 <link href='https://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400' rel='stylesheet' type='text/css'>
 <!--Custom styles-->
 <link rel="stylesheet" type="text/css" href="css/index.css">
 
 <style type="text/css">

	#particles-js {
	  position: absolute;
	  width: 100%;
	  height: 70%;
	  background:;
	}
 </style>

</head>
<body>

  <% 
      System.out.println("from index: " + session.getAttribute("email"));
	  if(session.getAttribute("email") != null){
		  response.sendRedirect("checkbio");
	  }
	  /* else{
		  response.sendRedirect("checkbio");
	  } */
  
  %>
  <!-- <nav class="shift">
    <ul>
      <li><a href="#">About Us</a></li>
      <li><a href="#">Contact Us</a></li>
    </ul>
  </nav>  -->
	<br><br><br><h3 style="text-align:center; color: #ffffff">Welcome to FitEasy!</h3>
    <h5 style="text-align:center; color: #ffffff">Your one stop solution to Fitness</h5>
    <div id="particles-js"></div>
    <div class="container" style= "height: 580px">
   <div class="d-flex justify-content-center h-100">
    <div class="card bg-light">
     <button id="btn1" style="width:50%; margin: auto">Login</button>

     <!-- login modal -->
     <div id="id01" class="modal" id="#modal1">
      <form class="modal-content animate" action="#" style= "width: 500px">
        <div class="imgcontainer">
          <span class="close" title="Close Modal">&times;</span>
          <h2>Log In</h2>
        </div>

        <div class="container">
          <label for="email"><b>Email</b></label>
          <input type="text" placeholder="Enter Email" name="email" id="emailLogIn" required>

          <label for="psw"><b>Password</b></label>
          <input type="password" placeholder="Enter Password" name="psw" id="psw" required><br><br>

          <input type="button" class="cancelbtn" id="loginbtn" value="Login" style= "color: white">
<!--           <button id = "loginbtn" class="cancelbtn">Login</button> -->
          <label>
            <button id="btn2" type="button" class="cancelbtn">Cancel</button>
          </label>
          <span class="psw">Forgot <a href="#">password?</a></span>
        </div>
  </form>
</div>

    <button id="btn3" style="width:50%; margin: auto">Sign Up</button>

    <!-- sign-up modal -->
    <div id="id02" class="modal" id="modal2">
      <form class="modal-content animate" name="form1" action="signup" onsubmit="return formValidate()"  style= "width: 500px; margin-top: 50px">
        <div class="container">
          <span id="sp2" class="close" title="Close Modal">&times;</span>
          <h2>Sign Up</h2>
          <p>Please fill in this form to create an account.</p>
          <hr>
          <label for="userName"><b>Name</b></label>
          <input type="text" placeholder="Enter Username" name="userName" id = "userName" required>

          <label for="email"><b>Email</b></label>
          <input type="email" placeholder="Enter Email" name="email" id = "emailSignIn" required>
     
          <label for="contact"><b>Contact No.</b></label>
          <input type="text" placeholder="Enter Contact Number" name="contact" id = "contact" required>

          <label for="password"><b>Password</b></label>
          <input type="password" placeholder="Enter Password" name="password" id = "password" required>

          <label for="psw-repeat"><b>Repeat Password</b></label>
          <input type="password" placeholder="Repeat Password" name="psw-repeat" required>

          <!-- <label>
            <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
          </label> -->

          <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

          <div class="clearfix">
            <button id="btn4" type="button" class="cancelbtn">Cancel</button>
            <button type="submit" class="cancelbtn">Submit</button>
          </div>
        </div>
      </form>
    </div>
        
  </div>
  <div class="alert alert-danger text-center" id="failed" style="height:50px; width:300px; margin-top: 400px; margin-left:-340px">
	     <strong id="failedtext"></strong>
   </div>
        <!-- //yet to be created modal for failed login and signup -->
    <!-- <div id="failedmodal" class="modal">
       <div class="modal-content animate">
	     <div class="alert alert-danger text-center" id="failed" style="height:50px; width:300px; margin-top: 400px; margin-left:-340px">
		     <strong id="failedtext"></strong>
	    </div>
	   </div>
    </div>
 --> 
    
</div>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/login1.js"></script>
<script type="text/javascript" src="js/particles.js"></script>
<script type="text/javascript" src="js/app.js"></script>  

</body>

<!--Footer text -->
<div class="copy-right-top border-top">
  <p class="copy-right text-center py-4" style="color: white">&copy; 2019 Digital. All Rights Reserved | Design by Prabhat 
  </p>
</div>

</html>