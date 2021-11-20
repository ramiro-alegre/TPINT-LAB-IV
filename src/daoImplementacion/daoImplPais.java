package daoImplementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoPais;
import entidad.Pais;

public class daoImplPais implements daoPais {

	private static final String readall = "SELECT * FROM paises";
	
	@Override
	public ArrayList<Pais> readAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Pais> paises = new ArrayList<Pais>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				paises.add(getPais(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return paises;
	}

	private Pais getPais(ResultSet resultSet) throws SQLException {

		Pais pais = new Pais ();
		pais.setId(resultSet.getInt("id"));
		pais.setNombre(resultSet.getString("nombre"));
		return pais;
	}

}
