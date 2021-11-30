package daoImplementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoAlumno;
import entidad.Alumno;


public class daoImplAlumno implements daoAlumno{
	
	private static final String insert = "INSERT INTO alumnos (Dni,Legajo,NombreApellido,FechaNacimiento,direccion,idprovincia,idnacionalidad,email,telefono) VALUES(?,?,?,?,?,?,?,?,?)";
	private static final String update = "UPDATE alumnos SET Legajo = ? ,NombreApellido = ?,FechaNacimiento = ?,direccion = ?,idprovincia = ?,idnacionalidad = ?,email = ?,telefono = ?, estado = ? WHERE Dni = ?";
	private static final String delete = "UPDATE alumnos SET Estado = false WHERE Dni = ?";
	private static final String readall = "SELECT * FROM alumnos WHERE estado = true";
	private static final String readFromDni = "SELECT * FROM alumnos WHERE dni = ?";
	private static final String verificarLegajo = "SELECT * FROM alumnos WHERE legajo = ?";
	private static final String verificarEmail = "SELECT * FROM alumnos WHERE email = ?";
	
	@Override
	public boolean insert(Alumno alumno) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			
			statement.setInt(1, alumno.getDni());
			statement.setInt(2, alumno.getLegajo());
			statement.setString(3, alumno.getNombreApellido());
			statement.setString(4, alumno.getFechaNacimiento());
			statement.setString(5, alumno.getDireccion());
			statement.setInt(6, alumno.getProvincia().getId());
			statement.setInt(7, alumno.getNacionalidad().getId());
			statement.setString(8, alumno.getEmail());
			statement.setInt(9, alumno.getTelefono());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return isInsertExitoso;
	}
	
	@Override
	public boolean update(Alumno alumno) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(update);
			
			statement.setInt(1, alumno.getLegajo());
			statement.setString(2, alumno.getNombreApellido());
			statement.setString(3, alumno.getFechaNacimiento());
			statement.setString(4, alumno.getDireccion());
			statement.setInt(5, alumno.getProvincia().getId());
			statement.setInt(6, alumno.getNacionalidad().getId());
			statement.setString(7, alumno.getEmail());
			statement.setInt(8, alumno.getTelefono());
			statement.setBoolean(9 , alumno.getEstado());
			statement.setInt(10, alumno.getDni());
			
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
	public boolean delete(Alumno alumno) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			
			statement.setInt(1, alumno.getDni());
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
	
	public boolean delete(int dni) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			
			statement.setInt(1, dni);
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
	public ArrayList<Alumno> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				alumnos.add(getAlumno(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return alumnos;
	}

	private Alumno getAlumno(ResultSet resultSet) throws SQLException
	{
		Alumno alumno = new Alumno();
		daoImplProvincia provincia = new daoImplProvincia ();
		daoImplPais nacionalidad = new daoImplPais ();
		
		alumno.setDni(resultSet.getInt("dni")); 
		alumno.setLegajo(resultSet.getInt("legajo")); 
		alumno.setNombreApellido(resultSet.getString("nombreApellido")); 
		alumno.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
		alumno.setDireccion(resultSet.getString("direccion"));
		alumno.setProvincia(provincia.provinciaFromID(resultSet.getInt("idProvincia")));
		alumno.setNacionalidad(nacionalidad.paisFromID(resultSet.getInt("idNacionalidad")));
		alumno.setEmail(resultSet.getString("email"));
		alumno.setTelefono(resultSet.getInt("telefono"));
		alumno.setEstado(resultSet.getBoolean("estado"));
		
		return alumno;
	}

	@Override
	public Alumno readFromDni(int dniAlumno) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet; 
		Alumno alumno = new Alumno();
		
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readFromDni);
			statement.setInt(1,dniAlumno);
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				return getAlumno(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return alumno;
	}

	@Override
	public boolean verificarDni(int dni) {
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
			statement = conexion.getSQLConexion().prepareStatement(readFromDni);
			statement.setInt(1,dni);
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				return false;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean verificarLegajo(int legajo) {
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
			statement = conexion.getSQLConexion().prepareStatement(verificarLegajo);
			statement.setInt(1,legajo);
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				return false;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean verificarEmail(String email) {
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
			statement = conexion.getSQLConexion().prepareStatement(verificarEmail);
			statement.setString(1,email);
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				return false;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return true;
	}

}
