<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page isELIgnored="false"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Help Page</title>
</head>
<body>
<h1>This is Help page</h1>

	<% //String nName = (String) request.getAttribute("name"); %>
	<h1> My name is ${name}
		<%-- <%= nName --%>
	</h1>
	
	<%// Integer roll_number = (Integer) request.getAttribute("rN"); %>
	<h1> Roll Number = ${rN}
		<%--<%= roll_number %> --%>
	</h1>
</body>
</html>