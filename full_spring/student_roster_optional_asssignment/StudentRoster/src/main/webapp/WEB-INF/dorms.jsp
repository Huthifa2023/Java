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
<title>Dorms</title>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body class="w-75 mx-auto">
	<h1 class="text-center">Dorms</h1>
	
	<div class="w-75">
		<h3><a href="/dorms/new">Add new Dorm</a></h3>
		<h3><a href="/students/new">Add new Student</a></h3>
	</div>
	
	<table class="table table-dark text-center">
	  <tr>
	    <th><h4>Dorm</h4></th>
	    <th><h4>Action</h4></th>
	  </tr>
	  <c:forEach var="onedorm" items="${dorms}">
	 	 <tr>
		    <td>${onedorm.name}</td>
		    <td><a href="dorms/${onedorm.id}">See Students</a></td>
		  </tr>
	  </c:forEach>
	</table>
	
	
</body>
</html>