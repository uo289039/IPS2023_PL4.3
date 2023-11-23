package giis.demo.tkrun;

public class TiempoParcialDTO {
	
	private String nombre;
	private int distancia;
	private String id_c;
	
	public TiempoParcialDTO(String nombre, int distancia, String id_c) {
		super();
		this.nombre = nombre;
		this.distancia = distancia;
		this.id_c = id_c;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDistancia() {
		return distancia;
	}

	public String getId_c() {
		return id_c;
	}
	
	

}
