package giis.demo.tkrun;

import java.util.ArrayList;
import java.util.List;

public class TiempoDisplayDto {
	
	private String nombre;
	private int dorsal;
	private String tiempo;
	private String sexo;
	private int posicion;
	private String parciales;
	
	private List<String> tParciales=new ArrayList<String>();
	
	public TiempoDisplayDto(int posicion, String nombre, String sexo, int dorsal, String tiempo,
			List<String> tp5, String p) {
		super();
		this.setPosicion(posicion);
		this.setNombre(nombre);
		this.setDorsal(dorsal);
		this.setTiempo(tiempo);
		this.setSexo(sexo);
		this.tParciales=tp5;
		parciales=p;
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
	public List<String> gettParciales() {
		return tParciales;
	}
	
	
	public String getParciales() {
		parciales="";
		for(int i=0;i<tParciales.size();i++)
			parciales+=tParciales.get(i)+";";
		
		return parciales;
	}
	public void setParciales(String parciales) {
		this.parciales = parciales;
	}
	public void settParciales(List<String> tParciales) {
		this.tParciales = tParciales;
	}
	
	
	
}