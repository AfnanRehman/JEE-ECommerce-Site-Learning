<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Confirmation</title>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
</style>
</head>
<body>
<form:form modelAttribute="confirmedorder" method="post">
		<table border="1" width=900>
			<tr>
				<th>Confirmation Number: 12345</th>
			</tr>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${confirmedorder.items}" var="item" varStatus="loop">
				<tr>
					<td><form:input path = "items[${loop.index}].name" readonly = "True"/></td>
					<td><form:input path = "items[${loop.index}].price" readonly = "True"/></td>
					<td><form:input path="items[${loop.index}].quantity" /></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
	<form:form modelAttribute="payment" method="post">

    	<table border="1" width=900>
    		<tr>
    			<th>Name</th>
    			<th>Card Number</th>
    			<th>CVV Code</th>
    			<th>Expiration Date</th>
    		</tr>
			<tr>
				<td><form:input type="text" path="holderName" /></td>
				<td><form:input type="text" path="ccNumber" /></td>
				<td><form:input type="text" path="cvvCode" /></td>
				<td><form:input type="text" path="expDate" /></td>
			</tr>
    	</table>
	</form:form>
	<div style="overflow-x:auto;">
	<form:form modelAttribute="shipping" method="post" action="/MyLaptop">
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
			<td><form:input type="text" path="name" /></td>
			<td><form:input type="text" path="addLine1" /></td>
			<td><form:input type="text" path="addLine2" /></td>
			<td><form:input type="text" path="city" /></td>
			<td><form:input type="text" path="state" /></td>
			<td><form:input type="text" path="zip" /></td>
		</tr>
		<tr>
				<td colspan="2"><input type="submit" value="Return"></td>
		</tr>
    	</table>
	</form:form>
	</div>
</body>
</html>
