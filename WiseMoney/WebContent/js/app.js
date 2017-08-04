var app = angular.module('wiseMoneyApp', ['ngRoute']);
app.config(function($routeProvider){
	$routeProvider
//	.when('/', {
//		templateUrl: 'views/register.jsp'
//	})
	.when('/test', {
		templateUrl: 'views/test.jsp',
		controller: 'TestCtrl'
	})
	.when('/home', {
		templateUrl: 'index.jsp',
		controller: 'ProfileCtrl'
	})
//	.otherwise({redirectTo: '/'});
	
});