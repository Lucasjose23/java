<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="rede.classes.Membro"%>
<%@page import="rede.classes.Publicacao"%>
<%@page import="redes.dao.RedeDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
	</head>
	<body>
		<form action="servletPublicacao" method="post">
			<div class="row">
				<div class="form-group col-6 col-md-4 ">
				 	<h1>Tela de Publicações</h1>
				</div>
			</div>
		</form>
		
		<div class="container">
			<div class="container-fluid" id=main>   
		    	<h3 class="page-header" id="tituloLogin"><strong>Publicações</strong></h3>
		        <jsp:useBean id="dao" class="redes.dao.RedeDAO" />
		        <div class="row">
		            <c:forEach var="publicacao" items="${dao.readAll}">
		            	<div class="col-sm-8">
		            		
		                    <p><strong>${publicacao.getDatahora() }</strong></p> 
		                    <p>${publicacao.getMembro().getNome() }</p>
		                    <p>${publicacao.getTexto() }</p>
		                    <hr/>
		                    <br/>
		                </div> 
		        	</c:forEach>
		    	</div> 
			</div>	
		</div>
	</body>
</html>