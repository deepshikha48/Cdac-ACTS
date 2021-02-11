<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Course Management</title>
<link rel="stylesheet" href="/css/main.css" type="text/css" />
</head>
<body>

	<hr>
	<h1>Student Course Management</h1>
	<hr>
	<br>

	<div>
		<h2>Welcome</h2>
		<a href="<spring:url value='/course/list'/>">Course List</a>
	</div>

</body>
</html>