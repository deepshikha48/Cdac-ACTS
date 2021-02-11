<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
<link rel="stylesheet" href="/css/main.css" type="text/css" />
</head>
<body>
	<hr>
	<h1>Flight Reservation System</h1>
	<hr>
	<br>

	<div>
		<h2>Something went wrong :(</h2>
		<a href=${requestScope.uri}>Go back and try again</a>
	</div>
</body>
</html>