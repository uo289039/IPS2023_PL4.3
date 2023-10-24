package giis.demo.tkrun;

public class DatosAtleta {

	
	private String nombre;
	private String nombre_c;
	private String tipo;
	private String inscripcion;
	private String cuota;
	
	
	public DatosAtleta(String nombre, String nombre_c, String tipo, String inscripcion, String cuota) {
		super();
		this.nombre = nombre;
		this.nombre_c = nombre_c;
		this.tipo = tipo;
		this.inscripcion = inscripcion;
		this.cuota = cuota;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNombre_c() {
		return nombre_c;
	}


	public void setNombre_c(String nombre_c) {
		this.nombre_c = nombre_c;
	}


	public String getCategoria() {
		return tipo;
	}


	public void setCategoria(String tipo) {
		this.tipo = tipo;
	}


	public String getInscripcion() {
		return inscripcion;
	}


	public void setInscripcion(String inscripcion) {
		this.inscripcion = inscripcion;
	}


	public String getCuota() {
		return cuota;
	}


	public void setCuota(String cuota) {
		this.cuota = cuota;
	}
	
	
	
}
