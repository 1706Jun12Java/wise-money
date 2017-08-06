<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sharpe Ratio Chart</title>
		<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.5/angular.min.js"></script>
			
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<script src="https://code.highcharts.com/highcharts.js"></script>
		<script src="https://code.highcharts.com/modules/exporting.js"></script>
		
		<style>
		body {
		background: url(wmbackground.png) no-repeat center center fixed; 
  		-webkit-background-size: cover;
  		-moz-background-size: cover;
  		-o-background-size: cover;
  		background-size: cover;
		}
		
		#container {
			min-width: 310px;
			max-width: 800px;
			height: 400px;
			margin: 0 auto
		}
		</style>
	</head>	
<body>  
	
	<div id="container"></div>
	<button id="button" class="autocompare">Add point</button>

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