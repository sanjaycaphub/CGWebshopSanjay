<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../layouts/template.jsp"%>
<%@ include file="../layouts/header.jsp"%>
<%@ include file="../layouts/leftpanel.jsp"%>

<div class="main_col">
	<h5 align="right" style="color:blue">${newOrderMsg}</h5>
	<br>
	<h3>Checkout</h3>
	<br>

	<form:form method="POST" action="submitorder.htm"
		commandName="userorder">
		<table>
			<tr>
				<td><h6>Ship Products to Following Address</h6></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<c:if test="${empty loginUser}">
			<tr>
				<td>First Name:</td>
				<td><form:input path="guestFirstName" /></td>
				<td><form:errors path="guestFirstName" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="guestLastName" /></td>
				<td><form:errors path="guestLastName" /></td>
			</tr>
			</c:if>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>Street Address:</td>
				<td><form:textarea path="shippingAddress" /></td>
				<td><form:errors path="shippingAddress" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input path="shippingCity" /></td>
				<td><form:errors path="shippingCity" /></td>
			</tr>
			<tr>
				<td>Zip:</td>
				<td><form:input path="shippingZip" /></td>
				<td><form:errors path="shippingZip" /></td>
			</tr>	
			
		</table>
		<br>

		<c:if test="${not empty (userorder.orderItems)}">
			<h3>Order Summary</h3>
			<table id="products">
				<tr>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Product Price</th>
				</tr>
				<c:forEach items="${userorder.orderItems}" var="orderitems">
					<tr class="alt">
						<td>${orderitems.products.productName}</td>
						<td>${orderitems.prodQuantity}</td>
						<td>${orderitems.price}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br>
		
		<table align="center">
			<tr>
				<td><form:hidden path="amountTotal" /></td>
				<td><h5>Order Amount Total: ${userorder.amountTotal}</h5></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit Order" class="myButton"></td>
				<td><a href="viewshoppingcart.htm" class="myLink">Modify
						Items</a></td>
				<td><a href="searchproduct.htm" class="myLink">Continue
						Shopping</a></td>
			</tr>
		</table>

	</form:form>
</div>
<br class="clearer">

<%@ include file="../layouts/footer.jsp"%>