<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

	<div ng-controller="PortfolioCtrl">
		<div class="col-md-6">
		
			<input type="text" ng-model="search">
			<table id="portfolio-table" class="table table-striped table-condensed">
			<thead>
				<tr>
				<th>Id</th>
				<th>Symbol</th>
				<th>Name</th>
				<th>Volume</th>
				<th>Total Price</th>
				<th>Last Transaction</th>
				<th>Last Updated</th>
				<th>Created</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="share in portfolio | filter:search | orderBy: 'stockId.stockSymbol'">
					<td>{{share.stockId.stockId}}</td>
					<td>{{share.stockId.stockSymbol}}</td>
					<td>{{share.stockId.stockName}}</td>
					<td>{{share.volume}}</td>
					<td>{{share.totalValue | currency:"$":2}}</td>
					<td><span class="label label-success">{{share.lastTx}}</span></td>
					<td>{{share.lastUpdated | date:'M/dd/yyyy h:mm:ss a'}}</td>
					<td>{{share.dateCreated | date:'M/dd/yyyy h:mm:ss a'}}</td>
				</tr>
			</tbody>
			</table>
		</div> 	
 	
 </div>