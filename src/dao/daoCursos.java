package dao;

import java.util.ArrayList;

import entidad.Curso;

public interface daoCursos {
	public ArrayList<Curso> readAllFromProf(int dniProfesor);
	
	public Curso cursoFromID(int idCurso);
	
	public boolean insert (Curso curso);
}
