package giis.demo.tkrun;

import java.util.List;

import giis.demo.util.Database;
import giis.demo.util.io.FileUtil;
import giis.demo.util.io.ParserCompeticion;

public class TiemposModel {
	
	private Database db = new Database();
	
	private static final String OBTENER_NOMBRE = "SELECT nombre_c FROM competicion"
												   + " WHERE id = ?";
	private static final String OBTENER_ID = "SELECT id FROM competicion"
													+ " WHERE nombre_c = ?";
	
	private static final String ELIMINAR_CLASIFICACION = "DELETE FROM tiempo WHERE id_c = ?";
	
	private static final String OBTENER_CLASIFICACION = "SELECT DISTINCT a.nombre, a.sexo, t.dorsal, t.tiempo"
														+ "	FROM atleta a, participa p, tiempo t"
														+ " WHERE p.id_c = ? AND p.id_c  = t.id_c"
														+ " AND a.correoE = p.correoElec"
														+ " AND p.dorsal = t.dorsal"
														+ " AND p.dorsal <> 0"
														+ " ORDER BY CASE WHEN t.tiempo = '---' THEN 1 ELSE 0 END";

	private static final String OBTENER_CLASIFICACION_POR_SEXO = "SELECT DISTINCT a.nombre, a.sexo, t.dorsal, t.tiempo"
											+ "	FROM atleta a, participa p, tiempo t"
											+ " WHERE p.id_c = ? AND a.sexo = ? AND p.id_c  = t.id_c"
											+ " AND a.correoE = p.correoElec"
											+ " AND p.dorsal = t.dorsal"
											+ " AND p.dorsal <> 0"
											+ " ORDER BY CASE WHEN t.tiempo = '---' THEN 1 ELSE 0 END";;
	
	public void insertarTiempos(String nombreCarrera) {
		
		String carreraId = getId(nombreCarrera);
		List<TiempoEntity> tiempos = cargarTiempos("src/main/java/files/" + carreraId + ".csv", carreraId);
		db.executeUpdate(ELIMINAR_CLASIFICACION, carreraId);
		String query = "INSERT INTO tiempo (id_c, dorsal, tiempo) VALUES (?, ?, ?)";
		for(TiempoEntity t: tiempos) {
			db.executeUpdate(query, carreraId, t.getDorsal(), t.getTiempo());	
		}
		
	}
	
	public String getNombre(String id) {
		List<CarreraDisplayDTO> res = db.executeQueryPojo(CarreraDisplayDTO.class, OBTENER_NOMBRE, id);
		if(res.isEmpty()) {
			return "";
		}
		return res.get(0).getNombre_c();
	}
	
	public String getId(String nombre) {
		List<CarreraDisplayDTO> res = db.executeQueryPojo(CarreraDisplayDTO.class, OBTENER_ID, nombre);
		if(res.isEmpty()) {
			return "";
		}
		return res.get(0).getId();
	}
	
	private List<TiempoEntity> cargarTiempos(String ruta, String idC) {
		return new ParserCompeticion().parseLines(new FileUtil().readLines(ruta), idC);
	}
	
	public List<TiempoDisplayDto> getTiempos(String nombreCarrera) {
		String carreraId = getId(nombreCarrera);
		List<TiempoDisplayDto> tiempos =  db.executeQueryPojo(TiempoDisplayDto.class, OBTENER_CLASIFICACION, carreraId);
		int pos = 1;
		for(TiempoDisplayDto t: tiempos) {
			t.setPosicion(pos);
			pos++;
		}
		return tiempos;
	}
	
	public List<TiempoDisplayDto> getTiemposPorSexo(String nombreCarrera, String sexo) {
		String carreraId = getId(nombreCarrera);
		List<TiempoDisplayDto> tiempos =  db.executeQueryPojo(TiempoDisplayDto.class, OBTENER_CLASIFICACION_POR_SEXO, carreraId, sexo);
		int pos = 1;
		for(TiempoDisplayDto t: tiempos) {
			t.setPosicion(pos);
			pos++;
		}
		return tiempos;
	}
	
	

}
