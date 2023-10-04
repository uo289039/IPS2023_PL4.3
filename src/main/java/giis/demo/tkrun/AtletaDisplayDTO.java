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
	private Date fechaI;
	private double distancia;
	public AtletaDisplayDTO() {}
	public AtletaDisplayDTO(String rowId, String rowDescripcion, String rowEstado, Date rowFecha) {
		this.dni=rowId;
		this.nombre=rowDescripcion;
		this.categoria=rowEstado;
		this.fechaI=rowFecha;
	}
	public String getDni() { return this.dni; }
	public String getNombre() { return this.nombre; }
	public String getCategoria() {return this.categoria; }
	public Date getFechaI() {return this.fechaI;}
	public double getDistancia() {return this.distancia;}
	public void setDni(String value) { this.dni=value; }
	public void setNombre(String value) { this.nombre=value; }
	public void setCategoria(String value) { this.categoria=value; }
	public void setFechaI(Date date) {this.fechaI=date;}
	public void setDistancia(double d) {this.distancia=d;}
	//NOTA: se pueden generar getters y setters de forma automatica usando lombok:  
	//https://www.sitepoint.com/declutter-pojos-with-lombok-tutorial/
	//http://www.baeldung.com/intro-to-project-lombok
}
