package giis.demo.tkrun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.*;
import giis.demo.util.Util;
//import giis.demo.util.ApplicationException;
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
public class ParticipaModel {
	//private static final String MSG_FECHA_INSCRIPCION_NO_NULA = "La fecha de inscripcion no puede ser nula";

	private Database db=new Database();
	private List<AtletaDisplayDTO>correosValidos=getCorreosValidos();
	
	//SQL para obtener la lista de carreras activas para una fecha dada,
	//se incluye aqui porque se usara en diferentes versiones de los metodos bajo prueba
	public static final String SQL_LISTA_PARTICIPA=
			"Select nombre_c from Competicion";
	
	//public static final String SQL_LISTA_COMPETICIONES="Select distinct nombre_c from Competicion";
	/**
	 * Obtiene la lista de carreras futuras (posteriores a una fecha dada) con el id, descripcion
	 * y la indicacion de si tienen inscripcion abierta.
	 * Implementacion usando la utilidad que obtiene una lista de arrays de objetos 
	 * resultado de la ejecucion de una query sql
	 */
	public List<Object[]> getListaCompeticionArray() {
		//validateNotNull(fechaInscripcion,MSG_FECHA_INSCRIPCION_NO_NULA);
		//concatena los campos deseados en una unica columna pues el objetivo es devolver una lista de strings
		String sql=SQL_LISTA_PARTICIPA;
		
		return db.executeQueryArray(sql);
	}
	/**
	 * Obtiene la lista de carreras activas en forma objetos para una fecha de inscripcion dada
	 */
	public List<CarreraDisplayDTO> getListaParticipa() {
		//validateNotNull(fechaInscripcion,MSG_FECHA_INSCRIPCION_NO_NULA);
		String sql=
				"Select distinct nombre_c from Competicion";
		//String d=Util.dateToIsoString(fechaInscripcion);
		return db.executeQueryPojo(CarreraDisplayDTO.class, sql);
	}
	
	
	public List<CarreraDisplayDTO> getListaParticipa(String correo) {
		//validateNotNull(fechaInscripcion,MSG_FECHA_INSCRIPCION_NO_NULA);
		String sql=
				"Select distinct nombre_c,inicio, fin, nPlazas from Competicion c, Participa p,"
				+ "Atleta a where c.id=p.id_c and p.correoElec=a.correoE"
				+ " and a.correoE=?";
		//String d=Util.dateToIsoString(fechaInscripcion);
		return db.executeQueryPojo(CarreraDisplayDTO.class, sql, correo);
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
	public CarreraEntity getParticipa() {
		String sql="Select distinct nombre_c from Competicion";
		List<CarreraEntity> atletas=db.executeQueryPojo(CarreraEntity.class, sql);
		//validateCondition(!atletas.isEmpty(),"Id de competicion no encontrado: ");
		return atletas.get(0);
	}
	
	public CarreraDisplayDTO[] getNombresCompeticiones() {
		StringBuilder query=new StringBuilder();
		String sentencia="Select distinct nombre_c, id from Competicion";
		query.append(sentencia);
		
		return db.executeQueryPojo(CarreraDisplayDTO.class,query.toString()).toArray(new CarreraDisplayDTO[0]);
	}
	
	public List<CarreraDisplayDTO> getListaNombresCompeticiones() {
		StringBuilder query=new StringBuilder();
		String sentencia="Select distinct nombre_c, id from Competicion";
		query.append(sentencia);
		
		return db.executeQueryPojo(CarreraDisplayDTO.class,query.toString());
	}

	private List<AtletaDisplayDTO> getCorreosValidos() {
		StringBuilder query=new StringBuilder();
		String sentencia="Select distinct correoE from Atleta";
		query.append(sentencia);
		
		return db.executeQueryPojo(AtletaDisplayDTO.class,query.toString());
	}
	
	/**
	 * Actualiza las fechas de inscripcion de una carrera
	 */
	public void updateFechasInscripcion(int id, Date inicio, Date fin) {
//		CarreraEntity carrera=this.getParticipa();
		//validateFechasInscripcion(inicio, fin, Util.isoStringToDate(carrera.getFecha()));
		String sql="UPDATE competicion SET inicio=?, fin=? WHERE id=?";
		db.executeUpdate(sql, Util.dateToIsoString(inicio), Util.dateToIsoString(fin), id);
	}
//	private void validateFechasInscripcion(Date inicio, Date fin, Date fecha) {
//		validateNotNull(inicio,"La fecha de inicio de inscripcion no puede ser nula");
//		validateNotNull(fin,"La fecha de fin de inscripcion no puede ser nula");
//		validateNotNull(fecha,"La fecha de fin de carrera no puede ser nula");
//		validateCondition(inicio.compareTo(fin)<=0, "La fecha de inicio no puede ser posterior a la de fin");
//		validateCondition(fin.compareTo(fecha)<=0, "La fecha de fin no puede ser posterior a la de la carrera");
//	}

	/* De uso general para validacion de objetos */
//	private void validateNotNull(Object obj, String message) {
//		if (obj==null)
//			throw new ApplicationException(message);
//	}
//	private void validateCondition(boolean condition, String message) {
//		if (!condition)
//			throw new ApplicationException(message);
//	}
	
	protected void insertaData(String info1, String info2,String info3) {
		if(!yaInscrito(info2,info1)) {
			String sql="insert into participa(correoElec,id_c,estadoI,completado) values(?,?,?,?)";
			db.executeUpdate(sql, info1, info2, info3,"No terminada");
		}
	}
	
	protected boolean yaInscrito(String id_c, String correo) {
		String sql="Select id_c, correoElec from Participa where id_c=? and correoElec=?";
		if(db.executeQueryPojo(ParticipaDisplayDTO.class, sql, id_c,correo).isEmpty())
			return false;
		
		return true;
	}
	
	
//	public String getInfoParticipa(String correo) {
//		String sql="Select distinct a.nombre, c.nombre_c, c2.tipo, "
//				+ "a.inscripcion, c.cuota  from Atleta a,"
//				+ "Participa p, Competicion c, Categoria c2 "
//				+ "where a.correoE=p.correoElec and p.id_c=c.id and c.id_cat=c2.id_categoria and a.correoE=?";
//		List<CarreraDisplayDTO> data=db.executeQueryPojo(CarreraDisplayDTO.class, sql, correo);
//		String datos="";
//		for(int i=0;i<data.size();i++)
//			datos+=data.get(i).toString2()+" ";
//		
//		return datos;
//		
//	}
	public boolean hayPlazas(String id) {
		String sql="Select nPlazas from Competicion where id=?";
		String sql2="Select count(*) from Competicion where id=?";
		
		List<CarreraDisplayDTO> data=db.executeQueryPojo(CarreraDisplayDTO.class, sql, id);
		List<Object[]> data2=db.executeQueryArray(sql2, id);
		if(data.size()==0)
			return false;
		System.out.println((int)data2.get(0)[0]);
		if(data.get(0).getnPlazas()>(int)data2.get(0)[0])//data.get(0).getnPlazas()>0 &&
			return true;
		
		return false;
	}
	
//	public void actualizaValidados(ArrayList<String>nuevos) {
//		correosValidos=nuevos;
//	}
//	
	public boolean isCorreoValido(String correo) {
		for(int i=0;i<correosValidos.size();i++)
			if(!correo.equals("")) {
				if(correo.equals(correosValidos.get(i).getCorreoE()))
					return true;
			}
		return false;
	}
	
	public List<DatosAtleta> datosAtletaInscrito(String correo, String id) {
		String sql="Select distinct a.nombre, c.nombre_c, nombre_cat, a.inscripcion, "
				+ "p.cuota from Atleta a, Participa part, CategoriaCompeticion cat,Competicion c, Plazo p "
				+ "where correoE=? and p.id_c=? and a.correoE=part.correoElec and "
				+ "part.id_c=c.id and c.id=p.id_c and c.id=cat.id_c";
		List<DatosAtleta> datos=db.executeQueryPojo(DatosAtleta.class, sql,correo,id);
		
		return datos;
	}
	
	protected void insertaTrans(String info1, String info2,String info3, String info4, double info5, String info6) {
        String sql="insert into PagosTransferencia(nombre_Completo,correoElec,dni,importe,iban,id_c) values(?,?,?,?,?,?)";
        db.executeUpdate(sql, info1, info2, info3, info4, info5);
}
	
	public CarreraDisplayDTO getIbanCompeticion(String idCategoria) {
        //validateNotNull(fechaInscripcion,MSG_FECHA_INSCRIPCION_NO_NULA);
        String sql="Select distinct iban_c from Competicion where id=?";
        //String d=Util.dateToIsoString(fechaInscripcion);
        List<CarreraDisplayDTO> c = db.executeQueryPojo(CarreraDisplayDTO.class, sql, idCategoria);
        return c.get(0);
	}
	

	public CarreraDisplayDTO getCuotaCompeticion(String idCategoria) {
		//validateNotNull(fechaInscripcion,MSG_FECHA_INSCRIPCION_NO_NULA);
		String sql="Select distinct cuota from Plazo where id_c=?";
		//String d=Util.dateToIsoString(fechaInscripcion);
		List<CarreraDisplayDTO> c = db.executeQueryPojo(CarreraDisplayDTO.class, sql, idCategoria);
		return c.get(0);
	}
	

//	public CarreraDisplayDTO getCuotaCompeticion(String idCategoria) {
//		//validateNotNull(fechaInscripcion,MSG_FECHA_INSCRIPCION_NO_NULA);
//		String sql="Select distinct cuota from Competicion where id=?";
//		//String d=Util.dateToIsoString(fechaInscripcion);
//		List<CarreraDisplayDTO> c = db.executeQueryPojo(CarreraDisplayDTO.class, sql, idCategoria);
//		return c.get(0);
//	}
	public void insertaDataAtleta(String nombre, String nombre_c, String categoria, String inscripcion, double cuota, String correo, String id) {
		String sql="insert into DatosAtleta(nombre,nombre_c,categoria,inscripcion,cuota,id_c,correoE) values(?,?,?,?,?,?,?)";
		db.executeUpdate(sql,nombre,nombre_c,categoria,inscripcion,cuota,correo,id);
		
		String sql2="insert into DatosInscripciones (nombre_c,estadoI,fecha_cambio_estado,correoE) values(?,?,?,?)";
		db.executeUpdate(sql2,nombre_c,"Preinscrito",inscripcion,correo);
	}

	public String getNombreCompeticion(String id) {
		String sql="Select nombre_c from Competicion where "
				+ "id=?";
		List<CarreraDisplayDTO> datos=db.executeQueryPojo(CarreraDisplayDTO.class, sql,id);
		
		return datos.get(0).getNombre_c();
	}
	public CategoriaCompeticion getCategoria(String id) {
		String sql="Select * from CategoriaCompeticion cat, Competicion c where "
				+ "c.id=? and c.id=cat.id_c"; //Mete datos en la BD, debería tirar
		List<CategoriaCompeticion> datos=db.executeQueryPojo(CategoriaCompeticion.class, sql,id);
		
		return datos.get(0);
	}
	public String getInscripcion(String correo) {
		String sql="Select a.inscripcion from Atleta a, Participa p where "
				+ "p.correoElec=? and p.correoElec=a.correoE";
		List<AtletaDisplayDTO> datos=db.executeQueryPojo(AtletaDisplayDTO.class, sql,correo);
		
		return datos.get(0).getFechaInscripcionCambioEstado();
	}
	public String getTfNombre(String correo) {
		String sql="Select a.nombre from Atleta a where "
				+ "a.correoE=? ";
		List<AtletaDisplayDTO> datos=db.executeQueryPojo(AtletaDisplayDTO.class, sql,correo);
		
		return datos.get(0).getNombre();
	}
	
	
	public void insertaDataAtleta(String nombre_c, String correo) {
		
		Date fechaActual=new Date(); 
		String sql="insert into DatosInscripciones(correoE,nombre_c,estadoI,fecha_cambio_estado) values(?,?,?,?)";
		db.executeUpdate(sql, correo, nombre_c, "Preinscrito",fechaActual);
	
		
	}
	
	
	
	
	
	

}
