package giis.demo.tkrun;

public class Categoria {

	private String id_categoria;
	
	private String tipo;
	
	
	public Categoria() {}
	public Categoria(String rowCategoria, String rowTipo) {
		
		this.id_categoria=rowCategoria;
		
		this.tipo=rowTipo;
		
		//this.correoE=rowCorreo;
		}
	
	public String getId_categoria() {return this.id_categoria; }
	public String getTipo() {return this.tipo;}
	
	
	public void setCategoria(String value) { this.id_categoria=value; }
	public void setTipo(String value) {this.tipo=value;}
	
	
	
	
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


