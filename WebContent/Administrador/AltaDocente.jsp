<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Alta Docente</title>
<link href="StyleGeneral.css" rel="stylesheet" type="text/css">
<link href="AltaAlumnoDocente.css" rel="stylesheet" type="text/css">
</head>
<body>


<header>

<div class="conteiner__volver"><a href="AdministradorDocentes.jsp">Volver</a></div>

<div class="conteiner__h1">
<h1>Agregar Docente</h1>
</div>

<div class="conteiner__usuario">
<p>Bienvenido <span id="usuario">Lorem</span></p>
</div>
</header>


<form class="formulario">

<div class="conteiner__data">
<label for="Dni">Dni</label> <input type="text" id="Dni">
</div>

<div class="conteiner__data">
<label for="Nombreyapellido">Nombre y Apellido</label> <input type="text" id="NombreYapellido">
</div>

<div class="conteiner__data">
<label for="FechaNacimiento">Fecha de Nacimiento</label> <input type="text" id="FechaNacimiento">
</div>

<div class="conteiner__data">
<label for="Direccion">Direccion</label> <input type="text" id="Direccion">
</div>

<div class="conteiner__data">
<label for="Localidad">Localidad</label> 
<select id="Localidad">
<option value="San Fernando">San Fernando</option>
<option value="Tigre">Tigre</option>
<option value="Escobar">Escobar</option>
</select>
</div>

<div class="conteiner__data">
<label for="Nacionalidad">Nacionalidad</label> 
<select>
<option value="Argentina">Argentina</option>
<option value="Uruguay">Uruguay</option>
<option value="Peru">Peru</option>
</select>
</div>

<div class="conteiner__data">
<label for="Email">Email</label> <input type="email" id="Email">
</div>

<div class="conteiner__data">
<label for="Password">Password</label> <input type="text" id="Password">
</div>

<div class="conteiner__data">
<label for="Telefono">Telefono</label><input type="tel" id="Telefono">
</div>

<div>
<button type="submit">Agregar Docente</button>
</div>

</form>



</body>
</html>