angular.module('wiseMoneyApp').controller('PortfolioCtrl', function($scope, $http){

	$http.get('portfolio')
		.then(function(response) {
			$scope.portfolio = response.data;
		})
});