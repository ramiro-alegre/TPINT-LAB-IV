package dao;

import java.util.ArrayList;

import entidad.CursosAlumnos;



public interface daoCursosAlumnos {
	public ArrayList<CursosAlumnos> readAllFromID(int idCurso);
}
