package daoImplementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import dao.daoDocente;
import entidad.Docente;



public class daoImplDocente implements daoDocente {
	
	private static final String insert = "INSERT INTO docentes (Dni,Legajo,NombreApellido,FechaNacimiento,direccion,idlocalidad,idnacionalidad,email,telefono) VALUES(?,?,?,?,?,?,?,?,?)";
	private static final String update = "UPDATE docentes SET Legajo = ? ,NombreApellido = ?,FechaNacimiento = ?,direccion = ?,idlocalidad = ?,idnacionalidad = ?,email = ?,telefono = ?, estado = ? WHERE Dni = ?";
	private static final String delete = "UPDATE docentes SET Estado = false WHERE Dni = ?";
	private static final String readall = "SELECT * FROM docentes WHERE estado = true";
	private static final String verifyAccount = "SELECT dni, estado FROM docentes WHERE dni == ? and estado == true";

	@Override
	public boolean insert(Docente docente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			
			statement.setInt(1, docente.getDni());
			statement.setInt(2, docente.getLegajo());
			statement.setString(3, docente.getNombreApellido());
			statement.setString(4, docente.getFechaNacimiento());
			statement.setString(5, docente.getDireccion());
			statement.setInt(6, docente.getLocalidad().getId());
			statement.setInt(7, docente.getNacionalidad().getId());
			statement.setString(8, docente.getEmail());
			statement.setInt(9, docente.getTelefono());
			
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
	public boolean update(Docente docente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(update);
			
			statement.setInt(1, docente.getLegajo());
			statement.setString(2, docente.getNombreApellido());
			statement.setString(3, docente.getFechaNacimiento());
			statement.setString(4, docente.getDireccion());
			statement.setInt(5, docente.getLocalidad().getId());
			statement.setInt(6, docente.getNacionalidad().getId());
			statement.setString(7, docente.getEmail());
			statement.setInt(8, docente.getTelefono());
			statement.setBoolean(9 , docente.getEstado());
			statement.setInt(10, docente.getDni());
			
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
	
	@Override
	public boolean delete(int id) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			
			statement.setInt(1, id);
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
	public ArrayList<Docente> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Docente> docentes = new ArrayList<Docente>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				docentes.add(getDocente(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return docentes;
	}

	private Docente getDocente(ResultSet resultSet) throws SQLException {
		Docente docente = new Docente();
		daoImplLocalidad localidad = new daoImplLocalidad ();
		daoImplPais nacionalidad = new daoImplPais ();
		
		docente.setDni(resultSet.getInt("dni")); 
		docente.setLegajo(resultSet.getInt("legajo")); 
		docente.setNombreApellido(resultSet.getString("nombreApellido")); 
		docente.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
		docente.setDireccion(resultSet.getString("direccion"));
		docente.setLocalidad(localidad.localidadFromID(resultSet.getInt("idLocalidad")));
		docente.setNacionalidad(nacionalidad.paisFromID(resultSet.getInt("idNacionalidad")));
		docente.setEmail(resultSet.getString("email"));
		docente.setTelefono(resultSet.getInt("telefono"));
		docente.setEstado(resultSet.getBoolean("estado"));
		
		return docente;
	}
	
	

	

	
}
