<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador</title>
<link href="Administrador/StyleGeneral.css" rel="stylesheet" type="text/css">
<link href="Administrador/Administrador.css" rel="stylesheet" type="text/css">
</head>
<body>

	<header>
	<div class="conteiner__logout">
		<a class="logout" href="#">Cerrar Sesión</a>
	</div>

	<div class="conteiner__h1">
		<h1>MENU ADMINISTRADOR</h1>
	</div>

	<div class="conteiner__usuario">
		<p>
			Bienvenido <span id="usuario">Lorem</span>
		</p>
	</div>

	</header>

	<main>

	<div class="conteiner__h2">Opciones</div>
	<div class="conteiner__links">
		<a href="./servletPersona?toAdmAlumnos=1">Alumnos</a> 
		<a href="./servletPersona?toAdmDocentes=1">Docentes</a> 
		<a href="AltaCursos.jsp">Cursos</a>
	</div>

	</main>

</body>
</html>