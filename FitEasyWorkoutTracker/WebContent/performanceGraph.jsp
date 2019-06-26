<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Work Out Progress Line Graph</title>
<link rel="stylesheet" type="text/css" href="css/graph.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style type="text/css">
		.container{
			margin-top:10px; 
			width: auto; 
			height:680px;
		}
</style>
  	<script type="text/javascript" src="js/jquery.min.js"></script>
  	<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
  	<script type="text/javascript" src="js/canvasjs.min.js"></script>
  	<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/canvasjs/1.7.0/canvasjs.min.js"></script> -->
	
	<script type="text/javascript">
			
$(document).ready(function () {		
		
		var option1 = {
			
			animationEnabled: true,
			animationDuration: 5000,
			exportEnabled: true,
			
			title: {
					text:"Weekly Progress Graph",
					fontColor: "white",
					fontSize:"30"
			},
			axisX:{
				labelFontColor: "white",
				interval:1,
				/*minimum: -1,
				maximum: 6, */
				title:"<-----------------------Daily Improvement For Last Week----------------------->",
				titleFontColor: "white",
				titleFontSize: 20,
				labelFontSize: 15,
				labelAngle: -30
			},
			
			axisY:{
				
				labelFontColor: "white",
				/* interval: 50,
				minimum: 0,
				maximum: 500, */
				title:"<-----------------------Calories Burnt----------------------->",
				titleFontColor: "white",
				titleFontSize: 20,
				labelFontSize: 15,
				labelAngle: -30
				
			},
			backgroundColor: "rgba(0,0,0, .5)",
			data:[
						{
							lineColor: "#FF2F01",
						
							type: "spline",
							dataPoints:[
								 									 		
								<c:forEach items="${dataList}" var="coordinate">
								{label : "${coordinate.getDate()}" , y : ${coordinate.getCalBurnt()} , color: "#27FFBE"},
								</c:forEach>
								/* {x : 1, y : 5}, //By Static Value1
								{x : 2, y : 9},
								{x : 3, y : 3},
								{x : 4, y : 6},
								{x : 5, y : 2} */
							]
						
						}
				]
			
		};
		
		var option2 = {
				
				animationEnabled: true,
				animationDuration: 5000,
				exportEnabled: true,
				
				title: {
						text:"Monthly Progress Graph",
						fontColor: "white",
						fontSize:"30"
				},
				axisX:{
					labelFontColor: "white",
					interval:1,
					/*minimum: -1,
					maximum: 6, */
					title:"<-----------------------Daily Improvement For Last Month----------------------->",
					titleFontColor: "white",
					titleFontSize: 20,
					labelFontSize: 15,
					labelAngle: -30
				},
				
				axisY:{
					
					labelFontColor: "white",
					/* interval: 50,
					minimum: 0,
					maximum: 500, */
					title:"<-----------------------Calories Burnt----------------------->",
					titleFontColor: "white",
					titleFontSize: 20,
					labelFontSize: 15,
					labelAngle: -30
					
				},
				backgroundColor: "rgba(0,0,0, .5)",
				data:[
							{
								lineColor: "#B6FF00",
							
								type: "spline",
								dataPoints:[
									 									 		
									<c:forEach items="${newdataList}" var="coordinate">
									{label : "${coordinate.getDate()}" , y : ${coordinate.getCalBurnt()} , color: "#FF0049"},
									</c:forEach>
									/* {x : 1, y : 5}, //By Static Value1
									{x : 2, y : 9},
									{x : 3, y : 3},
									{x : 4, y : 6},
									{x : 5, y : 2} */
								]
							
							}
					]
				
			};
		
		
		
		
		var chart1 = new CanvasJS.Chart("graphDiv", option1);
    	chart1.render();
		
		
		
		       
		    	 $('input[type="checkbox"]').click(function(){
		            if($(this).is(":not(:checked)")){
		            	var chart1 = new CanvasJS.Chart("graphDiv", option1);
		            	chart1.render();
		            }
		            else if($(this).is(":checked")){
		            	var chart2 = new CanvasJS.Chart("graphDiv", option2);
		            	chart2.render();
		            }
		        }); 
			
			
			
		    	
		});
	
	
	</script>
  	
</head>
<body>
    
    <%
	    if(session.getAttribute("email") == null) {
	    	response.sendRedirect("index.jsp");
	    }
    %>
  
	<nav style="background-color: #353535;" class="navbar navbar-dark">

		    <div class="container-fluid">
		      	
		      	<a class="navbar-brand" href="#"><h3>FitEasy</h3></a>
		      	<h2 style="text-align : center; color: white"> Don't stop till you drop! </h2>
		      	<a class="navbar-brand" href="DailyWorkoutReport.jsp"><h5>Progress Report</h5></a>
		    	<a class="navbar-brand" href="logout"><h5>Log Out</h5></a>
		      
		    </div>
  	</nav>

			<div id="graphDiv" class="container">
			</div>
			
			<div class="onoffswitch" id="switchDiv">
			    <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch">
			    <label class="onoffswitch-label" for="myonoffswitch">
			        <span class="onoffswitch-inner"></span>
			        <span class="onoffswitch-switch"></span>
			    </label>
			</div>


</body>
</html>