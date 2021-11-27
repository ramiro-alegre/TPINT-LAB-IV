<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Perfil"%>
<%@page import="entidad.Docente"%>
<%@page import="entidad.Pais"%>
<%@page import="entidad.Localidad"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador Docentes</title>
<link href="Administrador/StyleGeneral.css" rel="stylesheet" type="text/css">
<link href="Administrador/AdministradorAlumnosDocentes.css" rel="stylesheet" type="text/css">


<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>


<script type="text/javascript">
    $(document).ready( function () {
        var table = $('.table').DataTable();
        
     
        
    } );
    
    //Intentando eliminar el mensaje pasados 3 segundos 
 	let div = document.querySelector('#center');
    if(div){
    	
    	setTimeout(function() {
    		$("#center").remove();
        }, 3000);
    }
    </script>
</head>
<body>
<% Perfil perfil = null;
if(session.getAttribute("Perfil")!= null){
       perfil = (Perfil) session.getAttribute("Perfil");
} %>
	<header>

		<div class="conteiner__volver">
			<a href="Administrador/Administrador.jsp">Volver</a>
		</div>

		<div class="conteiner__h1">
			<h1>Panel Docentes</h1>
		</div>

		<div class="conteiner__usuario">
			<p>
				Bienvenido <%if(perfil != null) { %><span id="usuario"><%=perfil.getEmail() %></span>  <%} %>
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

		<a href="servletPersona?toAgregarDocente=1"><button type="button">Agregar
				Docente</button></a>

	</div>



	<div class="conteiner__tabla">

		<table id="customers" class="table">
		<thead>
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
				
				<th>Modificar</th>
				
				<th>Eliminar</th>


			</tr>
			</thead>
<tbody>


			 <%  if(listaDocentes!=null)
		for(Docente docente : listaDocentes) 
		{
	%>
	
		<tr>  
		    <form name="tablaDocentes" action="servletPersona" method="get">
				
				<td> <input type="number" name="dniDocente" readonly="readonly" value="<%=docente.getDni()%>"> </td> 
				<td> <input type="number" required name="legajoDocente" value="<%=docente.getLegajo() %>" ></td>   
				<td> <input type="text" required name="nombreDocente" value="<%=docente.getNombreApellido() %>" ></td> 
				<td> <input type="text" required pattern="\d{1,2}/\d{1,2}/\d{4}" title="La fecha no es v&aacute;lida" name="nacimientoDocente" value="<%=docente.getFechaNacimiento() %>" ></td> 
				<td> <input type="text" required name="direccionDocente" value="<%=docente.getDireccion() %>" ></td> 
				     <td> 
				         <select required name="localidadDocente">
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
</tbody>
		</table>

		<% if(request.getAttribute("updateExitosoDocente") != null){
			%><div class="center" ><p class="mensaje"><%=request.getAttribute("updateExitosoDocente") %></p></div><% 
					request.setAttribute("updateExitosoDocente", null);
			}%>
			
			<% if(request.getAttribute("deleteExitosoDocente") != null){
			%><div class="center"><p class="mensaje"><%=request.getAttribute("deleteExitosoDocente") %></p></div><% 
					request.setAttribute("deleteExitosoDocente", null);
			}%>
			
			<% if(request.getAttribute("insertExitosoDocente") != null){
			%><div class="center"><p class="mensaje"><%=request.getAttribute("insertExitosoDocente") %></p></div><% 
					request.setAttribute("insertExitosoDocente", null);
			}%>
			
		
	</div>

	</main>


</body>

 

</html>