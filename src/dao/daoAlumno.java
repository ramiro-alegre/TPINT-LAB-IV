package dao;

import java.util.ArrayList;

import entidad.Alumno;


public interface daoAlumno {

	public boolean insert(Alumno alumno);
	public boolean delete(Alumno alumno);
	public ArrayList<Alumno> readAll();
	public boolean update(Alumno alumno);
	public Alumno readFromDni (int dniAlumno);
	public boolean verificarDni(int dni);
	public boolean verificarLegajo(int legajo);
	public boolean verificarEmail(String email);
}
