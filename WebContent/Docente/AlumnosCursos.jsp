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
<link href="docente.css" rel="stylesheet" type="text/css">
</head>
<body>
<% 
Perfil perfil = null;
if(session.getAttribute("Perfil")!= null){
       perfil = (Perfil) session.getAttribute("Perfil");
} %>
	<header>

		<div class="conteiner__volver">
			<a style="color: white" href="Cursos.jsp">Volver</a>
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
	System.out.println(listaAlumnos.size());
	System.out.println(listaMaterias.size());
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
         
		<div class="button_container">
			<button type="submit" name="modificarNotas">Guardar Cambios</button>
		</div>

		<div class="conteiner__cursos">

			<table>

				<tr>
                   
					<th>Nombre y Apellido</th>

					<th>Legajo</th>

					<th>Nota Parcial 1</th>

					<th>Nota Parcial 2</th>

					<th>Nota Recuperatorio 1</th>

					<th>Nota Recuperatorio 2</th>

					<th>Estado</th>

				</tr>

<% int i=0; if(listaAlumnos!=null && notasAlumnos != null && cursoPorID != null ) {
    
		for(CursosAlumnos notasAlumno : notasAlumnos) 
		{  if (cursoPorID.getId() == notasAlumno.getIdCurso()){ %>
				<tr> 
				
                   <% for (Alumno alumno : listaAlumnos) {
                      if(alumno.getDni() == notasAlumno.getDniAlumno()){   %>
					<td><%=alumno.getNombreApellido()%></td>
					<td><%=alumno.getLegajo()%></td>
					
					<%}} %>
					
					<td>
					    <input type="hidden" name="alumno<%=i%>" value=<%=notasAlumno.getDniAlumno()%>>
					<input type="number" min="1" max="10" step=".1" name="alumno<%=i%>" value=<%=notasAlumno.getParcialUno() %>
						 style="width: 40px; align: center;"></td>
					<td><input type="number" min="1" max="10" step=".1" name="alumno<%=i%>" value=<%=notasAlumno.getParcialDos() %>
						 style="width: 40px; align: center;"></td>
					<td><input type="number" min="1" max="10" step=".1" name="alumno<%=i%>" value=<%=notasAlumno.getRecuperatorioUno() %>
						 style="width: 40px; align: center;"></td>
					<td><input type="number" min="1" max="10" step=".1" name="alumno<%=i%>" value=<%=notasAlumno.getRecuperatorioDos() %>
						 style="width: 40px; align: center;"></td>

					<td><select name="alumno<%=i%>">
							<option <%if(notasAlumno.getEstado() == "Regular"){%> selected <%}%>value="Regular">Regular</option>
							<option <%if(notasAlumno.getEstado() == "Libre")  {%> selected <%}%>value="Libre">Libre</option>
					</select></td>
                    
				</tr>
        <% i++;  }
             }
        }%>
			</table>
         
		</div>
		<div class="button_container">
		<input type="hidden" name="filas" value=<%=i%>>
		<input type="hidden" name="cursoPorID" value=<%=cursoPorID.getId()%>>
			<button name="modificarNotas" type="submit">Guardar Cambios</button>
		</div>
	</form>
</body>
</html>