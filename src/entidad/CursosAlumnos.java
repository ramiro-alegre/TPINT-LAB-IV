package entidad;

public class CursosAlumnos {
  
  private int idCurso;
  private int dniAlumno;
  private float parcialUno;
  private float parcialDos;
  private float recuperatorioUno;
  private float recuperatorioDos;
  private boolean estado;
  
  public CursosAlumnos () {}
  
public CursosAlumnos(int idCurso, int dniAlumno, float parcialUno, float parcialDos, float recuperatorioUno,
		float recuperatorioDos, boolean estado) {
	super();
	this.idCurso = idCurso;
	this.dniAlumno = dniAlumno;
	this.parcialUno = parcialUno;
	this.parcialDos = parcialDos;
	this.recuperatorioUno = recuperatorioUno;
	this.recuperatorioDos = recuperatorioDos;
	this.estado = estado;
}


public int getIdCurso() {
	return idCurso;
}


public void setIdCurso(int idCurso) {
	this.idCurso = idCurso;
}


public int getDniAlumno() {
	return dniAlumno;
}


public void setDniAlumno(int dniAlumno) {
	this.dniAlumno = dniAlumno;
}


public float getParcialUno() {
	return parcialUno;
}


public void setParcialUno(float parcialUno) {
	this.parcialUno = parcialUno;
}


public float getParcialDos() {
	return parcialDos;
}


public void setParcialDos(float parcialDos) {
	this.parcialDos = parcialDos;
}


public float getRecuperatorioUno() {
	return recuperatorioUno;
}


public void setRecuperatorioUno(float recuperatorioUno) {
	this.recuperatorioUno = recuperatorioUno;
}


public float getRecuperatorioDos() {
	return recuperatorioDos;
}


public void setRecuperatorioDos(float recuperatorioDos) {
	this.recuperatorioDos = recuperatorioDos;
}


public boolean getEstado() {
	return estado;
}


public void setEstado(boolean estado) {
	this.estado = estado;
}


}
