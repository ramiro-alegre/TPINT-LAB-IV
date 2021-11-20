package daoImplementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoProvincia;
import entidad.Localidad;
import entidad.Provincia;

public class daoImplProvincia implements daoProvincia {

	private static final String readall = "SELECT * FROM provincias";
	
	@Override
	public ArrayList<Provincia> readAll() {
		
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Provincia> provincias = new ArrayList<Provincia>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				provincias.add(getProvincia(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return provincias;
	}

	private Provincia getProvincia(ResultSet resultSet) throws SQLException {
		
		Provincia provincia = new Provincia ();
		provincia.setId(resultSet.getInt("id"));
		provincia.setNombre(resultSet.getString("nombre"));
		return provincia;
	}

}
