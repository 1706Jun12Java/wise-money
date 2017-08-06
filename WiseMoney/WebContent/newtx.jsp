<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Transaction</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.5/angular.min.js"></script>
	
<link href="http://fonts.googleapis.com/css?family=Abel|Buenard:400,700" rel="stylesheet" />
<link rel="stylesheet" href="resources/css/wsstyle.css"/>
<!--
<link rel="stylesheet" href="resources/css/wsstyle.css"/>
-->
</head>

<div id="wrapper">
<body >
	<h1 id="header2">WiseMoney <span>Portfolio Risk Evaluation</span></h1>
	
	<div id="nav">
	<ul>
		<li><a href="" style="background-color:#869DC7; padding-top: 10px; padding-bottom: 10px">Home</a></li>
		<li><a href="">View Portfolio</a></li>
		<li><a href="">Manager Login</a></li>
		<li><a href="">Log out</a></li>
		</ul>
	</div>
	<div class="content" ng-app="app" ng-controller="autoCompleteCTRL" ng-click="hideMenu($event)" id="myBody">
	<h3 align="center">New Transaction</h3>
	
		<div class="div1">
		
			<form class="tx-form" action="newtx" method="POST">
			
			<p class="message">Enter stock symbol:</p>
			<div class="list-wrapper">        	
        	<!-- <div class="label">Enter stock symbol:</div>  -->          
            <div><input type="text" placeholder="Search for stocks" id="textFiled" class="input" ng-keydown="checkKeyDown($event)" ng-keyup="checkKeyUp($event)"  ng-model="searchText" ng-change="search()" /></div>
            <ul class="suggestions-list">
                <li ng-repeat="suggestion in suggestions track by $index" ng-class="{active : selectedIndex === $index}" ng-click="AssignValueAndHide($index)">{{suggestion}}</li>
            </ul>
            
        </div>
			
			  
			 <p class="message">Enter volume:</p>
			  <input type="text" name="stockVolume"/>
			  
			  <p class="message">Transaction type:</p>
			  <select id="confirmselect">
				  <option id = "txOption" value="txOption">Choose Transaction</option>
				  <option id = "buy" value="buy">BUY</option>
				  <option value="sell">SELL</option>
				</select>
			 <p class="message">Order type:</p>
			  <select id="confirmselect">
				  <option id = "orderType">Choose Order Type</option>
				  <option id = "buy">Market Order</option>
				  <option id="sell">Limit Order</option>
				  <option id="sell">Stop Order</option>
				</select>
			  
			  <button type="submit" name="SubmitButton" value="submit">&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp; </button>
			</form>
		</div>
	</div>
</body>
</div>
<footer id="sticky">
	<span style="float:left;">WiseMoney. © All rights reserved.</span>
	<span style="float:right;">Follow us on social media</span>
</footer>
</html>

<script>
var app = angular.module('app',[]);
app.controller('autoCompleteCTRL', function($scope, $rootScope){
	"use strict";
	$rootScope.searchItems = [
		  "MSFT",
		  "GOOG",
		  "AAPL",
		  "AMZN",
		  "IBM",
		  "KO",
		  "DIS",
		  "EXPE",
		  "WMT"
	];
	
	//Sort Array
	$rootScope.searchItems.sort();
	//Define Suggestions List
	$rootScope.suggestions = [];
	//Define Selected Suggestion Item
	$rootScope.selectedIndex = -1;
	
	//Function To Call On ng-change
	$rootScope.search = function(){
		$rootScope.suggestions = [];
		var myMaxSuggestionListLength = 0;
		for(var i=0; i<$rootScope.searchItems.length; i++){
			var searchItemsSmallLetters = angular.uppercase($rootScope.searchItems[i]);
			var searchTextSmallLetters = angular.uppercase($scope.searchText);
			if( searchItemsSmallLetters.indexOf(searchTextSmallLetters) !== -1){
				$rootScope.suggestions.push(searchItemsSmallLetters);
				myMaxSuggestionListLength += 1;
				if(myMaxSuggestionListLength === 5){
					break;
				}
			}
		}
	};
	
	//Keep Track Of Search Text Value During The Selection From The Suggestions List  
	$rootScope.$watch('selectedIndex',function(val){
		if(val !== -1) {
			$scope.searchText = $rootScope.suggestions[$rootScope.selectedIndex];
		}
	});
	
	
	//Text Field Events
	//Function To Call on ng-keydown
	$rootScope.checkKeyDown = function(event){
		if(event.keyCode === 40){//down key, increment selectedIndex
			event.preventDefault();
			if($rootScope.selectedIndex+1 < $rootScope.suggestions.length){
				$rootScope.selectedIndex++;
			}else{
				$rootScope.selectedIndex = 0;
			}
		}else if(event.keyCode === 38){ //up key, decrement selectedIndex
			event.preventDefault();
			if($rootScope.selectedIndex-1 >= 0){
				$rootScope.selectedIndex--;
			}else{
				$rootScope.selectedIndex = $rootScope.suggestions.length-1;
			}
		}else if(event.keyCode === 13){ //enter key, empty suggestions array
			event.preventDefault();
			$rootScope.suggestions = [];
			$rootScope.selectedIndex = -1;
		}else if(event.keyCode === 27){ //ESC key, empty suggestions array
			event.preventDefault();
			$rootScope.suggestions = [];
			$rootScope.selectedIndex = -1;
		}else{
			$rootScope.search();	
		}
	};
	
	//ClickOutSide
	var exclude1 = document.getElementById('textFiled');
	$rootScope.hideMenu = function($event){
		$rootScope.search();
		//make a condition for every object you wat to exclude
		if($event.target !== exclude1) {
			$rootScope.suggestions = [];
			$rootScope.selectedIndex = -1;
		}
	};
	//======================================
	
	//Function To Call on ng-keyup
	$rootScope.checkKeyUp = function(event){ 
		if(event.keyCode !== 8 || event.keyCode !== 46){//delete or backspace
			if($scope.searchText === ""){
				$rootScope.suggestions = [];
				$rootScope.selectedIndex = -1;
			}
		}
	};
	//======================================
	
	//List Item Events
	//Function To Call on ng-click
	$rootScope.AssignValueAndHide = function(index){
		 $scope.searchText = $rootScope.suggestions[index];
		 $rootScope.suggestions=[];
		 $rootScope.selectedIndex = -1;
	};
	//======================================
});
</script>
