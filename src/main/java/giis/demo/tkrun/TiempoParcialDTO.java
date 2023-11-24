package giis.demo.tkrun;

public class TiempoParcialDTO {
	
	private String nombre;
	private double distancia;
	private int id_c;
	
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
	

}
