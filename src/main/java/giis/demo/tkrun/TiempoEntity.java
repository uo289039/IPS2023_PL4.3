package giis.demo.tkrun;

public class TiempoEntity {
	
	private int dorsal;
	private double tiempo;
	
	public TiempoEntity(int dorsal, double tiempo) {
		this.dorsal = dorsal;
		this.tiempo = tiempo;
	}
	
	public int getDorsal() { return dorsal; }
	public void setDorsal(int dorsal) { this.dorsal = dorsal; }
	public double getTiempo() { return tiempo; }
	public void setTiempo(double tiempo) { this.tiempo = tiempo; }

}
