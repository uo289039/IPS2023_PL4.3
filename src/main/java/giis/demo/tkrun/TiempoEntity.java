package giis.demo.tkrun;

import java.util.List;

public class TiempoEntity {
	
	private String idCarrera;
	private int dorsal;
	private String tiempo;
	
	private List<String> tParciales;
	

	public TiempoEntity(String idCarrera, int dorsal, String tiempo, 
			List<String> tp5) {
		super();
		this.idCarrera = idCarrera;
		this.dorsal = dorsal;
		this.tiempo = tiempo;
		this.tParciales=tp5;
		
	}
	public int getDorsal() { return dorsal; }
	public void setDorsal(int dorsal) { this.dorsal = dorsal; }
	public String getTiempo() { return tiempo; }
	public void setTiempo(String tiempo) { this.tiempo = tiempo; }
	public String getIdCarrera() { return idCarrera; }
	public void setIdCarrera(String idCarrera) { this.idCarrera = idCarrera; }
	
	public List<String> gettParciales() {
		return tParciales;
	}
	public void settParciales(List<String> tParciales) {
		this.tParciales = tParciales;
	}

	

}