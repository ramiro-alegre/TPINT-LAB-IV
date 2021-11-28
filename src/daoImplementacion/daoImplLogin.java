package daoImplementacion;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import entidad.Perfil;


public class daoImplLogin {
	
	final String ConsultaPerfil = "select * from perfiles where email = ? and contrasenia = ? and estado = true " ;

	public Perfil getValidPerfil(Perfil Perfil) throws ClassNotFoundException {
		
		
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		PreparedStatement statement;
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
		
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		PreparedStatement statement;
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
	

