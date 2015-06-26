<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../layouts/template.jsp"%>
<%@ include file="../layouts/header.jsp"%>
<%@ include file="../layouts/leftpanel.jsp"%>


<div class="main_col">
	<h4 id="sucessmsg" class="sucessmsg" style="color: blue">${saveProductMsg}</h4>

	<form:form method="POST" action="saveproduct.htm"
		commandName="productForm">

		<input type="hidden" name="userAction" value="add">

		<h3>Manage Product - Add New Product</h3>
		<br>
		<br>
		<table border="0" cellspacing="5">
			<tr>
				<td><form:label path="category">
						<h6>Select Category:</h6>
					</form:label></td>

				<td><form:select path="category.categoryId">
						<form:options items="${selectCategoryList}"
							itemLabel="categoryName" itemValue="categoryId" />
					</form:select></td>
				<td><form:errors path="category" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>

			<tr>
				<td><h6>Product Name:</h6></td>
				<td><form:input path="productName" />
				<td><form:errors path="productName" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>

			<tr>
				<td><h6>Product Description:</h6></td>
				<td><form:textarea path="description" /></td>
				<td><form:errors path="description" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>

			<tr>
				<td><h6>Product Price:</h6></td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td align="left"><input type="submit" value="Save Product"
					class="myButton"></td>
				<td align="right"><a href="allproducts.htm" class="myLink">View
						All Products</a>
			</tr>

		</table>

	</form:form>
</div>
<br class="clearer">

<%@ include file="../layouts/footer.jsp"%>