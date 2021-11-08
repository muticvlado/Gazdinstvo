<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista racuna</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<jsp:include page="include/header.jsp"></jsp:include>

<h3>Lista racuna</h3>
<hr>
<br>
<a href="new-racun-form" class="novo">Novi racun</a>
<br><br>
<table>
	<tr><th>#</th><th>Rb</th><th>Kupac</th><th>Datum</th><th>Broj racuna</th><th>Action</th></tr>
	<c:forEach items="${racuni}" var="racun" varStatus="rb">
		<tr>
			<td>${racun.id}</td>
			<td>${rb.count}</td>
			<td>${racun.kupac.naziv}</td>
			<td>${racun.datum}</td>
			<td>${racun.broj}</td>
			<td>
				<a href="racun-edit?id=${racun.id}"><i class="fas fa-edit edit"></i></a> | 
				<a href="racun-delete?id=${racun.id}" onclick="return confirm('Brisanje racuna?')"><i class="far fa-trash-alt delete"></i></a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>