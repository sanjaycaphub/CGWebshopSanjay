<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="left_col">


	<h3 align="center">
		<u>Quick Links</u>
	</h3>

	<ul>

		<li></li>
		<li><h6>
				<a href="searchproduct.htm">Search Products</a>
			</h6></li>
		<li></li>
		<li><h6>
				<a href="viewshoppingcart.htm">View Shopping Cart</a>
			</h6></li>
		<li></li>
		<li><h6>
				<a href="signup.htm">New User - Sign Up Now</a>
			</h6></li>
		<li></li>
		<c:choose>
		<c:when test="${empty loginUser}">
		<li><h6>
				<a href="signin.htm">Sign In</a>
			</h6></li>
		<li></li>
		</c:when>
		</c:choose>
	</ul>

</div>