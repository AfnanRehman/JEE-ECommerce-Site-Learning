<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team 7 Laptop Emporium</title>
</head>
<body>
<form:form modelAttribute="PaymentInfo" method="post" action="purchase/submitPayment">

    <table border="1" width=900>
    <tr>
    	<th>Name</th>
    	<th>Card Number</th>
    	<th>CCV Code</th>
    	<th>Expiration Date</th>
    </tr>
	<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<td><c:out value="${paymentinfo.holderName}"></c:out></td>
			<td><c:out value="$${paymentinfo.ccNumber}"></c:out></td>
			<td><c:out value="$${paymentinfo.ccvCode}"></c:out></td>
			<td><form:input path="paymentinfo[${loop.index}].expDate" /></td>
		</tr>
	</c:forEach>

	  <tr>
		<td colspan="2"><input type="submit" value="Purchase"></td>
	  </tr>
	

    </table>
</form:form>
</body>
</html>