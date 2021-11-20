<%@page import="entidad.Persona"%>
<%@page import="entidad.Pais"%>
<%@page import="entidad.Provincia"%>
<%@page import="entidad.Localidad"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador Alumnos</title>
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
			<h1>Panel Alumnos</h1>
		</div>

		<div class="conteiner__usuario">
			<p>
				Bienvenido <span id="usuario">Lorem</span>
			</p>
		</div>
	</header>

	<main>

<% 
	ArrayList<Persona> listaAlumnos = null;
	if(request.getAttribute("listaAlumnos")!=null)
	{
		listaAlumnos = (ArrayList<Persona>) request.getAttribute("listaAlumnos");
	}
	
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
	
	ArrayList<Localidad> listaLocalidades = null;
	if(request.getAttribute("listaLocalidades")!=null)
	{
		listaLocalidades = (ArrayList<Localidad>) request.getAttribute("listaLocalidades");
	}

 %>
  
	<div class="conteiner__h2">
		<h2>Alumnos</h2>

		<a href="AltaAlumno.jsp"><button type="button">Agregar
				Alumno</button></a>

	</div>



	<div class="conteiner__alumnos">

		<table>

			<tr>

				<th>Dni</th>

				<th>Legajo</th>

				<th>Nombre y Apellido</th>

				<th>Fecha de Nacimiento</th>

				<th>Dirreción</th>

                <th>Localidad</th>

                <th>Provincia</th>

				<th>Nacionalidad</th>

				<th>Email</th>

				<th>Teléfono</th>
				
				<th></th>
				
				<th></th>


			</tr>

			 <%  if(listaAlumnos!=null)
		for(Persona alumno : listaAlumnos) 
		{
	%>
		<tr>  
		    <form name="tablaAlumnos" action="servletPersona" method="get">
				
				<td> <input type="text" name="dniAlumno" readonly="readonly" value="<%=alumno.getDni()%>"> </td> 
				<td> <input type="text" required name="legajoAlumno" value="<%=alumno.getLegajo() %>" ></td>   
				<td> <input type="text" required name="nombreAlumno" value="<%=alumno.getNombreApellido() %>" ></td> 
				<td> <input type="text" required name="nacimientoAlumno" value="<%=alumno.getFechaNacimiento() %>" ></td> 
				<td> <input type="text" required name="direccionAlumno" value="<%=alumno.getDireccion() %>" ></td> 
				<td> <select required name="localidadAlumno" >
                     <%  if(listaLocalidades!=null) 
                         {
		                    for(Localidad localidad : listaLocalidades) 
		                    {
		                       if (alumno.getProvincia().getId()==localidad.getIdProvincia())
		                       {
		                       
		                         if (alumno.getLocalidad().getId() == localidad.getId())  
		                         {
		                          %>         
							      <option selected="selected" value="<%=localidad.getId() %>"><%=localidad.getNombre() %></option>
	                              <%
		                         } else {
	                              %>         
							      <option value="<%=localidad.getId() %>"><%=localidad.getNombre() %></option>
	                              <%
	                             }
	                           }
	                        }
	                    }
	                 
	                 %>							
					</select>
					</td>
					
				     <td> 
				         <select required name="provinciaAlumno" onchange=<%=  %> >
                     <%  if(listaProvincias!=null)
		                    {
		                    for(Provincia provincia : listaProvincias) 
		                    {
		                       if (alumno.getProvincia().getId()==provincia.getId())
		                       {
	                 %>
							   <option selected="selected" value="<%=provincia.getId() %>"><%=provincia.getNombre() %></option>
	                 <%
	                           }else{ 
	                  %> 
	                 <option value="<%=provincia.getId() %>"><%=provincia.getNombre() %></option>
	                 
	                     <%    }
                             }
                            }
	                     %>							

					     </select>
				
				</td> 
				<td> <select required name="nacionalidadAlumno" >
				 <%  if(listaPaises!=null)
		                    {
		                    for(Pais pais : listaPaises) 
		                    {  
		                          if (alumno.getNacionalidad().getId()==pais.getId())
		                       {
		                    %>	
				                   <option selected="selected" value="<%=pais.getId() %>"><%=pais.getNombre() %></option>
				<% } else {
				%>
				                   <option value="<%=pais.getId() %>"><%=pais.getNombre() %></option>
				<% }
				}}
				
				%>
				</select>
				</td> 
				<td> <input type="text" required name="emailAlumno" value="<%=alumno.getEmail() %>" ></td> 
				<td> <input type="text" required name="telefonoAlumno" value="<%=alumno.getTelefono() %>" ></td> 
				<td> <input type="submit" name="modificarAlumno" value="Modificar"> </td>
				<td> <input type="submit" name="eliminarAlumno" value="Eliminar"> </td>    
				
			</form> 
		</tr>
	<%  } %>

		</table>

	</div>

	</main>

</body>
</html>