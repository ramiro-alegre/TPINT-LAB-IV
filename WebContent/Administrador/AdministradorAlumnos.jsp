<%@page import="entidad.Perfil"%>
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
<link href="Administrador/StyleGeneral.css" rel="stylesheet" type="text/css">

<link href="Administrador/AdministradorAlumnosDocentes.css" rel="stylesheet"
	type="text/css">
	
	
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
</head>
<body>
<% 
Perfil perfil = null;
if(session.getAttribute("Perfil")!= null){
       perfil = (Perfil) session.getAttribute("Perfil");
} %>
	<header>

		<div class="conteiner__volver">
			<a href="servletPersona?toAdmGeneral=1" >Volver</a>
		</div>

		<div class="conteiner__h1">
			<h1>Panel Alumnos</h1>
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
	
	int dniAlumno = 0;
	 if(request.getAttribute("avisoModificarAlumno")!=null){
			
		dniAlumno = (int)request.getAttribute("avisoModificarAlumno");
	}
	
 %>
  
	<div class="conteiner__h2">
		<h2>Alumnos</h2>

		<a href="servletPersona?toAgregarAlumno=1"><button type="button">Agregar
				Alumno</button></a>

	</div>



	<div class="conteiner__alumnos">

	<table id="customers" class="table">

        <thead>
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
			
	    </thead>

		 <% 
			 
			 
			 
			 if(request.getAttribute("avisoModificarAlumno")!= null){
					
				 if(listaAlumnos!=null){
					 
					 //En este punto necesitamos que los filtros desaparezcan 
					 
					 %>
<script type="text/javascript">

  $(document).ready(function() {
	
      $('.table tfoot').remove();
        
   

    // DataTable
    var table = $('.table').DataTable({
    	searching: false
    });
  } );
</script>
					 <% 
					 
					 for(Alumno alumno : listaAlumnos){
						 if(dniAlumno == alumno.getDni()){
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
				<td> <input type="submit" name="modificarAlumno" value="Modificar" onclick="return confirm('seguro que desea modificar al alumno?')" > </td>
				<td> <input type="submit" name="eliminarAlumno" value="Eliminar"  onclick="return confirm('seguro que desea eliminar al alumno?')" > </td>    
				
			</form> 
		</tr>
							 
							 <% 
						 }
					 }
				 }
				 
				} else{
			 
			 if(listaAlumnos!=null)
//Tabla por default cuando no se modifica nada		 
 %>

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
 <% 	 
			
		for(Alumno alumno : listaAlumnos) 
		{
	%>
	
		<tr>  
		    <form name="tablaAlumnos" action="servletPersona" method="get">
				
				<td name="dniAlumno"> <%=alumno.getDni()%> <input type="hidden" name="dniAlumno" value="<%=alumno.getDni()%>"></td> 
				<td><%=alumno.getLegajo() %></td>   
				<td><%=alumno.getNombreApellido() %></td> 
				<td><%=alumno.getFechaNacimiento() %></td> 
				<td><%=alumno.getDireccion() %></td> 
				<td> 
				         
                     <%  if(listaProvincias!=null)
		                    {
		                    for(Provincia provincia: listaProvincias) 
		                    {
		                       if (alumno.getProvincia().getId()==provincia.getId())
		                       {
	                 %>
							   <%=provincia.getNombre() %>
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
		                          if (alumno.getNacionalidad().getId()==pais.getId())
		                         {
		                    %>	
				                   <%=pais.getNombre() %>
				<%               } 
				             }
				           }
				
				%>
				
				</td> 
				<td><%=alumno.getEmail()%></td> 
				<td><%=alumno.getTelefono()%></td> 
				<td><input type="submit" name="modificarAlumnoAviso" value="Modificar"></td>
				<td><input type="submit" name="eliminarAlumno" value="Eliminar"></td>    
				
			</form> 
		</tr>
		
		
	<%  }} %>
	</tbody>
	 <tfoot>
            <tr>
                <th>dni</th>
                <th>legajo</th>
                <th>nombre y apellido</th>
                <th>fecha de nacimiento</th>
                <th>direcci�n</th>
                <th>localidad</th>
                <th>nacionalidad</th>
                <th>email</th>
                <th>telefono</th>
            </tr>
        </tfoot>
</table>

		<% if(request.getAttribute("updateExitosoAlumno") != null){
			%><div class="center" ><p class="mensaje"><%=request.getAttribute("updateExitosoAlumno") %></p></div><% 
					request.setAttribute("updateExitosoAlumno", null);
			}%>
			
			<% if(request.getAttribute("deleteExitosoAlumno") != null){
			%><div class="center"><p class="mensaje"><%=request.getAttribute("deleteExitosoAlumno") %></p></div><% 
					request.setAttribute("deleteExitosoAlumno", null);
			}%>
			
			<% if(request.getAttribute("insertExitosoAlumno") != null){
			%><div class="center"><p class="mensaje"><%=request.getAttribute("insertExitosoAlumno") %></p></div><% 
					request.setAttribute("insertExitosoAlumno", null);
			}%>
			
		
	</div>

	</main>


</body>

 

</html>