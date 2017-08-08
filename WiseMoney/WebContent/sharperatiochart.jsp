<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<div class="col-md-10">
	
	<div id="container"></div>
	<button type="button" id="button" class="btn btn-primary">Feed Data</button>
	<!--  
	<c:url value="/media/wmbackground.png" var="bgPic" />
	<img  src="${bgPic}" width="400" height="400" ></img>
	-->

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
 </div>