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
<title>${dorm.name}</title>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body class="w-75 mx-auto">
	<h1 class="text-center">${dorm.name} Students</h1>
	
	<div class="w-75">
		<h3><a href="/dorms">Dashboard</a></h3>
	</div>
	
	
	<form:form action="/dorms/${dorm.id}" method="post" class="form-inline mx-auto text-center" modelAttribute="student">
		<input type="hidden" name="_method" value="put">
		  <div class="form-group mb-2">
		    <label class="sr-only">All Students:</label>
<%-- 		    <form:errors path="dorm"/>
 --%>		    <form:select path="dorm">
		    <c:forEach var="onestudent" items="${allStudents}">
		    <form:option value="${onestudent}" path="dorm">${onestudent.name} (${onestudent.dorm.name})</form:option>
		    </c:forEach>
		    </form:select>
		  </div>
		  
		  <div class="form-group mb-2">
		    <button type="submit" class="btn btn-primary mb-2">Move To ${dorm.name}</button>
		  </div>
	</form:form>
	
	<table class="table table-dark text-center">
	  <tr>
	    <th><h4>Student in ${dorm.name}</h4></th>
	    <th><h4>Action</h4></th>
	  </tr>
	  <c:forEach var="student" items="${dorm.students}">
	 	 <tr>
		    <td>${student.name}</td>
		    <td><a href="dorms/${onedorm.id}/remove">Remove</a></td>
		  </tr>
	  </c:forEach>
	</table>
	
</body>
</html>