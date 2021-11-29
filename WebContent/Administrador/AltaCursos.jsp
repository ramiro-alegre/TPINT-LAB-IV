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
<link href="StyleGeneral.css" rel="stylesheet" type="text/css">
<link href="AltaAlumnoDocente.css" rel="stylesheet" type="text/css">
<link href="AdministradorAlumnosDocentes.css" rel="stylesheet"
	type="text/css">

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
	<form class="formulario" method="get" action="servletPersona">

		<div class="conteiner__data">
			<label for="materia">Materia</label> 
			
			<select name="materia"id="materia">
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
			<label for="anioCurso">Año</label> 
			<input type="number" id="anioCurso" min="2021" max="2031" placeholder="2021" style="width: 80px">
		</div>

		<div class="conteiner__data">
			<label for="docente">Docente</label> 
			<select name="docente" id="docente">
				<%if(listaDocentes!=null)
		        {
		            for(Docente docente : listaDocentes) 
		            {  %>
				<option value="<%=docente.getDni()%>"><%=docente.getNombreApellido()%></option>
				<%  }
				}    %>
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

					<th>Nombre y Apellido</th>

					<th>Añadir</th>

				</tr>

				
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
				

			</table>
		</div>
		<div style="padding: 10px; text-align: center">
			<button type="submit" name="agregarCurso" onclick="return confirm('seguro que desea agregar el nuevo curso?')"  >Agregar Curso</button>
		</div>

	</form>

</body>
</html>