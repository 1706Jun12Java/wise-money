<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Transaction</title>
     <meta charset="utf-8" />
     <title>Pure Angular JS Autocomplete Text Field</title>
     <link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
     <script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.5/angular.min.js"></script>
	<!--<script src="controllers/autoCompleteCTRL.js"></script>-->
	
	<style>
	/* style for autocomplete drop-down list */
		@charset "utf-8";
		body {	
			background: url(media/wmbackground.png) no-repeat center center fixed; 
  			-webkit-background-size: cover;
  			-moz-background-size: cover;
  			-o-background-size: cover;
  			background-size: cover;
  		}		
		.suggestions-list {
			position: relative;
			list-style-type: none;
			margin:0px;
			padding:0;
			overflow:hidden;
			border-radius:.5em;
		}
		.suggestions-list li {
			color: #000000;
			padding: 5px 10px;
			height:30px;
			cursor: pointer;
			background: #f5f5f5;
			border-left: 1px solid #ddd;
			border-right: 1px solid #ddd;
			width:382px;
		}
		.suggestions-list li:last-child{
			border-bottom: 1px solid #ddd;
		}
		.suggestions-list li:hover {
			background: #ddd;
		}
		.suggestions-list li:active,
		.suggestions-list li.active {
			color: #FFFFFF;
			background: #0610a3;
			width:382px;
		}
		.suggestions-list:focus{
			outline:none;
		}
	</style>        
</head>

<body ng-app="app" ng-controller="autoCompleteCTRL" ng-click="hideMenu($event)">
       	
	<div class="label">Enter stock symbol:</div>          
	<div><input type="text" placeholder="Search for stocks" id="textFiled" class="input" ng-keydown="checkKeyDown($event)" ng-keyup="checkKeyUp($event)"  ng-model="searchText" ng-change="search()" /></div>
		<ul class="suggestions-list">
			<li ng-repeat="suggestion in suggestions track by $index" ng-class="{active : selectedIndex === $index}" ng-click="AssignValueAndHide($index)">{{suggestion}}</li>
		</ul>
	</div>        
<!-- End Of view -->
</body>
    
</html>

<script>
// JavaScript Document
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
