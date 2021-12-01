<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Perfil"%>
<%@page import="entidad.Alumno"%>
<%@page import="entidad.Curso"%>
<%@page import="entidad.Materia"%>
<%@page import="entidad.CursosAlumnos"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumnos</title>
<link href="Docente/docente.css" rel="stylesheet" type="text/css">
<link href="Docente/AlumnosCursos.css" rel="stylesheet" type="text/css">
<link href="Administrador/StyleGeneral.css" rel="stylesheet" type="text/css">


<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
</head>

<script type="text/javascript">

$(document).ready(function() {

    // DataTable
    var table = $('.table').DataTable({
    	searching: false
    });
} );
</script>

<body>
<% 
Perfil perfil = null;
if(session.getAttribute("Perfil")!= null){
       perfil = (Perfil) session.getAttribute("Perfil");
} %>
	<header>

		<div class="conteiner__volver">
			<a style="color: white" href="servletPersona?toCursos=1">Volver</a>
		</div>

		<div class="conteiner__h1">
			<h1>Alumnos por curso</h1>
		</div>

		<div class="conteiner__usuario">
			<p>
				Bienvenido <%if(perfil != null) { %><span id="usuario"><%=perfil.getEmail() %></span>  <%} %>
			</p>
		</div>
	</header>

	<main>
<% 
	ArrayList<Alumno> listaAlumnos = null;
	if(request.getAttribute("listaAlumnos")!=null)
	{
		listaAlumnos = (ArrayList<Alumno>) request.getAttribute("listaAlumnos");
	}
	
	ArrayList<Materia> listaMaterias = null;
	if(request.getAttribute("listaMaterias")!=null)
	{
		listaMaterias = (ArrayList<Materia>) request.getAttribute("listaMaterias");
	}
	
	ArrayList<CursosAlumnos> notasAlumnos = null;
	if(request.getAttribute("notasAlumnos")!=null)
	{
		notasAlumnos = (ArrayList<CursosAlumnos>) request.getAttribute("notasAlumnos");
	}
	
	Curso cursoPorID = null;
	if(request.getAttribute("cursoPorID")!=null)
	{
		cursoPorID = (Curso) request.getAttribute("cursoPorID");
	}
	
	System.out.println(cursoPorID.getId());
	System.out.println(notasAlumnos.size());
	%>
	<div class="conteiner__h2">
		<h2>Alumnos de 
	    <%if(cursoPorID != null && listaMaterias != null ) {
		     for (Materia materia : listaMaterias){ 
		         if (materia.getId() == cursoPorID.getIdMateria()){  %>
		         <%=materia.getNombre()%>
		         <% } 
		     }  %>
		 - Semestre <%=cursoPorID.getSemestre()%>
		 - Año <%=cursoPorID.getAnio()%> <% } %>
		  </h2>
	</div>
<form name="tablaNotas" action="servletPersona" method="get">
         
	

		<div class="conteiner__cursos">

		<table class=".table" id="customers">
			<thead>
				<tr>
                   
					<th>Nombre y Apellido</th>

					<th>Legajo</th>

					<th>Nota Parcial 1</th>

					<th>Nota Parcial 2</th>

					<th>Nota Recuperatorio 1</th>

					<th>Nota Recuperatorio 2</th>

					<th>Estado</th>

				</tr>
			</thead>
<tbody>

<% int i=0; if(listaAlumnos!=null && notasAlumnos != null && cursoPorID != null ) {
    
		for(CursosAlumnos notasAlumno : notasAlumnos) 
		{  if (cursoPorID.getId() == notasAlumno.getIdCurso()){System.out.println(notasAlumno.getEstado()); %>
				<tr> 
				
                   <% for (Alumno alumno : listaAlumnos) {
                      if(alumno.getDni() == notasAlumno.getDniAlumno()){   %>
					<td><%=alumno.getNombreApellido()%></td>
					<td><%=alumno.getLegajo()%></td>
					
					<%}} %>
					
					<td>
					    <input type="hidden" name="alumno<%=i%>" value=<%=notasAlumno.getDniAlumno()%>>
					<input type="number" min="0" max="10" step=".1" name="alumno<%=i%>" value=<%=notasAlumno.getParcialUno() %>
						 style="width: 40px; align: center;"></td>
					<td><input type="number" min="0" max="10" step=".1" name="alumno<%=i%>" value=<%=notasAlumno.getParcialDos() %>>
					</td>
					<td><input type="number" min="0" max="10" step=".1" name="alumno<%=i%>" value=<%=notasAlumno.getRecuperatorioUno() %>>
					</td>
					<td><input type="number" min="0" max="10" step=".1" name="alumno<%=i%>" value=<%=notasAlumno.getRecuperatorioDos() %>>
					</td>

					<td><select name="alumno<%=i%>">
					<%if(notasAlumno.getEstado()){%>
							<option selected="selected" value="true">Regular</option>
							<option value="false">Libre</option>
					<%}else {%>
							<option value="true">Regular</option>
							<option selected="selected" value="false">Libre</option>
					<%}%>
					</select></td>
                    
				</tr>
        <% i++;  }
             }
        }%>
        </tbody>
			</table>
         
		</div>
		<div class="button_container">
		<input type="hidden" name="filas" value=<%=i%>>
		<input type="hidden" name="cursoPorID" value=<%=cursoPorID.getId()%>>
			<button name="modificarNotas" type="submit">Guardar Cambios</button>
		</div>
	</form>
	<% if(request.getAttribute("updateExitosoNotas") != null){
			%><div class="center"><p class="mensaje"><%=request.getAttribute("updateExitosoNotas") %></p></div><% 
					request.setAttribute("updateExitosoNotas", null);
			}%>
</body>
</html>