<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Order Summary</title>
</head>
<body>
	<form:form modelAttribute="vieworder" method="post"
		action="confirmOrder">
		<table border="1" width=900>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Order ID</th>
			</tr>
			
			<tr>
				<td><%= request.getAttribute("item.name") %></td>
				<td><%= request.getAttribute("item.price") %></td>
				<td><%= request.getAttribute("items[0].quantity") %></td>
				<td><%= request.getAttribute("order.orderNumber") %></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Confirm"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
