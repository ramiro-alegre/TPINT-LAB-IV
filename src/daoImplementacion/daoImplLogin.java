package daoImplementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import dao.daoPerfil;
import entidad.Pais;
import entidad.Perfil;


public class daoImplLogin {
	
	final String ConsultaPerfil = "select * from perfiles where email = ? and contrasenia = ? and estado = true " ;

	public Perfil getValidPerfil(Perfil Perfil) throws ClassNotFoundException {
		boolean status = false;
		
		
		Class.forName("com.mysql.jdbc.Driver");

		java.sql.PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();

			try {	
				statement =  conexion.prepareStatement(ConsultaPerfil);
						
			statement.setString(1, Perfil.getEmail());
			statement.setString(2, Perfil.getContrasenia());

			System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				return getPerfil(rs) ;
			}

		} catch (SQLException e) {
			
			printSQLException(e);
		}
		return Perfil;
	}
	
	public Perfil getValidPerfil(String email,String contrasenia) throws ClassNotFoundException {
		
		Perfil perfil = new Perfil();
		
		Class.forName("com.mysql.jdbc.Driver");

		java.sql.PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();

			try {	
				statement =  conexion.prepareStatement(ConsultaPerfil);
						
			statement.setString(1, email);
			statement.setString(2, contrasenia);

			System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				return getPerfil(rs) ;
			}

		} catch (SQLException e) {
			
			printSQLException(e);
		}
			perfil.setEstado(false);
		return perfil;
	}

	 private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				
				}
			}
		}
	 
	 private Perfil getPerfil(ResultSet resultSet) throws SQLException {

			Perfil Perfil = new Perfil ();
			Perfil.setDni(resultSet.getInt("dni"));
			Perfil.setEmail(resultSet.getString("email"));
			Perfil.setContrasenia(resultSet.getString("contrasenia"));
			Perfil.setAdministrador(resultSet.getBoolean("esAdministrador"));
			Perfil.setEstado(resultSet.getBoolean("estado"));
			
			return Perfil;
		}
	 
	}
	

