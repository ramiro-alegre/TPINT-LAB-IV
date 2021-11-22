<%@page import="entidad.Alumno"%>
<%@page import="entidad.Pais"%>
<%@page import="entidad.Provincia"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
			<a href="Administrador/Administrador.jsp">Volver</a>
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
	ArrayList<Alumno> listaAlumnos = null;
	if(request.getAttribute("listaAlumnos")!=null)
	{
		listaAlumnos = (ArrayList<Alumno>) request.getAttribute("listaAlumnos");
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

                <th>Provincia</th>

				<th>Nacionalidad</th>

				<th>Email</th>

				<th>Teléfono</th>
				
				<th></th>
				
				<th></th>


			</tr>

			 <%  if(listaAlumnos!=null)
		for(Alumno alumno : listaAlumnos) 
		{
	%>
		<tr>  
		    <form name="tablaAlumnos" action="servletPersona" method="get">
				
				<td> <input type="number" name="dniAlumno" readonly="readonly" value="<%=alumno.getDni()%>"> </td> 
				<td> <input type="number" required name="legajoAlumno" value="<%=alumno.getLegajo() %>" ></td>   
				<td> <input type="text" required name="nombreAlumno" value="<%=alumno.getNombreApellido() %>" ></td> 
				<td> <input type="text" required pattern="\d{1,2}/\d{1,2}/\d{4}" title="La fecha no es v&aacute;lida" name="nacimientoAlumno" value="<%=alumno.getFechaNacimiento() %>" ></td> 
				<td> <input type="text" required name="direccionAlumno" value="<%=alumno.getDireccion() %>" ></td> 
				     <td> 
				         <select required name="provinciaAlumno">
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
				<%               } else {
				%>
				                   <option value="<%=pais.getId() %>"><%=pais.getNombre() %></option>
				<%               }
				             }
				           }
				
				%>
				</select>
				</td> 
				<td> <input type="email" required name="emailAlumno" value="<%=alumno.getEmail() %>" ></td> 
				<td> <input type="number" required name="telefonoAlumno" value="<%=alumno.getTelefono() %>" ></td> 
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