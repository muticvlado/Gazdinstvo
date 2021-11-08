<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Racun</title>

<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
	$(function() {
		$("#datum").datepicker();
	});
</script>

</head>
<body>
<jsp:include page="include/header.jsp"></jsp:include>

<h3>Racun</h3>
<hr>
<br>
<form:form action="racun-save" modelAttribute="racun">
<table>
	<form:hidden path="id"/>
	<tr><td>Broj racuna</td><td><form:input path="broj"/></td></tr>
	<tr><td>Datum</td><td><form:input path="datum"/></td></tr>
	<tr>
		<td>Kupac</td>		
		<td>
		<form:select path="kupac.id">
			<form:option value="0" label="-----------------------"></form:option>
			<c:forEach items="${kupci}" var="kupac">
				<form:option value="${kupac.id}" label="${kupac.naziv}"></form:option>
			</c:forEach>
		</form:select>
		</td>
	</tr>	
	<tr><td colspan="2"><input type="submit" value="Save" onsubmit="return $('#kupac.id').val()=='0'"></td></tr>
</table>
</form:form>
<br>
<a href="stavka-new?racunid=${racun.id}" onclick="return $('#id').val()>0" class="novo">Nova stavka</a>
<br><br>
<table>
	<tr>
		<th>#</th>
		<th>Rb</th>
		<th>Artikal</th>
		<th>Jm</th>
		<th>Poreska stopa</th>
		<th>Kolicina</th>
		<th>Cena</th>
		<th>Iznos bez pdv</th>
		<th>Iznos pdv</th>
		<th>Ukupno sa pdv</th>
		<th>Action</th>
	</tr>
	<c:set var="total" value="0" />
	<c:forEach items="${racun.stavke}" var="stavka" varStatus="rb">	
		<tr>
			<td>${stavka.id}</td>
			<td>${rb.count}</td>
			<td>${stavka.artikal.naziv}</td>
			<td>${stavka.artikal.jm}</td>
			<td><fmt:formatNumber type="percent">${stavka.porez}</fmt:formatNumber></td>
			<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${stavka.kolicina}</fmt:formatNumber></td>
			<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${stavka.cena}</fmt:formatNumber></td>
			<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${stavka.kolicina*stavka.cena}</fmt:formatNumber></td>
			<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${stavka.porez*stavka.kolicina*stavka.cena}</fmt:formatNumber></td>
			<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2">${stavka.kolicina*stavka.cena*(stavka.porez+1)}</fmt:formatNumber></td>
			<td>
				<a href="stavka-edit?id=${stavka.id}"><i class="fas fa-edit edit"></i></a> | 
				<a href="stavka-delete?stavkaid=${stavka.id}&racunid=${racun.id}" onclick="return confirm('Brisanje stavke?')"><i class="far fa-trash-alt delete"></i></a></td>
		</tr>		
		<c:set var="total" value="${total + stavka.kolicina*stavka.cena*(stavka.porez+1)}" />
	</c:forEach>
	<tr align="center" style="color: white; font-size: 20px; font-size: large; font-weight: bold; background-color: green"><td colspan="11"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"><c:out value="${total}"/></fmt:formatNumber></td></tr>
</table>

</body>
</html>