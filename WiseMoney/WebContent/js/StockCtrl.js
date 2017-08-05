angular.module('wiseMoneyApp').controller('StockCtrl', function($scope, $http){
//	$scope.url = "/profileInfo";
	
//	function getStockList(){
//		$http({method:"GET", url:$scope.url})
//		.then(function(response){
//			$scope.stocks = response.data;
//		})
//	}
	$http.get('WiseMoney/profileInfo')
		.then(function(response) {
			$scope.stocks = response.data;
		})
	
	
	
	
//	$http.get('WiseMoney/profileInfo')
//    .then(function(response) {
//        console.log("success");
//        console.log(response.data);
//    }, function (error) {
//        console.log(error);
//    })
});


//	
//	
//	
////	.success(function(data, response){
////		$scope.stockList = response.data;
////	});
////	then(function(response) {
////		$scope.stockList = response.data;
////	});
//});
//
//angular.module("wiseMoneyApp").controller("StockCtrl", ['$scope', '$http',
//	function($scope, $http) {
//	$http({method:'GET', url:'/profile'})
//	.success(function(data, status, headers, config){
//		$scope.profiles = data;
//	})
//	.error(function(data, status, headers, config){
//		alert("failure");
//	});
//}
//	])
//	
	
	//	$http.get('http://localhost:8080/WiseMoney/profile.json')
