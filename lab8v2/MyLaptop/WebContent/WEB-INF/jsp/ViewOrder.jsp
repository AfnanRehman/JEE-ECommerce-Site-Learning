<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/MyLaptop/css/mystyle.css">
<link rel="stylesheet" type="text/css" href="/MyLaptop/css/table.css">
<title>View Order Summary</title>
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


	<br>

	<form:form modelAttribute="vieworder" method="post"
		action="confirmOrder">
		<table border="1" width=900>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Order ID</th>
			</tr>
			<c:forEach items="${vieworder.lineItems}" var="item" varStatus="loop">
				<tr>
					<td><form:input path="lineItems[${loop.index}].itemName"
							readonly="True" /></td>
					<td><form:input path="lineItems[${loop.index}].price" /></td>
					<td><form:input path="lineItems[${loop.index}].quantity" /></td>
				
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2"><input type="submit" value="Confirm"></td>
			</tr>
		</table>
	</form:form>
	<jsp:include page="footer.jsp" />
</body>
</html>
