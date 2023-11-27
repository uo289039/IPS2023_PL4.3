package giis.demo.tkrun;



/**
 * Cada una de las filas que muestran al usuario las carreras y su estado
 * IMPORTANTE: Cuando se usan los componentes de Apache Commons DbUtils debe
 * mantenerse de forma estricta el convenio de capitalización de Java:
 *  - Capitalizar todas las palabras que forman un identificador 
 *    excepto la primera letra de nombres de métodos y variables.
 *  - No utilizar subrayados
 * Seguir tambien estos mismos criterios en los nombres de tablas y campos de la BD
 */
public class ComparaDisplayDTO {
	
	private String correoE;
	private double tiempo;
	private int puesto;
	private double t_intermedio;
	private double ritmo;
	private double distancia;
	private String completado;
	private String nombre;
	public ComparaDisplayDTO() {}
	public ComparaDisplayDTO(String rowCorreo, double rowTiempo, int rowPuesto,
			double rowTinterm, double rowRitmo, double rowDist, String rowEstado, String rowNombre) {
		
		this.correoE=rowCorreo;
		this.tiempo=rowTiempo;
		this.puesto=rowPuesto;
		this.t_intermedio=rowTinterm;
		this.ritmo=rowRitmo;
		this.distancia=rowDist;
		this.completado=rowEstado;
		this.nombre=rowNombre;
		}
	public String getCorreoE() {
		return correoE;
	}
	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}
	public double getTiempo() {
		return tiempo;
	}
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	public int getPuesto() {
		return puesto;
	}
	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}
	public double getT_intermedio() {
		return t_intermedio;
	}
	public void setT_intermedio(double t_intermedio) {
		this.t_intermedio = t_intermedio;
	}
	public double getRitmo() {
		return ritmo;
	}
	public void setRitmo(double ritmo) {
		this.ritmo = ritmo;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public String getCompletado() {
		return completado;
	}
	public void setCompletado(String completado) {
		this.completado = completado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
//	
	//NOTA: se pueden generar getters y setters de forma automatica usando lombok:  
	//https://www.sitepoint.com/declutter-pojos-with-lombok-tutorial/
	//http://www.baeldung.com/intro-to-project-lombok
}
