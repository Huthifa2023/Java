<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo JSP</title>

<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/script.js"></script>

</head>
<body>

	<h1>Hello World</h1>
	
	<h1>Fruit of the Day</h1>
	<h2><c:out value="${dojoName}"/></h2>
	
	
	<h1>Dojo Locations</h1>
    <c:forEach var="oneDojo" items="${dojosFromMyController}">
        <p><c:out value="${oneDojo}"></c:out></p>
    </c:forEach>
    
    <h1>how many times i visit this page?</h1>
    <p>	until now you visit this page:	<c:out value="${count}"></c:out> times</p>
	
</body>
</html>