<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro carro</title>
</head>
<body>
<form action="ServletCarro" method="post">

<input type="hidden" name="id" value="${carro.id}" />

	<label>Modelo:</label>
	<input type="text" name="modelo" value="${carro.modelo} "/> <br/>
	
	<label>Marca:</label>
	<input type="text" name="marca" value="${carro.marca} "/> <br/>
	
	<label>Tipo Combustivel:</label>
	<input type="text" name="tipocombustivel" value="${carro.tipoCombustivel } "/> <br/>
	
	<label>Valor:</label>
	<input type="text" name="valor" value="${carro.valor} "/> <br/>
	
	<input type="submit" value="Salvar" />
</form>
</body>
</html>