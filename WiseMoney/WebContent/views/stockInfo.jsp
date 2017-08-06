<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<div ng-controller="StockCtrl">
		<h3>Stock Market</h3>
		<div class="col-md-6">
		<input type="text" ng-model="search">
			<table>
				<tr>
				<th>Id</th>
				<th>Symbol</th>
				<th>Name</th>
				<th>Price</th>
				
				</tr>
				<tr ng-repeat="share in stocks | filter:search | orderBy:'stockSymbol'">
					<td>{{share.stockId}}</td>
					<td>{{share.stockSymbol}}</td>
					<td>{{share.stockName}}</td>
					<td>{{share.stockValue | currency:"$":2}}</td>
				</tr>
			</table>
		</div>
 	</div>