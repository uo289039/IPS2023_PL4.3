package giis.demo.tkrun;

import java.util.*;
import giis.demo.util.Util;
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
public class AtletaModel {
	private static final String MSG_FECHA_INSCRIPCION_NO_NULA = "La fecha de inscripcion no puede ser nula";

	private Database db=new Database();
	
	//SQL para obtener la lista de carreras activas para una fecha dada,
	//se incluye aqui porque se usara en diferentes versiones de los metodos bajo prueba
	public static final String SQL_LISTA_DATOS_ATLETAS=
			"Select distinct a.dni, a.nombre, a.inscripcion, c.id_cat "
			+ "from Atleta a, Participa p, Competicion c, \n"
			+ "where a.dni=p.dni and p.id=c.id  and c.id='?'";
	/**
	 * Obtiene la lista de carreras futuras (posteriores a una fecha dada) con el id, descripcion
	 * y la indicacion de si tienen inscripcion abierta.
	 * Implementacion usando la utilidad que obtiene una lista de arrays de objetos 
	 * resultado de la ejecucion de una query sql
	 */
	public List<Object[]> getListaAtletasArray(String idCategoria) {
		//validateNotNull(fechaInscripcion,MSG_FECHA_INSCRIPCION_NO_NULA);
		//concatena los campos deseados en una unica columna pues el objetivo es devolver una lista de strings
		String sql="SELECT dni || '-' || nombre || ' ' || inscripcion || '' || id_cat "
				+ " from (" + SQL_LISTA_DATOS_ATLETAS + ")";
		
		return db.executeQueryArray(sql, idCategoria);
	}
	/**
	 * Obtiene la lista de carreras activas en forma objetos para una fecha de inscripcion dada
	 */
	public List<CarreraDisplayDTO> getListaAtletas(String idCategoria) {
		//validateNotNull(fechaInscripcion,MSG_FECHA_INSCRIPCION_NO_NULA);
		String sql=
				"Select distinct a.dni, a.nombre, a.inscripcion, c.id_cat "
						+ "from Atleta a, Participa p, Competicion c, \n"
						+ "where a.dni=p.dni and p.id=c.id  and c.id='?'";
		//String d=Util.dateToIsoString(fechaInscripcion);
		return db.executeQueryPojo(CarreraDisplayDTO.class, sql, idCategoria);
	}
	/** 
	 * Obtiene el porcentaje de descuento (valor negativo) o recargo aplicable a una carrera dada por su id cuando se
	 * realiza la inscripcion en una fecha dada.
	 * Causa excepcion si no esta abierta la inscripcion.
	 * Implementacion usando la utilidad que obtiene una lista de arrays de objetos 
	 * restultado de la ejecucion de una query sql
	 */
//	public int getDescuentoRecargo(long idCarrera, Date fechaInscripcion) {
//		validateNotNull(fechaInscripcion,MSG_FECHA_INSCRIPCION_NO_NULA);
//		String sql=
//				 "SELECT "
//				+" case when ?<inicio then NULL" //antes de inscripcion
//				+"   when ?<=fin then -30" //fase 1
//				+"   when ?<fecha then 0" //fase 2
//				+"   when ?=fecha then 50" //fase 3
//				+"   else NULL "
//				+" end as descuentoRecargo"
//				+" from Competicion where id=? order by id";			
//		String d=Util.dateToIsoString(fechaInscripcion);
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
		String sql="SELECT dni,f_nacimiento,nombre,sexo,inscripcion from Atleta where dni=?";
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
	
}
