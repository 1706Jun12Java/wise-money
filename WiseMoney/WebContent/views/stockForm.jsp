<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
	</head>
	<body ng-app="app" ng-controller="autoCompleteCTRL" ng-click="hideMenu($event)">
<%-- 		<form:form method="POST" action="/stockForm" modelAttribute="portfolio">
			<table>
				<tr>
					<td><form:label path="stockId">Stock Name</form:label></td>
					<td><form:input path="stockId"/></td>
				</tr>
				<tr>
					<td><form:label path="volume">Volume</form:label></td>
					<td><form:input path="volume"/></td>
				</tr>
				<tr>
					<td><form:label path="lastTx">Transaction</form:label></td>
					<td><form:input path="lastTx"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"/></td>
				</tr>
			</table>
		</form:form> --%>

		<form role="form" action="stockForm" method="post" id="login-form">
			<div class="form-group">
				<label for="stockSymbol" class="sr-only">Stock</label>
				<input type="text" name="stockSymbol" class="form-control" placeholder="Stock Symbol">
			</div>
			<div class="form-group">
				<label for="volume" class="sr-only">Volume</label>
				<input type="text" name="volume" class="form-control" placeholder="Volume">
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
	</body>


</html>

