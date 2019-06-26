<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection,
java.sql.DriverManager,
java.sql.PreparedStatement,
java.sql.ResultSet,
java.sql.SQLException,
java.util.*
"%>
<!DOCTYPE html>
<html>
<head>
 	<title>FitEasy : Biometrics</title>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  	<link rel="stylesheet" type="text/css" href="css/biometrics.css">
</head>

<body id="img" background="">

     <%
	    if(session.getAttribute("email") == null) {
	    	response.sendRedirect("index.jsp");
	    }
     %>
 
<!-- For Navbar -->

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar"></button>
      <a class="navbar-brand" href="#">FitEasy</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
     	<ul class="nav navbar-nav navbar-right">
        <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

  
<div id="containerBg" class="container-fluid jumbotron text-center">    
  <!-- <div id="img" class="jumbotron row content"> -->
    
    
    <div class="card-group">
    <form class="form-inline" name="bioform" onsubmit="return workPlanFunc()">
    <div class="card border-0" id="card1">
    <div class="col-sm-12 text-left card-body"> 
      <!-- <center> --><h2 class="card-title" id="id2">Welcome</h2><!-- </center> -->
      <p class="card-text" id="id3">Enter your biometric details to choose workout plan :-</p>
      <br><br><br>
      
<!-- <center> -->
 <div id="centralize">
  <div class="form-group">
    <label for="height">Your Height (in centimeters) :</label><br>
    <input type="text" class="form-control" id="height" name="height" placeholder="Enter your height" required>
  </div>
  
   &nbsp;&nbsp;&nbsp;
  <div class="form-group">
    <label for="weight">Your Weight (in kilograms) :</label><br>
    <input type="text" oninput="" class="form-control" id="weight" name="weight" placeholder="Enter your Weight" required>
  </div>
    &nbsp;&nbsp;&nbsp;
  <div class="form-group">
    <label for="age">Your Age (in years) :</label><br>
    <input type="text" class="form-control" id="age" name="age" placeholder="Enter your Age" required>
  </div>
    &nbsp;&nbsp;&nbsp;
  <div class="form-group form-check-inline">
  <label for="male female">Your Gender :</label>		<!-- Check it -->
	  <input class="form-check-input" type="radio" name="radgender" id="male" value="Male" required>
	  <label class="form-check-label" for="male">Male</label>
  </div>

 <div class="form-group form-check-inline">
  <input class="form-check-input" type="radio" name="radgender" id="female" value="Female" required>
  <label class="form-check-label" for="female">Female</label>
</div>

<!-- </center> -->
<br><br><br>
<!-- <center> -->
<button type="button" onclick="return idealWeight()" id="resultButton" class="btn btn-primary"><b>Check Ideal Body Weight</b></button>
<!-- </center> -->
</div>
 </div>
</div>

<div class="card border-0" id="card2">
    <div class="col-sm-12 card-body"> 
    <br><br><br>
    	<h2 class="card-title" id="id4"><!-- Result --></h2>
    	<p class="card-text" id="resultantText"></p>

  <p class="toHide"><label for="light heavy">Choose your workout plan :</label></p>

  <div class="toHide form-check">
	  <input class="form-check-input" type="radio" name="radplan" id="light" value="Light" checked>
	  <label class="form-check-label" for="light">Light</label>
  </div>

<div class="toHide form-check" >
  <input class="form-check-input" type="radio" name="radplan" id="heavy" value="Heavy">
  <label class="form-check-label" for="heavy">Heavy</label>
</div>

  <!-- <center> -->
<br>
  <button type="submit" class="toHide btn btn-primary">Submit</button>
<!-- </center> -->


      
   



    
    	<!-- <button type="button" onclick="idealWeight()" id="resultButton" class="btn btn-primary"><b>Check Ideal Body Weight</b></button> -->
    </div>
</div>
</form>
</div>
  <!-- </div> -->
</div>

<div class="foot">
<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/biometrics.js"></script>
</body>
</html>

