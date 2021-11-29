package daoImplementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoCursosAlumnos;

import entidad.CursosAlumnos;


public class daoImplCursAlumn implements daoCursosAlumnos {

	private static final String readAllFromID = "SELECT * FROM cursosxalumnos WHERE idCurso = ?";
    private static final String update = "UPDATE cursosxalumnos SET parcialUno = ?, parcialDos = ?, recuperatorioUno = ?, recuperatorioDos = ?,  estado = ? WHERE idCurso = ? AND dniAlumno = ? ";

	@Override
	public ArrayList<CursosAlumnos> readAllFromID(int idCurso) {
		 
		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		    ArrayList<CursosAlumnos> cxa = new ArrayList<CursosAlumnos>();
		 
		    PreparedStatement statement;
			ResultSet resultSet;
			
			
			Conexion conexion = Conexion.getConexion();
			try 
			{
				
				statement = conexion.getSQLConexion().prepareStatement(readAllFromID);
				statement.setInt(1,idCurso);
				
				resultSet = statement.executeQuery();
				
				while(resultSet.next())
				{
					cxa.add(getCursoAlumno(resultSet));
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return cxa;
	}

	private CursosAlumnos getCursoAlumno(ResultSet resultSet) throws SQLException {

        CursosAlumnos cxa = new CursosAlumnos();
        
        cxa.setIdCurso(resultSet.getInt("idCurso"));
        cxa.setDniAlumno(resultSet.getInt("dniAlumno"));
        cxa.setParcialUno(resultSet.getFloat("parcialUno"));
        cxa.setParcialDos(resultSet.getFloat("parcialDos"));
        cxa.setRecuperatorioUno(resultSet.getFloat("recuperatorioUno"));
        cxa.setRecuperatorioDos(resultSet.getFloat("recuperatorioDos"));
        cxa.setEstado(resultSet.getBoolean("estado"));
		return cxa;
	}


	@Override
	public boolean insert(CursosAlumnos notas) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CursosAlumnos notas) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isupdateExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(update);
			
			statement.setFloat(1, notas.getParcialUno());
			statement.setFloat(2, notas.getParcialDos());
			statement.setFloat(3, notas.getRecuperatorioUno());
			statement.setFloat(4, notas.getRecuperatorioDos());
			statement.setBoolean(5 , notas.getEstado());
			
			statement.setInt(6, notas.getIdCurso());
			statement.setInt(7, notas.getDniAlumno());
			
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
