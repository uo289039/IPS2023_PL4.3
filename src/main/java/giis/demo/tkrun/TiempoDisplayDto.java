package giis.demo.tkrun;

public class TiempoDisplayDto {
	
	private String nombre;
	private int dorsal;
	private String tiempo;
	private String sexo;
	private int posicion;
	
	private String tp1;
	private String tp2;
	private String tp3;
	private String tp4;
	private String tp5;
	
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
	
	public String getTp1() {
		return tp1;
	}
	public void setTp1(String tp1) {
		this.tp1 = tp1;
	}
	public String getTp2() {
		return tp2;
	}
	public void setTp2(String tp2) {
		this.tp2 = tp2;
	}
	public String getTp3() {
		return tp3;
	}
	public void setTp3(String tp3) {
		this.tp3 = tp3;
	}
	public String getTp4() {
		return tp4;
	}
	public void setTp4(String tp4) {
		this.tp4 = tp4;
	}
	public String getTp5() {
		return tp5;
	}
	public void setTp5(String tp5) {
		this.tp5 = tp5;
	}
	
}