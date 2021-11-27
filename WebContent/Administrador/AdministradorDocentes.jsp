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
$(document).ready(function() {
	$('.table thead th').each( function () {
        var title = $('.table tfoot th').eq( $(this).index() ).text();
        if(title!=""){
            $(this).html( '<input type="text" placeholder="Filtrar '+title+'" />' );
      }
    } );

    // DataTable
    var table = $('.table').DataTable({
   
    });

    // Apply the search
    table.columns().eq( 0 ).each( function ( colIdx ) {
        
        $( 'input', table.column( colIdx ).header() ).on( 'keyup change', function () {
            table
                .column( colIdx )
                .search( this.value )
                .draw();
        } );
    } );
} );
    
    

 
    

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

				<th>Dirección</th>

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
				
				<td name="dniDocente"><%=docente.getDni()%> <input type="hidden" name="dniDocente" value="<%=docente.getDni()%>"></td> 
				<td><%=docente.getLegajo() %></td>   
				<td><%=docente.getNombreApellido() %></td> 
				<td><%=docente.getFechaNacimiento() %></td> 
				<td><%=docente.getDireccion() %></td> 
				<td> 
				         
                     <%  if(listaLocalidades!=null)
		                    {
		                    for(Localidad localidad : listaLocalidades) 
		                    {
		                       if (docente.getLocalidad().getId()==localidad.getId())
		                       {
	                 %>
							   <%=localidad.getNombre() %>
	                 <%
	                           }
                             }
                            }
	                     %>							

					    
				
				</td> 
				<td> 
				 <%  if(listaPaises!=null)
		                    {
		                    for(Pais pais : listaPaises) 
		                      {  
		                          if (docente.getNacionalidad().getId()==pais.getId())
		                         {
		                    %>	
				                   <%=pais.getNombre() %>
				<%               } 
				             }
				           }
				
				%>
				
				</td> 
				<td><%=docente.getEmail()%></td> 
				<td><%=docente.getTelefono()%></td> 
				<td><input type="submit" name="modificarDocente" value="Modificar"></td>
				<td><input type="submit" name="eliminarDocente" value="Eliminar"></td>    
				
			</form> 
		</tr>
		
		
	<%  } %>
	</tbody>
	 <tfoot>
            <tr>
                <th>dni</th>
                <th>legajo</th>
                <th>nombre y apellido</th>
                <th>fecha de nacimiento</th>
                <th>dirección</th>
                <th>localidad</th>
                <th>nacionalidad</th>
                <th>email</th>
                <th>teléfono</th>
            </tr>
        </tfoot>
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