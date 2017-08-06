var app = angular.module('wiseMoneyApp', ['ngRoute']);
app.config(function($routeProvider){
	$routeProvider
	.when('/test', {
		templateUrl: 'views/test.jsp',
		controller: 'TestCtrl'
	})
	.when('/stocks', {
		templateUrl: 'views/stockInfo.jsp',
		controller: 'StockCtrl'
	})
	.when('/portfolio', {
		templateUrl: 'views/portfolio.jsp',
		controller: 'PortfolioCtrl'
	})
	.when('/stockForm', {
		templateUrl: 'views/stockForm.jsp',
		controller: 'StockFormCtrl'
	})
});