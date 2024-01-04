<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="w-75 mx-auto">
		<h1 class="text-center">Wellcome To Gold Ninja Game</h1>
		
		<header class="mt-5 d-flex justify-content-around"> 
			<h2>Your Gold: <span class="shadow p-3 mb-5 bg-white rounded"> <c:out value="${gold}"></c:out> </span></h2>
			
			<h2> <a href="/reset">Reset</a> </h2>
		</header>
		
		<main class="d-flex justify-content-around mt-5">
			<div class="border text-center shadow p-3 mb-5 bg-white rounded">
				<h3 class="mt-5">Farm</h3>
				<h4 class="mt-5">(earns 10-20 gold)</h4>
				<form class="mt-4 mb-4" action="/find" method="post">
				<input type="hidden" name="dig" value="farm">
				<button type="submit">Find Gold!</button>
				</form>
			</div>
			
			<div class="border text-center shadow p-3 mb-5 bg-white rounded">
				<h3 class="mt-5">Cave</h3>
				<h4 class="mt-5">(earns 5-10 gold)</h4>
				<form class="mt-4 mb-4" action="/find" method="post">
				<input type="hidden" name="dig" value="cave">
				<button type="submit">Find Gold!</button>
				</form>
			</div>
			
			<div class="border text-center shadow p-3 mb-5 bg-white rounded">
				<h3 class="mt-5">House</h3>
				<h4 class="mt-5">(earns 2-5 gold)</h4>
				<form class="mt-4 mb-4" action="/find" method="post">
				<input type="hidden" name="dig" value="house">
				<button type="submit">Find Gold!</button>
				</form>
			</div>
			
			<div class="border text-center shadow p-3 mb-5 bg-white rounded">
				<h3 class="mt-5">Quest</h3>
				<h4 class="mt-5">(earns/takes 0-50 gold)</h4>
				<form class="mt-4 mb-4" action="/find" method="post">
				<input type="hidden" name="dig" value="quest">
				<button type="submit">Find Gold!</button>
				</form>
			</div>
		
		</main>
		
		<section>
			<h2>Activities:</h2>
			
			<div>
				<c:forEach var="message" items="${activities}">
    	   		 	<p><c:out value="${message}"></c:out></p>
    			</c:forEach>
			
			</div>
			
		</section>
</body>
</html>