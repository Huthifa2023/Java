<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>huthifa first Spring jsp</title>
</head>
<body>
	<h1 style="color: red;">Hello World</h1>
	
	<% for(int i=0; i<5; i++) { %>
		<h2><%= i%></h2>
	<% } %>
	
	<h3> The time is: <%= new Date() %></h3>
	
	<h1>two plus two is: </h1>
	<h2><c:out value="${2+2}"></c:out></h2>
	
	<h1>Fruit of the Day</h1>
	<h2><c:out value="${fruit}"/></h2>

	
</body>
</html>