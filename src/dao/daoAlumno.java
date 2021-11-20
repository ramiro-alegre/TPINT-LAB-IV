package dao;

import java.util.ArrayList;

import entidad.Alumno;


public interface daoAlumno {

	public boolean insert(Alumno alumno);
	public boolean delete(Alumno alumno);
	public ArrayList<Alumno> readAll();
	public boolean update(Alumno alumno);
}
