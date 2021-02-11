<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
		<h2>Passenger Details Form</h2>
		<h3>HELLO, ${sessionScope.valid_user.name}</h3>
		<br>
		<h4>You have choosen: ${sessionScope.choosen_flight.airlines}
			from ${sessionScope.choosen_flight.depCity} to
			${sessionScope.choosen_flight.arrivalCity}
		</h4>
			
		<form:form method="post" modelAttribute="passenger">
		<table>
			<tr>
				<td>Passenger Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Contact</td>
				<td><form:input path="contact" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Proceed to payment" /></td>
			</tr>
		</table>
	</form:form>
	</div>


</body>
</html>