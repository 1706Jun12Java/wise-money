<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>testing</title>
</head>
<body>
	this is the display jsp page!
	
<%-- 	Result is: <%= request.getAttribute("result") %> --%>	
	Result is: ${result}
	
<%-- 	<% for(int i=0; i < result.size(); i++){ %>
		<tr>
			<td><%=result.get(i).getStockByName()%></td>
		</tr>
	<% } %> --%>

</body>
</html>