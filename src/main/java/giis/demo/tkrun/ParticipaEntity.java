package giis.demo.tkrun;

public class ParticipaEntity {

	
	private String dni_at;
	private String id_c;
	private String estadoI;
	private String correo;
	private String cat;
	
	
	
	public ParticipaEntity(String correo, String idC, String string, String cat) {
		this.setCorreo(correo);
		this.id_c = idC;
		this.estadoI = string;
		this.setCat(cat);
	}
	public String getDni() { return this.dni_at; }
	public String getIdComp() { return this.id_c; }
	public String getEstadoI() {return this.estadoI;}
	public void setDni(String value) { this.dni_at=value; }
	public void setIdComp(String value) { this.id_c=value; }
	public void setEstadoI(String d) {this.estadoI=d;}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	
}
