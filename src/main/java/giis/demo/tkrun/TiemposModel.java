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
	
	private static final String OBTENER_CORREO = "SELECT correoElec as correoE FROM participa"
			+ " WHERE id_c = ? and dorsal=?";
	
	//private static final String ELIMINAR_CLASIFICACION = "DELETE FROM tiempo WHERE id_c = ?";
	
	private static final String OBTENER_CLASIFICACION = "SELECT DISTINCT a.nombre, a.sexo, p.dorsal, p.tiempo"
														+ "	FROM atleta a, participa p"
														+ " WHERE p.id_c = ? "
														+ " AND a.correoE = p.correoElec"
													
														+ " AND p.dorsal <> 0"
														+ " ORDER BY CASE WHEN p.tiempo = '---' THEN 1 ELSE 0 END";

	private static final String OBTENER_CLASIFICACION_POR_SEXO = "SELECT DISTINCT a.nombre, a.sexo, p.dorsal, p.tiempo"
											+ "	FROM atleta a, participa p"
											+ " WHERE p.id_c = ? AND a.sexo = ? "
											+ " AND a.correoE = p.correoElec"
											
											+ " AND p.dorsal <> 0"
											+ " ORDER BY CASE WHEN p.tiempo = '---' THEN 1 ELSE 0 END";
	
	
	
	private static final String SQL_LISTA_COMPETICIONES="Select distinct nombre_c from Competicion c ";										
											
	
	private static final String OBTENER_ESTADO="Select distinct estadoI as estadoInscripcion from Participa c where correoElec=?";										
	
	
	public void insertarTiempos(String nombreCarrera) {
		
		String carreraId = getId(nombreCarrera);
		List<TiempoEntity> tiempos = cargarTiempos("src/main/java/files/" + carreraId + ".csv", carreraId);
		//db.executeUpdate(ELIMINAR_CLASIFICACION, carreraId);
		
		String query = "UPDATE Participa set dorsal=?, tiempo=? where id_c=? and correoElec=? and estadoI=?";
		for(TiempoEntity t: tiempos) {
			String correo=getCorreo(carreraId,t.getDorsal());
			String estado=getEstado(correo);
			db.executeUpdate(query, t.getDorsal(), t.getTiempo(), carreraId,correo,estado);	
		}
		
	}
	
	private String getEstado(String correo) {
		List<AtletaDisplayDTO> res = db.executeQueryPojo(AtletaDisplayDTO.class, OBTENER_ESTADO, correo);
		if(res.isEmpty()) {
			return "";
		}
		return res.get(0).getEstadoInscripcion();
	}

	private String getCorreo(String carreraId, int dorsal) {
		List<AtletaDisplayDTO> res = db.executeQueryPojo(AtletaDisplayDTO.class, OBTENER_CORREO, carreraId,dorsal);
		if(res.isEmpty()) {
			return "";
		}
		return res.get(0).getCorreoE();
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

	public boolean compruebaCarrera(String nombreCarrera) {
		List<CarreraDisplayDTO>correos=db.executeQueryPojo(CarreraDisplayDTO.class, SQL_LISTA_COMPETICIONES);
		for(int i=0;i<correos.size();i++)
			if(correos.get(i).getNombre_c().equals(nombreCarrera))
				return true;
		
		return false;
	}
	
	

}
