<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Pais"%>
<%@page import="entidad.Localidad"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Alta Docente</title>
<link href="Administrador/StyleGeneral.css" rel="stylesheet" type="text/css">
<link href="Administrador/AltaAlumnoDocente.css" rel="stylesheet" type="text/css">
</head>
<body>


	<header>

		<div class="conteiner__volver">
			<a href="servletPersona?toAdmDocentes=1">Volver</a>
		</div>

		<div class="conteiner__h1">
			<h1>Agregar Docente</h1>
		</div>

		<div class="conteiner__usuario">
			<p>
				Bienvenido <span id="usuario">Lorem</span>
			</p>
		</div>
	</header>

<% 

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



	<form class="formulario" action="servletPersona" method="get">

		<div class="conteiner__data">
			<label for="Dni">Dni</label> <input type="text" id="Dni" required name="dniDocente">
		</div>
		
		<div class="conteiner__data">
			<label for="Legajo" >Legajo</label> <input type="text" id="Legajo" required name="legajoDocente">
		</div>

		<div class="conteiner__data">
			<label for="Nombreyapellido">Nombre y Apellido</label> <input
				type="text" id="NombreYapellido" required name="nombreDocente">
		</div>

		<div class="conteiner__data">
			<label for="FechaNacimiento">Fecha de Nacimiento</label> <input
				type="text" id="FechaNacimiento" required name="nacimientoDocente">
		</div>

		<div class="conteiner__data">
			<label for="Direccion">Direccion</label> <input type="text"
				id="Direccion" name="direccionDocente" required>
		</div>

		<div class="conteiner__data">
			<label for="Localidad">Localidad</label> <select id="Localidad" required name="localidadDocente">
			
                     <%  if(listaLocalidades!=null)
		                    {
                    	 
		                    for(Localidad localidad : listaLocalidades) 
		                    {		                       
	                 %>
	                 
	                 <option value="<%=localidad.getId() %>"><%=localidad.getNombre() %></option>
	                 
	                     <%  }
                             }
                            
	                     %>							

					     </select>
		</div>

		<div class="conteiner__data">
			<label for="Nacionalidad">Nacionalidad</label> <select id="Nacionalidad" required name="nacionalidadDocente" >
				 <%  if(listaPaises!=null)
		               {
		                    for(Pais pais : listaPaises) 
		                       {  
		         %>	
				                   <option selected value="<%=pais.getId() %>"><%=pais.getNombre() %></option>
				           <%  }
				             
				       }
				
				            %>
				    
				</select>
		</div>
		
		<%if(listaPaises == null){
				    	%><label>LISTA PAISES ES NULL</label><% 
				    } %>

		<div class="conteiner__data">
			<label for="Email">Email</label> <input type="email" id="Email" name="emailDocente" required>
		</div>

		<div class="conteiner__data">
			<label for="Password">Password</label> <input type="text"
				id="Password" name="contraseniaDocente" required>
		</div>

		<div class="conteiner__data">
			<label for="Telefono">Telefono</label><input type="tel" id="Telefono" name="telefonoDocente" required>
		</div>

		<div>
			<button type="submit" name="agregarDocente">Agregar Docente</button>
		</div>

	</form>



</body>
</html>