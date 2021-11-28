package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.daoMateria;
import dao.daoPerfil;
import daoImplementacion.daoImplAlumno;
import daoImplementacion.daoImplCursAlumn;
import daoImplementacion.daoImplCursos;
import daoImplementacion.daoImplDocente;
import daoImplementacion.daoImplLocalidad;
import daoImplementacion.daoImplLogin;
import daoImplementacion.daoImplMateria;
import daoImplementacion.daoImplPais;
import daoImplementacion.daoImplPerfil;
import daoImplementacion.daoImplProvincia;

import java.util.ArrayList;

import entidad.Alumno;
import entidad.Curso;
import entidad.Docente;
import entidad.Localidad;
import entidad.Materia;
import entidad.Pais;
import entidad.Perfil;
import entidad.Provincia;
import entidad.CursosAlumnos;


@WebServlet("/servletPersona")
public class servletPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public servletPersona() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		daoImplAlumno daoAlumno = new daoImplAlumno();
		daoImplDocente daoDocente = new daoImplDocente();
		daoImplLocalidad daoLocalidad = new daoImplLocalidad(); 
		daoImplProvincia daoProvincia = new daoImplProvincia();
		daoImplPais daoPais = new daoImplPais();
		daoImplPerfil daoPerfil = new daoImplPerfil();
		daoImplCursAlumn daoCursosxAlumnos = new daoImplCursAlumn();
		
		daoImplCursos daoCursos = new daoImplCursos();
		daoImplMateria daoMateria = new daoImplMateria();
		
		ArrayList<Pais> listaPaises = daoPais.readAll();
		ArrayList<Provincia> listaProvincias = daoProvincia.readAll();
		ArrayList<Localidad> listaLocalidades = daoLocalidad.readAll();   
		ArrayList<Alumno> listaAlumnos= daoAlumno.readAll();
		ArrayList<Docente> listaDocentes= daoDocente.readAll();
		ArrayList<Materia> listaMaterias = daoMateria.readAll();
		
		
		
		
		if(request.getParameter("toAdmAlumnos")!=null)   // ---LINK HACIA ADMINISTRADOR ALUMNOS
		{
				request.setAttribute("listaAlumnos", listaAlumnos);
				request.setAttribute("listaProvincias", listaProvincias);
				request.setAttribute("listaPaises", listaPaises);
				
				RequestDispatcher rd = request.getRequestDispatcher("Administrador/AdministradorAlumnos.jsp");  
				
		        rd.forward(request, response);	
		}
		
		if(request.getParameter("toAdmDocentes")!=null)  // ---LINK HACIA ADMINISTRADOR DOCENTES
		{
				request.setAttribute("listaDocentes", listaDocentes);
				request.setAttribute("listaLocalidades", listaLocalidades);
				request.setAttribute("listaPaises", listaPaises);
				
				RequestDispatcher rd = request.getRequestDispatcher("Administrador/AdministradorDocentes.jsp");   
		        rd.forward(request, response);	
		}
		
		
		if(request.getParameter("eliminarAlumno")!=null)  // ---BOTON QUE ELIMINA ALUMNOS
		{
			
			int dni = Integer.parseInt(request.getParameter("dniAlumno").toString());
			
			boolean isDeleteExitoso = daoAlumno.delete(dni);
			
			listaPaises = daoPais.readAll();
			listaProvincias = daoProvincia.readAll();
			listaAlumnos= daoAlumno.readAll();
			
			   request.setAttribute("deleteExitoso",isDeleteExitoso);
			   request.setAttribute("listaAlumnos", listaAlumnos);
				request.setAttribute("listaProvincias", listaProvincias);
				request.setAttribute("listaPaises", listaPaises);
			   
		       RequestDispatcher rd = request.getRequestDispatcher("Administrador/AdministradorAlumnos.jsp");
		       rd.forward(request, response);
		}
		
		if(request.getParameter("modificarAlumno")!=null)    // ---BOTON QUE MODIFICA ALUMNOS
		{
			
			Alumno alumno = new Alumno();
					
			
			alumno.setDni(Integer.parseInt(request.getParameter("dniAlumno").toString()));
			alumno.setLegajo(Integer.parseInt(request.getParameter("legajoAlumno").toString()));
			alumno.setNombreApellido(request.getParameter("nombreAlumno").toString());
			alumno.setFechaNacimiento(request.getParameter("nacimientoAlumno").toString());
			alumno.setDireccion(request.getParameter("direccionAlumno").toString());
			alumno.setProvincia(daoProvincia.provinciaFromID(Integer.parseInt(request.getParameter("provinciaAlumno").toString())));
			alumno.setNacionalidad(daoPais.paisFromID(Integer.parseInt(request.getParameter("nacionalidadAlumno").toString())));
			alumno.setEmail(request.getParameter("emailAlumno").toString());		                     
			alumno.setTelefono(Integer.parseInt(request.getParameter("telefonoAlumno").toString()));		                     
			alumno.setEstado(true);		                     
					         	
			boolean isUpdateExitoso = daoAlumno.update(alumno);
			
			listaPaises = daoPais.readAll();
			listaProvincias = daoProvincia.readAll();
			listaAlumnos= daoAlumno.readAll();
			
			request.setAttribute("updateExitoso",isUpdateExitoso);
			request.setAttribute("listaAlumnos", listaAlumnos);
			request.setAttribute("listaProvincias", listaProvincias);
			request.setAttribute("listaPaises", listaPaises);
		    RequestDispatcher rd = request.getRequestDispatcher("Administrador/AdministradorAlumnos.jsp");
		    rd.forward(request, response);
			
		}
		
		if(request.getParameter("eliminarDocente")!=null)     // ---BOTON QUE ELIMINA DOCENTES
		{
			
			int dni = Integer.parseInt(request.getParameter("dniDocente").toString());
			
			boolean isDeleteExitoso = daoDocente.delete(dni);
			boolean isDeleteExitoso2 = daoPerfil.delete(dni);
			
			String mensaje = "";
			
			/*Operador ternario*/
			mensaje = (isDeleteExitoso && isDeleteExitoso2) ? "Eliminado correctamente" : (!isDeleteExitoso) ? 
			"Ocurrio un error al eliminar el docente" : (!isDeleteExitoso2) ? "Ocurrio un error al eliminar su usuario" : "Ocurrio un error";
			
			
			
			
			listaPaises = daoPais.readAll();
			listaLocalidades = daoLocalidad.readAll();
			listaDocentes= daoDocente.readAll();
			
			   request.setAttribute("deleteExitosoDocente",mensaje);
			   
			   request.setAttribute("listaDocentes", listaDocentes);
				request.setAttribute("listaLocalidades", listaLocalidades);
				request.setAttribute("listaPaises", listaPaises);
			   
		       RequestDispatcher rd = request.getRequestDispatcher("Administrador/AdministradorDocentes.jsp");
		       rd.forward(request, response);
		}
		
		
		if(request.getParameter("modificarDocenteAviso") != null) {
			
			listaPaises = daoPais.readAll();
			listaLocalidades = daoLocalidad.readAll();
			listaDocentes= daoDocente.readAll();
			
			
			request.setAttribute("listaDocentes", listaDocentes);
			request.setAttribute("listaLocalidades", listaLocalidades);
			request.setAttribute("listaPaises", listaPaises);
			
			int dni = Integer.parseInt(request.getParameter("dniDocente").toString());
			request.setAttribute("avisoModificarDocente", dni);
			
			System.out.println(request.getAttribute("avisoModificarDocente"));
			RequestDispatcher rd = request.getRequestDispatcher("Administrador/AdministradorDocentes.jsp");
		    rd.forward(request, response);
		}
		
		if(request.getParameter("modificarDocente")!=null) // ---BOTON QUE MODIFICA DOCENTES
		{
			
			Docente docente = new Docente();
					
			
			docente.setDni(Integer.parseInt(request.getParameter("dniDocente").toString()));
			docente.setLegajo(Integer.parseInt(request.getParameter("legajoDocente").toString()));
			docente.setNombreApellido(request.getParameter("nombreDocente").toString());
			docente.setFechaNacimiento(request.getParameter("nacimientoDocente").toString());
			docente.setDireccion(request.getParameter("direccionDocente").toString());
			docente.setLocalidad(daoLocalidad.localidadFromID(Integer.parseInt(request.getParameter("localidadDocente").toString())));
			docente.setNacionalidad(daoPais.paisFromID(Integer.parseInt(request.getParameter("nacionalidadDocente").toString())));
			docente.setEmail(request.getParameter("emailDocente").toString());		                     
			docente.setTelefono(Integer.parseInt(request.getParameter("telefonoDocente").toString()));		                     
			docente.setEstado(true);		                     
					         	
			boolean isUpdateExitoso = daoDocente.update(docente);
			
			                             /*Este es el operador ternario*/
			String mensaje = isUpdateExitoso ? "Modificado correctamente" : "Ocurrio un error";
			
			
			listaPaises = daoPais.readAll();
			listaLocalidades = daoLocalidad.readAll();
			listaDocentes= daoDocente.readAll();
			
			request.setAttribute("updateExitosoDocente",mensaje);
			
			request.setAttribute("listaDocentes", listaDocentes);
			request.setAttribute("listaLocalidades", listaLocalidades);
			request.setAttribute("listaPaises", listaPaises);
			
			request.setAttribute("avisoModificarDocente", null);
			
		    RequestDispatcher rd = request.getRequestDispatcher("./servletPersona?toAdmDocentes=1");
		    rd.forward(request, response);
			
		}


	   if(request.getParameter("agregarAlumno")!=null) // ---BOTON QUE AGREGA alumnos
		{

			Alumno alumno = new Alumno();
			

			alumno.setDni(Integer.parseInt(request.getParameter("dniAlumno").toString()));
			alumno.setLegajo(Integer.parseInt(request.getParameter("legajoAlumno").toString()));
	        alumno.setNombreApellido(request.getParameter("nombreAlumno").toString());
	        alumno.setFechaNacimiento(request.getParameter("nacimientoAlumno").toString());
		    alumno.setDireccion(request.getParameter("direccionAlumno").toString());
			alumno.setNacionalidad(daoPais.paisFromID(Integer.parseInt(request.getParameter("nacionalidadAlumno").toString())));
			alumno.setProvincia(daoProvincia.provinciaFromID(Integer.parseInt(request.getParameter("provinciaAlumno").toString())));
			
			alumno.setEmail(request.getParameter("emailAlumno").toString());		                     
			alumno.setTelefono(Integer.parseInt(request.getParameter("telefonoAlumno").toString()));		                     
			alumno.setEstado(true);	
			
			boolean isInsertExitoso = daoAlumno.insert(alumno);
			
			String mensaje = "";
			mensaje = (isInsertExitoso) ? "Agregado correctamente" : "Ocurrio un error al agregar el Alumno";
			
			request.setAttribute("insertExitosoAlumno",mensaje);
			
			/*Este caso es en el que no haya ocurrido ningun error, por lo tanto se muestra el mensaje en admAlumnos*/
			if(isInsertExitoso ) {
				RequestDispatcher rd = request.getRequestDispatcher("./servletPersona?toAdmAlumnos=1");
			    rd.forward(request, response);
			}
			/*Este caso es en el que haya ocurrido un error, por lo tanto se muestra el mensaje en alumno*/
			  RequestDispatcher rd = request.getRequestDispatcher("./servletPersona?toAgregarAlumno=1");
			    rd.forward(request, response);
			
		}
		
		if(request.getParameter("agregarDocente")!=null) // -----BOTON QUE AGREGA DOCENTES
		{

			
			request.setAttribute("listaLocalidades", listaLocalidades);
			request.setAttribute("listaPaises", listaPaises);
			
			
			Docente docente = new Docente();
					
			
			
			docente.setDni(Integer.parseInt(request.getParameter("dniDocente").toString()));
			docente.setLegajo(Integer.parseInt(request.getParameter("legajoDocente").toString()));
			docente.setNombreApellido(request.getParameter("nombreDocente").toString());
			docente.setFechaNacimiento(request.getParameter("nacimientoDocente").toString());
			docente.setDireccion(request.getParameter("direccionDocente").toString());
			docente.setLocalidad(daoLocalidad.localidadFromID(Integer.parseInt(request.getParameter("localidadDocente").toString())));
			docente.setNacionalidad(daoPais.paisFromID(Integer.parseInt(request.getParameter("nacionalidadDocente").toString())));
			docente.setEmail(request.getParameter("emailDocente").toString());		                     
			docente.setTelefono(Integer.parseInt(request.getParameter("telefonoDocente").toString()));		                     
			docente.setEstado(true);	
			
			boolean isInsertExitoso = daoDocente.insert(docente);
			
			String mensaje = "";
			mensaje = (isInsertExitoso) ? "Agregado correctamente" : "Dni, legajo o email ya registrados";
			
			request.setAttribute("insertExitosoDocente",mensaje);
			
			//Ocurrio un error al agregar el docente, por lo tanto, no se agrega su perfil 
			if(!isInsertExitoso) 
			{
				RequestDispatcher rd = request.getRequestDispatcher("Administrador/AltaDocente.jsp");
			    rd.forward(request, response);
			}
			
			
			Perfil perfil = new Perfil();
			
			perfil.setDni(docente.getDni());
			perfil.setEmail(docente.getEmail());
			perfil.setContrasenia(request.getParameter("contraseniaDocente").toString());
			
			boolean isInsertExitoso2 = daoPerfil.insert(perfil);
			
			mensaje = (isInsertExitoso2) ? "Agregado correctamente" : "Ocurrio un error al agregar su usuario";
			
			request.setAttribute("insertExitosoDocente",mensaje);
			
			/*Este caso es en el que no haya ocurrido ningun error, por lo tanto se muestra el mensaje en admDocentes*/
			if(isInsertExitoso && isInsertExitoso2) {
				RequestDispatcher rd = request.getRequestDispatcher("Administrador/AltaDocente.jsp");
			    rd.forward(request, response);
			}
			/*Este caso es en el que haya ocurrido un error, por lo tanto se muestra el mensaje en AgregarDocente*/
			  RequestDispatcher rd = request.getRequestDispatcher("Administrador/AltaDocente.jsp");
			    rd.forward(request, response);
			
		}
		
		if(request.getParameter("toAgregarDocente")!=null)  // ---LINK HACIA AGREGAR DOCENTES
		{
				
				request.setAttribute("listaLocalidades", listaLocalidades);
				request.setAttribute("listaPaises", listaPaises);
				
				RequestDispatcher rd = request.getRequestDispatcher("Administrador/AltaDocente.jsp");  
				
		        rd.forward(request, response);	
		}
		
		if(request.getParameter("toAgregarAlumno")!=null)  // ---LINK HACIA AGREGAR ALUMNOS
		{
				
				request.setAttribute("listaProvincias", listaProvincias);
				request.setAttribute("listaPaises", listaPaises);
				
				RequestDispatcher rd = request.getRequestDispatcher("Administrador/AltaAlumno.jsp");  
				
		        rd.forward(request, response);	
		}
		
		
		if(request.getParameter("cerrarSesion")!=null)  // ---LINK HACIA LOGIN ELIMINANDO VARIABLE SESSION
		{
				
				request.getSession().removeAttribute("Perfil");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");  
				
		        rd.forward(request, response);	
		}
		
		if(request.getParameter("toCursos")!=null) { // ---LINK HACIA CURSOS SEGUN PROFESOR
		
		    Perfil perfilDocente = (Perfil)request.getSession().getAttribute("Perfil");
			ArrayList<Curso> listaCursos = daoCursos.readAllFromProf(perfilDocente.getDni());
			
			request.setAttribute("listaCursos", listaCursos);
			request.setAttribute("listaMaterias", listaMaterias );
			RequestDispatcher rd = request.getRequestDispatcher("Docente/Cursos.jsp");
			
			rd.forward(request, response);
		}
		
		if(request.getParameter("toCursosxAlumnos")!=null) { // ---LINK HACIA ALUMNOS POR CURSO
			
			Curso cursoPorID = daoCursos.cursoFromID(Integer.parseInt(request.getParameter("toCursosxAlumnos").toString()));
			
			ArrayList<CursosAlumnos> notasAlumnos = daoCursosxAlumnos.readAllFromID(Integer.parseInt(request.getParameter("toCursosxAlumnos").toString()));
			
			request.setAttribute("listaAlumnos", listaAlumnos);
			request.setAttribute("notasAlumnos", notasAlumnos);
			request.setAttribute("cursoPorID", cursoPorID);
			request.setAttribute("listaMaterias", listaMaterias );
			RequestDispatcher rd = request.getRequestDispatcher("Docente/AlumnosCursos.jsp");
			
			rd.forward(request, response);
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		daoImplLogin  daoImplLogin;
		daoImplLogin = new daoImplLogin();
		
		String email = request.getParameter("email");
		String contrasenia = request.getParameter("contrasenia");
		Perfil perfil;
		

		try {
			perfil = daoImplLogin.getValidPerfil(email, contrasenia);
			
			if (perfil.isEstado() ) {
				
				if(perfil.isAdministrador()) {
				request.getSession().setAttribute("Perfil",perfil);	
				RequestDispatcher rd = request.getRequestDispatcher("Administrador/Administrador.jsp");
				rd.forward(request,response);
				}else {
		
						request.getSession().setAttribute("Perfil",perfil);	
						RequestDispatcher rd = request.getRequestDispatcher("Docente/Docente.jsp");
						rd.forward(request,response);
					  
					}
				
				
			} else {
				
				request.setAttribute("perfilInvalido","Usuario o contrasenia invalido");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request,response);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
