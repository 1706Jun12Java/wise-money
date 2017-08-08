<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sharpe Ratio Chart</title>
		
		<link rel="stylesheet" href="../css/table.css">
<link rel="stylesheet" href="../css/main.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-route.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		
		<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.5/angular.min.js"></script>
			
		<!-- <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> -->
		<script src="https://code.highcharts.com/highcharts.js"></script>
		<script src="https://code.highcharts.com/modules/exporting.js"></script>
		<link rel="stylesheet" href="css/main.css">
		<style>
				
		#container {
			min-width: 310px;
			max-width: 800px;
			height: 400px;
			margin: 0 auto
		}
		#button {
			position:relative;
    		transition: .5s ease;
    		top: 70%;
    		left: 75%;
		}
		</style>
	</head>	
<body>  
	
	<nav class="navbar navbar-default navbar-inverse" role="navigation">
	<div class="container-fluid">
	<div class="collapse navbar-collapse">
	<nav class="navbar navbar-nav navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="profile">Wise Money</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="Active"><a href="profile">Home</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-center">
					<li><a>Welcome, ${user.firstName}</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout">Logout</a></li>
				</ul>
			</div>
		</div>
		</nav>
		</div>
		</div>
		</nav>
		
		<div class="col-md-2">
		
		<nav class="navbar navbar-inverse sidebar">		
		<div class="container-fluid">
		<div class="navbar-header">
			<div class="navbar-brand" align="center">Menu</div>
			</div>
			
		
		
			
			<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li>
				 <a href="#/portfolio">
				 My Portfolio</a></li>
				
				
				<li>
				<a href="#/stocks">
				Stock Market</a></li>
				
				
				
				<li>
				<a href="#/stockForm">
				BUY/SELL</a></li>				
			</ul>
			</div>
		</div>
		</nav>
		</div>
	
	<div id="container"></div>
	<button id="button" class="autocompare">Add point</button>
	<!--  
	<c:url value="/media/wmbackground.png" var="bgPic" />
	<img  src="${bgPic}" width="400" height="400" ></img>
	-->
</body>  
</html>  

<script>
var chart = Highcharts.chart('container', {

	title: {
        text: 'Sharpe Ratio Trend'
    },
	yAxis: {
        title: {
            text: 'Sharpe ratio value'
        }
    },
	plotOptions: {
        series: {
            animation: {
                duration: 5000
            }
        }
    },
	
    series: [{
		name: 'MSFT',
        data: [0.76, 0.41, 0.91, 0.04, 0.43, 0.49, 0.84, 0.32, 0.15, 0.20]
    },
    {
		name: 'GOOG',
        data: [0.57, 0.19, 0.32, 0.68, 0.56, 0.30, 0.51, 0.21, 0.91, 0.38]
    },
	{
		name: 'AAPL',
        data: [0.77, 0.01, 0.25, 0.27, 0.06, 0.20, 0.44, 0.02, 0.83, 0.25]
    }]

});

$('#button').click(function () {
    chart.series[0].addPoint(Math.random());
	chart.series[1].addPoint(Math.random());
	chart.series[2].addPoint(Math.random());
});
</script>