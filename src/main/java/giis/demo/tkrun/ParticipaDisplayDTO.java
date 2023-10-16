package giis.demo.tkrun;

public class ParticipaDisplayDTO {

	
	private String correoElec;
	private String id_c;
	private String estadoI;
	
	
	
	public ParticipaDisplayDTO(String rowId, String rowId_c, String rowEstado) {
		this.correoElec=rowId;
		this.id_c=rowId_c;
		this.estadoI=rowEstado;
	}
	
	public ParticipaDisplayDTO() {
		this.correoElec=null;
		this.id_c=null;
		this.estadoI=null;
		
	}
	public String getDni() { return this.correoElec; }
	public String getNombre() { return this.id_c; }
	public String getEstadoI() {return this.estadoI;}
	public void setDni(String value) { this.correoElec=value; }
	public void setNombre(String value) { this.id_c=value; }
	public void setEstadoI(String d) {this.estadoI=d;}
	
	
}
