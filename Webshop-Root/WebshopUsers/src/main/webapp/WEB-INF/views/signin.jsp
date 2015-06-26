<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="../layouts/template.jsp"%>
<%@ include file="../layouts/header.jsp"%>
<%@ include file="../layouts/leftpanel.jsp"%>

<div class="main_col">
	<div align="center">

		<h3>PetSupplies Users Login</h3>
		<br> <br>

		<form:form action="signin.htm" method="post">
			<table>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" /></td>
					<td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="login" class="myButton" /></td>
				</tr>
				<tr>
					<form:errors></form:errors>
					<td colspan="2" style="color: red">${wrongLoginCredentials}</td>
				</tr>
			</table>
			<input type="hidden" name="isadmin" value="N" />
		</form:form>
	</div>
</div>


<br class="clearer">

<%@ include file="../layouts/footer.jsp"%>