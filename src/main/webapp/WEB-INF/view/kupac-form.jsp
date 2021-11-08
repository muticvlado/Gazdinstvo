<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kupac</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<jsp:include page="include/header.jsp"></jsp:include>

<h3>KUPAC xtssdasada</h3>
<hr>
<br>
<form:form action="kupac-save" modelAttribute="kupac">
<table>
	<form:hidden path="id"/>
	<tr><td>Naziv</td><td><form:input path="naziv"/></td></tr>
	<tr><td>Adresa</td><td><form:input path="adresa"/></td></tr>
	<tr><td>Mesto</td><td><form:input path="mesto"/></td></tr>
	<tr><td>Pib</td><td><form:input path="pib"/></td></tr>
	<tr><td>Telefon</td><td><form:input path="telefon"/></td></tr>
	<tr><td>Email</td><td><form:input path="email"/></td></tr>
	<tr><td colspan="2"><input type="submit" value="Save"></td></tr>
</table>
</form:form>
</body>
</html>