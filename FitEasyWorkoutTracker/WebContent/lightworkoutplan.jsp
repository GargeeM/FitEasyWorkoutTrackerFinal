<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Light Workout Plan</title>
	<link href="css/LightWorkoutCss.css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

  <%
	    if(session.getAttribute("email") == null) {
	    	response.sendRedirect("index.jsp");
	    }
    %>

  <header class="container">
       <nav class="navbar fixed-top navbar-dark bg-dark">
           <a class="navbar-brand" href="#">FitEasy</a>
           <form class="form-inline my-2 my-lg-0" action = "logout">
            
            <button type="submit" class="btn btn-primary" id = "signout" style="margin-right:10px" data-toggle="modal" data-target="#flipFlop">Sign Out</button>
           </form>
       </nav>
    </header>
<div class="container-fluid">
  <div class="row content" id ="mid-row">
    <div class="col-sm-3 sidenav" id = "sidebar">
    <form action="">
      <h4 id= "workout-heading">Workout Options</h4> 
        <span id= "Jogging"><a id= "Jogging" href="#">Jogging</a></span>
        <span id= "Squats"><a id= "Squats" href="#">Squats</a></span>
        <span id= "Plank"><a id= "Plank" href="#">Plank</a></span>
        <span id= "Crunches"><a id= "Crunches" href="#">Crunches</a></span> 
        <span id= "Pilates"><a id= "Pilates" href="#">Pilates</a></span> 
        <span id= "Cycling"><a id= "Cycling" href="#">Cycling</a></span> 
        <span id= "Swimming"><a id= "Swimming" href="#">Swimming</a></span>  
        <span id= "Aerobics"><a id= "Aerobics" href="#">Aerobics</a></span> 
        <span id= "Free Hand Exercises"><a id= "Free Hand Exercises" href="#">Free Hand Exercises</a></span>  
      <br>
    </form>  
    </div>

    <div class="col-sm-9" id="right-section">

    		<div>
    		  <ul class="list-inline">
                <li><a href="graph" id="graph"></a></li>
                <li><a href="DailyWorkoutReport.jsp" id="report"></a></li>
              </ul>
            </div>
                
        <div id="statModal" class = "modal modal-fade">
         	<div class="modal-content text-center" id = "statModal-id">
         		<h4 id="stat1">You completed Jogging for:</h4><br>
         		   <h5 id = "timespan"></h5><br>
         		<h4 id ="stat2">Calories burnt:</h4><br>
         		   <h5 id = "calorie"></h5><br>

         		<button class="btn-primary closeButton">Close</button>
         	</div>
         </div>
       
       </div>
      </div>
    </div>
  

<!-- The Modal -->

<div id="myModal" class="modal modal-fade">

  <!-- Modal content -->
    <div class="modal-content" id = "modal-id">
    <img id="activityGif" src="images/joggingGIF.gif" style= "height:200px">
  	<h1 id="timer"><time>00:00:00</time></h1>
    <button class = "btn-success btn-lg" id = "start-button">Start Timer</button>
    <button class = "btn-danger btn-lg close" id= "stop-button">Stop Timer</button>

  </div>

</div>

<footer class="container-fluid navbar-dark bg-dark">
  <p align="center">Contact information: <a href="mailto:FitEasy@gmail.com">
  fitEasy@workout.org.in</a></p>
  <p id = "servletCall"></p>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src ="js/LightWorkoutJS.js"></script>
  

</body>
</html>