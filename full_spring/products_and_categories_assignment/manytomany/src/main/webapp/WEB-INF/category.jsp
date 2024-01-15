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
<title>Category Page</title>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body class="mx-auto w-75">
	<h1 class="text-center">${product.name}</h1>
	
		<h3><a href="/">Home</a></h3>

	<div class="mt-4 border-top"></div>
	<h3>Products:</h3>
	<ul>
		<c:forEach var="prod" items="${category.products}">
		<li>${prod.name}</li>
		</c:forEach>
	</ul>
	
	<div class="mt-4 border-top"></div>
	<main>
	
	<h3>Add Product:</h3>
	
	<form:form action="/categories/${category.id}" method="post" modelAttribute="newProduct">
		
			<form:select path="id">
				<c:forEach var="product" items="${productsToAdd}">
				<form:option value="${product.id}">${product.name}</form:option>
				</c:forEach>
			</form:select>
	
	   <input type="submit" value="Add"/>
	</form:form>
	
	
	</main>
	
	
</body>
</html>