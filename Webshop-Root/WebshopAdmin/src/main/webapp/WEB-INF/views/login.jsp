<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Webshop Admin Login</title>
</head>
<body>
	<div align="center">
		<h3>PetSupplies Admin Login</h3>
		<form:form action="login.htm" method="post">
			<table>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" /></td>
					<td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="login" /></td>
				</tr>
				<tr>
					<form:errors></form:errors>
					<td colspan="2" style="color: red">${wrongLoginCredentials}</td>
				</tr>
			</table>
			<input type="hidden" name="isadmin" value="Y" />
		</form:form>
	</div>
</body>
</html>