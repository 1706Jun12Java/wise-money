<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<div ng-controller="StockCtrl">
		<div class="container">
		<div class="row">
		<div class="col-md-10">
 		<div class="panel panel-success">
			<div class="panel-heading">
				<h4>Stock Market
			<div class="pull-right">
			<span>
		<a class="btn btn-success" data-toggle="collapse" title="Toggle table filter" data-container="body" data-target="#filterStock" aria-expanded="false" aria-controls="filterStock">
		<i class="glyphicon glyphicon-filter"></i></a></span>
		</div>
		</h4>
		</div>
		
		<div class="panel-body">
		<div class="collapse" id="filterStock">
		<input type="text" class="form-control" ng-model="search" placeholder="Filter Stock">
		</div>
		</div>
			<table id="stock-table" class="table table-striped table-condensed">
			<thead>
				<tr>
				<th>#</th>
				<th>Id</th>
				<th>Symbol</th>
				<th>Name</th>
				<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="share in stocks | filter:search | orderBy:'stockSymbol'">
					<td>{{$index+1}}</td>
					<td>{{share.stockId}}</td>
					<td>{{share.stockSymbol}}</td>
					<td>{{share.stockName}}</td>
					<td>{{share.stockValue | currency:"$":2}}</td>
				</tr>
			</tbody>
			</table>
		</div>
		</div>
  	</div>
  	</div>
 	</div>