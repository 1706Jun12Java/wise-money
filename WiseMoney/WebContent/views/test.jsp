<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<div ng-controller="TestCtrl">
	<p>fun with services</p>
	<label>Our current location is:</label>{{myUrl}}<br>
	<p>
		<button ng-click="toggleTime()">show the time?</button>
	</p>
	<div ng-show="showTime">
		<label>The current time is:</label>{{theTime}}
	</div>

</div>
</html>
