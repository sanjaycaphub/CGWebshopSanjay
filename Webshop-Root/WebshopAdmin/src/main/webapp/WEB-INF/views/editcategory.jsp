<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../layouts/template.jsp"%>
<%@ include file="../layouts/header.jsp"%>
<%@ include file="../layouts/leftpanel.jsp"%>


<div class="main_col">
	<h4 id="sucessmsg" class="sucessmsg" style="color: blue">${saveCategoryMsg}</h4>

	<form:form method="POST" action="savecategory.htm"
		commandName="categoryForm">

		<input type="hidden" name="userAction" value="edit">
		<form:hidden path="categoryId" />

		<h3>Manage Category - Edit Category</h3>
		<br>
		<br>
		<table border="0" cellspacing="5">
			<tr>
				<td><h6>Category Name:</h6></td>
				<td><form:hidden path="categoryName" /><b>${categoryForm.categoryName}</b></td>
				<td><form:errors path="categoryName" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>

			<tr>
				<td><h6>Category Description:</h6></td>
				<td><form:textarea path="categoryDesc" cols="24" rows="4" /></td>
				<td><form:errors path="categoryDesc" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>

			<tr>
				<td align="left"><input type="submit" value="Save Category"
					class="myButton"></td>
				<td align="right"><a href="allcategories.htm" class="myLink">View
						All Categories</a>
			</tr>

		</table>
	</form:form>
</div>
<br class="clearer">

<%@ include file="../layouts/footer.jsp"%>