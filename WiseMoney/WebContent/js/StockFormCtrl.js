angular.module('wiseMoneyApp').controller('StockFormCtrl', function($scope, $http){
	$http.get('stocks')
		.then(function(response) {
			$scope.stocks = response.data;
			$scope.someStock = $scope.stocks[0];
		})
});