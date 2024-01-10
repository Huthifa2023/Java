<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="w-75 mx-auto text-center">
		<h1>Burbank Location Ninjas</h1>
		
		<table class="table">
		  <tr>
		    <th>First NAme</th>
		    <th>Last Name</th>
		    <th>Age</th>
		  </tr>
		  <c:forEach var="ninja" items="${theDojo.ninjas}">
		  <tr>
		    <td>${ninja.first_name}</td>
		    <td>${ninja.last_name}</td>
		    <td>${ninja.age}</td>
		  </tr>
		  	</c:forEach>
		</table>
</body>
</html>