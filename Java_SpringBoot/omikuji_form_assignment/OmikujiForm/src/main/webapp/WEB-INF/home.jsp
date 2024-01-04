<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="mx-auto text-center">

	<h1>Send an Omikuji</h1>
	
	<div class="mx-auto text-center">
		
		<form class="w-50 mx-auto text-center" action="/sendomi" method="POST">
			<label>Pick any number from 5 to 25</label>
			<input class="form-control" type="number" name="number">
			
			<label>Enter the name of any city</label>
			<input  class="form-control" type="text" name="city">
			
			<label>Enter a name of any real person</label>
			<input class="form-control" type="text" name="person">
			
			<label>Enter professional endeavor or hobby</label>
			<input class="form-control" type="text" name="hobby">
			
			<label>Enter any type of living thing</label>
			<input class="form-control" type="text" name="livingthing">
			
			<label>Say something nice to someone</label>
			<input class="form-control" type="text" name="nice">
			
			<label>send and show a friend</label>
			<button class="btn btn-primary mb-2" type="submit"> Send </button>
		</form>
	
			
	</div>
	
</body>
</html>