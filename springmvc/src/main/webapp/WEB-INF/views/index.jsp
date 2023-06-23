<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<h1> This is Home Page.</h1>
<h1> Called by controller</h1>
<h2>url /home</h2>

	<% String name = (String) request.getAttribute("Name");
		%>
		<h1>Name is <%= name %></h1>
	<%Integer id = (Integer) request.getAttribute("id");%>
		<h1>Id is <%=id %></h1>
	<% List<String> friends = (List<String>) request.getAttribute("list");%>
	

	<% for(String s : friends) { %>
	    <h1><%= s %></h1>
	<% } %>
	
		
</body>
</html>