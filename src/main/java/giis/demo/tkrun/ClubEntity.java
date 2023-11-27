package giis.demo.tkrun;

public class ClubEntity {
	private String id_comp;
	private String id_club;
	private String nombre;
	private int numAtletas;
	public ClubEntity(String rowcomp, String rowclub, String rownom, int rownum) {
		this.id_comp = rowcomp;
		this.id_club = rowclub;
		this.nombre = rownom;
		this.numAtletas = rownum;
	}
	public String getIdComp() { return this.id_comp; }
	public String getIdClub() { return this.id_club; }
	public String getNombre() { return this.nombre; }
	public int getNumAtletas() { return this.numAtletas; }
	public void setIdComp(String value) { this.id_comp=value; }
	public void setIdClub(String value) { this.id_club=value; }
	public void setNombre(String value) { this.nombre=value; }
	public void setNumAtletas(int value) { this.numAtletas=value; }
}
