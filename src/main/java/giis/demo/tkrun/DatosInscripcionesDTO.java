package giis.demo.tkrun;

public class DatosInscripcionesDTO {

	
	
	private String fecha_cambio_estado;
	private String estadoI;
	private String correoE;
	private String nombre_c;
	public DatosInscripcionesDTO() {}
	public DatosInscripcionesDTO(String rowFecha_cambio_estado, String rowNombre_c, String rowEstado, String rowCorreo) {
		this.fecha_cambio_estado=rowFecha_cambio_estado;
		this.estadoI=rowEstado;
		this.correoE=rowCorreo;
		this.nombre_c=rowNombre_c;
		}
	public String getFecha_cambio_estado() { return this.fecha_cambio_estado; }
	public String getNombre_c() { return this.nombre_c; }
	public String getEstadoI() {return this.estadoI;}
	public String getCorreo() {return this.correoE;}
	
	public void setFecha_cambio_estado(String value) { this.fecha_cambio_estado=value; }
	public void setNombre_c(String value) { this.nombre_c=value; }
	public void setCorreo(String d) {this.correoE=d;}
	public void setEstadoI(String d) {this.estadoI=d;}
	
	
	
}
