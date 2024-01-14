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
<title>Books</title>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body class="w-75 mx-auto text-center">
	
	<header class="d-flex justify-content-around">
	<div>
		<h1>${book.title}</h1>
	</div>
	
	<div>
		<h3><a href="/dashboard">back to the shelves</a></h3>
	</div>
	</header> 	
	
	<main class="mx-auto text-center">
		<h4><span class="text-danger">${book.user.username}</span> read <span class="text-info">${book.title}</span> by <span class="text-success">${book.author}</span> </h4>
	 	<h5>here are ${book.user.username}'s thoughts</h5>
	 	
	 	<h6>${book.thoughts }</h6>
	
	</main>
	
	<footer class="mx-auto text-center">
		<c:if test="${user.id == book.user.id}">
		<div class="d-flex justify-content-center">
		<h4><a class="btn btn-primary">edit</a></h4>
		<h4><a href="/delete/${book.id}" class="btn btn-primary">Delete</a></h4>
		</div>
		</c:if>
	
	</footer>

</body>
</html>