package giis.demo.tkrun;

public class ParticipaDisplayDTO {

	
	private String dni_at;
	private String id_c;
	private String estadoI;
	
	
	
	public ParticipaDisplayDTO(String rowId, String rowId_c, String rowEstado) {
		this.dni_at=rowId;
		this.id_c=rowId_c;
		this.estadoI=rowEstado;
	}
	public String getDni() { return this.dni_at; }
	public String getNombre() { return this.id_c; }
	public String getEstadoI() {return this.estadoI;}
	public void setDni(String value) { this.dni_at=value; }
	public void setNombre(String value) { this.id_c=value; }
	public void setEstadoI(String d) {this.estadoI=d;}
	
}
