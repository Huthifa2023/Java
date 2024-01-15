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
<title>New Category</title>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body class="mx-auto w-75">
	<h1 class="text-center">New Category</h1>
	
		<h3><a href="/">Home</a></h3>

	<div class="mt-4 border-top"></div>
	
	<main>
	
	<form:form action="/categories/new" method="post" modelAttribute="newCategory">
		<table class="table table-bordered w-75 text-center mx-auto mt-4">
		  
		  <tr>
		    <td> Name: </td>
		    <td>
		    	<form:errors path="name"/>
	      		<form:input path="name"/>
		    </td>
		  </tr>

		  <tr>
		      <td colspan="2"><input class="btn btn-primary mx-auto text-center" type="submit" value="Submit"/></td>
	    	</tr>
		</table>
	</form:form>
	
	
	</main>
	
	
</body>
</html>