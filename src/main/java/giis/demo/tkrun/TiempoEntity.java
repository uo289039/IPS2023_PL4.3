package giis.demo.tkrun;

import java.util.ArrayList;
import java.util.List;

public class TiempoEntity {
	
	private String idCarrera;
	private int dorsal;
	private String tiempo;
	private List<String> tiemposParciales;
	
	public TiempoEntity(String idCarrera, int dorsal, String tiempo, List<String> tiemposParciales) {
		this.idCarrera = idCarrera;
		this.dorsal = dorsal;
		this.tiempo = tiempo;
		this.tiemposParciales = new ArrayList<>(tiemposParciales);
	}
	
	public int getDorsal() { return dorsal; }
	public void setDorsal(int dorsal) { this.dorsal = dorsal; }
	public String getTiempo() { return tiempo; }
	public void setTiempo(String tiempo) { this.tiempo = tiempo; }
	public String getIdCarrera() { return idCarrera; }
	public void setIdCarrera(String idCarrera) { this.idCarrera = idCarrera; }

	public ArrayList<String> getTiemposParciales() {
		return new ArrayList<String>(tiemposParciales);
	}

	public void setTiemposParciales(List<String> tiemposParciales) {
		this.tiemposParciales = tiemposParciales;
	}

}
