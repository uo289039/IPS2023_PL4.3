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
	private String fecha;
	private String descr;
	private double distancia;
	private String nombre_c;
	private int nPlazas;
	
	private String iban;
	private String cancelacion;
	private String fechaCancelacion;
	private int devolucion;
	private boolean tiemposParciales;
	
	private int tp1;
	private int tp2;
	private int tp3;
	private int tp4;
	private int tp5;

	
	private String inicio; //las fechas son string (vienen de sqlite)
	private String fin;


	public String getId() { return this.id; }
	public String getFecha() { return this.fecha; }
	public String getDescr() { return this.descr; }
	public double getDistancia() {return this.distancia;}
	public String getNombre_c() {return nombre_c;}
	public void setId(String value) { this.id=value; }
	public void setFecha(String value) { this.fecha=value; }
	public void setDescr(String value) { this.descr=value; }
	public void setDistancia(double d) {this.distancia=d;}
	public void setNombre_c(String nombre_c) {this.nombre_c = nombre_c;}
	public int getnPlazas() {
		return nPlazas;
	}
	public void setnPlazas(int nPlazas) {
		this.nPlazas = nPlazas;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getCancelacion() {
		return cancelacion;
	}
	public void setCancelacion(String cancelacion) {
		this.cancelacion = cancelacion;
	}
	public String getFechaCancelacion() {
		return fechaCancelacion;
	}
	public void setFechaCancelacion(String fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}
	public int getDevolucion() {
		return devolucion;
	}
	public void setDevolucion(int devolucion) {
		this.devolucion = devolucion;
	}
	public boolean isTiemposParciales() {
		return tiemposParciales;
	}
	public void setTiemposParciales(boolean tiemposParciales) {
		this.tiemposParciales = tiemposParciales;
	}
	public int getTp1() {
		return tp1;
	}
	public void setTp1(int tp1) {
		this.tp1 = tp1;
	}
	public int getTp2() {
		return tp2;
	}
	public void setTp2(int tp2) {
		this.tp2 = tp2;
	}
	public int getTp3() {
		return tp3;
	}
	public void setTp3(int tp3) {
		this.tp3 = tp3;
	}
	public int getTp4() {
		return tp4;
	}
	public void setTp4(int tp4) {
		this.tp4 = tp4;
	}
	public int getTp5() {
		return tp5;
	}
	public void setTp5(int tp5) {
		this.tp5 = tp5;
	}

	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}

	
	
	
	//NOTA: se pueden generar getters y setters de forma automatica usando lombok:  
	//https://www.sitepoint.com/declutter-pojos-with-lombok-tutorial/
	//http://www.baeldung.com/intro-to-project-lombok
	//En un fichero con este mismo nombre, pero con extension .txt se muestra un ejemplo
}