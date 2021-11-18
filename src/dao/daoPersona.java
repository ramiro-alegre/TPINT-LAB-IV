package dao;

import java.util.ArrayList;

import entidad.Persona;

public interface daoPersona {

	public boolean insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public ArrayList<Persona> readAll();
	public boolean update(Persona personaU);
}
