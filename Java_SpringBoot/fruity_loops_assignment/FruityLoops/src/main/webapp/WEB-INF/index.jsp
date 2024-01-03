<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruit Store</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="mx-auto text-center">
	<h1>Fruit Store</h1>
	
	<table class="mx-auto table table-striped w-75">
	  <tr>
	    <th>Name</th>
	    <th>Price</th>
	  </tr>
	  <c:forEach var="onefruit" items="${fruits}">
	  <tr>
	    <td><c:out value="${onefruit.getName()}"></c:out></td>
	    <td><c:out value="${onefruit.price}"></c:out></td>
	  </tr>
	  </c:forEach>
	</table>
	
</body>
</html>