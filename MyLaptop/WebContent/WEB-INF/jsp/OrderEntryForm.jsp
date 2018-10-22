<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/MyLaptop/css/mystyle.css">
<link rel="stylesheet" type="text/css" href="/MyLaptop/css/table.css">
<title>Enter Order</title>

</head>
<body>

	<jsp:include page="header.jsp" />
	<div class="body">

		<c:out value="${message}" />
		<form:form modelAttribute="order" method="post"
			action="purchase/submitItems">



			<table border="1" width=900>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>

				<c:forEach items="${order.lineItems}" var="item" varStatus="loop">
					<form:hidden path="lineItems[${loop.index}].itemNumber"
						value="${item.itemNumber}" />
					<tr>


						<td><c:out value="${item.itemName}" /> <form:hidden
								path="lineItems[${loop.index}].itemName"
								value="${item.itemName}" /></td>
						<td><c:out value="$${item.price}" /> <form:hidden
								path="lineItems[${loop.index}].price" value="${item.price}" /></td>
						<td><form:input path="lineItems[${loop.index}].quantity" /></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2"><input type="submit" value="Purchase"></td>
				</tr>


			</table>
		</form:form>
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>