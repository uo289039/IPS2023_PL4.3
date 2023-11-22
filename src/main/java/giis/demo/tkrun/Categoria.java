package giis.demo.tkrun;

public class Categoria {

	private String id_c;
	
	private String genero;
	
	private String nombre_cat;
	
	private int edadMax;
	private int edadMin;
	
	
	public Categoria() {}
	public Categoria(String rowCategoria, String rowgenero,String rowNom, int rI, int rF) {
		
		this.id_c=rowCategoria;
		
		this.genero=rowgenero;
		
		this.nombre_cat=rowNom;
		
		this.edadMin=rI;
		
		this.edadMax=rF;
		
		}
	
	public String getId_c() {return this.id_c; }
	public String getGenero() {return this.genero;}
	
	
	public void setCategoria(String value) { this.id_c=value; }
	public void setGenero(String value) {this.genero=value;}
	public String getNombre_cat() {
		return nombre_cat;
	}
	public void setNombre_cat(String nombre_cat) {
		this.nombre_cat = nombre_cat;
	}
	public int getEdadMax() {
		return edadMax;
	}
	public void setEdadMax(int edadMax) {
		this.edadMax = edadMax;
	}
	public int getEdadMin() {
		return edadMin;
	}
	public void setEdadMin(int edadMin) {
		this.edadMin = edadMin;
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


