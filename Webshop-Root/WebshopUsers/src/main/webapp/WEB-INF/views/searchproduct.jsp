<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../layouts/template.jsp"%>
<%@ include file="../layouts/header.jsp"%>
<%@ include file="../layouts/leftpanel.jsp"%>


<script>

function addToCart(productId)
{
	
	var prodQuantity = document.getElementById(productId).value;
	  var hrefLink = "addtocart.htm?prodId="+productId+"&quantity="+prodQuantity;
	 	document.location.href = hrefLink;
}

</script>


<div class="main_col">
<h5 style="color:blue" align="right">${cartaddemsg}</h5>

	<form method="GET" action="productsearch.htm">

		<h3>Search Product</h3>
		<br> <br>
		<table width="95%">
			<tr>
				<td><h6>Browse By Category:</h6></td>
				<td><select name='selectcategory'>
						<option value="0" label="All" />
						<c:forEach items="${selectCategoryList}" var="category">
							<option value="${category.categoryId}">${category.categoryName}</option>
						</c:forEach>
				</select></td>
				<td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td align="center"><h6 style="color: red">
						<i>OR</i>
					</h6></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td><h6 style="color: green">
						<i>Search By Following:</i>
					</h6></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td><h6>Product Name:</h6></td>
				<td><input type="text" name="prodname" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td><h6>Product Description:</h6></td>
				<td><input type="text" name="proddesc" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
		</table>
		<br>
		<div align="right">
			<input type="submit" value="Search" class="myButton">
		</div>



	</form>
	<br> <br>
	
	<c:if test="${!empty showProductsList}">

		<table id="products">
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

		</table>

	</c:if>
</div>

<br class="clearer">

<%@ include file="../layouts/footer.jsp"%>