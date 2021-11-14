package entidad;

public class Provincia {
	
	private int id;
	private int idPais;
	private String nombre;
	
public Provincia() {
		
	}
	
	public Provincia(int id, int idPais, String nombre) {
		super();
		this.id = id;
		this.idPais = idPais;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", idPais=" + idPais + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
