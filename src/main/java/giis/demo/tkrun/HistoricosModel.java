package giis.demo.tkrun;

import java.util.ArrayList;
import java.util.List;

import giis.demo.util.Database;
import giis.demo.util.io.FileUtil;
import giis.demo.util.io.ParserCompeticion;



public class HistoricosModel {
	
	private Database db = new Database();
	
	private static final String OBTENER_NOMBRE = "SELECT nombre_c FROM competicion, participa"
												   + " WHERE id = id_c and correoElec=?";
	private static final String OBTENER_ID = "SELECT id FROM competicion"
													+ " WHERE nombre_c = ?";
	
	
	private static final String OBTENER_ID_POR_CORREO = "SELECT id FROM competicion, participa"
			+ " WHERE id_c = id and correoElec=?";
	
//	private static final String OBTENER_FECHA = "SELECT fecha as inicio FROM competicion"
//			+ " WHERE id = ?";
	
//	private static final String OBTENER_TIPO = "SELECT distinct tipo as Categoria FROM competicion c, tiempo t, participa p"
//			+ " WHERE c.id = p.id_c and p.correoElec=? and t.id_c= p.id_c";
	
	
//	private static final String SELECCIONA_INFO_TIEMPOS = "SELECT dorsal, tiempo FROM Participa"
//			+ " WHERE id_c = ?";
//	
//	private static final String ELIMINAR_CLASIFICACION = "DELETE FROM Particpa WHERE id_c = ?";
	
	private static final String OBTENER_CLASIFICACION = "SELECT DISTINCT c.nombre_c, p.dorsal, c.fecha, p.tiempo, c.tipo as Categoria"
														+ "	FROM participa p, competicion c, Atleta a"
														+ " WHERE p.id_c = ? And c.id=p.id_c"
														+ " AND a.correoE=p.correoElec and a.correoE=?"
														
														+ " AND p.dorsal <> 0"
														+ " ORDER BY CASE WHEN p.tiempo = '---' THEN 1 ELSE 0 END";
	
	
	private static final String OBTENER_CLASIFICACION_POR_TIPO = "SELECT DISTINCT c.nombre_c, p.dorsal, c.fecha, p.tiempo, c.tipo as Categoria"
			+ "	FROM participa p, competicion c"
			+ " WHERE p.correoElec = ? And c.id=p.id_c and c.tipo=?"
			
			+ " AND p.dorsal <> 0"
			+ " ORDER BY CASE WHEN p.tiempo = '---' THEN 1 ELSE 0 END";
	
	
	private static final String OBTENER_CLASIFICACION_POR_DISTANCIA = "SELECT DISTINCT c.nombre_c, p.dorsal, c.fecha, p.tiempo, c.tipo as Categoria"
			+ "	FROM participa p, competicion c"
			+ " WHERE p.correoElec = ? And c.id=p.id_c"
			
			+ " AND p.dorsal <> 0"
			+ " ORDER BY CASE WHEN p.tiempo = '---' THEN 1 ELSE 0 END";
	
	
	
	
	private static final String OBTENER_CLASIFICACION_MEDIA_MARATON = "SELECT DISTINCT c.nombre_c, p.dorsal, c.fecha, p.tiempo, c.tipo as Categoria"
			+ "	FROM participa p, competicion c"
			+ " WHERE p.correoElec = ?  And c.id=p.id_c"
			+ " and c.distancia<=21"
			+ " AND p.dorsal <> 0"
			+ " ORDER BY CASE WHEN p.tiempo = '---' THEN 1 ELSE 0 END";
	
	
	private static final String OBTENER_CLASIFICACION_MARATON = "SELECT DISTINCT c.nombre_c, p.dorsal, c.fecha, p.tiempo, c.tipo as Categoria"
			+ "	FROM participa p, competicion c"
			+ " WHERE p.correoElec = ? AND c.id=p.id_c"
			+ " and c.distancia>21 and c.distancia<=42"
			+ " AND p.dorsal <> 0"
			+ " ORDER BY CASE WHEN p.tiempo = '---' THEN 1 ELSE 0 END";
	
	
	private static final String OBTENER_CLASIFICACION_ULTRA_MARATON = "SELECT DISTINCT c.nombre_c, p.dorsal, c.fecha, p.tiempo, c.tipo as Categoria"
			+ "	FROM participa p,  competicion c"
			+ " WHERE p.correoElec = ? AND c.id=p.id_c"
			+ " and c.distancia>42"
			+ " AND p.dorsal <> 0"
			+ " ORDER BY CASE WHEN p.tiempo = '---' THEN 1 ELSE 0 END";

//	private static final String OBTENER_CLASIFICACION_POR_SEXO = "SELECT DISTINCT a.nombre, a.sexo, p.dorsal, p.tiempo"
//											+ "	FROM atleta a, participa p, tiempo t"
//											+ " WHERE p.id_c = ? AND a.sexo = ? AND p.id_c  = t.id_c"
//											+ " AND a.correoE = p.correoElec"
//											+ " AND p.dorsal = p.dorsal"
//											+ " AND p.dorsal <> 0"
//											+ " ORDER BY CASE WHEN p.tiempo = '---' THEN 1 ELSE 0 END";;
	
	
	private static final String OBTENER_DISTANCIAS="SELECT distancia "
			+ "from Competicion c  where id=?";
	
	private static final String CORREOS="Select distinct correoE from Atleta a ";
	
//	public void insertarHistorial(String correo) {
//		
//		
//		String nombreCarrera=getNombre(correo);
//		insertarTiempos(nombreCarrera);
//		String carreraId = getId(nombreCarrera);
//		
//		List<HistoricoEntity> tiempos = cargaDatos(carreraId);
//		
//	}
		
	
	
