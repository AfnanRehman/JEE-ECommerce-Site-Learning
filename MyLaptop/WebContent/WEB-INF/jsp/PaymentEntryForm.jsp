<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team 7 Laptop Emporium</title>
</head>
<body>
	<form:form modelAttribute="paymentInfo" method="post"
		action="purchase/submitPayment">

		<table border="1" width=900>
			<tr>
				<th>Name</th>
				<th>Card Number</th>
				<th>CVV Code</th>
				<th>Expiration Date</th>
			</tr>

			<tr>
				<td><form:input path="holderName" /></td>
				<td><form:input path="ccNumber" /></td>
				<td><form:input path="cvvCode" /></td>
				<td><form:input path="expDate" /></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="Purchase"></td>
			</tr>


		</table>
	</form:form>
</body>
</html>