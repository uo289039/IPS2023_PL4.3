package giis.demo.tkrun;

import java.util.*;
import giis.demo.util.Util;
import giis.demo.util.io.FileUtil;
import giis.demo.util.io.ParserClub;
import giis.demo.util.Database;

/**
 * Acceso a los datos de carreras e inscripciones, 
 * utilizado como modelo para el ejemplo de swing y para las pruebas unitarias y de interfaz de usuario.
 * 
 * <br/>En los metodos de este ejemplo toda la logica de negocio se realiza mediante una unica query sql por lo que siempre
 * se utilizan los metodos de utilidad en la clase Database que usan apache commons-dbutils y controlan la conexion. 
 * En caso de que en un mismo metodo se realicen diferentes queries se deberia controlar la conexion desde esta clase 
 * (ver como ejemplo la implementacion en Database).
 * 
 * <br/>Si utilizase algún otro framework para manejar la persistencia, la funcionalidad proporcionada por esta clase sería la asignada
 * a los Servicios, Repositorios y DAOs.
 */
public class ClubModel {

	private Database db=new Database();
	
	/**
	 * Obtiene la lista de carreras activas en forma objetos para una fecha de inscripcion dada
	 */
	public List<CarreraDisplayDTO> getListaCarreras() {
		String sql=
				 "SELECT id,nombre_c,c.descr,c.distancia, nPlazas"
				+" from Competicion c, Plazo p"
				+" where c.fecha>=?"
				+" and ? >= p.fechaIni"
				+ " and ? <= p.fechaFin"
				+" and p.id_c = c.id order by c.id";
		String d=Util.dateToIsoString(new Date());
		return db.executeQueryPojo(CarreraDisplayDTO.class, sql, d, d, d);
	}
	
	/**
	 * Obtiene todos los datos de la carrera con el id indicado
	 */
	public CarreraEntity getCarrera(int id) {
		String sql="SELECT * from Competicion where id=?";
		List<CarreraEntity> carreras=db.executeQueryPojo(CarreraEntity.class, sql, id);
		return carreras.get(0);
	}

	public boolean compruebaClub(String text, String id) {
		String sql="SELECT * from Club where nombre=? and id_comp=?";
		List<CarreraEntity> carreras=db.executeQueryPojo(CarreraEntity.class, sql, text,id);
		return carreras.isEmpty();
	}
	
	public void insertarClub(String idC, String clubName) {
		int numP = getNumP(idC);
		ClubEntity club = cargarClub("src/main/java/files/" + clubName + ".csv", idC, numP);
		String query = "INSERT INTO Club (id_comp, id_club, nombre, numAtletas) VALUES (?, ?, ?, ?)";
		db.executeUpdate(query, idC, club.getIdClub(), club.getNombre(), club.getNumAtletas());
	}
	
	private int getNumP(String idC) {
		String sql="SELECT nPlazas from Competicion where id=?";
		List<CarreraEntity> carreras=db.executeQueryPojo(CarreraEntity.class, sql, idC);
		return carreras.get(0).getnPlazas();
	}

	public List<CategoriaEntity> getCategorias(int id) {
		String sql="SELECT * from CategoriaCompeticion where id_c=?";
		List<CategoriaEntity> categorias=db.executeQueryPojo(CategoriaEntity.class, sql, id);
		return categorias;
	}
	
	private ClubEntity cargarClub(String ruta, String idC, int numP) {
		return new ParserClub().parseLines(new FileUtil().readLines(ruta), idC, numP);
	}

	public void inscribeAtleta(ParticipaEntity atleta) {
		String query = "INSERT INTO Participa (correoElec,id_c, estadoI, categoria) VALUES (?, ?, ?, ?)";
		db.executeUpdate(query, atleta.getCorreo(), atleta.getIdComp(), atleta.getEstadoI(), atleta.getCat());
	}

	public void bajaPlazas(String idC) {
		String query = "UPDATE Competicion SET nPlazas = nPlazas-1	WHERE id = ?";
		db.executeUpdate(query, idC);
	}
	
}
