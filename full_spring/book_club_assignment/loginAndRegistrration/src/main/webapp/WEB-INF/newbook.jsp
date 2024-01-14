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
		<h1>Welcome, to your Book shelf!</h1>
	</div>
	
	<div>
		<h3><a href="/dashboard">back to the shelves</a></h3>
	</div>
	</header>
	
	<main class="mx-auto text-center">
	
		<form:form action="/books/new" method="post" modelAttribute="newBook">
		    <p>
		        <form:label path="title">Title:</form:label>
		        <form:errors path="title"/>
		        <form:input path="title"/>
		    </p>
		    <p>
		        <form:label path="author">Author:</form:label>
		        <form:errors path="author"/>
		        <form:input path="author"/>
		    </p>
		    <p>
		        <form:label path="thoughts">My thoughts:</form:label>
		        <form:errors path="thoughts"/>     
		        <form:input path="thoughts"/>
		    </p>    
		    	
		    <input type="submit" value="Submit"/>
		</form:form> 
	
	</main>

</body>
</html>