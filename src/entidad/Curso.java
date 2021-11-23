package entidad;

public class Curso {
 private int id;
 private int idMateria;
 private int semestre;
 private int anio;
 private int dniDocente;
 private boolean estado;
 
 
public Curso () {}
 
public Curso(int id, int idMateria, int semestre, int anio, int dniDocente, boolean estado) {
	super();
	this.id = id;
	this.idMateria = idMateria;
	this.semestre = semestre;
	this.anio = anio;
	this.dniDocente = dniDocente;
	this.estado = estado;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public int getIdMateria() {
	return idMateria;
}


public void setIdMateria(int idMateria) {
	this.idMateria = idMateria;
}


public int getSemestre() {
	return semestre;
}


public void setSemestre(int semestre) {
	this.semestre = semestre;
}


public int getAnio() {
	return anio;
}


public void setAnio(int anio) {
	this.anio = anio;
}


public int getDniDocente() {
	return dniDocente;
}


public void setDniDocente(int dniDocente) {
	this.dniDocente = dniDocente;
}


public boolean isEstado() {
	return estado;
}


public void setEstado(boolean estado) {
	this.estado = estado;
}
 

 
}
