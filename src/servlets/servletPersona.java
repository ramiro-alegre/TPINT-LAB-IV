package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImplementacion.daoImplAlumno;
import daoImplementacion.daoImplDocente;
import daoImplementacion.daoImplLocalidad;
import daoImplementacion.daoImplPais;
import daoImplementacion.daoImplProvincia;

import java.util.ArrayList;

import entidad.Alumno;
import entidad.Docente;
import entidad.Localidad;
import entidad.Pais;
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
		//daoImplLocalidad daoLocalidad = new daoImplLocalidad(); -------descomentar cuando se ahga la parte de ABML docentes
		daoImplProvincia daoProvincia = new daoImplProvincia();
		daoImplPais daoPais = new daoImplPais();
		
		ArrayList<Pais> listaPaises = daoPais.readAll();
		ArrayList<Provincia> listaProvincias = daoProvincia.readAll();
		//ArrayList<Localidad> listaLocalidades = daoLocalidad.readAll();   -------descomentar cuando se ahga la parte de ABML docentes
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
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
