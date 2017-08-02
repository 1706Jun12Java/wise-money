<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Portfolio</title>
</head>
<body>
  
<h1>Portfolio holdings</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Stock</th><th>Volume</th><th>Value</th><th>Last Tx</th><th>Tx Date</th><th>Buy</th><th>Sell</th></tr>  
   <c:forEach var="stock" items="${list}">   
   <tr>  
   <td>${stock.StockName}</td>  
   <td>${stock.Volume}</td>
   <td>${stock.Value}</td>  
   <td>${stock.LastTx}</td>  
   <td>${stock.TxDate}</td>  
   <td><a href="buystock/${stock.id}">Buy</a></td>  
   <td><a href="sellstock/${stock.id}">Sell</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="portfolioform">Add new stock</a>  

</body>
</html>