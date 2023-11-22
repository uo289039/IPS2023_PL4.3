package giis.demo.tkrun;

public class PlazoDisplayDTO {
	private String id_comp;
	private String descr;
	private String fechaIni;
	private String fechaFin;
	private int cuota;
	public PlazoDisplayDTO() {}
	public PlazoDisplayDTO(String rowDescr, String rowIni, String rowFin, int rowCuota) {
		this.descr=rowDescr;
		this.fechaIni=rowIni;
		this.fechaFin=rowFin;
		this.cuota = rowCuota;
	}
	public String getId() { return this.id_comp; }
	public String getDescr() { return this.descr; }
	public String getFechaIni() { return this.fechaIni; }
	public String getfechaFin() { return this.fechaFin; }
	public int getCuota() { return this.cuota; }
	public void setId(String value) { this.id_comp=value; }
	public void setDescr(String value) { this.descr=value; }
	public void setFechaIni(String value) { this.fechaIni=value; }
	public void setFechaFin(String value) { this.fechaFin=value; }
	public void setCuota(int value) { this.cuota=value; }
	
}
