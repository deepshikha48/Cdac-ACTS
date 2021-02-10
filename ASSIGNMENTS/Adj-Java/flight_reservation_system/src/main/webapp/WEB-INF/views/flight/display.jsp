<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

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
			<h2>Available Flights</h2>
			<table>
				<tr>
					<th>Airlines</th>
					<th>Departure city</th>
					<th>Arrival city</th>
					<th>Departure date</th>
					<th>Departure time</th>
					<th>Link</th>		
				</tr>
				<c:forEach var="flight" items="${requestScope.flights}">
					<tr>
						<td>${flight.airlines}</td>
						<td>${flight.depCity}</td>
						<td>${flight.arrivalCity}</td>
						<td>${flight.depDate}</td>
						<td>${flight.depTime}</td>
						<td><a href="<spring:url value='/passenger/details?id=${flight.id}'/>">Book now</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>