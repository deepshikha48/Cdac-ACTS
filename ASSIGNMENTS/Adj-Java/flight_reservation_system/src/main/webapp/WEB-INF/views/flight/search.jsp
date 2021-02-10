<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
		
			<h2>Search Available Flights</h2>
			<h3 style="color: red; text-align: centre">${requestScope.error.mesg}</h3>
			<h3 style="color: red; text-align: centre">${requestScope.msg}</h3>
	
			<form method="post">
				<table>
					<tr>
						<td>Enter departure city</td>
						<td><input type="text" name="from" /></td>
					</tr>
					<tr>
						<td>Enter arrival city</td>
						<td><input type="text" name="to" /></td>
					</tr>
	
					<tr>
						<td>Enter departure date</td>
						<td><input type="date" name="date" /></td>
					</tr>
	
					<tr>
						<td><input type="submit" value="search" /></td>
					</tr>
				</table>
			</form>
	
		</div>
	
	</body>
</html>