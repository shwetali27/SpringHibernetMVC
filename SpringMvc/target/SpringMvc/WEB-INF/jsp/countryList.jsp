<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title><spring:message code="country.plural" /></title>
<style type="text/css">
	<%@include file = "/publicHtml/world.css"%>
</style>
</head>
<body>
	<h1>
		<spring:message code="application.name" />
	</h1>
	<table>
		<tr>
			<td align="right" valign="bottom">
				<button onclick="window.location='countryForm.html'">Add</button>
			</td>
		</tr>
		<tr>
			<td>
				<table class="silver" width="180">
					<tr>
						<th></th>
						<th><spring:message code="country.plural" /></th>
					</tr>
					<c:forEach items="${countries}" var="country">
						<tr>
							<td width="20"><a
								href="<c:url value='countryForm.html?id=${country.id}'/>"> <img
									src="/home/bridgelabz/MavenProject/HelloWorld/src/main/webapp/publicHtml/images/edit.gif" style="border-style: none;" />
							</a></td>
							<td><a href="countryDetails.html?id=${country.id}">
									${country.name} </a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>