<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Course Management</title>
<link rel="stylesheet" href="/css/main.css" type="text/css" />
</head>
<body>
	<h1>Student Course Management</h1>
	<div>
		<h2>List Of Courses</h2>
		<table class="for_table_border">

			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Delete Course</td>
				<td>Add Student</td>

			</tr>
			<c:forEach var="c" items="${requestScope.courses}">

				<tr>
					<td>${c.id}</td>
					<td>${c.courseName}</td>
					<td><a href="<spring:url value='/course/delete?id=${c.id}'/>">delete</a></td>
					<td><a href="<spring:url value='/student/add?id=${c.id}'/>">add</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>