<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Perfil"%>
<%@page import="entidad.Materia"%>
<%@page import="entidad.Docente"%>
<%@page import="entidad.Alumno"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Cursos</title>
<link href="Administrador/StyleGeneral.css" rel="stylesheet" type="text/css">
<link href="Administrador/AltaCursos.css" rel="stylesheet" type="text/css">
<link href="./tablas.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>





</head>
<body>
<% Perfil perfil = null;
if(session.getAttribute("Perfil")!= null){
       perfil = (Perfil) session.getAttribute("Perfil");
} 

ArrayList<Alumno> listaAlumnos = null;
	if(request.getAttribute("listaAlumnos")!=null)
	{
		listaAlumnos = (ArrayList<Alumno>) request.getAttribute("listaAlumnos");
	}
	
ArrayList<Docente> listaDocentes = null;
	if(request.getAttribute("listaDocentes")!=null)
	{
		listaDocentes = (ArrayList<Docente>) request.getAttribute("listaDocentes");
	}
	
ArrayList<Materia> listaMaterias = null;
	if(request.getAttribute("listaMaterias")!=null)
	{
		listaMaterias = (ArrayList<Materia>) request.getAttribute("listaMaterias");
	}	
	
%>
	<header>

		<div class="conteiner__volver">
			<a href="servletPersona?toAdmGeneral=1">Volver</a>
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
	<form class="formulario" method="get" action="servletPersona">

	<div class="conteiner__data--general">
		<div class="conteiner__data">
			<label for="materia">Materia</label> 
			
			<select name="idMateria"id="materia">
			<%if(listaMaterias!=null)
		        {
		            for(Materia materia : listaMaterias) 
		            {  %>
				<option value="<%=materia.getId()%>"><%=materia.getNombre()%></option>
				<%  }
				}    %>
			</select>
		</div>

		<div class="conteiner__data">
			<label for="semestre">Semestre</label> 
			
			<select name="semestre" id="semestre">
				<option value="1">Primer Semestre</option>
				<option value="2">Segundo Semestre</option>
				<option value="3">Tercer Semestre</option>
				<option value="4">Cuarto Semestre</option>
				<option value="5">Quinto Semestre</option>
				<option value="6">Sexto Semestre</option>
			</select>
		</div>

		<div class="conteiner__data">
			<label for="anioCurso">A�o</label> 
			<input type="number" name="anio" id="anioCurso" min="2021" max="2031" placeholder="2021" style="width: 80px">
		</div>

		<div class="conteiner__data">
			<label for="docente">Docente</label> 
			<select name="dniDocente" id="docente">
				<%if(listaDocentes!=null)
		        {
		            for(Docente docente : listaDocentes) 
		            {  %>
				<option value="<%=docente.getDni()%>"><%=docente.getNombreApellido()%></option>
				<%  }
				}    %>
			</select>
		</div>

	</div>
		<div class="conteiner__h3">
			<h3>Agregar alumnos al curso:</h3>
		</div>
		<div class="conteiner__alumnos">

			<table class=".table" id="customers">

				<thead>
				<tr>
					<th>Legajo</th>

					<th>Dni</th>

					<th>Nombre y Apellido</th>

					<th>A�adir</th>
				</tr>
				</thead>
<tbody>
				
                <%if(listaAlumnos!=null)
		        {
		            for(Alumno alumno : listaAlumnos) 
		            {  %>
                    <tr>

					<td><%=alumno.getLegajo()%></td>
					<td><%=alumno.getDni()%></td>
					<td><%=alumno.getNombreApellido()%></td>
					<td><input type="checkbox" id="cbox" name="dni" value="<%=alumno.getDni()%>"></td>
					</tr>
               <%   }  
               }     %>
				
</tbody>
			</table>
		</div>
		<div style="padding: 10px; text-align: center">
			<button type="submit" name="agregarCurso" onclick="return confirm('seguro que desea agregar el nuevo curso?')"  >Agregar Curso</button>
		</div>

	</form>
	
	<% if(request.getAttribute("mensajeAltaCurso") != null){
			%><div class="center"><p class="mensaje"><%=request.getAttribute("mensajeAltaCurso") %></p></div><% 
					request.setAttribute("mensajeAltaCurso", null);
			}%>

</body>

<script type="text/javascript">

$(document).ready(function() {
	

    // DataTable
    var table = $('.table').DataTable({
    });


} );
</script>
</html>