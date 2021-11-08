<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista artikala</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<jsp:include page="include/header.jsp"></jsp:include>

<h3>Lista artikala</h3>
<hr>
<br>
<a href="artikal-form" class="novo">Novi artikal</a>
<br><br>
<table>
	<tr><th>#</th><th>Naziv</th><th>Jm</th><th>Poreska stopa</th><th>Cena</th><th>Action</th></tr>
	<c:forEach items="${artikli}" var="artikal">
		<tr>
			<td>${artikal.id}</td>
			<td>${artikal.naziv}</td>
			<td>${artikal.jm}</td>
			<td><fmt:formatNumber type="percent">${artikal.porez}</fmt:formatNumber></td>
			<td>${artikal.cena}</td>
			<td>
				<a href="artikal-edit?id=${artikal.id}"><i class="fas fa-edit edit"></i></a> | 
				<a href="artikal-delete?id=${artikal.id}" onclick="return confirm('Brisanje artikla?')"><i class="far fa-trash-alt delete"></i></a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>