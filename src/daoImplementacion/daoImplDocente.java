package daoImplementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.daoPersona;
import entidad.Persona;


public class daoImplDocente implements daoPersona {
	
	private static final String insert = "INSERT INTO docentes (Dni,Legajo,NombreApellido,FechaNacimiento,direccion,idlocalidad,idprovincia,idnacionalidad,email,telefono) VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String delete = "UPDATE docentes SET Estado = false WHERE Dni = ?";
	private static final String readall = "SELECT Dni,Legajo,NombreApellido AS [Nombre y Apellido],FechaNacimiento AS [Fecha de Nacimiento],direccion AS Dirección,idlocalidad AS Localidad,idprovincia AS Provincia,idnacionalidad AS Nacionalidad,Email,Telefono AS Teléfono, Estado FROM docentes";
	private static final String update = "UPDATE docentes SET NombreApellido = ?,FechaNacimiento = ?,direccion = ?,idlocalidad = ?,idprovincia = ?,idnacionalidad = ?,email = ?,telefono = ? WHERE Dni = ?";

	@Override
	public boolean insert(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getDni());
			statement.setInt(2, persona.getLegajo());
			statement.setString(3, persona.getNombreApellido());
			statement.setString(4, persona.getFechaNacimiento());
			statement.setString(5, persona.getDireccion());
			statement.setInt(6, persona.getLocalidad().getId());
			statement.setInt(7, persona.getProvincia().getId());
			statement.setInt(8, persona.getNacionalidad().getId());
			statement.setString(9, persona.getEmail());
			statement.setInt(10, persona.getTelefono());
			
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			
			statement.setInt(1, persona_a_eliminar.getDni());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	

	@Override
	public List<Persona> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return personas;
	}

	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		
		daoImplLocalidades localizador = new daoImplLocalidades();
		
		Persona person = localizador.getPersonaLocalizada(resultSet.getInt("Localidad"));
		
		person.setDni(resultSet.getInt("Dni")); 
		person.setLegajo(resultSet.getInt("Legajo")); 
		person.setNombreApellido(resultSet.getString("Nombre y Apellido")); 
		person.setFechaNacimiento(resultSet.getString("Fecha de nacimiento"));
		person.setDireccion(resultSet.getString("Dirección")); 
		person.setEmail(resultSet.getString("Email"));
		person.setTelefono(resultSet.getInt("Teléfono"));
		person.setEstado(resultSet.getBoolean("Estado"));
		
		return person;
	}

	@Override
	public boolean update(Persona persona) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(update);
			
			statement.setString(1, persona.getNombreApellido());
			statement.setString(2, persona.getFechaNacimiento());
			statement.setString(3, persona.getDireccion());
			statement.setInt(4, persona.getLocalidad().getId());
			statement.setInt(5, persona.getProvincia().getId());
			statement.setInt(6, persona.getNacionalidad().getId());
			statement.setString(7, persona.getEmail());
			statement.setInt(8, persona.getTelefono());
			
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isupdateExitoso = true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return isupdateExitoso;
	}

}
