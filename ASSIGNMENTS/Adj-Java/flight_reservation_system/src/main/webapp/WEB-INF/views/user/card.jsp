<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online flight reservation</title>
<link rel="stylesheet" href="/css/main.css" type="text/css" />
</head>
<body>
	<h1>Flight Reservation System</h1>
	<div>
		<h2>Card Details Form</h2>
		<form:form method="post" modelAttribute="userCard">
			<table>
				<tr>
					<td>Card number</td>
					<td><form:input path="cardNumber" /></td>
				</tr>
				<tr>
					<td>Expiry date</td>
					<td><form:input type="date" path="expDate" /></td>
				</tr>
				<tr>
					<td>Cvv</td>
					<td><form:password path="cvv" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Pay" /></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>