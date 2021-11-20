package daoImplementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoProvincia;
import entidad.Provincia;

public class daoImplProvincia implements daoProvincia {

	private static final String readall = "SELECT * FROM provincias";
	private static final String ProvinciafromID = "SELECT Provincias.nombre, Provincias.id FROM Provincias WHERE Provincias.id = ? ";
	
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

	public Provincia provinciaFromID(int id) {
		
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 Provincia provincia = new Provincia();
		 
		    PreparedStatement statement;
			ResultSet resultSet;
			
			
			Conexion conexion = Conexion.getConexion();
			try 
			{
				
				statement = conexion.getSQLConexion().prepareStatement(ProvinciafromID);
				statement.setInt(1,id);
				
				resultSet = statement.executeQuery();
				
				while(resultSet.next())
				{
					provincia.setId(resultSet.getInt("Provincias.id"));
					provincia.setNombre(resultSet.getString("Provincias.nombre"));
					return provincia;
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return provincia;
	}
}
