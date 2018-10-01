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
			<c:forEach items="${vieworder.items}" var="item" varStatus="loop">
				<tr>
					<td><form:input path = "items[${loop.index}].name" readonly = "True"/></td>
					<td><form:input path = "items[${loop.index}].price" /></td>
					<td><form:input path="items[${loop.index}].quantity" /></td>
					<td><form:input type="text" path="orderNumber"/></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2"><input type="submit" value="Confirm"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
