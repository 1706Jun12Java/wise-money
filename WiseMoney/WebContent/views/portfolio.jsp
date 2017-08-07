<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

	<div ng-controller="PortfolioCtrl">
	<div class="container">
		<div class="row">
		<div class="col-md-10">
			<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Portfolio
 			<div class="pull-right">
				<span>
				<a class="btn btn-primary" data-toggle="collapse" title="Toggle table filter" data-container="body" data-target="#filterThis" aria-expanded="false" aria-controls="filterThis">
				<i class="glyphicon glyphicon-filter"></i> </a></span>
				</div>
				
				</h4>
				</div>
				
				<div class="panel-body">
				<div class="collapse" id="filterThis">
					<input type="text" class="form-control" ng-model="search" placeholder="Filter Portfolio">
				</div>
				</div>
			<table id="portfolio-table" class="table table-striped table-condensed">
			<thead>
				<tr>
				<th>#</th>
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
					<td>{{$index+1}}</td>
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
		</div>
	</div>
 	
 </div>