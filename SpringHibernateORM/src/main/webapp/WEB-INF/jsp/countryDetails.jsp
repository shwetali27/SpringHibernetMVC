<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title><spring:message code="country.details" /></title>
<style type="text/css">
	<%@include file = "/publicHtml/world.css"%>
</style>

</head>
<body>
	<h1>
		<spring:message code="application.name" />
	</h1>
		
	<table class="silver" width="260">
		
		<tr>
			<th colspan=2><spring:message code="country.details" /></th>
		</tr>
		<tr>
			<td><spring:message code="country.name" /></td>
			<td>${country.name}</td>
		</tr>
		<tr>
			<td><spring:message code="country.area" /></td>
			<td><fmt:formatNumber type="number" value="${country.area}" /></td>
		</tr>
		<tr>
			<td><spring:message code="country.population" /></td>
			<td><fmt:formatNumber type="number"
					value="${country.population}" /></td>
		</tr>
		<tr>
			<td><spring:message code="country.updatedOn" /></td>
			<td><fmt:formatDate value="${country.populationLastUpdated}" /></td>
		</tr>
		<tr>
			<td><spring:message code="country.currency" /></td>
			<td>${country.currency}</td>
		</tr>
	</table>
	
	
	<table>
		<tr align="right" valign="bottom">
			<button type="submit" onClick="location.href='countryForm.html?id=${country.id}'">edit</button>
				<form action="countryDetails.html" method="post">
					<button type="submit" name="delete"
						onclick="return confirm('Are you sure you want to delete ${country.name}?')">Delete</button>
				</form>	
		</tr>
	</table>
	
	<a href="countryList.html"> &lt;&lt;<spring:message
			code="navigation.back" />
	</a>

</body>
</html>

