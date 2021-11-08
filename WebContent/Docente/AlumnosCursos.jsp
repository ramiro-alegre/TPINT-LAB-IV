<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumnos</title>
<link href="docente.css" rel="stylesheet" type="text/css">
</head>
<body>

<header>

<div class="conteiner__volver"><a style="color:white" href="Cursos.jsp">Volver</a></div>

<div class="conteiner__h1">
<h1>Alumnos por curso</h1>
</div>

<div class="conteiner__usuario">
<p>Bienvenido <span id="usuario">Lorem</span></p>
</div>
</header>

<main>

<div class="conteiner__h2">
<h2>Alumnos de %Materia% %Semestre% %Año%</h2>
</div>

<form>
<div class="button_container">
<button type="submit">Guardar Cambios </button>
</div>

<div class="conteiner__cursos">

<table>

  <tr>

    <th>Nombre</th>

    <th>Apellido</th>

    <th>Legajo</th>
    
    <th>Nota Parcial 1</th>
    
	<th>Nota Parcial 2</th>
	
	<th>Nota Recuperatorio 1</th>
	
	<th>Nota Recuperatorio 2</th>
	
	<th>Estado</th>
	
  </tr>
  
  <tr>
 
  <td>Lorem</td>
  <td>Lorem</td>
  <td>Lorem</td>
  <td><input type="number" min="1" max="10" name="notaP1" placeholder="0" style="width: 40px; align: center; "></td>
  <td><input type="number" min="1" max="10" name="notaP2" placeholder="0" style="width: 40px; align: center; "></td>
  <td><input type="number" min="1" max="10" name="notaR1" placeholder="0" style="width: 40px; align: center; "></td>
  <td><input type="number" min="1" max="10" name="notaR2" placeholder="0" style="width: 40px; align: center; "></td>
  
  <td> <select name="estadoAlumno">
       <option value="Regular">Regular</option>
       <option value="Libre">Libre</option>
       </select>
  </td>
  
  </tr>
  
  </table>

</div>
<div class="button_container">
<button type="submit">Guardar Cambios </button>
</div>
</form>
</body>
</html>