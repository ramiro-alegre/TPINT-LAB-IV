package daoImplementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.daoCursos;
import entidad.Curso;

public class daoImplCursos implements daoCursos {

	
	private static final String readallFromProf = "SELECT * FROM cursos WHERE estado = true AND dniDocente = ?";
	private static final String cursofromID = "SELECT * FROM cursos WHERE id = ?";
	
	
	@Override
	public ArrayList<Curso> readAllFromProf(int dniProfesor) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readallFromProf);
			statement.setInt(1,dniProfesor);
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				cursos.add(getCurso(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return cursos;
	}

	private Curso getCurso(ResultSet resultSet) throws SQLException {
		Curso curso = new Curso();
		
		curso.setId(resultSet.getInt("id"));
		curso.setIdMateria(resultSet.getInt("idMateria"));
		curso.setSemestre(resultSet.getInt("semestre"));
		curso.setAnio(resultSet.getInt("anio"));
		curso.setDniDocente(resultSet.getInt("dniDocente"));
		curso.setEstado(resultSet.getBoolean("estado"));
		return curso;
	}

	@Override
	public Curso cursoFromID(int idCurso) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		ResultSet resultSet; 
		Curso curso = new Curso();
		
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(cursofromID);
			statement.setInt(1,idCurso);
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				return curso;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return curso;
	}

}
