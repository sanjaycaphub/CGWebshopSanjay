<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../layouts/template.jsp" %>
<%@ include file="../layouts/header.jsp" %>
<%@ include file="../layouts/leftpanel.jsp" %>


<div class="main_col">

	<h4 id="sucessmsg" class="sucessmsg" style="color:red">${catDelMsg}</h4>
	
	
	<h3>All Categories</h3>
	<br>
	<br>
		
			<c:if test="${!empty catList}">
					<table id="categories">
						<tr>
							<th>Category Name</th>
							<th>Description</th>
							<th>Action</th>							
						</tr>
						<c:forEach items="${catList}" var="category">
							<tr class="alt">								
								<td>${category.categoryName}</td>
								<td>${category.categoryDesc}</td>
								<td><a href="editsinglecategory.htm?catId=${category.categoryId}">Edit</a>
									/ <a href="deletesinglecategory.htm?catId=${category.categoryId}">delete</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
</div>
<br class="clearer">
				
<%@ include file="../layouts/footer.jsp" %>