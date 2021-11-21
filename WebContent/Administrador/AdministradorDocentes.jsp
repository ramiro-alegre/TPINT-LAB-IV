<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Docente"%>
<%@page import="entidad.Pais"%>
<%@page import="entidad.Localidad"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador Docentes</title>
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
			<h1>Panel Docentes</h1>
		</div>

		<div class="conteiner__usuario">
			<p>
				Bienvenido <span id="usuario">Lorem</span>
			</p>
		</div>
	</header>

	<main>

<% 
	ArrayList<Docente> listaDocentes = null;
	if(request.getAttribute("listaDocentes")!=null)
	{
		listaDocentes = (ArrayList<Docente>) request.getAttribute("listaDocentes");
	}
	
	ArrayList<Pais> listaPaises = null;
	if(request.getAttribute("listaPaises")!=null)
	{
		listaPaises = (ArrayList<Pais>) request.getAttribute("listaPaises");
	}
	
	ArrayList<Localidad> listaLocalidades = null;
	if(request.getAttribute("listaLocalidades")!=null)
	{
		listaLocalidades = (ArrayList<Localidad>) request.getAttribute("listaLocalidades");
	}
	
 %>



	<div class="conteiner__h2">
		<h2>Docentes</h2>

		<a href="AltaDocente.jsp"><button type="button">Agregar
				Docente</button></a>

	</div>



	<div class="conteiner__tabla">

		<table>

			<tr>

				<th>Dni</th>

				<th>Legajo</th>

				<th>Nombre y Apellido</th>

				<th>Fecha de Nacimiento</th>

				<th>Dirreción</th>

                <th>Localidad</th>

				<th>Nacionalidad</th>

				<th>Email</th>

				<th>Teléfono</th>
				
				<th></th>
				
				<th></th>


			</tr>

			 <%  if(listaDocentes!=null)
		for(Docente docente : listaDocentes) 
		{
	%>
		<tr>  
		    <form name="tablaDocentes" action="servletPersona" method="get">
				
				<td> <input type="number" name="dniDocente" readonly="readonly" value="<%=docente.getDni()%>"> </td> 
				<td> <input type="number" required name="legajoAlumno" value="<%=docente.getLegajo() %>" ></td>   
				<td> <input type="text" required name="nombreAlumno" value="<%=docente.getNombreApellido() %>" ></td> 
				<td> <input type="text" required pattern="\d{1,2}/\d{1,2}/\d{4}" title="La fecha no es v&aacute;lida" name="nacimientoDocente" value="<%=docente.getFechaNacimiento() %>" ></td> 
				<td> <input type="text" required name="direccionDocente" value="<%=docente.getDireccion() %>" ></td> 
				     <td> 
				         <select required name="provinciaAlumno">
                     <%  if(listaLocalidades!=null)
		                    {
		                    for(Localidad localidad : listaLocalidades) 
		                    {
		                       if (docente.getLocalidad().getId()==localidad.getId())
		                       {
	                 %>
							   <option selected="selected" value="<%=localidad.getId() %>"><%=localidad.getNombre() %></option>
	                 <%
	                           }else{ 
	                  %> 
	                 <option value="<%=localidad.getId() %>"><%=localidad.getNombre() %></option>
	                 
	                     <%    }
                             }
                            }
	                     %>							

					     </select>
				
				</td> 
				<td> <select required name="nacionalidadDocente" >
				 <%  if(listaPaises!=null)
		                    {
		                    for(Pais pais : listaPaises) 
		                      {  
		                          if (docente.getNacionalidad().getId()==pais.getId())
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
				<td> <input type="email" required name="emailDocente" value="<%=docente.getEmail() %>" ></td> 
				<td> <input type="number" required name="telefonoDocente" value="<%=docente.getTelefono() %>" ></td> 
				<td> <input type="submit" name="modificarDocente" value="Modificar"> </td>
				<td> <input type="submit" name="eliminarDocente" value="Eliminar"> </td>    
				
			</form> 
		</tr>
	<%  } %>

		</table>

	</div>

	</main>


</body>
</html>