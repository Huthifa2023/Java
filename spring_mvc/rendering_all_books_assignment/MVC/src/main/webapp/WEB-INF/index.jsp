<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All books</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="w-75 mx-auto text-center">
	<h1 class="mx-auto text-center">All Books</h1>
	<table class="table">
	    <thead>
	        <tr>
	            <th>ID</th>
	            <th>Title</th>
	            <th>Language</th>
	            <th>Number of Pages</th>
	        </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="book" items="${books}">
	        <tr>
	            <th><a><c:out value="${book.getId()}"></c:out></a></th>
	            <th><a href="/show/<c:out value="${book.getId()}"></c:out>"><c:out value="${book.getTitle()}"></c:out></a></th>
	            <th><a><c:out value="${book.getLanguage()}"></c:out></a></th>
	            <th><a><c:out value="${book.getNumberOfPages()}"></c:out></a></th>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
</body>
</html>