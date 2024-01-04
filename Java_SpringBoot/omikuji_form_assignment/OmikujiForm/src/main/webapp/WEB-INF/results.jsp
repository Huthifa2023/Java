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
<body class="mx-auto text-center">
	
	<h1>Here is your Omikuji</h1>
	
	<div class="w-25 bg-info mx-auto text-center">
		<h4>
			In <c:out value="${number}"></c:out> you will live in <c:out value="${city}"></c:out>
			with <c:out value="${person}"></c:out> as your roomate, <c:out value="${hobby}"></c:out>
			for a living, The next time you see a <c:out value="${livingthing}"></c:out>
			you will have good luck, also <c:out value="${nice}"></c:out>.
		</h4>
	
			<a href="/omikuji">Go Back</a>
	</div>
	
</body>
</html>