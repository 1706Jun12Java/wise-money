<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.5/angular.min.js"></script>
	
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<title>Sharpe Ratio Chart</title>
<link href="http://fonts.googleapis.com/css?family=Abel|Buenard:400,700" rel="stylesheet" />
<link rel="stylesheet" href="resources/css/wsstyle.css"/>


</head>

<div id="wrapper">
<body>

	<h1 id="header2">WiseMoney <span>Portfolio Risk Evaluation</span></h1>
	
	<div id="nav">
	<ul>
		<li><a href="" style="background-color:#869DC7; padding-top: 10px; padding-bottom: 10px">Home</a></li>
		<li><a href="">View Portfolio</a></li>
		<li><a href="">Manager Login</a></li>
		<li><a href="">Log out</a></li>
		</ul>
	</div>
	
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
                duration: 8000
            }
        }
    },

	
    series: [{
		name: 'MSFT',
        data: [0.76, 0.41, 0.90, 0.68, 0.56, 0.30, 0.51, 0.21, 0.91, 0.38]
    },
    {
		name: 'GOOG',
        data: [0.57, 0.19, 0.91, 0.04, 0.43, 0.49, 0.84, 0.32, 0.15, 0.20]
    },
	{
		name: 'AAPL',
        data: [0.77, 0.01, 0.04, 0.27, 0.06, 0.20, 0.44, 0.02, 0.83, 0.25]
    }]

});

// the button action
//var i = 0.1;
$('#button').click(function () {
    chart.series[0].addPoint(Math.random());
	chart.series[1].addPoint(Math.random());
	chart.series[2].addPoint(Math.random());
    //chart.series[1].addPoint(1 * (i % 3));
    //i += 1;
	
});
</script>
<button id="chartButton">Add point</button>	

</body>
</div>
<footer id="sticky">
	<span id="left">WiseMoney. © All rights reserved.</span>
	<span id="right">Follow us on social media</span>
</footer>
</html>