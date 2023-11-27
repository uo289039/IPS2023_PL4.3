package giis.demo.tkrun;

/**
 * Datos del modelo de dominio de cada una de las carreras
 * IMPORTANTE: Cuando se usan los componentes de Apache Commons DbUtils debe
 * mantenerse de forma estricta el convenio de capitalización de Java:
 *  - Capitalizar todas las palabras que forman un identificador 
 *    excepto la primera letra de nombres de métodos y variables.
 *  - No utilizar subrayados
 * Seguir tambien estos mismos criterios en los nombres de tablas y campos de la BD
 */
public class PlazoEntity {
	private String id_comp;
	private String descr;
	private String fechaMin;
	private String fechaMax;
	private int cuota;
	
	public String getId() { return this.id_comp; }
	public String getDescr() { return this.descr; }
	public String getFechaMin() { return this.fechaMin; }
	public String getfechaMax() { return this.fechaMax; }
	public int getCuota() { return this.cuota; }
	public void setId(String value) { this.id_comp=value; }
	public void setNombre(String value) { this.descr=value; }
	public void setFechaMin(String value) { this.fechaMin=value; }
	public void setFechaMax(String value) { this.fechaMax=value; }
	public void setCuota(int value) { this.cuota=value; }
}
