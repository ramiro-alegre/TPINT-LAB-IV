package dao;

import java.util.List;

import entidad.Persona;

public interface daoPersona {

	public boolean insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public List<Persona> readAll();
	public boolean update(Persona personaU);
}
