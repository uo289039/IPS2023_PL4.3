
package giis.demo.tkrun;

public class TiempoParcialDTO {

	private String nombre;
	private double distancia;
	private int id_c;
	private int dorsal;
	private String tiempo;
	
	
	public TiempoParcialDTO() {}
	public TiempoParcialDTO(String nombre, double distancia, int id_c) {
		super();
		this.nombre = nombre;
		this.distancia = distancia;
		this.id_c = id_c;
	}

	public String getNombre() {
		return nombre;
	}

	public double getDistancia() {
		return distancia;
	}

	public int getId_c() {
		return id_c;
	}

	public void setIdCarrera(int idCarrera) {
		this.id_c = idCarrera;
	}
	
	@Override
	public String toString() {
		return nombre;
	}

	public String getTiempo() {
		return tiempo;
	}

	public Object getDorsal() {
		return dorsal;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public void setId_c(int id_c) {
		this.id_c = id_c;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
	
	
}
