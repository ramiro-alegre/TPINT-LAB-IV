package entidad;

public class Alumno {
	private int dni;
	private int legajo;
	private String nombreApellido;
	private String fechaNacimiento;
	private String direccion;
	private Provincia provincia;
	private Pais nacionalidad;
	private String email;
	private int telefono;
	private Boolean estado;
	
	public Alumno() {
		
	}
	
	public Alumno(int dni, int legajo, String nombreApellido, String fechaNacimiento, String direccion,
		Provincia provincia, Pais nacionalidad, String email, int telefono, Boolean estado) {
		super();
		this.dni = dni;
		this.legajo = legajo;
		this.nombreApellido = nombreApellido;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.provincia = provincia;
		this.nacionalidad = nacionalidad;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Pais getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Pais nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
