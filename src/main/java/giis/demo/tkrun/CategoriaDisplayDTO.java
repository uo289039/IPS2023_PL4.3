package giis.demo.tkrun;

public class CategoriaDisplayDTO {
	private String id_c;
	private String nombre_cat;
	private int edadMin;
	private int edadMax;
	private String genero;
	public CategoriaDisplayDTO() {}
	public CategoriaDisplayDTO(String rownombre, int rowMin, int rowMax, String rowGenero) {
		this.nombre_cat=rownombre;
		this.edadMin=rowMin;
		this.edadMax=rowMax;
		this.genero = rowGenero;
	}
	public String getId() { return this.id_c; }
	public String getNombre() { return this.nombre_cat; }
	public int getEdadMin() { return this.edadMin; }
	public int getEdadMax() { return this.edadMax; }
	public String getGenero() { return this.genero; }
	public void setId(String value) { this.id_c=value; }
	public void setNombre(String value) { this.nombre_cat=value; }
	public void setEdadMin(int value) { this.edadMin=value; }
	public void setEdadMax(int value) { this.edadMax=value; }
	public void setGenero(String value) { this.genero=value; }
	
}
