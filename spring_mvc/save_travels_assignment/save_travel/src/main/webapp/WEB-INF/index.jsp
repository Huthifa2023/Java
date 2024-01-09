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
<title>Save Travels</title>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body class="mx-auto text-center w-75">
	<h1>Save Travels</h1>
	
	
	<table class="table w-50 mx-auto text-center">
	  <tr>
	    <th>Expense</th>
	    <th>Vendor</th>
	    <th>Amount</th>
	    <th>Action</th>
	  </tr>
	  
	  		<c:forEach var="travel" items="${travels}">
		  <tr>
		    <td><c:out value="${travel.expense}"></c:out></td>
		    <td><c:out value="${travel.vendor}"></c:out></td>
		    <td>$<c:out value="${travel.amount}"></c:out></td>
		    <td><a href="/travel/edit/<c:out value="${travel.id}"></c:out>">edit</a></td>
		  </tr>
		  </c:forEach>
	  
	</table>
	
	<h2>Add an expense</h2>
	<form:form action="/addtravel" method="post" modelAttribute="travel">
	    <p>
	        <form:label path="expense">Expense</form:label>
	        <form:errors path="expense"/>
	        <form:input path="expense"/>
	    </p>
	    <p>
	        <form:label path="vendor">Vendor</form:label>
	        <form:errors path="vendor"/>
	        <form:textarea path="vendor"/>
	    </p>
	    <p>
	        <form:label path="amount">Amount</form:label>
	        <form:errors path="amount"/>     
	        <form:input type="number" path="amount"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>    
	
	
	
</body>
</html>