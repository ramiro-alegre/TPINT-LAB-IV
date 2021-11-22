package entidad;

public class Perfil {

	int dni;
	String email;
	String contrasenia;
	boolean isAdministrador;
	boolean estado;
	
	

	public Perfil() {
		// TODO Auto-generated constructor stub
	}



	public int getDni() {
		return dni;
	}



	public void setDni(int dni) {
		this.dni = dni;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getContrasenia() {
		return contrasenia;
	}



	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}



	public boolean isAdministrador() {
		return isAdministrador;
	}



	public void setAdministrador(boolean isAdministrador) {
		this.isAdministrador = isAdministrador;
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
