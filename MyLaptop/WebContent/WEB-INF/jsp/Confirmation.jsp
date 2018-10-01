<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Confirmation</title>
</head>
<body>
<table border="1" width=900>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${order.items}" var="item" varStatus="loop">
				<tr>
					<td><%= request.getAttribute("${item.name}") %></td>
					<td><%= request.getAttribute("$${item.price}") %></td>
					<td><%= request.getAttribute("items[${loop.index}].quantity") %></td>
				</tr>
			</c:forEach>
		</table>
		<table border="1" width=900>
    		<tr>
    			<th>Name</th>
    			<th>Card Number</th>
    			<th>CVV Code</th>
    			<th>Expiration Date</th>
    		</tr>
			<tr>
				<td><%= request.getAttribute("${holderName}") %></td>
				<td><%= request.getAttribute("${ccNumber}") %></td>
				<td><%= request.getAttribute("${cvvCode}") %></td>
				<td><%= request.getAttribute("${expDate}") %></td>
			</tr>
    	</table>
    	<table border="1" width=900>
	    	<tr>
	    		<th>Name</th>
	    		<th>Address Line 1</th>
	    		<th>Address Line 2</th>
	    		<th>City</th>
	    		<th>State</th>
	    		<th>ZIP</th>
	    	</tr>
			<tr>
				<td><%= request.getAttribute("${name}") %></td>
				<td><%= request.getAttribute("${addLine1}") %></td>
				<td><%= request.getAttribute("${addLine2}") %></td>
				<td><%= request.getAttribute("${city}") %></td>
				<td><%= request.getAttribute("${state}") %></td>
				<td><%= request.getAttribute("${zip}") %></td>
			</tr>
    	</table>
</body>
</html>
