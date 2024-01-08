<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
		<h1>Wellcome</h1>
		<h2>Book Title: <c:out value="${title}"></c:out></h2>
		<h3>Book Description: <c:out value="${description}"></c:out></h3>
		<h3>Book Language: <c:out value="${language}"></c:out></h3>
		<h3>Number of pages: <c:out value="${numPages}"></c:out></h3>
</body>
</html>