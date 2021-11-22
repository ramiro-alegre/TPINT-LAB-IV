package dao;

import java.util.ArrayList;
import entidad.Perfil;

public interface daoPerfil {

	public boolean insert(Perfil perfil);
	public boolean delete(int dni);
	public ArrayList<Perfil> readAll();
	public boolean update(Perfil perfil);
}
