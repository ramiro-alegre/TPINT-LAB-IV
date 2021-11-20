package daoImplementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoLocalidad;
import entidad.Localidad;

public class daoImplLocalidad implements daoLocalidad {

	private static final String LocalidadfromID ="SELECT Localidades.nombre, Localidades.id FROM Localidades WHERE Localidades.id = ? ";
	
	
	private static final String readall = "SELECT * FROM localidades";
	
 
	@Override
	public ArrayList<Localidad> readAll() {
		
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				localidades.add(getLocalidad(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return localidades;
	}

	private Localidad getLocalidad(ResultSet resultSet) throws SQLException {
		
		Localidad localidad = new Localidad ();
		localidad.setId(resultSet.getInt("id"));
		localidad.setNombre(resultSet.getString("nombre"));
		return localidad;
	}
	
	public Localidad localidadFromID(int id) {
		
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 Localidad localidad = new Localidad();
		 
		    PreparedStatement statement;
			ResultSet resultSet;
			
			
			Conexion conexion = Conexion.getConexion();
			try 
			{
				
				statement = conexion.getSQLConexion().prepareStatement(LocalidadfromID);
				statement.setInt(1,id);
				
				resultSet = statement.executeQuery();
				
				while(resultSet.next())
				{
					localidad.setId(resultSet.getInt("Localidades.id"));
					localidad.setNombre(resultSet.getString("Localidades.nombre"));
					return localidad;
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return localidad;
	}
}
