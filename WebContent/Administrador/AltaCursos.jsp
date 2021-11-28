<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Perfil"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Cursos</title>
<link href="StyleGeneral.css" rel="stylesheet" type="text/css">
<link href="AltaAlumnoDocente.css" rel="stylesheet" type="text/css">
<link href="AdministradorAlumnosDocentes.css" rel="stylesheet"
	type="text/css">

</head>
<body>
<% Perfil perfil = null;
if(session.getAttribute("Perfil")!= null){
       perfil = (Perfil) session.getAttribute("Perfil");
} %>
	<header>

		<div class="conteiner__volver">
			<a href="Administrador.jsp">Volver</a>
		</div>

		<div class="conteiner__h1">
			<h1>Agregar Curso</h1>
		</div>

		<div class="conteiner__usuario">
			<p>
				Bienvenido <%if(perfil != null) { %><span id="usuario"><%=perfil.getEmail() %></span>  <%} %>
			</p>
		</div>
	</header>
	</div>
	<div style="padding: 5px; text-align: center">
		<h3>Datos del curso:</h3>
	</div>
	<form class="formulario">

		<div class="conteiner__data">
			<label for="materia">Materia</label> <select name="materia"
				id="materia">
				<option value="%materia1%">%Materia1%</option>
				<option value="%materia2%">%Materia2%</option>
			</select>
		</div>

		<div class="conteiner__data">
			<label for="semestre">Semestre</label> <select name="semestre"
				id="semestre">
				<option value="1">Primer Semestre</option>
				<option value="2">Segundo Semestre</option>
			</select>
		</div>

		<div class="conteiner__data">
			<label for="anioCurso">Año</label> <input type="number"
				id="anioCurso" placeholder="2021" style="width: 80px">
		</div>

		<div class="conteiner__data">
			<label for="docente">Docente</label> <select name="semestre"
				id="semestre">
				<option value="%docente1%">%docente1%</option>
				<option value="%docente2%">%docente2%</option>
			</select>
		</div>

		<div class="conteiner__data"></div>
		<div style="padding: 5px; text-align: center">
			<h3>Agregar alumnos al curso:</h3>
		</div>
		<div class="conteiner__alumnos">

			<table>

				<tr>

					<th>Legajo</th>

					<th>Dni</th>

					<th>Nombre</th>

					<th>Apellido</th>

					<th>Añadir</th>

				</tr>

				<tr>



					<td>Lorem</td>
					<td>Lorem</td>
					<td>Lorem</td>
					<td>Lorem</td>
					<td><input type="checkbox" id="cbox" value="%dni%"></td>

				</tr>

			</table>
		</div>
		<div style="padding: 10px; text-align: center">
			<button type="submit" onclick="return confirm('seguro que desea agregar el nuevo curso?')"  >Agregar Curso</button>
		</div>

	</form>

</body>
</html>