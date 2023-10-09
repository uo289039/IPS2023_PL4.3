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
	public AtletaDisplayDTO() {}
	public AtletaDisplayDTO(String rowId, String rowDescripcion, String rowCategoria, String rowFecha, String rowEstado) {
		this.dni=rowId;
		this.nombre=rowDescripcion;
		this.categoria=rowCategoria;
		this.inscripcion=rowFecha;
		this.estadoI=rowEstado;
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
	//NOTA: se pueden generar getters y setters de forma automatica usando lombok:  
	//https://www.sitepoint.com/declutter-pojos-with-lombok-tutorial/
	//http://www.baeldung.com/intro-to-project-lombok
}
