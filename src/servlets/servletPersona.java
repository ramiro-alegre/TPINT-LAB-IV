package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.daoPerfil;
import daoImplementacion.daoImplAlumno;
import daoImplementacion.daoImplDocente;
import daoImplementacion.daoImplLocalidad;
import daoImplementacion.daoImplLogin;
import daoImplementacion.daoImplPais;
import daoImplementacion.daoImplPerfil;
import daoImplementacion.daoImplProvincia;

import java.util.ArrayList;

import entidad.Alumno;
import entidad.Docente;
import entidad.Localidad;
import entidad.Pais;
import entidad.Perfil;
import entidad.Provincia;


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
		
		ArrayList<Pais> listaPaises = daoPais.readAll();
		ArrayList<Provincia> listaProvincias = daoProvincia.readAll();
		ArrayList<Localidad> listaLocalidades = daoLocalidad.readAll();   
		ArrayList<Alumno> listaAlumnos= daoAlumno.readAll();
		ArrayList<Docente> listaDocentes= daoDocente.readAll();
		
		
		
		
		if(request.getParameter("toAdmAlumnos")!=null)
		{
				request.setAttribute("listaAlumnos", listaAlumnos);
				request.setAttribute("listaProvincias", listaProvincias);
				request.setAttribute("listaPaises", listaPaises);
				
				RequestDispatcher rd = request.getRequestDispatcher("Administrador/AdministradorAlumnos.jsp");  
				
		        rd.forward(request, response);	
		}
		
		if(request.getParameter("toAdmDocentes")!=null)
		{
				request.setAttribute("listaDocentes", listaDocentes);
				request.setAttribute("listaLocalidades", listaLocalidades);
				
				RequestDispatcher rd = request.getRequestDispatcher("Administrador/AdministradorDocentes.jsp");   
		        rd.forward(request, response);	
		}
		
		
		if(request.getParameter("eliminarAlumno")!=null)
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
		
		if(request.getParameter("modificarAlumno")!=null)
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
		
		if(request.getParameter("eliminarDocente")!=null)
		{
			
			int dni = Integer.parseInt(request.getParameter("dniDocente").toString());
			
			boolean isDeleteExitoso = daoDocente.delete(dni);
			
			listaPaises = daoPais.readAll();
			listaLocalidades = daoLocalidad.readAll();
			listaDocentes= daoDocente.readAll();
			
			   request.setAttribute("deleteExitosoDocente",isDeleteExitoso);
			   request.setAttribute("listaDocentes", listaDocentes);
				request.setAttribute("listaLocalidades", listaLocalidades);
				request.setAttribute("listaPaises", listaPaises);
			   
		       RequestDispatcher rd = request.getRequestDispatcher("Administrador/AdministradorDocentes.jsp");
		       rd.forward(request, response);
		}
		
		if(request.getParameter("modificarDocente")!=null)
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
			
			listaPaises = daoPais.readAll();
			listaLocalidades = daoLocalidad.readAll();
			listaDocentes= daoDocente.readAll();
			
			request.setAttribute("updateExitosoDocente",isUpdateExitoso);
			request.setAttribute("listaAlumnos", listaDocentes);
			request.setAttribute("listaLocalidades", listaLocalidades);
			request.setAttribute("listaPaises", listaPaises);
		    RequestDispatcher rd = request.getRequestDispatcher("Administrador/AdministradorDocentes.jsp");
		    rd.forward(request, response);
			
		}
		
		if(request.getParameter("agregarDocente")!=null) 
		{

			Docente docente = new Docente();
					
			//Se comenta el legajo porque es automatico(auto incrementable)
			docente.setDni(Integer.parseInt(request.getParameter("dniDocente").toString()));
			//docente.setLegajo(Integer.parseInt(request.getParameter("legajoDocente").toString()));
			docente.setNombreApellido(request.getParameter("nombreDocente").toString());
			docente.setFechaNacimiento(request.getParameter("nacimientoDocente").toString());
			docente.setDireccion(request.getParameter("direccionDocente").toString());
			docente.setLocalidad(daoLocalidad.localidadFromID(Integer.parseInt(request.getParameter("localidadDocente").toString())));
			docente.setNacionalidad(daoPais.paisFromID(Integer.parseInt(request.getParameter("nacionalidadDocente").toString())));
			docente.setEmail(request.getParameter("emailDocente").toString());		                     
			docente.setTelefono(Integer.parseInt(request.getParameter("telefonoDocente").toString()));		                     
			docente.setEstado(true);	
			
			boolean isInsertExitoso = daoDocente.insert(docente);
			request.setAttribute("insertExitosoDocente",isInsertExitoso);
			
			//En este punto, ya se creo correctamente el docente
			//Ahora se pasa a crear su perfil
			
			Perfil perfil = new Perfil();
			
			perfil.setDni(docente.getDni());
			perfil.setEmail(docente.getEmail());
			perfil.setContrasenia(request.getParameter("contraseniaDocente").toString());
			
			boolean isInsertExitoso2 = daoPerfil.insert(perfil);
			request.setAttribute("insertExitosoPerfilDocente",isInsertExitoso2);
			
			//En este punto, ya se creo correctamente su perfil
			
			RequestDispatcher rd = request.getRequestDispatcher("Administrador/AdministradorDocentes.jsp");
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
				request.setAttribute("Perfil",perfil);	
				RequestDispatcher rd = request.getRequestDispatcher("Administrador/Administrador.jsp");
				rd.forward(request,response);
				}else {
		
						request.setAttribute("Perfil",perfil);	
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
