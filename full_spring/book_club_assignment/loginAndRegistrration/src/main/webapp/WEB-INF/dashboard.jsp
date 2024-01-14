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
		<h1>Welcome, ${user.username}></h1>
		<h4>books from everyones shelves</h4>
	</div>
	
	<div>
		<h3><a href="/logout">LogOut</a></h3>
		<h3><a href="/books/new">+ Add to my shelf!</a></h3>
	</div>
	</header>
	
	<main class="mx-auto text-center">
	
		<table class="mx-auto text-center table w-75 mt-4">
		  <tr>
		    <th>ID</th>
		    <th>Title</th>
		    <th>Author Name</th>
		    <th>Posted By</th>
		    
		  </tr>
		  	<c:forEach var="oneBook" items="${allBooks}">
		  <tr>
		    <td>${oneBook.id}</td>
		    <td><a href="/books/${oneBook.id}">${oneBook.title}</a></td>
		    <td>${oneBook.author}</td>
		    <th>${oneBook.user.username}</th>
		  </tr>
		 </c:forEach>
		</table>
	
	</main>

</body>
</html>