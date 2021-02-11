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
		<%-- /user/login method=post--%>
		<h1>Flight Reservation System</h1>
		<div>
		
			<h2>Sign In</h2>
			<h3 style="color: red; text-align: centre">${requestScope.mesg}</h3>
			<h3 style="color: red; text-align: centre">${requestScope.error.mesg}</h3>
			
			<form method="post">
				<table>
					<tr>
						<td>Enter User Email</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td>Enter Password</td>
						<td><input type="password" name="password" /></td>
					</tr>
	
					<tr>
						<td><input type="submit" value="Login" /></td>
					</tr>
				</table>
			</form>
	
		</div>
	
	</body>
</html>