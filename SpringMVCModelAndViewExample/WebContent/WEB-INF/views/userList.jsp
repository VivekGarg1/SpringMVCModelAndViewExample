<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Store Application</title>
</head>
<body>
<a href="/SpringMVCModelAndViewExample/">Back</a>
	<h2 align="center">User Management Application</h2>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h3>List of users</h3>
			</caption>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Age</th>
				<th>Country</th>
			</tr>

			<c:forEach var="user"  items="${usersList}">
			<tr>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.age}" /></td>
				<td><c:out value="${user.country}" /></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>