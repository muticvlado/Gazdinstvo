<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stavka racuna</title>
<link rel="stylesheet" href="css/main.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

	function artikalFocus() {
		document.getElementById('artikal.id').focus();
	}	
	
	function proveriUnos() {
		var artikal = document.getElementById('artikal.id').value;
		var porez = document.getElementById('porez').value;
		var kolicina = document.getElementById('kolicina').value;
		var cena = document.getElementById('cena').value;

		if (artikal == 0 || porez <= 0 || kolicina <= 0 || cena <= 0) {
			alert("Proverite unos!");
			document.getElementById('artikal.id').focus();
			return false;
		} else
			return true;
	}
</script>
</head>
<body onload="artikalFocus()">
<jsp:include page="include/header.jsp"></jsp:include>

<h3>Stavka racuna</h3>
<hr>
<br>
<form:form action="stavka-save" modelAttribute="stavka">
<table>
	<form:hidden path="id"/>
	
	<tr><td>Racun Id</td><td><form:input path="racun.id" disabled="false"/></td></tr>
	<tr>
		<td>Artikal</td>
		<td>
			<form:select path="artikal.id">
				<form:option value="0" label="-----------------------"></form:option>
				<form:options items="${artikli}" itemLabel="naziv" itemValue="id"/>
			</form:select>
		</td>
	</tr>
	<tr><td>Poreska stopa</td><td><form:input path="porez"/></td></tr>
	<tr><td>Kolicina</td><td><form:input path="kolicina"/></td></tr>
	<tr><td>Cena</td><td><form:input path="cena"/></td></tr>
	<tr><td colspan="2"><input type="submit" value="Save" onclick="return proveriUnos()"></td></tr>
</table>
</form:form>
</body>
</html>