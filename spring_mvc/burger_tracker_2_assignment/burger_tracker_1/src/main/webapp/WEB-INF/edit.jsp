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
<title>Burger Tracker</title>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body class="mx-auto text-center w-75">
	<h1>Burger Tracker</h1>
	
	<h2>Edit Burger</h2>
	
	<form:form action="/editBurger/${burger.id}" method="post" modelAttribute="burger" class="w-50 mx-auto text-center">
			<input type="hidden" name="_method" value="put">
	    <p>
	        <form:label path="burgerName">Burger Name</form:label>
	        <form:errors path="burgerName"/>
	        <form:input class="form-control" path="burgerName"/>
	    </p>
	    <p>
	        <form:label path="resturantName">Restaurant Name</form:label>
	        <form:errors path="resturantName"/>
	        <form:input class="form-control" path="resturantName"/>
	    </p>
	    <p>
	        <form:label path="rating">Rating</form:label>
	        <form:errors path="rating"/>
	        <form:input class="form-control" type="number" path="rating"/>
	    </p>
	    <p>
	        <form:label path="notes">Notes</form:label>
	        <form:errors path="notes"/>     
	        <form:textarea class="form-control" path="notes"/>
	    </p>    
	    <input class="btn btn-secondary" type="submit" value="Submit"/>
	</form:form>    	
	
</body>
</html>