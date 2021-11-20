package daoImplementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoPais;
import entidad.Pais;

public class daoImplPais implements daoPais {

	private static final String readall = "SELECT * FROM paises";
	private static final String NacionalidadfromID = "SELECT Paises.nombre, Paises.id FROM Paises WHERE Paises.id = ? ";
	
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

	public Pais paisFromID(int id) {
		
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 Pais pais = new Pais();
		 
		    PreparedStatement statement;
			ResultSet resultSet;
			
			
			Conexion conexion = Conexion.getConexion();
			try 
			{
				
				statement = conexion.getSQLConexion().prepareStatement(NacionalidadfromID);
				statement.setInt(1,id);
				
				resultSet = statement.executeQuery();
				
				while(resultSet.next())
				{
					pais.setId(resultSet.getInt("Paises.id"));
					pais.setNombre(resultSet.getString("Paises.nombre"));
					return pais;
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return pais;
			
	}
}
