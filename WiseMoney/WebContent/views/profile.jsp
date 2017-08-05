<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="wiseMoneyApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-route.js"
	type="text/javascript"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Wise Money</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="Active"><a href="profile">Home</a></li>
					
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container">
		<div class="jumbotron">
			<h4>Portfolio</h4>
			<c:forEach items="${stockList}" var="stock">
				<tr>
					<td>${stock.stockName}</td>
				</tr>
			</c:forEach>
				<p>${stockList}</p>
				
		</div>
	
	</div>
 
	<h2>List of Stocks</h2> 
	${userData.firstName}
	${userData.lastName}
	${userData.email}
		
		<a class="btn btn-primary btn-md" href="#/test">test</a>
		<a class="btn btn-primary btn-md" href="#/stock">stock</a>
	
	
	
<div ng-view></div>



</body>
<script src="js/app.js"></script>
<script src="js/TestCtrl.js"></script>
<script src="js/StockCtrl.js"></script>

</html>