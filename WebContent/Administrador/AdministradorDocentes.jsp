<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador Docentes</title>
<link href="StyleGeneral.css" rel="stylesheet" type="text/css">
<link href="AdministradorAlumnosDocentes.css" rel="stylesheet"
	type="text/css">
</head>
<body>

	<header>

		<div class="conteiner__volver">
			<a href="Administrador.jsp">Volver</a>
		</div>

		<div class="conteiner__h1">
			<h1>Panel Docentes</h1>
		</div>

		<div class="conteiner__usuario">
			<p>
				Bienvenido <span id="usuario">Lorem</span>
			</p>
		</div>
	</header>

	<main>

	<div class="conteiner__h2">
		<h2>Docentes</h2>

		<a href="AltaDocente.jsp"><button type="button">Agregar
				Docente</button></a>

	</div>



	<div class="conteiner__tabla">

		<table>

			<tr>

				<th>Legajo</th>

				<th>Dni</th>

				<th>Nombre</th>

				<th>Apellido</th>

				<th>Fecha Nacimiento</th>

				<th>Dirreción</th>

				<th>Localidad</th>

				<th>Nacionalidad</th>

				<th>Email</th>

				<th>Teléfono</th>


			</tr>

			<tr>



				<td>Lorem</td>
				<td>Lorem</td>
				<td>Lorem</td>
				<td>Lorem</td>
				<td>Lorem</td>
				<td>Lorem</td>
				<td>Lorem</td>
				<td>Lorem</td>
				<td>Lorem</td>
				<td>Lorem</td>
				<td>
					<button>Modificar</button>
				</td>
				<td>
					<button>Eliminar</button>
				</td>

			</tr>

		</table>

	</div>

	</main>


</body>
</html>