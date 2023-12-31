package giis.demo.tkrun;

import java.util.*;
import giis.demo.util.Util;
import giis.demo.util.io.FileUtil;
import giis.demo.util.io.ParserCompeticion;
import giis.demo.util.ApplicationException;
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
public class ComparaModel {
	//private static final String MSG_FECHA_INSCRIPCION_NO_NULA = "La fecha de inscripcion no puede ser nula";

	private Database db=new Database();
	
	//SQL para obtener la lista de carreras activas para una fecha dada,
	//se incluye aqui porque se usara en diferentes versiones de los metodos bajo prueba
	public static final String SQL_LISTA_DATOS_ATLETAS=
			"Select nombre from Atleta a, Participa p, Competicion c WHERE a.correoE =p.correoElec "
			+ "and p.id_c =c.id and c.nombre_c =? and a.correoE!=? and p.estadoI='Inscrito'";
	
	
	private static final String OBTENER_CLASIFICACION = "SELECT DISTINCT a.correoE, p.tiempo,p.ritmo,c.distancia,p.completado, p.dorsal"
			+ "	FROM atleta a, participa p, TiempoParcial tp,competicion c"
			+ " WHERE p.id_c = ? and p.id_c=c.id and p.id_c=tp.id_c"
			+ " AND a.correoE = p.correoElec"
			+ " AND a.nombre=?"
			+ " AND p.dorsal <> 0"
			+ " ORDER BY CASE WHEN p.tiempo = '---' THEN 1 ELSE 0 END";
	
	
	private static final String OBTENER_ID = "SELECT id FROM competicion"
			+ " WHERE nombre_c = ?";
	
	
	
	private static final String LISTA_NOMBRES_C="Select distinct nombre_c from Competicion c";
	
	private static final String OBTENER_T_PARCIALES="Select distinct tiempo from TiempoParcial where id_c=? and dorsal=?";
	/**
	 * Obtiene la lista de carreras futuras (posteriores a una fecha dada) con el id, descripcion
	 * y la indicacion de si tienen inscripcion abierta.
	 * Implementacion usando la utilidad que obtiene una lista de arrays de objetos 
	 * resultado de la ejecucion de una query sql
	 */
	public List<Object[]> getListaComparaAtletasArray(String nombreCompeticion) {
		//validateNotNull(fechaInscripcionnscripcion,MSG_FECHA_INSCRIPCION_NO_NULA);
		//concatena los campos deseados en una unica columna pues el objetivo es devolver una lista de strings
		String sql="SELECT tiempo || '-' || puesto || ' ' || t_intermedio || ' ' || ritmo || ' ' || distancia || ' ' || estado"
				+ " from (" + SQL_LISTA_DATOS_ATLETAS + ")";
		
		return db.executeQueryArray(sql, nombreCompeticion);
	}
	/**
	 * Obtiene la lista de carreras activas en forma objetos para una fecha de inscripcion dada
	 * @param correo 
	 */
	public List<AtletaDisplayDTO> getListaComparaAtletas(String nombreCarrera, String correo) {
		//validateNotNull(fechaInscripcionnscripcion,MSG_FECHA_INSCRIPCION_NO_NULA);
		
		//String d=Util.dateToIsoString(fechaInscripcionnscripcion);
		return db.executeQueryPojo(AtletaDisplayDTO.class, SQL_LISTA_DATOS_ATLETAS, nombreCarrera,correo);
	}
	/** 
	 * Obtiene el porcentaje de descuento (valor negativo) o recargo aplicable a una carrera dada por su id cuando se
	 * realiza la inscripcion en una fecha dada.
	 * Causa excepcion si no esta abierta la inscripcion.
	 * Implementacion usando la utilidad que obtiene una lista de arrays de objetos 
	 * restultado de la ejecucion de una query sql
	 */
//	public int getDescuentoRecargo(long idCarrera, Date fechaInscripcionnscripcion) {
//		validateNotNull(fechaInscripcionnscripcion,MSG_FECHA_INSCRIPCION_NO_NULA);
//		String sql=
//				 "SELECT "
//				+" case when ?<inicio then NULL" //antes de inscripcion
//				+"   when ?<=fin then -30" //fase 1
//				+"   when ?<fecha then 0" //fase 2
//				+"   when ?=fecha then 50" //fase 3
//				+"   else NULL "
//				+" end as descuentoRecargo"
//				+" from Competicion where id=? order by id";			
//		String d=Util.dateToIsoString(fechaInscripcionnscripcion);
//		List<Object[]>rows=db.executeQueryArray(sql, d, d, d, d, idCarrera);
//		//determina el valor a devolver o posibles excepciones
//		if (rows.isEmpty())
//			throw new ApplicationException("Id de competicion no encontrado: "+idCarrera);
//		else if (rows.get(0)[0]==null)
//			throw new ApplicationException("No es posible la inscripcion en esta fecha");
//		else
//			return (int)rows.get(0)[0];
//	}
	
