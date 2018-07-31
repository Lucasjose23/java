<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastro</title>
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
		<div style="text-align: center">
    		<h3>${mensagem}</h3>
    	</div>
		<form action="servletMembro" method="post">
			<div class="row">
				<div class="col-6 col-md-4"></div>
				<div class="form-group col-6 col-md-4 ">
				
					<h1 >Cadastrar-se</h1>
					</br>
					 <hr class="my-4">
					<label>Nome:   </label>
					<input type="text" name="nome"  class="form-control" /> <br/>
					
					<label>Usuario:</label>
					<input type="text" name="usuario" class="form-control"/> <br/>
					
					<label>Senha:  </label>
					<input type="password" name="senha" class="form-control" /> <br/>

					<input type="submit" class="btn btn-success" value="Salvar" />
				</div>
			</div>
		 </form>	
	</body>
</html>