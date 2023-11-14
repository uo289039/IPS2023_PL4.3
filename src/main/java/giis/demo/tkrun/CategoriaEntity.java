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
public class CategoriaEntity {
	private String id_comp;
	private int edadMin;
	private int edadMax;
	private String genero;

	public String getId() { return this.id_comp; }
	public int getEdadMin() { return this.edadMin; }
	public int getEdadMax() { return this.edadMax; }
	public String getGenero() { return this.genero; }
	public void setId(String value) { this.id_comp=value; }
	public void setEdadMin(int value) { this.edadMin=value; }
	public void setEdadMax(int value) { this.edadMax=value; }
	public void setGenero(String value) { this.genero=value; }
}
