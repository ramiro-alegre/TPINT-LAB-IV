<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Perfil"%>
<%@page import="entidad.Materia"%>
<%@page import="entidad.Curso"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursos</title>
<link href="Docente/docente.css" rel="stylesheet" type="text/css">
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

		<div>
			<a style="color: white" href="servletPersona?toDocentes=1">Volver</a>
		</div>

		<div class="conteiner__h1">
			<h1>Mis cursos</h1>
		</div>

		<div class="conteiner__usuario">
			<p>
				Bienvenido <%if(perfil != null) { %><span id="usuario"><%=perfil.getEmail() %></span>  <%} %>
			</p>
		</div>
	</header>

	<main>
	<% 
	ArrayList<Curso> listaCursos = null;
	if(request.getAttribute("listaCursos")!=null)
	{
		listaCursos = (ArrayList<Curso>) request.getAttribute("listaCursos");
	}
	
	ArrayList<Materia> listaMaterias = null;
	if(request.getAttribute("listaMaterias")!=null)
	{
		listaMaterias = (ArrayList<Materia>) request.getAttribute("listaMaterias");
	}
	%>

	<div class="conteiner__h2">
		<h2>Cursos</h2>
	</div>

	<div class="conteiner__cursos">

		<table class="table">
		<thead>
			<tr>

				<th>Materia</th>

				<th>Semestre</th>

				<th>Año</th>

				<th>Alumnos</th>

			</tr>
		</thead>
		<tbody>
 <%  if(listaCursos!=null && listaMaterias !=  null)
		for(Curso curso : listaCursos) 
		{
	%>
		    
		    <tr>  
                 <% for (Materia materia : listaMaterias) {
                      if (materia.getId()== curso.getIdMateria()) {%>
				<td><%=materia.getNombre()%></td> 
				     <%}} %>
				<td><%=curso.getSemestre()%></td>   
				<td><%=curso.getAnio()%></td> 
				<td><a href="servletPersona?toCursosxAlumnos=<%=curso.getId()%>">Ver Alumnos / Notas</a></td>
            
			</tr>
			
<% }  %>
</tbody>
		</table>

	</div>

	</main>

</body>
</html>