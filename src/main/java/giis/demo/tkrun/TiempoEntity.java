package giis.demo.tkrun;

public class TiempoEntity {
	
	private String idCarrera;
	private int dorsal;
	private String tiempo;
	
	public TiempoEntity(String idCarrera, int dorsal, String tiempo) {
		this.idCarrera = idCarrera;
		this.dorsal = dorsal;
		this.tiempo = tiempo;
	}
	
	public int getDorsal() { return dorsal; }
	public void setDorsal(int dorsal) { this.dorsal = dorsal; }
	public String getTiempo() { return tiempo; }
	public void setTiempo(String tiempo) { this.tiempo = tiempo; }
	public String getIdCarrera() { return idCarrera; }
	public void setIdCarrera(String idCarrera) { this.idCarrera = idCarrera; }

}
