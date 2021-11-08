<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista kupaca</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<jsp:include page="include/header.jsp"></jsp:include>

<h3>Lista kupaca</h3>
<hr>
<br>
<a href="kupac-form" class="novo">Novi kupac</a>
<br><br>
<table>
	<tr><th>#</th><th>Naziv</th><th>Adresa</th><th>Mesto</th><th>Telefon</th><th>Action</th></tr>
	<c:forEach items="${kupci}" var="kupac">
		<tr>
			<td>${kupac.id}</td>
			<td>${kupac.naziv}</td>
			<td>${kupac.adresa}</td>
			<td>${kupac.mesto}</td>
			<td>${kupac.telefon}</td>
			<td>
				<a href="kupac-edit?id=${kupac.id}"><i class="fas fa-edit edit"></i></a> | 
				<a href="kupac-delete?id=${kupac.id}" onclick="return confirm('Brisanje kupca?')"><i class="far fa-trash-alt delete"></i></a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>