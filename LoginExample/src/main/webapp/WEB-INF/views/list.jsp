<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Database</h1>
<table>
	<tr>
	<td>Id	</td>
	<td>Username	</td>
	<td>Password	</td>
	</tr>
	
	<c:forEach items="${list}" var="login">
			<tr>
				<td>${login.getId()}</td>
				<td>${login.getUsername()}</td>
				<td>${login.getPassword()}</td>
			</tr>
		
	</c:forEach>
</table>
</body>
</html>