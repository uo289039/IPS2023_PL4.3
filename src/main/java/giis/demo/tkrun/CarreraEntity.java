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
public class CarreraEntity {
	private String id;
	private String inicio; //las fechas son string (vienen de sqlite)
	private String fin;
	private String fecha;
	private String descr;
	private double cuota;
	private double distancia;
	private String nombre_c;
	private int nPlazas;

	public String getId() { return this.id; }
	public String getInicio() { return this.inicio; }
	public String getFin() { return this.fin; }
	public String getFecha() { return this.fecha; }
	public String getDescr() { return this.descr; }
	public double getCuota() {return this.cuota;}
	public double getDistancia() {return this.distancia;}
	public String getNombre_c() {return nombre_c;}
	public void setId(String value) { this.id=value; }
	public void setInicio(String value) { this.inicio=value; }
	public void setFin(String value) { this.fin=value; }
	public void setFecha(String value) { this.fecha=value; }
	public void setDescr(String value) { this.descr=value; }
	public void setCuota(double c) {this.cuota=c;}
	public void setDistancia(double d) {this.distancia=d;}
	public void setNombre_c(String nombre_c) {this.nombre_c = nombre_c;}
	public int getnPlazas() {
		return nPlazas;
	}
	public void setnPlazas(int nPlazas) {
		this.nPlazas = nPlazas;
	}
	
	//NOTA: se pueden generar getters y setters de forma automatica usando lombok:  
	//https://www.sitepoint.com/declutter-pojos-with-lombok-tutorial/
	//http://www.baeldung.com/intro-to-project-lombok
	//En un fichero con este mismo nombre, pero con extension .txt se muestra un ejemplo
}
