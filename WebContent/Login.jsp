<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UTN FRGP</title>
<link href="Login.css" rel="stylesheet" type="text/css">
</head>
<body>

	<header>
	<div class="h1__header">
		<h1>Acceder</h1>
	</div>
	</header>

	<main>

	<form class="formulario" action="servletPersona" method ="post">
	

		<div class="conteiner__data">
			<label for="user">Nombre de usuario</label> <input type="text"
				id="email" name="email">
		</div>

		<div class="conteiner__data">
			<label for="password">Contraseña</label> <input type="password"
				id="contrasenia" name="contrasenia">
		</div>

		<div>
			<button type="submit">Acceder</button>
		</div>

      

	</form>

      <% if(request.getParameter("perfilInvalido")!=null){
    	  
    	  %> <h3>Usuario o contrasenia invalido</h3> <%
    	  
      } %>

	</main>

</body>
</html>