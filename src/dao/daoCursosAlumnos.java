package dao;

import java.util.ArrayList;

import entidad.CursosAlumnos;



public interface daoCursosAlumnos {
	public ArrayList<CursosAlumnos> readAllFromID(int idCurso);
	public boolean insert (CursosAlumnos cxa);
	public boolean update (CursosAlumnos notas);
}
