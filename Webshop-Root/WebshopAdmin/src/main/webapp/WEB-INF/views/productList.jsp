<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../layouts/template.jsp" %>
<%@ include file="../layouts/header.jsp" %>
<%@ include file="../layouts/leftpanel.jsp" %>


<div class="main_col">

<h4 id="sucessmsg" class="sucessmsg" style="color:blue">${prodDelMsg}</h4>		
	
	
	<h3>All Products</h3>
	<br>
	<br>
			<c:if test="${!empty productList}">
					<table id="products">
						<tr>
							<th>Product Name</th>
							<th>Description</th>
							<th>Product Price</th>
							<th>Product Category</th>
							<th>Action</th>							
						</tr>
						<c:forEach items="${productList}" var="prod">
							<tr class="alt">								
								<td>${prod.productName}</td>
								<td>${prod.description}</td>
								<td>${prod.price}</td>
								<td>${prod.category.categoryName}</td>								
								<td><a href="editsingleproduct.htm?prodId=${prod.productId}">Edit</a>
									/ <a href="deletesingleproduct.htm?prodId=${prod.productId}">delete</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
</div>
<br class="clearer">
				
<%@ include file="../layouts/footer.jsp" %>