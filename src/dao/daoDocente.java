package dao;

import java.util.ArrayList;

import entidad.Docente;

public interface daoDocente {
	public boolean insert(Docente docente);
	public boolean delete(int id);
	public ArrayList<Docente> readAll();
	public boolean update(Docente docente);
	public boolean verificarDni(int dni);
	public boolean verificarLegajo(int legajo);
	public boolean verificarEmail(String email);
}
