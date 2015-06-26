<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../layouts/template.jsp"%>
<%@ include file="../layouts/header.jsp"%>
<%@ include file="../layouts/leftpanel.jsp"%>

<div class="main_col">
	<div align="center">

		<h5 align="right" style="color:blue">${registerUserMsg}</h5>
		<br>
		<h3>Sign Up is Easy and Free !!!</h3>
		<br>

		<form:form method="POST" action="registeruser.htm"
			commandName="userForm">


			<table>

				<tr>
					<td><h6>First Name:</h6></td>
					<td><form:input path="firstName" />
					<td>
					<td><form:errors path="firstName" cssStyle="color:red" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td><h6>Last Name:</h6></td>
					<td><form:input path="lastName" />
					<td>
					<td><form:errors path="lastName" cssStyle="color:red" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td><h6>UserName:</h6></td>
					<td><form:input path="userName" />
					<td>
					<td><form:errors path="userName" cssStyle="color:red" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td><h6>Password:</h6></td>
					<td><form:password path="password" />
					<td><form:errors path="password" cssStyle="color:red" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td><h6>Email:</h6></td>
					<td><form:input path="email" />
					<td>
					<td><form:errors path="email" cssStyle="color:red" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td><h6>Street Address:</h6></td>
					<td><form:textarea path="streetAddress" />
					<td>
					<td><form:errors path="streetAddress" cssStyle="color:red" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td><h6>City:</h6></td>
					<td><form:input path="city" />
					<td>
					<td><form:errors path="city" cssStyle="color:red" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td><h6>Zipcode:</h6></td>
					<td><form:input path="zip" />
					<td>
					<td><form:errors path="zip" cssStyle="color:red" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>

				<tr>
					<td><input type="submit" value="Register" class="myButton"></td>
				</tr>
			</table>
		</form:form>
	</div>
</div>


<br class="clearer">

<%@ include file="../layouts/footer.jsp"%>