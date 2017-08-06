<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="wiseMoneyApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Profile</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-route.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/table.css">

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
		</div>
		</div>
		</nav>
	</nav>
	</div>
			<ul>
				<li class="active"><a href="#/portfolio">My Portfolio</a></li>
				<li class="active"><a href="#/stocks">Stock Market</a></li>
				<li class="active"><a href="#/stockForm">BUY/SELL</a></li>				
			</ul>
	</nav>
		<div ng-view></div>

</body>
<script src="js/app.js"></script>
<script src="js/TestCtrl.js"></script>
<script src="js/StockCtrl.js"></script>
<script src="js/PortfolioCtrl.js"></script>
<script src="js/StockFormCtrl.js"></script>

</html>