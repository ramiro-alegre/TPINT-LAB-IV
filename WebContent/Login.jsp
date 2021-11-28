<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
				id="email" name="email" required >
		</div>

		<div class="conteiner__data">
			<label for="password">Contraseña</label> <input type="password"
				id="contrasenia" name="contrasenia" required >
		</div>

		<div>
			<button type="submit">Acceder</button>
		</div>

      

	</form>

      <% if(request.getParameter("perfilInvalido")!=null){
    	  
    	  %><div><h3>Usuario o contrasenia invalido</h3></div> <%
    	  
      } %>

	</main>

</body>
</html>