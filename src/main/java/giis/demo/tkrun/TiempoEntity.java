package giis.demo.tkrun;

public class TiempoEntity {
	
	private String idCarrera;
	private int dorsal;
	private String tiempo;
	
	private String tp1;
	private String tp2;
	private String tp3;
	private String tp4;
	private String tp5;

	public TiempoEntity(String idCarrera, int dorsal, String tiempo, String tp1, String tp2, String tp3, String tp4,
			String tp5) {
		super();
		this.idCarrera = idCarrera;
		this.dorsal = dorsal;
		this.tiempo = tiempo;
		this.tp1 = tp1;
		this.tp2 = tp2;
		this.tp3 = tp3;
		this.tp4 = tp4;
		this.tp5 = tp5;
	}
	public int getDorsal() { return dorsal; }
	public void setDorsal(int dorsal) { this.dorsal = dorsal; }
	public String getTiempo() { return tiempo; }
	public void setTiempo(String tiempo) { this.tiempo = tiempo; }
	public String getIdCarrera() { return idCarrera; }
	public void setIdCarrera(String idCarrera) { this.idCarrera = idCarrera; }

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