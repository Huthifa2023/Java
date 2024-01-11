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
<title>New Student</title>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body class="w-75 mx-auto">
	<h1 class="text-center">New Student</h1>
	
	<div class="w-75">
		<h3><a href="/dorms">Dashboard</a></h3>
	</div>
	
	<form:form action="/students/new" method="post" modelAttribute="student" class="form-inline mx-auto text-center">
	    <div class="form-group mb-2">
		    <form:label path="name" for="DormnewDorm" class="sr-only">Name:</form:label>
		    <form:errors path="name"/>
		    <form:input path="name" type="text" class="form-control" id="DormnewDorm" />
		  </div>
		  <div class="form-group mb-2">
		    <form:label path="dorm" for="DormnewDorm" class="sr-only">Dorm:</form:label>
		    <form:errors path="dorm"/>
		    
		    <form:select path="dorm">
		    <c:forEach var="onedorm" items="${dorms}">
		    <form:option value="${onedorm.id}">${onedorm.name}</form:option>
		    </c:forEach>
		    </form:select>
		    
		  </div>
	    	<button type="submit" class="btn btn-primary mb-2">Add Student</button>
	</form:form>
	
	
</body>
</html>

</body>
</html>