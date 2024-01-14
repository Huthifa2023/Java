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
<title>Login and Registration</title>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body class="w-75 d-flex mx-auto text-center justify-content-around">
	
	<div>
	<h2>Registration</h2>
	<form:form action="/register" method="post" modelAttribute="newUser">
	    <p>
	        <form:label path="username">User Name:</form:label>
	        <form:errors path="username"/>
	        <form:input path="username"/>
	    </p>
	    <p>
	        <form:label path="email">Email:</form:label>
	        <form:errors path="email"/>
	        <form:input type="email" path="email"/>
	    </p>
	    <p>
	        <form:label path="password">Password:</form:label>
	        <form:errors path="password"/>     
	        <form:input type="password" path="password"/>
	    </p>    
	    <p>
	        <form:label path="confirm">Confirm PW:</form:label>
	        <form:errors path="confirm"/>     
	        <form:input type="password" path="confirm"/>
	    </p> 
	    <input type="submit" value="Submit"/>
	</form:form>  
	</div>

	<div>
        <!-- Login Form -->
        <h2>Login</h2>
	<form:form action="/login" method="post" modelAttribute="newLogin">
	    <p>
	        <form:label path="email">Email:</form:label>
	        <form:errors path="email"/>
	        <form:input type="email" path="email"/>
	    </p>
	    <p>
	        <form:label path="password">Password:</form:label>
	        <form:errors path="password"/>     
	        <form:input type="password" path="password"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>  
	</div>

</body>
</html>