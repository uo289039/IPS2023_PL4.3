package giis.demo.tkrun;

import java.sql.Date;

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
	//private String correoE;
	private int dorsal;
	public AtletaDisplayDTO() {}
	public AtletaDisplayDTO(String rowId, String rowDescripcion, String rowCategoria, String rowFecha, String rowEstado, String rowCorreo, int rowDorsal) {
		this.dni=rowId;
		this.nombre=rowDescripcion;
		this.categoria=rowCategoria;
		this.inscripcion=rowFecha;
		this.estadoI=rowEstado;
		this.dorsal=rowDorsal;
		//this.correoE=rowCorreo;
		}
	public String getDni() { return this.dni; }
	public String getNombre() { return this.nombre; }
	public String getCategoria() {return this.categoria; }
	public String getFechaI() {return this.inscripcion;}
	public String getEstadoI() {return this.estadoI;}
	public void setDni(String value) { this.dni=value; }
	public void setNombre(String value) { this.nombre=value; }
	public void setCategoria(String value) { this.categoria=value; }
	public void setFechaI(String date) {this.inscripcion=date;}
	public void setEstadoI(String d) {this.estadoI=d;}
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
	
	
	
//	public String getCorreoE() {
//		return correoE;
//	}
//	public void setCorreoE(String correoE) {
//		this.correoE = correoE;
//	}
//	
	//NOTA: se pueden generar getters y setters de forma automatica usando lombok:  
	//https://www.sitepoint.com/declutter-pojos-with-lombok-tutorial/
	//http://www.baeldung.com/intro-to-project-lombok
}
