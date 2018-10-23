<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/MyLaptop/css/mystyle.css">
<link rel="stylesheet" type="text/css" href="/MyLaptop/css/table.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Confirmation</title>
<style>
html {
	color: #2E2E2E;
	font-family: Arial, Helvetica, sans-serif;
	background-color: #F2F2F2;
	max-width: 980px;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />


	<table border="1" width=900>
		<tr>
			<th>Confirmation Number: <c:out value="${confirmCode}" /></th>
		</tr>
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<c:forEach items="${order.lineItems}" var="item" varStatus="loop">
			<tr>
				<td><c:out value="${item.itemName}" /></td>
				<td><c:out value="${item.price}" /></td>
				<td><c:out value="${item.quantity}" /></td>
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
		<td><c:out value="${payment.holderName}" /></td>
		<td><c:out value="${payment.ccNumber}" /></td>
		<td><c:out value="${payment.cvvCode}" /></td>
		<td><c:out value="${payment.expDate}" /></td>
			<%-- <td><form:input type="text" path="holderName" /></td>
			<td><form:input type="text" path="ccNumber" /></td>
			<td><form:input type="text" path="cvvCode" /></td>
			<td><form:input type="text" path="expDate" /></td> --%>
		</tr>
	</table>

	<div style="overflow-x: auto;">
		<form:form method="post" action="/MyLaptop">
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
				<td><c:out value="${shippingInfo.name}" /></td>
				<td><c:out value="${shippingInfo.addLine1}" /></td>
				<td><c:out value="${shippingInfo.addLine2}" /></td>
				<td><c:out value="${shippingInfo.city}" /></td>
				<td><c:out value="${shippingInfo.state}" /></td>
				<td><c:out value="${shippingInfo.zip}" /></td>
		
					<%-- <td><form:input type="text" path="name" /></td>
					<td><form:input type="text" path="addLine1" /></td>
					<td><form:input type="text" path="addLine2" /></td>
					<td><form:input type="text" path="city" /></td>
					<td><form:input type="text" path="state" /></td>
					<td><form:input type="text" path="zip" /></td> --%>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Return"></td>
				</tr>
			</table>
		</form:form>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>
