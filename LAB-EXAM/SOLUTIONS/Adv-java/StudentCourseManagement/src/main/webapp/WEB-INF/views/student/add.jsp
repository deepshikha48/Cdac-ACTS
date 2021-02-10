<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Course Management</title>
<link rel="stylesheet" href="/css/main.css" type="text/css" />
</head>
<body>
	<div>
		<h1>Add New Student</h1>
		<form:form method="post" modelAttribute="student">
			<table>
				<tr>
					<td>Enter Name</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Enter Address</td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td>Enter DOB</td>
					<td><form:input type="date" path="dob" /></td>
				</tr>
				<tr>
					<td>Enter CGPA</td>
					<td><form:input type="number" path="cgpa" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Admit Student" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
