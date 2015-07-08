<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../layouts/template.jsp"%>
<%@ include file="../layouts/header.jsp"%>
<%@ include file="../layouts/leftpanel.jsp"%>


<script>

function updateCart(productId)
{
	var prodQuantity = document.getElementById(productId).value;
	  var hrefLink = "updatecart.htm?prodId="+productId+"&quantity="+prodQuantity;
	 	document.location.href = hrefLink;
}

</script>

<div class="main_col">

	<h5 style="color: blue" align="right">${additemstocart}</h5>
	<br>
	<h3>Your Shopping Cart</h3>
	<br>

	<c:if test="${empty cartList}">
		<h6>Cart is Empty</h6>
		<br>
	</c:if>

	<c:if test="${not empty cartList}">

		<table id="products">
			<tr>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Product Category</th>
				<th>Quantity Added</th>
				<th>Modify Quantity</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${cartList}" var="prod">
				<tr class="alt">
					<td>${prod.productName}</td>
					<td>${prod.price}</td>
					<td>${prod.category.categoryName}</td>
					<td>${prod.quantity}</td>
					<td><select name="select" id="${prod.productId}">
							<option value="1" selected>1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select></td>
					<td><a href="#" onclick="updateCart(${prod.productId});">
							Update</a> / <a href="removefromcart.htm?prodId=${prod.productId}">
							Remove</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
	</c:if>
	<div>
		<a href="searchproduct.htm" class="myLink">Continue Shopping</a>
		<c:if test="${empty loginUser}">
			<a href="proceedcheckout.htm" class="myLink">Guest Checkout</a>
			<a href="signin.htm" class="myLink">Sign In</a>
		</c:if>
		<c:if test="${not empty loginUser}">
			<a href="proceedcheckout.htm" class="myLink">Proceed to Checkout</a>
		</c:if>
	</div>
</div>



<br class="clearer">

<%@ include file="../layouts/footer.jsp"%>