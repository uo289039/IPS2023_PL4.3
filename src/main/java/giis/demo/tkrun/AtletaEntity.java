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
public class AtletaEntity {
	private String dni;
	private String nombre; //las fechas son string (vienen de sqlite)
	private String sexo;
	private String fecha_nacimiento;
	private String fecha_insc;
	private String correoE;
	private String telefono;
	private String pais;
	private String poblacion;
	public String getDni() { return this.dni; }
	public String getNombre() { return this.nombre; }
	public String getSexo() { return this.sexo; }
	public String getFecha_Nac() { return this.fecha_nacimiento; }
	public String getFecha_insc() { return this.fecha_insc; }
	public void setId(String value) { this.dni=value; }
	public void setNombre(String value) { this.nombre=value; }
	public void setSexo(String value) { this.sexo=value; }
	public void setFecha_Nac(String value) { this.fecha_nacimiento=value; }
	public void setFecha_insc(String value) { this.fecha_insc=value;}
	public String getCorreoE() {
		return correoE;
	}
	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
//	
	//NOTA: se pueden generar getters y setters de forma automatica usando lombok:  
	//https://www.sitepoint.com/declutter-pojos-with-lombok-tutorial/
	//http://www.baeldung.com/intro-to-project-lombok
	//En un fichero con este mismo nombre, pero con extension .txt se muestra un ejemplo
	
}
