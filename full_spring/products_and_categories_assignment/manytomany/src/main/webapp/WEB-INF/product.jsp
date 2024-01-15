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
<title>Product Page</title>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body class="mx-auto w-75">
	<h1 class="text-center">${product.name}</h1>
	
		<h3><a href="/">Home</a></h3>

	<div class="mt-4 border-top"></div>
	<h3>Categories:</h3>
	<ul>
		<c:forEach var="cat" items="${product.categories}">
		<li>${cat.name}</li>
		</c:forEach>
	</ul>
	
	<div class="mt-4 border-top"></div>
	<main>
	
	<h3>Add Category:</h3>
	
	<form:form action="/products/${product.id}" method="post" modelAttribute="newCategory">
		
			<form:select path="id">
				<c:forEach var="category" items="${categoriesToAdd}">
				<form:option value="${category.id}">${category.name}</form:option>
				</c:forEach>
			</form:select>
	
	   <input type="submit" value="Add"/>
	</form:form>
	
	
	</main>
	
	
</body>
</html>