	/**
	 * Obtiene todos los datos de la carrera con el id indicado
	 */
	public CarreraEntity getAtletas(int id) {
		String sql="SELECT nombre from Atleta where dni=?";
		List<CarreraEntity> atletas=db.executeQueryPojo(CarreraEntity.class, sql, id);
		validateCondition(!atletas.isEmpty(),"Id de competicion no encontrado: "+id);
		return atletas.get(0);
	}

	/**
	 * Actualiza las fechas de inscripcion de una carrera
	 */
	public void updateFechasInscripcion(int id, Date inicio, Date fin) {
		CarreraEntity carrera=this.getAtletas(id);
		validateFechasInscripcion(inicio, fin, Util.isoStringToDate(carrera.getFecha()));
		String sql="UPDATE competicion SET inicio=?, fin=? WHERE id=?";
		db.executeUpdate(sql, Util.dateToIsoString(inicio), Util.dateToIsoString(fin), id);
	}
	private void validateFechasInscripcion(Date inicio, Date fin, Date fecha) {
		validateNotNull(inicio,"La fecha de inicio de inscripcion no puede ser nula");
		validateNotNull(fin,"La fecha de fin de inscripcion no puede ser nula");
		validateNotNull(fecha,"La fecha de fin de carrera no puede ser nula");
		validateCondition(inicio.compareTo(fin)<=0, "La fecha de inicio no puede ser posterior a la de fin");
		validateCondition(fin.compareTo(fecha)<=0, "La fecha de fin no puede ser posterior a la de la carrera");
	}

	/* De uso general para validacion de objetos */
	private void validateNotNull(Object obj, String message) {
		if (obj==null)
			throw new ApplicationException(message);
	}
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
	
	
	public List<ComparaDisplayDTO> getTiempos(String nombreCarrera, List<String> competidores) {
		String carreraId = getId(nombreCarrera);
		List<ComparaDisplayDTO> tiempos =  new ArrayList<ComparaDisplayDTO>(); //db.executeQueryPojo(ComparaDisplayDTO.class, OBTENER_CLASIFICACION, carreraId)
		//ComparaDisplayDTO atleta=db.executeQueryPojo(ComparaDisplayDTO.class, OBTENER_CLASIFICACION, carreraId,nombre).get(0);
		for(String nombre:competidores) {
			List<ComparaDisplayDTO>lista=db.executeQueryPojo(ComparaDisplayDTO.class, OBTENER_CLASIFICACION, carreraId,nombre);
			if(lista.size()>0)
				tiempos.add(lista.get(0));
			}
		int pos = 1;
		for(ComparaDisplayDTO t: tiempos) {
			t.setPuesto(pos);
			List<TiempoParcialDTO> tiemposP =  db.executeQueryPojo(TiempoParcialDTO.class, OBTENER_T_PARCIALES, carreraId,t.getDorsal());
			if(tiemposP.size()>0)
				for(int i=0;i<tiemposP.size();i++)
					t.gettParciales().add(tiemposP.get(i).getTiempo());
			pos++;
		}
		return tiempos;
	}
	
	
	public String getId(String nombre) {
		List<CarreraDisplayDTO> res = db.executeQueryPojo(CarreraDisplayDTO.class, OBTENER_ID, nombre);
		if(res.isEmpty()) {
			return "";
		}
		return res.get(0).getId();
	}
	public boolean compruebaNombreCarrera(String carrera) {
		List<CarreraDisplayDTO>carreras=db.executeQueryPojo(CarreraDisplayDTO.class, LISTA_NOMBRES_C);
		for(int i=0;i<carreras.size();i++) {
			if(carrera.equals(carreras.get(i).getNombre_c()))
				return true;
		}
		return false;
	}
	public boolean compruebaCorreo(String correo) {
		StringBuilder query=new StringBuilder();
		String sentencia="Select distinct correoE from Atleta";
		query.append(sentencia);
		
		List<AtletaDisplayDTO>correos=db.executeQueryPojo(AtletaDisplayDTO.class,query.toString());
		for(int i=0;i<correos.size();i++) {
			if(correos.get(i).getCorreoE().equals(correo))
				return true;
		}
		
		return false;
	}
	public String getNombreUsuario(String textAtleta) {
		String sql="Select nombre from Atleta where correoE=?";
		List<AtletaDisplayDTO>atletaUser=db.executeQueryPojo(AtletaDisplayDTO.class, sql, textAtleta);
		return atletaUser.get(0).getNombre();
	}
	
	
	public void insertTp(TiempoParcialDTO tP) {
		String sql = "insert into tiempoparcial (id_c, dorsal, distancia, tiempo)"
					+ " values (?,?,?,?)";
		db.executeUpdate(sql, tP.getId_c(), tP.getDorsal(), tP.getDistancia(), tP.getTiempo());
	}	


//	private List<TiempoEntity> cargarTiempos(String ruta, String idC) {
//		return new ParserCompeticion().parseLines(new FileUtil().readLines(ruta), idC);
//	}
	
	
}
