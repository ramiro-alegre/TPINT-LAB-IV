package daoImplementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoPerfil;
import entidad.Alumno;
import entidad.Perfil;

public class daoImplPerfil implements daoPerfil{

	private static final String insert = "INSERT INTO perfiles (Dni,email,contrasenia) VALUES(?,?,?)";
	private static final String update = "UPDATE perfiles SET dni = ? ,email = ?,contrasenia = ? WHERE dni = ?";
	private static final String delete = "UPDATE perfiles SET Estado = false WHERE Dni = ?";
	//private static final String delete = "UPDATE perfiles SET Estado = false WHERE Dni = ?";
	//Se comento el delete porque por el momento no hay un estado para la baja logica en perfiles.
	private static final String readall = "SELECT * FROM perfiles";
	
	public daoImplPerfil() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insert(Perfil perfil) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			
			statement.setInt(1, perfil.getDni());
			statement.setString(2, perfil.getEmail());
			statement.setString(3, perfil.getContrasenia());
			
			
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
	
	public boolean delete(Perfil Perfil) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			
			statement.setInt(1, Perfil.getDni());
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
	public ArrayList<Perfil> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Perfil perfil) {
		// TODO Auto-generated method stub
		return false;
	}

}
