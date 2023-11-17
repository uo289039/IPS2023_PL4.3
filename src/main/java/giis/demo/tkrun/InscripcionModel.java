package giis.demo.tkrun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import javax.swing.JOptionPane;

//import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
//import giis.demo.util.Util;

public class InscripcionModel {
	private Database db=new Database();
	
	private boolean actualizado=false;
	
	//SQL para obtener la lista de carreras activas para una fecha dada,
	//se incluye aqui porque se usara en diferentes versiones de los metodos bajo prueba
	public static final String SQL_LISTA_CORREOS="Select distinct correoElec from Participa";
	
	/**
	 * Obtiene la lista de carreras activas en forma objetos para una fecha de inscripcion dada
	 */
	private boolean inCorreos(String correo) {
		
		String sql="Select distinct correoE from Atleta";
		
		List<AtletaDisplayDTO>correos= db.executeQueryPojo(AtletaDisplayDTO.class, sql);
		for(int i=0;i<correos.size();i++)
			if(correos.get(i).getCorreoE().equals(correo)) {
				JOptionPane.showMessageDialog(null, "No puede usar el correo de otro atleta registrado para crear su cuenta");
				return true;
			}
		
		return false;
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
	public void updateAtletas(String correo, String dni, String nombre, String sexo,String f_nacim,String poblacion, String telefono, String pais) {
		String sql="insert into Atleta (dni,f_nacimiento,nombre,sexo,inscripcion,formaPago,correoE,poblacion,telefono,pais) values (?,?,?,?,?,?,?,?,?,?)";
		if(!inCorreos(correo) && compruebaDNI(dni) && compruebaFecha(f_nacim)) {
			db.executeUpdate(sql,dni,f_nacim,nombre,sexo,"","",correo,poblacion,telefono,pais);
			actualizado=true;
		}
		
	}

	
	private boolean compruebaFecha(String fecha) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-m-dd");
		try {
			Date fechaN=sdf.parse(fecha);
			Date fechaActual=new Date(); 
			long now=fechaActual.getTime();
			long then=fechaN.getTime();
			long limite=18*365*24*60*60*1000;
			if(now-then>=limite) {
				return true;
			}
			return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

	private boolean compruebaDNI(String dni) {
String sql="Select distinct dni from Atleta";
		
		List<AtletaDisplayDTO>correos= db.executeQueryPojo(AtletaDisplayDTO.class, sql);
		for(int i=0;i<correos.size();i++)
			if(correos.get(i).getDni().equals(dni)) {
				JOptionPane.showMessageDialog(null, "No puede usar el dni de otro atleta registrado para crear su cuenta");
				return false;
			}
		
		
		return true;
	}

	/**
	 * Actualiza las fechas de inscripcion de una carrera
	 */
//	public void updateFechasInscripcion(int id, Date inicio, Date fin) {
//		CarreraEntity carrera=this.getAtletas(id);
//		validateFechasInscripcion(inicio, fin, Util.isoStringToDate(carrera.getFecha()));
//		String sql="UPDATE competicion SET inicio=?, fin=? WHERE id=?";
//		db.executeUpdate(sql, Util.dateToIsoString(inicio), Util.dateToIsoString(fin), id);
//	}
//	private void validateFechasInscripcion(Date inicio, Date fin, Date fecha) {
//		validateNotNull(inicio,"La fecha de inicio de inscripcion no puede ser nula");
//		validateNotNull(fin,"La fecha de fin de inscripcion no puede ser nula");
//		validateNotNull(fecha,"La fecha de fin de carrera no puede ser nula");
//		validateCondition(inicio.compareTo(fin)<=0, "La fecha de inicio no puede ser posterior a la de fin");
//		validateCondition(fin.compareTo(fecha)<=0, "La fecha de fin no puede ser posterior a la de la carrera");
//	}
//
//	/* De uso general para validacion de objetos */
//	private void validateNotNull(Object obj, String message) {
//		if (obj==null)
//			throw new ApplicationException(message);
//	}
//	private void validateCondition(boolean condition, String message) {
//		if (!condition)
//			throw new ApplicationException(message);
//	}
	
	public boolean isActualizado() {
		return actualizado;
	}
	
	public void reiniciaActualizado() {
		actualizado=false;
	}
	
}
