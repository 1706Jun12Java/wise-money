angular.module('wiseMoneyApp').controller('StockCtrl', function($scope, $http){
	$http.get('stocks')
		.then(function(response) {
			$scope.stocks = response.data;
		})
});