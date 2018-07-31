<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="rede.classes.Membro"%>
<%@page import="java.util.List"%>
<%@page import="redes.dao.RedeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Simple Social</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
	</head>	
	<body>
		<div class="row">
		<div class="col-6 col-md-4"></div>
			<div class="form-group col-6 col-md-4 " style="text-align: center;">
				<h1>Simple Social</h1>
			 	<a href="index.jsp" class="btn btn-primary" >Inicio</a>
			 	&nbsp
			 	<a href="Cadastro.jsp" class="btn btn-primary">Participar</a>
			 	&nbsp
			 	<a href="Publicar.jsp" class="btn btn-primary">Publicar</a>
			</div>
		</div>	
		<br/>
	 	<div class="container">
			<div class="container-fluid" id=main>   
		    	<h3 class="page-header" id="tituloLogin" style="text-align: center;"><strong>Todas as Publicações</strong></h3>
		        <jsp:useBean id="dao" class="redes.dao.RedeDAO" />
		        <div class="row">
		            <c:forEach var="publicacao" items="${dao.readAll}">
		            	<div class="col-sm-8">
		                    <p><strong>${publicacao.getTexto() }</strong></p> 
		                    <p style="text-align: right;">
			                    ${publicacao.getMembro().getNome() }
			                    ${publicacao.getDatahora() }
		                    </p>
		                    <hr/>
		                    <br/>
		                </div> 
		        	</c:forEach>
		    	</div> 
			</div>	
		</div>
	</body>
</html>