<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
			<h2>Status</h2>
			<h4>Ticket for ${sessionScope.choosen_flight.arrivalCity} booked successfully !!</h4>
			<br>
			<a href="<spring:url value='/user/logout'/>">logout</a>
		</div>
</body>
</html>