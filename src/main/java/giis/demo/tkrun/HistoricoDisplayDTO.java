package giis.demo.tkrun;

public class HistoricoDisplayDTO {

	
	private String nombre_c;
	private int dorsal;
	private String fecha;
	private int posicion;
	private int tiempo;
	private String categoria;
	
	
	public HistoricoDisplayDTO() {}
	public HistoricoDisplayDTO(String n_c,int rowDorsal, String date, int pos, int time, String cat) {
		this.nombre_c=n_c;
		this.dorsal=rowDorsal;
		this.fecha=date;
		this.posicion=pos;
		this.tiempo=time;
		this.categoria=cat;
	}
	
	public String getNombre_c() {
		return nombre_c;
	}
	public void setNombre_c(String nombre_c) {
		this.nombre_c = nombre_c;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
	
	
}
