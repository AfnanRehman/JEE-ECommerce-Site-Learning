<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter Payment Information</title>
<link rel="stylesheet" type="text/css" href="/MyLaptop/css/mystyle.css">
<link rel="stylesheet" type="text/css" href="/MyLaptop/css/table.css">
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



	<form:form modelAttribute="payment" method="post" class="body"
		action="submitPayment">

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
			<tr>
				<td colspan="2"><input type="submit" value="Shipping"></td>
			</tr>
		</table>
	</form:form>
	<jsp:include page="footer.jsp" />
</body>
</html>
