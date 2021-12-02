<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Perfil"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Docente</title>
<link href="Docente/docente.css" rel="stylesheet" type="text/css">
<link href="Administrador/StyleGeneral.css" rel="stylesheet" type="text/css">
</head>
<body>
<% 
Perfil perfil = null;
if(session.getAttribute("Perfil")!= null){
       perfil = (Perfil) session.getAttribute("Perfil");
} %>
	<header>
		<div class="conteiner__logout">
			<a style="color: white" href="servletPersona?cerrarSesion=1" onclick="return confirm('Seguro que desea cerrar sesion?')">Cerrar Sesión</a>
		</div>

		<div class="conteiner__h1">
			<h1>MENU DOCENTE</h1>
		</div>

		<div class="conteiner__usuario">
			<p>
					Bienvenido <%if(perfil != null) { %><span id="usuario"><%=perfil.getEmail() %></span>  <%} %>
			</p>
		</div>

	</header>

	<main>

	<div class="conteiner__h2">Opciones</div>
	<div class="conteiner__links">
		<a href="servletPersona?toCursos=1">Mis Cursos</a>
	</div>

	</main>


</body>
</html>