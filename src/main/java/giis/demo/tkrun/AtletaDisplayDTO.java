package giis.demo.tkrun;



/**
 * Cada una de las filas que muestran al usuario las carreras y su estado
 * IMPORTANTE: Cuando se usan los componentes de Apache Commons DbUtils debe
 * mantenerse de forma estricta el convenio de capitalización de Java:
 *  - Capitalizar todas las palabras que forman un identificador 
 *    excepto la primera letra de nombres de métodos y variables.
 *  - No utilizar subrayados
 * Seguir tambien estos mismos criterios en los nombres de tablas y campos de la BD
 */
public class AtletaDisplayDTO {
	private String dni;
	private String nombre;
	private String categoria;
	private String inscripcion;
	private String estadoI;
	private String correoE;
	private int dorsal;
	private String f_nacimiento;
	private String sexo;
	private String telefono;
	private String pais;
	private String poblacion;
	public AtletaDisplayDTO() {}
	public AtletaDisplayDTO(String rowId, String rowDescripcion, String rowCategoria,
			String rowFecha, String rowEstado, String rowCorreo, int rowDorsal, 
			String rowFechaN,String rowSexo,String rowTelefono,String rowPob,String rowPais) {
		this.dni=rowId;
		this.nombre=rowDescripcion;
		this.categoria=rowCategoria;
		this.inscripcion=rowFecha;
		this.estadoI=rowEstado;
		this.dorsal=rowDorsal;
		this.correoE=rowCorreo;
		this.f_nacimiento=rowFechaN;
		this.sexo=rowSexo;
		this.telefono=rowTelefono;
		this.pais=rowPais;
		this.poblacion=rowPob;
		}
	public String getDni() { return this.dni; }
	public String getNombre() { return this.nombre; }
	public String getCategoria() {return this.categoria; }
	public String getFechaInscripcionCambioEstado() {return this.inscripcion;}
	public String getEstadoInscripcion() {return this.estadoI;}
	public void setDni(String value) { this.dni=value; }
	public void setNombre(String value) { this.nombre=value; }
	public void setCategoria(String value) { this.categoria=value; }
	public void setFechaInscripcionCambioEstado(String date) {this.inscripcion=date;}
	public void setEstadoInscripcion(String d) {this.estadoI=d;}
	public String getInscripcion() {
		return inscripcion;
	}
	public void setInscripcion(String inscripcion) {
		this.inscripcion = inscripcion;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	
	
	public String getCorreoE() {
		return correoE;
	}
	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}
	public String getF_nacimiento() {
		return f_nacimiento;
	}
	public void setF_nacimiento(String f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	
	
//	
	//NOTA: se pueden generar getters y setters de forma automatica usando lombok:  
	//https://www.sitepoint.com/declutter-pojos-with-lombok-tutorial/
	//http://www.baeldung.com/intro-to-project-lombok
}
