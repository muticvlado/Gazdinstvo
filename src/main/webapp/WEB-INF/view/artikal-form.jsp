<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Artikal</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<jsp:include page="include/header.jsp"></jsp:include>

<h3>Artikal</h3>
<hr>
<br>
<form:form action="artikal-save" modelAttribute="artikal">
<table>
	<form:hidden path="id"/>
	<tr><td>Naziv</td><td><form:input path="naziv"/></td></tr>
	<tr><td>Jm</td><td><form:input path="jm"/></td></tr>
	<tr><td>Poreska stopa</td><td><form:input path="porez"/></td></tr>
	<tr><td>Cena</td><td><form:input path="cena"/></td></tr>
	<tr><td colspan="2"><input type="submit" value="Save"></td></tr>
</table>
</form:form>
</body>
</html>