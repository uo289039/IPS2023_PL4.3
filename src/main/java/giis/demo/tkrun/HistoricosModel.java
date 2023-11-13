package giis.demo.tkrun;

import java.util.ArrayList;
import java.util.List;

import giis.demo.util.Database;



public class HistoricosModel {
	
	private Database db = new Database();
	
	private static final String OBTENER_NOMBRE = "SELECT nombre_c FROM competicion, participa"
												   + " WHERE id = id_c and correoElec=?";
	private static final String OBTENER_ID = "SELECT id FROM competicion"
													+ " WHERE nombre_c = ?";
	
	
	private static final String OBTENER_ID_POR_CORREO = "SELECT id FROM competicion, participa"
			+ " WHERE id_c = id and correoElec=?";
	
	private static final String OBTENER_FECHA = "SELECT fecha FROM competicion"
			+ " WHERE id = ?";
	
	private static final String OBTENER_TIPO = "SELECT nombre_c,dorsal, tiempo, fecha,tipo FROM competicion, tiempo"
			+ " WHERE id = id_c and correoElec=?";
	
	
	private static final String SELECCIONA_INFO = "SELECT tipo FROM competicion"
			+ " WHERE id = ?";
	
	private static final String ELIMINAR_CLASIFICACION = "DELETE FROM tiempo WHERE id_c = ?";
	
	private static final String OBTENER_CLASIFICACION = "SELECT DISTINCT a.nombre, a.sexo, t.dorsal, t.tiempo"
														+ "	FROM atleta a, participa p, tiempo t"
														+ " WHERE p.correoElec = ? AND p.id_c  = t.id_c"
														+ " AND a.correoE = p.correoElec"
														+ " AND p.dorsal = t.dorsal"
														+ " AND p.dorsal <> 0"
														+ " ORDER BY CASE WHEN t.tiempo = '---' THEN 1 ELSE 0 END";

//	private static final String OBTENER_CLASIFICACION_POR_SEXO = "SELECT DISTINCT a.nombre, a.sexo, t.dorsal, t.tiempo"
//											+ "	FROM atleta a, participa p, tiempo t"
//											+ " WHERE p.id_c = ? AND a.sexo = ? AND p.id_c  = t.id_c"
//											+ " AND a.correoE = p.correoElec"
//											+ " AND p.dorsal = t.dorsal"
//											+ " AND p.dorsal <> 0"
//											+ " ORDER BY CASE WHEN t.tiempo = '---' THEN 1 ELSE 0 END";;
	
	public void insertarHistorial(String correo) {
		
		String nombreCarrera=getNombre(correo);
		String carreraId = getId(nombreCarrera);
		String categoria=getCategoria(carreraId);
		String fecha=getFecha(carreraId);
		List<HistoricoEntity> tiempos = new ArrayList<HistoricoEntity>();
		cargaDatos(tiempos,carreraId);
		db.executeUpdate(ELIMINAR_CLASIFICACION, carreraId);
		String query = "INSERT INTO Historico (nombre_c, dorsal, fecha, tiempo, categoria) VALUES (?, ?, ?, ?, ?)";
		for(HistoricoEntity t: tiempos) {
			db.executeUpdate(query, nombreCarrera, t.getDorsal(), fecha, t.getTiempo(),categoria);	
		}
		
	}
	
	private void cargaDatos(List<HistoricoEntity> tiempos, String carreraId) {
	tiempos=db.executeQueryPojo(HistoricoEntity.class,SELECCIONA_INFO, carreraId);
	
	}

	private String getFecha(String id) {
		List<CarreraDisplayDTO> res = db.executeQueryPojo(CarreraDisplayDTO.class, OBTENER_FECHA, id);
		if(res.isEmpty()) {
			return "";
		}
		return res.get(0).getInicio();
	
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
	
	
	public String getIdPorCorreo(String correo) {
		List<CarreraDisplayDTO> res = db.executeQueryPojo(CarreraDisplayDTO.class, OBTENER_ID_POR_CORREO, correo);
		if(res.isEmpty()) {
			return "";
		}
		return res.get(0).getId();
	}
	
//	private List<HistoricoEntity> cargarTiempos(String ruta,String idC, String nombre, String fecha) {
//		return new ParserCompeticion().parseLinesHistorico(new FileUtil().readLines(ruta), idC, nombre,fecha);
//	}
	
	public List<HistoricoDisplayDTO> getTiempos(String correo) {
		String carreraId = getIdPorCorreo(correo);
		List<HistoricoDisplayDTO> tiempos =  db.executeQueryPojo(HistoricoDisplayDTO.class, OBTENER_CLASIFICACION, carreraId);
		int pos = 1;
		for(HistoricoDisplayDTO t: tiempos) {
			t.setPosicion(pos);
			pos++;
		}
		return tiempos;
	}
	
	public List<HistoricoDisplayDTO> getTiemposPorTipo(String correo) {
		String carreraId = getId(correo);
		List<HistoricoDisplayDTO> tiempos =  db.executeQueryPojo(HistoricoDisplayDTO.class, OBTENER_TIPO, carreraId);
		int pos = 1;
		for(HistoricoDisplayDTO t: tiempos) {
			t.setPosicion(pos);
			pos++;
		}
		return tiempos;
	}
	
	

	public List<HistoricoDisplayDTO> getTiemposPorDistancia(String correo) {
		String carreraId = getId(correo);
		List<HistoricoDisplayDTO> tiempos =  db.executeQueryPojo(HistoricoDisplayDTO.class, OBTENER_CLASIFICACION, carreraId);
		int pos = 1;
		for(HistoricoDisplayDTO t: tiempos) {
			t.setPosicion(pos);
			pos++;
		}
		return tiempos;
	}
	
	private String getCategoria(String carreraId) {
		List<HistoricoDisplayDTO> cat =  db.executeQueryPojo(HistoricoDisplayDTO.class, OBTENER_CLASIFICACION, carreraId);
		
		return cat.get(0).getCategoria();
	}

}
