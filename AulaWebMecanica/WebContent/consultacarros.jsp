<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="modelo.Carro"%>
<%@page import="java.util.List"%>
<%@page import="webmecanica.dao.CarroDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Lista de Carros</h2>
	<jsp:useBean id="dao" class="webmecanica.dao.CarroDAO" />
	<table>
		
		<c:forEach var="carro" items="${dao.readAll}">
		<tr>
			<td>${carro.modelo }</td>
			<td>${carro.marca }</td>
			<td>${carro.tipoCombustivel }</td>
			<td>${carro.valor })</td>
			<td>
			<a href="ServletCarro?action=edit&id=${carro.id }">
			Editar</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>