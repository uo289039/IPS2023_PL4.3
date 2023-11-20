package giis.demo.tkrun;

public class PlazoDisplayDTO {
	private String id_comp;
	private String descr;
	private String fechaMin;
	private String fechaMax;
	private int cuota;
	public PlazoDisplayDTO() {}
	public PlazoDisplayDTO(String rowDescr, String rowMin, String rowMax, int rowCuota) {
		this.descr=rowDescr;
		this.fechaMin=rowMin;
		this.fechaMax=rowMax;
		this.cuota = rowCuota;
	}
	public String getId() { return this.id_comp; }
	public String getDescr() { return this.descr; }
	public String getFechaMin() { return this.fechaMin; }
	public String getfechaMax() { return this.fechaMax; }
	public int getCuota() { return this.cuota; }
	public void setId(String value) { this.id_comp=value; }
	public void setNombre(String value) { this.descr=value; }
	public void setFechaMin(String value) { this.fechaMin=value; }
	public void setFechaMax(String value) { this.fechaMax=value; }
	public void setCuota(int value) { this.cuota=value; }
	
}
