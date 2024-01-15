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
<title>Home</title>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body class="mx-auto w-75">
	<h1 class="text-center">Home Page</h1>
	
	<h3><a href="products/new">New Product</a></h3>
	<h3><a href="/categories/new">New Category</a></h3>
	
	<div class="mt-4 border-top"></div>
	
	
	<table class="table table-bordered w-75 text-center mx-auto mt-4">
	  <tr>
	    <th>Products</th>
	    <th>Categories</th>
	  </tr>
	  
	  <tr>
	    <td>
	    	<ul>
	    		<c:forEach var="product" items="${products}">
	    		<li><a href="/products/${product.id}">${product.name}</a></li>
	    		</c:forEach>
	    	</ul>
	    </td>
	    <td>
	    	<ul>
	    		<c:forEach var="category" items="${categories}">
	    		<li><a href="/categories/${category.id}">${category.name}</a></li>
	    		</c:forEach>
	    	</ul>
	    </td>
	  </tr>
	  
	</table>
	
</body>
</html>