<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header">
	<br /> <br />
	<h1>Welcome to PetSupplies Admin</h1>
	<br /> <br />
	<div align="right">
		<h5>
			Hello
			<c:out value="${loginUser.getFirstName()}"></c:out>
		</h5>

		<a href="home.htm"><b>Home</b></a> | <a href="logout.htm"><b>
				Logout</b></a>
	</div>
</div>