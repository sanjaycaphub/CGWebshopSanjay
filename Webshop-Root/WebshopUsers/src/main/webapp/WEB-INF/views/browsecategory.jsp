<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../layouts/template.jsp"%>
<%@ include file="../layouts/header.jsp"%>
<%@ include file="../layouts/leftpanel.jsp"%>


<div class="main_col">
	<form method="GET" action="categoryproducts.htm">
		<table>
			<tr>
				<td><h6>Browse By Category</h6></td>
				<td><select name='selectcategory'
					onload="this.form.submit();">
						
						<c:forEach items="${selectCategoryList}" var="category">
							<option value="${category.categoryId}">${category.categoryName}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
	</form>

	<c:if test="${!empty showProductsList}">

		<table id="categories">
			<tr>
				<th>Product Name</th>
				<th>Description</th>
				<th>Product Price</th>
				<th>Product Category</th>
				<th>Action</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${showProductsList}" var="prod">
				<tr class="alt">
					<td>${prod.productName}</td>
					<td>${prod.description}</td>
					<td>${prod.price}</td>
					<td>${prod.category.categoryName}</td>
					<td><a href="#" onclick="addToCart(${prod.productId});">Add
							to Cart</a></td>
					<td><select name="select" id="${prod.productId}">
							<option value="1" selected>1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select></td>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="viewshoppingcart.htm">View Shopping Cart</a></td>
			</tr>
		</table>

	</c:if>
	</body>
	</html>