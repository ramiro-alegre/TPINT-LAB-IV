<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UTN - Agregar alumno</title>
<link href="StyleGeneral.css" rel="stylesheet" type="text/css">
<link href="AltaAlumnoDocente.css" rel="stylesheet" type="text/css">
</head>
<body>

<header>

<div class="conteiner__volver"><a href="AdministradorAlumnos.jsp">Volver</a></div>

<div class="conteiner__h1">
<h1>Agregar Alumno</h1>
</div>

<div class="conteiner__usuario">
<p>Bienvenido <span id="usuario">Lorem</span></p>
</div>
</header>


<form class="formulario">

<div class="conteiner__data">
<label for="Dni">Dni</label> <input type="text" id="dni">
</div>

<div class="conteiner__data">
<label for="Nombre y apellido">Nombre y Apellido</label> <input type="text" id="NombreYapellido">
</div>

<div class="conteiner__data">
<label for="FechaNacimiento">Fecha de Nacimiento</label> <input type="text" id="FechaNacimiento">
</div>

<div class="conteiner__data">
<label for="Direccion">Direccion</label> <input type="text" id="Direccion">
</div>

<div class="conteiner__data">
<label for="Nacionalidad">Nacionalidad</label> <input type="text" id="Nacionalidad">
</div>

<div class="conteiner__data">
<label for="Direccion">Provincia</label> <input type="text" id="Provincia">
</div>

<div class="conteiner__data">
<label for="Email">Email</label> <input type="text" id="Email">
</div>

<div class="conteiner__data">
<label for="Telefono">Telefono</label><input type="text" id="Telefono">
</div>

<div>
<button type="submit">Agregar Alumno</button>
</div>

</form>

</body>
</html>