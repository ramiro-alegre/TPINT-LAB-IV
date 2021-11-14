package daoImplementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import entidad.Localidad;
import entidad.Pais;
import entidad.Persona;
import entidad.Provincia;

public class daoImplLocalidades {

	private static final String namesfromID ="SELECT Paises.nombre,Paises.id,Provincias.nombre,Provincias.id,Localidades.nombre, Localidades.id FROM Localidades INNER JOIN Provincias "
			          + "ON Localidades.idProvincia= Provincias.id INNER JOIN Paises ON Provincias.idPais = Paises.id WHERE Localidades.id = ? ";
	
 public Persona getPersonaLocalizada(int idLocalidad) {
	 
	 
	 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		PreparedStatement statement;
		ResultSet resultSet;
		
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(namesfromID);
			statement.setInt(1,idLocalidad);
			
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				return localizarPersona(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	 return new Persona();
 }
	
	private Persona localizarPersona(ResultSet resultSet) throws SQLException {
		
	    Persona pers = new Persona (); 
	    
	    Pais nac = new Pais ();
	    Provincia pro = new Provincia ();
		Localidad loc = new Localidad ();
	    nac.setNombre(resultSet.getString("Paises.nombre"));
		pro.setNombre(resultSet.getString("Provincias.nombre"));
		loc.setNombre(resultSet.getString("Localidades.nombre"));
		
		nac.setId(resultSet.getInt("Paises.id"));
		pro.setId(resultSet.getInt("Provincias.id"));
		loc.setId(resultSet.getInt("Localidades.id"));
		
		pers.setNacionalidad(nac);
		pers.setProvincia(pro);
		pers.setLocalidad(loc);
		return pers;
	}
}
