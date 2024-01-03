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
<body class="mx-auto">

	<main class="mx-auto text-center">
		<h2> you have visited <a href="/">http://localhost:8080</a> <c:out value="${count}"></c:out> times.</h2>
		<h3>Test another visit? <a href="/">Revisit again</a> </h3>
	
		<h4>Reset counter! <a href="/reset">Reset to 0</a></h4>
		
		
	</main>

</body>
</html>