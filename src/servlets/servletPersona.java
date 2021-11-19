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
import daoImplementacion.daoImplLocalidades;

import java.util.ArrayList;

import entidad.Persona;


@WebServlet("/servletPersona")
public class servletPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public servletPersona() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		daoImplAlumno daoAlumno = new daoImplAlumno();
		daoImplDocente daoDocente = new daoImplDocente();
		daoImplLocalidades daoLocalidades = new daoImplLocalidades();
		ArrayList<Persona> listaAlumnos= daoAlumno.readAll();
		ArrayList<Persona> listaDocentes= daoDocente.readAll();
		
		/*if(request.getParameter("toAdmAlumnos")!=null)
		{
				request.setAttribute("listaAlumnos", listaAlumnos);
			
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdministradorAlumnos.jsp");	 
				
		        rd.forward(request, response);	
		}*/
		
		if(request.getParameter("toAdmAlumnos")!=null)
		{
				request.setAttribute("listaAlumnos", listaAlumnos);
			
				RequestDispatcher rd = request.getRequestDispatcher("/AdministradorAlumnos.jsp");  
				
		        rd.forward(request, response);	
		}
		
		if(request.getParameter("toAdmDocentes")!=null)
		{
				request.setAttribute("listaDocentes", listaDocentes);
				
				RequestDispatcher rd = request.getRequestDispatcher("/AdministradorDocentes.jsp");   
		        rd.forward(request, response);	
		}
		
		
		if(request.getParameter("eliminarAlumno")!=null)
		{
			
			int dni = Integer.parseInt(request.getParameter("dniAlumno").toString());
			
			boolean isDeleteExitoso = daoAlumno.delete(dni);
			   request.setAttribute("deleteExitoso",isDeleteExitoso);
			   request.setAttribute("listaAlumnos", listaAlumnos);
		       RequestDispatcher rd = request.getRequestDispatcher("/AdministradorAlumnos.jsp");
		       rd.forward(request, response);
		}
		
		if(request.getParameter("modificarAlumno")!=null)
		{
			
			Persona alumno = daoLocalidades.getPersonaLocalizada(Integer.parseInt(request.getParameter("localidadAlumno").toString()));
			alumno.setDni(Integer.parseInt(request.getParameter("dniAlumno").toString()));
			alumno.setLegajo(Integer.parseInt(request.getParameter("legajoAlumno").toString()));
			alumno.setNombreApellido(request.getParameter("nombreAlumno").toString());
			alumno.setFechaNacimiento(request.getParameter("nacimientoAlumno").toString());
			alumno.setDireccion(request.getParameter("direccionAlumno").toString());		                     
			alumno.setEmail(request.getParameter("emailAlumno").toString());		                     
			alumno.setTelefono(Integer.parseInt(request.getParameter("telefonoAlumno").toString()));		                     
			alumno.setEstado(true);		                     
					         	
			boolean isUpdateExitoso = daoAlumno.update(alumno);
			
			request.setAttribute("deleteExitoso",isUpdateExitoso);
			request.setAttribute("listaAlumnos", listaAlumnos);
		    RequestDispatcher rd = request.getRequestDispatcher("/AdministradorAlumnos.jsp");
		    rd.forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
