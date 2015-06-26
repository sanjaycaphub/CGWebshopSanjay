<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>

function signout()
{
	
	var r = confirm("If you logout your shopping cart will be made empty. Press OK to continue.");
	
	if(r == true){  		
	document.location.href = "signout.htm";
	location.reload();
	}
	else 
		return false;

}

</script>

<div class="header">
	<br /> <br />
	<h1>Welcome to PetSupplies Store</h1>
	<h6>One stop destination for all your pets needs...</h6>
	<br /> <br />
	<div align="right">
		
		<c:choose>
		<c:when test="${not empty loginUser}">		
			<h5>
				Hello
				<c:out value="${loginUser.getFirstName()}"></c:out>
			</h5>
		</c:when>
		<c:otherwise>
		<h5>Hello</h5>
		</c:otherwise>
</c:choose>

		<a href="home.htm"><b>Home</b></a>
		<c:if test="${!empty loginUser}">  | <a id= "logoutLink" name="logoutLink" href="#" onclick="signout();"><b>
					SignOut</b></a>
		</c:if>
	</div>
</div>