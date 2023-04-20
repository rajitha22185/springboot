<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewAll</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<!-- Datatable plugin CSS file -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />

<!-- jQuery library file -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js">
	
</script>

<!-- Datatable plugin JS library file -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js">
	
</script>
</head>
<body>
<div class="container">
	<h1 style="text-align: center; color: white; background-color: black;">BooksInfo</h1>
	<br />
	<table class="table table-striped" id="tableID">
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Book Author</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books}">
				<tr>
					<td><c:out value="${book.bid}" /></td>
					<td><c:out value="${book.name}" /></td>
					<td><c:out value="${book.author}" /></td>
					<td><a class="btn btn-success" href="editbook?id=${book.bid}">
							Edit</a></td>
					<td><a class="btn btn-danger" href="deletebook?id=${book.bid}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="pdf"><button class="btn btn-info">PDF</button></a>
	<a href="excel"><button class="btn btn-warning">Excel</button></a>
	<a href="email"><button class="btn btn-primary">Email</button></a>
	<script>
		/* Initialization of datatable */
		$(document).ready(function() {
			$('#tableID').DataTable({
				pageLength : 5
			});
		});
	</script>
	</div>
</body>
</html>