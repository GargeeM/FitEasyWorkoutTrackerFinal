<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Daily workout report</title>
<link rel="stylesheet" type="text/css" href="css/reportstyle.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


</head>
<body>

    <%
	    if(session.getAttribute("email") == null) {
	    	response.sendRedirect("index.jsp");
	    }
    %>
    
	<!-- <div class="container-fluid"> -->
	<header>
		<nav class="navbar navbar-dark">
			<div class="container-fluid">

				<a class="navbar-brand" id="a1" href="#"><h3>FitEasy</h3></a>
				<h1 style="text-align: center; color: white">Workout Report</h1>
				<a class="navbar-brand active"
					style="padding: 10px; border-bottom: 5px solid white;"
					href="graph" style="float:right; margin-right:0;">Generate Graph</a> <a class="navbar-brand" id="a2" href="logout">
					<h5>LogOut</h5>
				</a>

			</div>
		</nav>
	</header>
	
		

		<div class="table table-responsive container" >
			<form id="classResult" class="row-md-10" >
			<table class="center table hoverTable" style="table-layout: fixed;">
				<thead id="sample">
				<tr>
				<th colspan="4" id= "head"> Workout Report</th>
				</tr>
				
				<tr>
					<th scope="col">Workout Plan</th>
					<th scope="col">Activity Name</th>
					<th scope="col">Time Taken</th>
					<th scope="col">Calories Burnt</th>
				</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			
		</form>
		</div>
		<div  style=" margin-left: 32%;padding-bottom: 5%;">
		<button class="btn btn-info btn-circle" id ='dailyReport' onclick=getReport()>Daily Report</button>
		<button class="btn btn-warning btn-circle" id ='weeklyReport' onclick=getReport()>Weekly Report</button>
		<button class="btn btn-success btn-circle" id='monthlyReport' onclick=getReport()>Monthly Report</button>
		</div>
		
		<div class="btn row-md-2" style="margin-left: 45%; padding-bottom: 5%">
			<button class="btn btn-primary btn-circle" onclick="printReport()" id="generateReport">Print</button>
		</div>
		
		<div>
			<footer class="container-fluid navbar-dark bg-dark">
				<p align="center">
					Contact information: <a href="mailer.html">
						fitEasy@workout.org.in</a>
				</p>
			</footer>
		</div>
		
		
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript">
        window.onload = function() {
        	$("#generateReport").hide();
        }

		 function getReport() {
			var reporttype =  event.srcElement.id;
			$('#generateReport').show();
			$('#sample').load('report?reporttype='+reporttype,function(responseValue, statusValue, xhr){
				if(statusValue == 'success')
				{	
					console.log(responseValue);
				}
				else
				console.log("Something wrong...");
			})};
			
			function printReport() {
				var printContents = document.getElementById('classResult').innerHTML;
				var originalContents = document.body.innerHTML;
				document.body.innerHTML = printContents;
				window.print();
				document.body.innerHTML = originalContents;
			}
			
			/* function hidePrintReport(){
				$('#generateReport').hide();
			}
 */			  
  </script>
		
</body>
</html>