	public boolean compruebaCorreo(String correo) {
		List<AtletaDisplayDTO>correos=db.executeQueryPojo(AtletaDisplayDTO.class, CORREOS);
		for(int i=0;i<correos.size();i++)
			if(correo.equals(correos.get(i).getCorreoE()))
				return true;
		return false;
	}

//	private List<HistoricoEntity> cargaDatos(String carreraId) {
//	return db.executeQueryPojo(HistoricoEntity.class,SELECCIONA_INFO_TIEMPOS, carreraId);
//	
//	}

//	private String getFecha(String id) {
//		List<CarreraDisplayDTO> res = db.executeQueryPojo(CarreraDisplayDTO.class, OBTENER_FECHA, id);
//		if(res.isEmpty()) {
//			return "";
//		}
//		return res.get(0).getInicio();
//	
//	}

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
		List<HistoricoDisplayDTO> tiempos =  db.executeQueryPojo(HistoricoDisplayDTO.class, OBTENER_CLASIFICACION, carreraId,correo);
		int pos = 1;
		for(HistoricoDisplayDTO t: tiempos) {
			t.setPosicion(pos);
			pos++;
		}
		return tiempos;
	}
	
	public List<HistoricoDisplayDTO> getTiemposPorTipo(String correo, String tipo) {
		if(tipo.equals("Todas"))
			return getTiempos(correo);
			
		List<HistoricoDisplayDTO> tiempos =  db.executeQueryPojo(HistoricoDisplayDTO.class, OBTENER_CLASIFICACION_POR_TIPO, correo, tipo);
		int pos = 1;
		for(HistoricoDisplayDTO t: tiempos) {
			t.setPosicion(pos);
			pos++;
		}
		return tiempos;
	}
	
	

	public List<HistoricoDisplayDTO> getTiemposPorDistancia(String correo, double distancia, String nombreDist) {
		List<HistoricoDisplayDTO> tiempos=null;
		if(nombreDist.equals("Todas"))
			tiempos=db.executeQueryPojo(HistoricoDisplayDTO.class, OBTENER_CLASIFICACION_POR_DISTANCIA, correo);
		
		else if(nombreDist.equals("Media maraton"))
			tiempos=db.executeQueryPojo(HistoricoDisplayDTO.class, OBTENER_CLASIFICACION_MEDIA_MARATON, correo);
		
		else if(nombreDist.equals("Maraton"))
			tiempos=db.executeQueryPojo(HistoricoDisplayDTO.class, OBTENER_CLASIFICACION_MARATON, correo);
		
		
		else if(nombreDist.equals("Ultra maraton"))
			tiempos=db.executeQueryPojo(HistoricoDisplayDTO.class, OBTENER_CLASIFICACION_ULTRA_MARATON, correo);
		
		int pos = 1;
		for(HistoricoDisplayDTO t: tiempos) {
			t.setPosicion(pos);
			pos++;
		}
		return tiempos;
	}
	
//	private String getCategoria(String carreraId) {
//		String sql="Select distinct tipo from competicion where id=?";
//		List<CategoriaCompeticion>cat=db.executeQueryPojo(CategoriaCompeticion.class, sql,carreraId);
//		return cat.get(0).getNombre_cat();
//	}
	
	public List<String> getTipos(){
		String sql="Select distinct tipo as nombre_cat from competicion";
		List<CategoriaCompeticion>carreras=db.executeQueryPojo(CategoriaCompeticion.class, sql);
		List<String>resultado=new ArrayList<String>();
		for(int i=0;i<carreras.size();i++)
			resultado.add(carreras.get(i).getNombre_cat());
		
		return resultado;
	}
	
	
	public void insertarTiempos(String nombreCarrera) {
		
		String carreraId = getId(nombreCarrera);
		List<TiempoEntity> tiempos = cargarTiempos("src/main/java/files/" + carreraId + ".csv", carreraId);
		//db.executeUpdate(ELIMINAR_CLASIFICACION, carreraId);
		String query = "UPDATE Participa set dorsal=?, tiempo=?  where id_c=?";
		for(TiempoEntity t: tiempos) {
			if(!inTablaUnique(t.getDorsal(),carreraId))
			db.executeUpdate(query, t.getDorsal(), t.getTiempo(),carreraId);	
		}
		
	}


	private boolean inTablaUnique(int dorsal, String carreraId) {
		// TODO Auto-generated method stub
		String sql="Select distinct id_c, dorsal from Participa p";
		List<HistoricoDisplayDTO>data=db.executeQueryPojo(HistoricoDisplayDTO.class, sql);
		String nombre=getNombre(carreraId);
		for(int i=0;i<data.size();i++) {
			if(data.get(i).getDorsal()==dorsal && data.get(i).getNombre_c().equals(nombre))
				return true;
		}
		return false;
	}



	private List<TiempoEntity> cargarTiempos(String ruta, String idC) {
	return new ParserCompeticion().parseLines(new FileUtil().readLines(ruta), idC);
}

	public double getDistancia(String correo) {
		String nombreCarrera=getNombre(correo);
		String carreraId = getId(nombreCarrera);
		List<CarreraDisplayDTO> carrera=db.executeQueryPojo(CarreraDisplayDTO.class,
				OBTENER_DISTANCIAS, carreraId);
		double distancia=carrera.get(0).getDistancia();
		return distancia;
	}


}
