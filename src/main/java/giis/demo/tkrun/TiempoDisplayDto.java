package giis.demo.tkrun;

public class TiempoDisplayDto {
	
	private String nombre;
	private int dorsal;
	private String tiempo;
	private String sexo;
	private int posicion;
	
	public TiempoDisplayDto(int posicion, String nombre, String sexo, int dorsal, String tiempo) {
		super();
		this.setPosicion(posicion);
		this.setNombre(nombre);
		this.setDorsal(dorsal);
		this.setTiempo(tiempo);
		this.setSexo(sexo);
	}
	public TiempoDisplayDto() {}
	public String getTiempo() { return tiempo; }
	public void setTiempo(String tiempo) { this.tiempo = tiempo; }
	public String getSexo() { return sexo; }
	public void setSexo(String sexo) { this.sexo = sexo; }
	public int getDorsal() { return dorsal; }
	public void setDorsal(int dorsal) { this.dorsal = dorsal; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public int getPosicion() { return posicion; }
	public void setPosicion(int posicion) { this.posicion = posicion; }
	
}
