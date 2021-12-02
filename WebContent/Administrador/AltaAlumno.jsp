<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Perfil"%>
<%@page import="entidad.Pais"%>
<%@page import="entidad.Localidad"%>
<%@page import="entidad.Provincia"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UTN - Agregar alumno</title>
<link href="Administrador/StyleGeneral.css" rel="stylesheet" type="text/css">
<link href="Administrador/AltaAlumnoDocente.css" rel="stylesheet" type="text/css">
</head>
<body>
<% Perfil perfil = null;
if(session.getAttribute("Perfil")!= null){
       perfil = (Perfil) session.getAttribute("Perfil");
} %>
	<header>

		<div class="conteiner__volver">
			<a href="servletPersona?toAdmAlumnos=1">Volver</a>
		</div>

		<div class="conteiner__h1">
			<h1>Agregar Alumno</h1>
		</div>

		<div class="conteiner__usuario">
			<p>
				Bienvenido <%if(perfil != null) { %><span id="usuario"><%=perfil.getEmail() %></span>  <%} %>
			</p>
		</div>
	</header>

	<% 

	ArrayList<Pais> listaPaises = null;
	if(request.getAttribute("listaPaises")!=null)
	{
		listaPaises = (ArrayList<Pais>) request.getAttribute("listaPaises");
	}
	
	ArrayList<Provincia> listaProvincias = null;
	if(request.getAttribute("listaProvincias")!=null)
	{
		listaProvincias = (ArrayList<Provincia>) request.getAttribute("listaProvincias");
	}
	
	
	
 %>

	<form class="formulario">

		<div class="conteiner__data">
			<label for="Dni">Dni</label> <input type="number" id="dni" name="dniAlumno" required>
		</div>
		
		<div class="conteiner__data">
			<label for="legajo">Legajo</label> <input type="number" id="legajo" name="legajoAlumno" required>
		</div>

		<div class="conteiner__data">
			<label for="Nombre y apellido">Nombre y Apellido</label> <input
				type="text" id="NombreYapellido" name="nombreAlumno" required>
		</div>

		<div class="conteiner__data">
			<label for="FechaNacimiento">Fecha de Nacimiento</label> <input
				type="text" pattern="\d{1,2}/\d{1,2}/\d{4}" title="La fecha no es v&aacute;lida" id="FechaNacimiento" name="nacimientoAlumno" required>
		</div>

		<div class="conteiner__data">
			<label for="Direccion">Direccion</label> 
			<input type="text" id="Direccion" name="direccionAlumno" required>
		</div>

		<div class="conteiner__data">
			<label for="Nacionalidad">Nacionalidad</label> <select id="Nacionalidad" required name="nacionalidadAlumno" >
				 <%  if(listaPaises!=null)
		               {
		                    for(Pais pais : listaPaises) 
		                       {  
		         %>	
				                   <option value="<%=pais.getId() %>"><%=pais.getNombre() %></option>
				           <%  }
				             
				       }
				
				            %>
				    
				</select>
		</div>
		<div class="conteiner__data">
			<label for="Provincia">Provincia</label> <select id="Provincia" required name="provinciaAlumno" >
				 <%  if(listaProvincias!=null)
		               {
		                    for(Provincia provincia : listaProvincias) 
		                       {  
		         %>	
				                   <option value="<%=provincia.getId() %>"><%=provincia.getNombre() %></option>
				           <%  }
				             
				       }
				
				            %>
				    
				</select>
		</div>

		<div class="conteiner__data">
			<label for="Email">Email</label> <input type="email" id="Email" name="emailAlumno" required>
		</div>

		<div class="conteiner__data">
			<label for="Telefono">Telefono</label><input type="number"
				id="Telefono" name="telefonoAlumno" required>
		</div>

		<div>
			<button type="submit" name="agregarAlumno" onclick="return confirm('seguro que desea agregar al alumno?')" >Agregar Alumno</button>
		</div>

	</form>

	<% if(request.getAttribute("insertExitosoAlumno") != null){
		%><div class="center"><p class="mensaje"><%=request.getAttribute("insertExitosoAlumno") %></p></div><% 
				request.setAttribute("insertExitosoAlumno", null);
		}%>


</body>
</html>