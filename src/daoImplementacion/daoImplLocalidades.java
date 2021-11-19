package daoImplementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import entidad.Localidad;
import entidad.Pais;
import entidad.Persona;
import entidad.Provincia;

public class daoImplLocalidades {

	private static final String LocalidadfromID ="SELECT Provincias.nombre,Provincias.id,Localidades.nombre, Localidades.id FROM Localidades INNER JOIN Provincias "
			                                   + "ON Localidades.idProvincia= Provincias.id WHERE Localidades.id = ? ";
	private static final String NacionalidadfromID = "SELECT Paises.nombre, Paises.id FROM Paises WHERE Paises.id = ? "; 
 public Persona getPersonaLocalizada(int idLocalidad, int idPais) {
	 
	 
	 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		PreparedStatement statement1;
		ResultSet resultSet1;
		PreparedStatement statement2;
		ResultSet resultSet2;
		
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement1 = conexion.getSQLConexion().prepareStatement(LocalidadfromID);
			statement1.setInt(1,idLocalidad);
			
			statement2 = conexion.getSQLConexion().prepareStatement(NacionalidadfromID);
			statement2.setInt(1,idPais);
			
			resultSet1 = statement1.executeQuery();
			resultSet2 = statement2.executeQuery();
			
			while(resultSet1.next() && resultSet2.next())
			{
				return localizarPersona(resultSet1,resultSet2);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	 return new Persona();
 }
	
	private Persona localizarPersona(ResultSet resultSet1, ResultSet resultSet2) throws SQLException {
		
	    Persona pers = new Persona (); 
	    
	    Pais nac = new Pais ();
	    Provincia pro = new Provincia ();
		Localidad loc = new Localidad ();
	    nac.setNombre(resultSet2.getString("Paises.nombre"));
		pro.setNombre(resultSet1.getString("Provincias.nombre"));
		loc.setNombre(resultSet1.getString("Localidades.nombre"));
		
		nac.setId(resultSet2.getInt("Paises.id"));
		pro.setId(resultSet1.getInt("Provincias.id"));
		loc.setId(resultSet1.getInt("Localidades.id"));
		
		pers.setNacionalidad(nac);
		pers.setProvincia(pro);
		pers.setLocalidad(loc);
		return pers;
	}
}
