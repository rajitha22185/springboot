<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddBook</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h2 style="color: green; justify-content: center">${msg}</h2>
	<div class="mb-3 d-flex justify-content-center">
		<form:form action="/create" method="post" modelAttribute="book">
    	<h2>Add Book</h2>
		<form:label class="form-label" path="name">Book Name</form:label>
			<form:input class="form-control" path="name"  />
			
			<form:label class="form-label" path="author">Author Name</form:label>
			<form:input class="form-control"  path="author"  />
			<input class="btn btn-success" type="submit" value="Submit">
			<br/><br/>
		<a href="/viewall">View All Books</a>
		</form:form>
	</div>
	
	
</div>

</body>
</html>