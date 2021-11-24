package daoImplementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoMateria;
import entidad.Materia;

public class daoImplMateria implements daoMateria {

	
	private static final String readall = "SELECT * FROM materias";
	
	
	@Override
	public ArrayList<Materia> readAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Materia> materias = new ArrayList<Materia>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				materias.add(getMateria(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return materias;
	}

	private Materia getMateria(ResultSet resultSet) throws SQLException {

		Materia materia = new Materia ();
		materia.setId(resultSet.getInt("id"));
		materia.setNombre(resultSet.getString("nombre"));
		return materia;
	}

}
