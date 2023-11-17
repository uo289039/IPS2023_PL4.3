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
public class ComparaEntity {
	private String correoE;
	private double tiempo;
	private int puesto;
	private double t_intermedio;
	private double ritmo;
	private double distancia;
	private String completado;
	
	
	
	
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
	
	
//	
	//NOTA: se pueden generar getters y setters de forma automatica usando lombok:  
	//https://www.sitepoint.com/declutter-pojos-with-lombok-tutorial/
	//http://www.baeldung.com/intro-to-project-lombok
	//En un fichero con este mismo nombre, pero con extension .txt se muestra un ejemplo
	
}
