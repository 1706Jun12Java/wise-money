<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html>
	<head>
	</head>
	<body>

	<div class="col-md-8">
		<form role="form" action="stockForm" method="post" id="login-form">
			<div class="form-group" name="stockForm">
				<label for="stockSymbol" class="sr-only">Stock</label>
 		 				
 			<select name="stockSymbol" class="form-control" placeholder="Select Stock">
 				<option ng-repeat="stock in stocks" value="{{stock.stockSymbol}}">{{stock.stockSymbol}}/{{stock.stockName}}</option>
					</select>
				
 			</div>
			<div class="form-group">
				<label for="volume" class="sr-only">Volume</label>
				<input type="text" name="volume" class="form-control" placeholder="Volume" value="${fn:escapeXml(param.volume)}" required>
				<span class="error">${messages.volume}</span>
				
			</div>
			<div class="form-group">
				<label for="tx" class="sr-only">Transaction</label>
				<select class="form-control" name="lastTx">
					<option>BUY</option>
					<option>SELL</option>
				</select>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary">
		</form>
	</div>
	</body>


</html>

